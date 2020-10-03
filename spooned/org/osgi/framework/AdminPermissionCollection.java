/* Copyright (c) OSGi Alliance (2000, 2013). All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */
package org.osgi.framework;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.Permission;
import java.security.PermissionCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/**
 * Stores a collection of {@code AdminPermission}s.
 */
final class AdminPermissionCollection extends PermissionCollection {
    private static final long serialVersionUID = 3906372644575328048L;

    /**
     * Collection of permissions.
     *
     * @unknown this
     */
    private transient Map<String, AdminPermission> permissions;

    /**
     * Boolean saying if "*" is in the collection.
     *
     * @serial 
     * @unknown this
     */
    private boolean all_allowed;

    /**
     * Create an empty AdminPermissions object.
     */
    public AdminPermissionCollection() {
        permissions = new HashMap<String, AdminPermission>();
    }

    /**
     * Adds a permission to this permission collection.
     *
     * @param permission
     * 		The {@code AdminPermission} object to add.
     * @throws IllegalArgumentException
     * 		If the specified permission is not an
     * 		{@code AdminPermission} instance or was constructed with a Bundle
     * 		object.
     * @throws SecurityException
     * 		If this {@code AdminPermissionCollection}
     * 		object has been marked read-only.
     */
    @Override
    public void add(Permission permission) {
        if (!(permission instanceof AdminPermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        }
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a " + "readonly PermissionCollection");
        }
        final AdminPermission ap = ((AdminPermission) (permission));
        if (ap.bundle != null) {
            throw new IllegalArgumentException("cannot add to collection: " + ap);
        }
        final String name = ap.getName();
        synchronized(this) {
            Map<String, AdminPermission> pc = permissions;
            AdminPermission existing = pc.get(name);
            if (existing != null) {
                int oldMask = existing.action_mask;
                int newMask = ap.action_mask;
                if (oldMask != newMask) {
                    pc.put(name, new AdminPermission(existing.filter, oldMask | newMask));
                }
            } else {
                pc.put(name, ap);
            }
            if (!all_allowed) {
                if (name.equals("*")) {
                    all_allowed = true;
                }
            }
        }
    }

    /**
     * Determines if the specified permissions implies the permissions expressed
     * in {@code permission}.
     *
     * @param permission
     * 		The Permission object to compare with the
     * 		{@code AdminPermission} objects in this collection.
     * @return {@code true} if {@code permission} is implied by an
    {@code AdminPermission} in this collection, {@code false}
    otherwise.
     */
    @Override
    public boolean implies(Permission permission) {
        if (!(permission instanceof AdminPermission)) {
            return false;
        }
        AdminPermission requested = ((AdminPermission) (permission));
        // if requested permission has a filter, then it is an invalid argument
        if (requested.filter != null) {
            return false;
        }
        int effective = AdminPermission.ACTION_NONE;
        Collection<AdminPermission> perms;
        synchronized(this) {
            Map<String, AdminPermission> pc = permissions;
            // short circuit if the "*" Permission was added
            if (all_allowed) {
                AdminPermission ap = pc.get("*");
                if (ap != null) {
                    effective |= ap.action_mask;
                    final int desired = requested.action_mask;
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
            }
            perms = pc.values();
        }
        // just iterate one by one
        for (AdminPermission perm : perms) {
            if (perm.implies0(requested, effective)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an enumeration of all {@code AdminPermission} objects in the
     * container.
     *
     * @return Enumeration of all {@code AdminPermission} objects.
     */
    @Override
    public synchronized Enumeration<Permission> elements() {
        List<Permission> all = new ArrayList<Permission>(permissions.values());
        return Collections.enumeration(all);
    }

    /* serialization logic */
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class), new ObjectStreamField("all_allowed", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        Hashtable<String, AdminPermission> hashtable = new Hashtable<String, AdminPermission>(permissions);
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("permissions", hashtable);
        pfields.put("all_allowed", all_allowed);
        out.writeFields();
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        @SuppressWarnings("unchecked")
        Hashtable<String, AdminPermission> hashtable = ((Hashtable<String, AdminPermission>) (gfields.get("permissions", null)));
        permissions = new HashMap<String, AdminPermission>(hashtable);
        all_allowed = gfields.get("all_allowed", false);
    }
}