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
import java.util.List;
import java.util.Map;
/**
 * Stores a set of CapabilityPermission permissions.
 *
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.security.PermissionCollection
 */
final class CapabilityPermissionCollection extends PermissionCollection {
    static final long serialVersionUID = -615322242639008920L;

    /**
     * Table of permissions.
     *
     * @serial 
     * @unknown this
     */
    private Map<String, CapabilityPermission> permissions;

    /**
     * Boolean saying if "*" is in the collection.
     *
     * @serial 
     * @unknown this
     */
    private boolean all_allowed;

    /**
     * Table of permissions with filter expressions.
     *
     * @serial 
     * @unknown this
     */
    private Map<String, CapabilityPermission> filterPermissions;

    /**
     * Creates an empty CapabilityPermissionCollection object.
     */
    public CapabilityPermissionCollection() {
        permissions = new HashMap<String, CapabilityPermission>();
        all_allowed = false;
    }

    /**
     * Adds a permission to this permission collection.
     *
     * @param permission
     * 		The Permission object to add.
     * @throws IllegalArgumentException
     * 		If the specified permission is not a
     * 		CapabilityPermission object.
     * @throws SecurityException
     * 		If this {@code CapabilityPermissionCollection}
     * 		object has been marked read-only.
     */
    @Override
    public void add(final Permission permission) {
        if (!(permission instanceof CapabilityPermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        }
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a " + "readonly PermissionCollection");
        }
        final CapabilityPermission cp = ((CapabilityPermission) (permission));
        if (cp.bundle != null) {
            throw new IllegalArgumentException("cannot add to collection: " + cp);
        }
        final String name = cp.getName();
        final Filter f = cp.filter;
        synchronized(this) {
            /* select the bucket for the permission */
            Map<String, CapabilityPermission> pc;
            if (f != null) {
                pc = filterPermissions;
                if (pc == null) {
                    filterPermissions = pc = new HashMap<String, CapabilityPermission>();
                }
            } else {
                pc = permissions;
            }
            final CapabilityPermission existing = pc.get(name);
            if (existing != null) {
                final int oldMask = existing.action_mask;
                final int newMask = cp.action_mask;
                if (oldMask != newMask) {
                    pc.put(name, new CapabilityPermission(name, oldMask | newMask));
                }
            } else {
                pc.put(name, cp);
            }
            if (!all_allowed) {
                if (name.equals("*")) {
                    all_allowed = true;
                }
            }
        }
    }

    /**
     * Determines if a set of permissions implies the permissions expressed in
     * {@code permission}.
     *
     * @param permission
     * 		The Permission object to compare.
     * @return {@code true} if {@code permission} is a proper subset of a
    permission in the set; {@code false} otherwise.
     */
    @Override
    public boolean implies(final Permission permission) {
        if (!(permission instanceof CapabilityPermission)) {
            return false;
        }
        final CapabilityPermission requested = ((CapabilityPermission) (permission));
        /* if requested permission has a filter, then it is an invalid argument */
        if (requested.filter != null) {
            return false;
        }
        String requestedName = requested.getName();
        final int desired = requested.action_mask;
        int effective = CapabilityPermission.ACTION_NONE;
        Collection<CapabilityPermission> perms;
        synchronized(this) {
            Map<String, CapabilityPermission> pc = permissions;
            CapabilityPermission cp;
            /* short circuit if the "*" Permission was added */
            if (all_allowed) {
                cp = pc.get("*");
                if (cp != null) {
                    effective |= cp.action_mask;
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
            }
            /* strategy: Check for full match first. Then work our way up the
            name looking for matches on a.b.*
             */
            cp = pc.get(requestedName);
            if (cp != null) {
                /* we have a direct hit! */
                effective |= cp.action_mask;
                if ((effective & desired) == desired) {
                    return true;
                }
            }
            /* work our way up the tree... */
            int last;
            int offset = requestedName.length() - 1;
            while ((last = requestedName.lastIndexOf(".", offset)) != (-1)) {
                requestedName = requestedName.substring(0, last + 1) + "*";
                cp = pc.get(requestedName);
                if (cp != null) {
                    effective |= cp.action_mask;
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
                offset = last - 1;
            } 
            /* we don't have to check for "*" as it was already checked before
            we were called.
             */
            pc = filterPermissions;
            if (pc == null) {
                return false;
            }
            perms = pc.values();
        }
        /* iterate one by one over filteredPermissions */
        for (CapabilityPermission perm : perms) {
            if (perm.implies0(requested, effective)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns an enumeration of all the {@code CapabilityPermission} objects in
     * the container.
     *
     * @return Enumeration of all the CapabilityPermission objects.
     */
    @Override
    public synchronized Enumeration<Permission> elements() {
        List<Permission> all = new ArrayList<Permission>(permissions.values());
        Map<String, CapabilityPermission> pc = filterPermissions;
        if (pc != null) {
            all.addAll(pc.values());
        }
        return Collections.enumeration(all);
    }

    /* serialization logic */
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", HashMap.class), new ObjectStreamField("all_allowed", Boolean.TYPE), new ObjectStreamField("filterPermissions", HashMap.class) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("permissions", permissions);
        pfields.put("all_allowed", all_allowed);
        pfields.put("filterPermissions", filterPermissions);
        out.writeFields();
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        @SuppressWarnings("unchecked")
        HashMap<String, CapabilityPermission> p = ((HashMap<String, CapabilityPermission>) (gfields.get("permissions", null)));
        permissions = p;
        all_allowed = gfields.get("all_allowed", false);
        @SuppressWarnings("unchecked")
        HashMap<String, CapabilityPermission> fp = ((HashMap<String, CapabilityPermission>) (gfields.get("filterPermissions", null)));
        filterPermissions = fp;
    }
}