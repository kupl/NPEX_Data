/* Copyright (c) OSGi Alliance (2010, 2013). All Rights Reserved.

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
import java.util.List;
import java.util.Map;
/**
 * Stores a set of {@code AdaptPermission} permissions.
 *
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.security.PermissionCollection
 */
final class AdaptPermissionCollection extends PermissionCollection {
    static final long serialVersionUID = -3350758995234427603L;

    /**
     * Collection of permissions.
     *
     * @serial 
     * @unknown this
     */
    private Map<String, AdaptPermission> permissions;

    /**
     * Boolean saying if "*" is in the collection.
     *
     * @serial 
     * @unknown this
     */
    private boolean all_allowed;

    /**
     * Create an empty AdaptPermissions object.
     */
    public AdaptPermissionCollection() {
        permissions = new HashMap<String, AdaptPermission>();
        all_allowed = false;
    }

    /**
     * Adds a permission to this permission collection.
     *
     * @param permission
     * 		The {@code AdaptPermission} object to add.
     * @throws IllegalArgumentException
     * 		If the specified permission is not a
     * 		{@code AdaptPermission} instance or was constructed with a Bundle
     * 		object.
     * @throws SecurityException
     * 		If this {@code AdaptPermissionCollection}
     * 		object has been marked read-only.
     */
    @Override
    public void add(final Permission permission) {
        if (!(permission instanceof AdaptPermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        }
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a " + "readonly PermissionCollection");
        }
        final AdaptPermission ap = ((AdaptPermission) (permission));
        if (ap.bundle != null) {
            throw new IllegalArgumentException("cannot add to collection: " + ap);
        }
        final String name = ap.getName();
        synchronized(this) {
            Map<String, AdaptPermission> pc = permissions;
            final AdaptPermission existing = pc.get(name);
            if (existing != null) {
                final int oldMask = existing.action_mask;
                final int newMask = ap.action_mask;
                if (oldMask != newMask) {
                    pc.put(name, new AdaptPermission(existing.filter, oldMask | newMask));
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
     * 		The Permission object to compare with this
     * 		{@code AdaptPermission} object.
     * @return {@code true} if {@code permission} is a proper subset of a
    permission in the set; {@code false} otherwise.
     */
    @Override
    public boolean implies(final Permission permission) {
        if (!(permission instanceof AdaptPermission)) {
            return false;
        }
        final AdaptPermission requested = ((AdaptPermission) (permission));
        /* if requested permission has a filter, then it is an invalid argument */
        if (requested.filter != null) {
            return false;
        }
        int effective = AdaptPermission.ACTION_NONE;
        Collection<AdaptPermission> perms;
        synchronized(this) {
            Map<String, AdaptPermission> pc = permissions;
            /* short circuit if the "*" Permission was added */
            if (all_allowed) {
                AdaptPermission ap = pc.get("*");
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
        /* iterate one by one over filteredPermissions */
        for (AdaptPermission perm : perms) {
            if (perm.implies0(requested, effective)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an enumeration of all {@code AdaptPermission} objects in the
     * container.
     *
     * @return Enumeration of all {@code AdaptPermission} objects.
     */
    @Override
    public synchronized Enumeration<Permission> elements() {
        List<Permission> all = new ArrayList<Permission>(permissions.values());
        return Collections.enumeration(all);
    }

    /* serialization logic */
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", HashMap.class), new ObjectStreamField("all_allowed", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("permissions", permissions);
        pfields.put("all_allowed", all_allowed);
        out.writeFields();
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        @SuppressWarnings("unchecked")
        HashMap<String, AdaptPermission> p = ((HashMap<String, AdaptPermission>) (gfields.get("permissions", null)));
        permissions = p;
        all_allowed = gfields.get("all_allowed", false);
    }
}