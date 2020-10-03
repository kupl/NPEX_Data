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
 * Stores a set of ServicePermission permissions.
 *
 * @see java.security.Permission
 * @see java.security.Permissions
 * @see java.security.PermissionCollection
 */
final class ServicePermissionCollection extends PermissionCollection {
    static final long serialVersionUID = 662615640374640621L;

    /**
     * Table of permissions.
     *
     * @unknown this
     */
    private transient Map<String, ServicePermission> permissions;

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
    private Map<String, ServicePermission> filterPermissions;

    /**
     * Creates an empty ServicePermissions object.
     */
    public ServicePermissionCollection() {
        permissions = new HashMap<String, ServicePermission>();
        all_allowed = false;
    }

    /**
     * Adds a permission to this permission collection.
     *
     * @param permission
     * 		The Permission object to add.
     * @throws IllegalArgumentException
     * 		If the specified permission is not a
     * 		ServicePermission object.
     * @throws SecurityException
     * 		If this {@code ServicePermissionCollection}
     * 		object has been marked read-only.
     */
    @Override
    public void add(final Permission permission) {
        if (!(permission instanceof ServicePermission)) {
            throw new IllegalArgumentException("invalid permission: " + permission);
        }
        if (isReadOnly()) {
            throw new SecurityException("attempt to add a Permission to a " + "readonly PermissionCollection");
        }
        final ServicePermission sp = ((ServicePermission) (permission));
        if (sp.service != null) {
            throw new IllegalArgumentException("cannot add to collection: " + sp);
        }
        final String name = sp.getName();
        final Filter f = sp.filter;
        synchronized(this) {
            /* select the bucket for the permission */
            Map<String, ServicePermission> pc;
            if (f != null) {
                pc = filterPermissions;
                if (pc == null) {
                    filterPermissions = pc = new HashMap<String, ServicePermission>();
                }
            } else {
                pc = permissions;
            }
            final ServicePermission existing = pc.get(name);
            if (existing != null) {
                final int oldMask = existing.action_mask;
                final int newMask = sp.action_mask;
                if (oldMask != newMask) {
                    pc.put(name, new ServicePermission(name, oldMask | newMask));
                }
            } else {
                pc.put(name, sp);
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
        if (!(permission instanceof ServicePermission)) {
            return false;
        }
        final ServicePermission requested = ((ServicePermission) (permission));
        /* if requested permission has a filter, then it is an invalid argument */
        if (requested.filter != null) {
            return false;
        }
        int effective = ServicePermission.ACTION_NONE;
        Collection<ServicePermission> perms;
        synchronized(this) {
            final int desired = requested.action_mask;
            /* short circuit if the "*" Permission was added */
            if (all_allowed) {
                ServicePermission sp = permissions.get("*");
                if (sp != null) {
                    effective |= sp.action_mask;
                    if ((effective & desired) == desired) {
                        return true;
                    }
                }
            }
            String[] requestedNames = requested.objectClass;
            /* if requested permission not created with ServiceReference */
            if (requestedNames == null) {
                effective |= effective(requested.getName(), desired, effective);
                if ((effective & desired) == desired) {
                    return true;
                }
            } else /* requested permission created with ServiceReference */
            {
                for (int i = 0, l = requestedNames.length; i < l; i++) {
                    if ((effective(requestedNames[i], desired, effective) & desired) == desired) {
                        return true;
                    }
                }
            }
            Map<String, ServicePermission> pc = filterPermissions;
            if (pc == null) {
                return false;
            }
            perms = pc.values();
        }
        /* iterate one by one over filteredPermissions */
        for (ServicePermission perm : perms) {
            if (perm.implies0(requested, effective)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Consult permissions map to compute the effective permission for the
     * requested permission name.
     *
     * @param requestedName
     * 		The requested service name.
     * @param desired
     * 		The desired actions.
     * @param effective
     * 		The effective actions.
     * @return The new effective actions.
     */
    private int effective(String requestedName, final int desired, int effective) {
        final Map<String, ServicePermission> pc = permissions;
        ServicePermission sp = pc.get(requestedName);
        // strategy:
        // Check for full match first. Then work our way up the
        // name looking for matches on a.b.*
        if (sp != null) {
            // we have a direct hit!
            effective |= sp.action_mask;
            if ((effective & desired) == desired) {
                return effective;
            }
        }
        // work our way up the tree...
        int last;
        int offset = requestedName.length() - 1;
        while ((last = requestedName.lastIndexOf(".", offset)) != (-1)) {
            requestedName = requestedName.substring(0, last + 1) + "*";
            sp = pc.get(requestedName);
            if (sp != null) {
                effective |= sp.action_mask;
                if ((effective & desired) == desired) {
                    return effective;
                }
            }
            offset = last - 1;
        } 
        /* we don't have to check for "*" as it was already checked before we
        were called.
         */
        return effective;
    }

    /**
     * Returns an enumeration of all the {@code ServicePermission} objects in
     * the container.
     *
     * @return Enumeration of all the ServicePermission objects.
     */
    @Override
    public synchronized Enumeration<Permission> elements() {
        List<Permission> all = new ArrayList<Permission>(permissions.values());
        Map<String, ServicePermission> pc = filterPermissions;
        if (pc != null) {
            all.addAll(pc.values());
        }
        return Collections.enumeration(all);
    }

    /* serialization logic */
    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[]{ new ObjectStreamField("permissions", Hashtable.class), new ObjectStreamField("all_allowed", Boolean.TYPE), new ObjectStreamField("filterPermissions", HashMap.class) };

    private synchronized void writeObject(ObjectOutputStream out) throws IOException {
        Hashtable<String, ServicePermission> hashtable = new Hashtable<String, ServicePermission>(permissions);
        ObjectOutputStream.PutField pfields = out.putFields();
        pfields.put("permissions", hashtable);
        pfields.put("all_allowed", all_allowed);
        pfields.put("filterPermissions", filterPermissions);
        out.writeFields();
    }

    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gfields = in.readFields();
        @SuppressWarnings("unchecked")
        Hashtable<String, ServicePermission> hashtable = ((Hashtable<String, ServicePermission>) (gfields.get("permissions", null)));
        permissions = new HashMap<String, ServicePermission>(hashtable);
        all_allowed = gfields.get("all_allowed", false);
        @SuppressWarnings("unchecked")
        HashMap<String, ServicePermission> fp = ((HashMap<String, ServicePermission>) (gfields.get("filterPermissions", null)));
        filterPermissions = fp;
    }
}