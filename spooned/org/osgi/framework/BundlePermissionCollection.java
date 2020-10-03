/* Copyright (c) OSGi Alliance (2004, 2013). All Rights Reserved.

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
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/**
 * Stores a set of {@code BundlePermission} permissions.
 *
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.security.PermissionCollection
 */
final class BundlePermissionCollection extends PermissionCollection {
    private static final long serialVersionUID = 3258407326846433079L;

    /**
     * Table of permissions.
     *
     * @unknown this
     */
    private transient Map<String, BundlePermission> permissions;

    /**
     * Boolean saying if "*" is in the collection.
     *
     * @serial 
     * @unknown this
     */
    private boolean all_allowed;

    /**
     * Create an empty BundlePermissions object.
     */
    public BundlePermissionCollection() {
        permissions = new HashMap<String, BundlePermission>();
        all_allowed = false;
    }

    /**
     * Add a permission to this permission collection.
     *
     * @param permission
     * 		The {@code BundlePermission} object to add.
     * @throws IllegalArgumentException
     * 		If the permission is not a
     * 		{@code BundlePermission} instance.
     * @throws SecurityException
     * 		If this {@code BundlePermissionCollection}
     * 		object has been marked read-only.
     */
    @Override
    public void add(final Permission permission) {
        if (!(permission instanceof BundlePermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        }
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a " + "readonly PermissionCollection");
        }
        final BundlePermission bp = ((BundlePermission) (permission));
        final String name = bp.getName();
        synchronized(this) {
            Map<String, BundlePermission> pc = permissions;
            BundlePermission existing = pc.get(name);
            if (existing != null) {
                final int oldMask = existing.getActionsMask();
                final int newMask = bp.getActionsMask();
                if (oldMask != newMask) {
                    pc.put(name, new BundlePermission(name, oldMask | newMask));
                }
            } else {
                pc.put(name, bp);
            }
            if (!all_allowed) {
                if (name.equals("*"))
                    all_allowed = true;

            }
        }
    }

    /**
     * Determines if the specified permissions implies the permissions expressed
     * in {@code permission}.
     *
     * @param permission
     * 		The Permission object to compare with this
     * 		{@code BundlePermission} object.
     * @return {@code true} if {@code permission} is a proper subset of a
    permission in the set; {@code false} otherwise.
     */
    @Override
    public boolean implies(final Permission permission) {
        if (!(permission instanceof BundlePermission)) {
            return false;
        }
        BundlePermission requested = ((BundlePermission) (permission));
        String requestedName = requested.getName();
        final int desired = requested.getActionsMask();
        int effective = BundlePermission.ACTION_NONE;
        BundlePermission bp;
        synchronized(this) {
            Map<String, BundlePermission> pc = permissions;
            /* short circuit if the "*" Permission was added */
            if (all_allowed) {
                bp = pc.get("*");
                if (bp != null) {
                    effective |= bp.getActionsMask();
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
            }
            bp = pc.get(requestedName);
            // strategy:
            // Check for full match first. Then work our way up the
            // name looking for matches on a.b.*
            if (bp != null) {
                // we have a direct hit!
                effective |= bp.getActionsMask();
                if ((effective & desired) == desired) {
                    return true;
                }
            }
            // work our way up the tree...
            int last;
            int offset = requestedName.length() - 1;
            while ((last = requestedName.lastIndexOf(".", offset)) != (-1)) {
                requestedName = requestedName.substring(0, last + 1) + "*";
                bp = pc.get(requestedName);
                if (bp != null) {
                    effective |= bp.getActionsMask();
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
                offset = last - 1;
            } 
            // we don't have to check for "*" as it was already checked
            // at the top (all_allowed), so we just return false
            return false;
        }
    }

    /**
     * Returns an enumeration of all {@code BundlePermission} objects in the
     * container.
     *
     * @return Enumeration of all {@code BundlePermission} objects.
     */
    @Override
    public synchronized Enumeration<Permission> elements() {
        List<Permission> all = new ArrayList<Permission>(permissions.values());
        return Collections.enumeration(all);
    }

    /* serialization logic */
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class), new ObjectStreamField("all_allowed", Boolean.TYPE) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        Hashtable<String, BundlePermission> hashtable = new Hashtable<String, BundlePermission>(permissions);
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("permissions", hashtable);
        pfields.put("all_allowed", all_allowed);
        out.writeFields();
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        @SuppressWarnings("unchecked")
        Hashtable<String, BundlePermission> hashtable = ((Hashtable<String, BundlePermission>) (gfields.get("permissions", null)));
        permissions = new HashMap<String, BundlePermission>(hashtable);
        all_allowed = gfields.get("all_allowed", false);
    }
}