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
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.AccessController;
import java.security.BasicPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
/**
 * A bundle's authority to import or export a package.
 *
 * <p>
 * A package is a dot-separated string that defines a fully qualified Java
 * package.
 * <p>
 * For example:
 *
 * <pre>
 * org.osgi.service.http
 * </pre>
 *
 * <p>
 * {@code PackagePermission} has three actions: {@code exportonly},
 * {@code import} and {@code export}. The {@code export} action, which is
 * deprecated, implies the {@code import} action.
 *
 * @unknown 
 * @author $Id: c2d45ff158a6a19ff7bc155af3ac9941cb6a89d6 $
 */
public final class PackagePermission extends BasicPermission {
    static final long serialVersionUID = -5107705877071099135L;

    /**
     * The action string {@code export}. The {@code export} action implies the
     * {@code import} action.
     *
     * @deprecated Since 1.5. Use {@code exportonly} instead.
     */
    public static final String EXPORT = "export";

    /**
     * The action string {@code exportonly}. The {@code exportonly} action does
     * not imply the {@code import} action.
     *
     * @since 1.5
     */
    public static final String EXPORTONLY = "exportonly";

    /**
     * The action string {@code import}.
     */
    public static final String IMPORT = "import";

    private static final int ACTION_EXPORT = 0x1;

    private static final int ACTION_IMPORT = 0x2;

    private static final int ACTION_ALL = ACTION_EXPORT | ACTION_IMPORT;

    static final int ACTION_NONE = 0;

    /**
     * The actions mask.
     */
    transient int action_mask;

    /**
     * The actions in canonical form.
     *
     * @serial 
     */
    private volatile String actions = null;

    /**
     * The bundle used by this PackagePermission.
     */
    final transient Bundle bundle;

    /**
     * If this PackagePermission was constructed with a filter, this holds a
     * Filter matching object used to evaluate the filter in implies.
     */
    transient Filter filter;

    /**
     * This map holds the properties of the permission, used to match a filter
     * in implies. This is not initialized until necessary, and then cached in
     * this object.
     */
    private volatile transient Map<String, Object> properties;

    /**
     * Creates a new {@code PackagePermission} object.
     *
     * <p>
     * The name is specified as a normal Java package name: a dot-separated
     * string. Wildcards may be used.
     *
     * <pre>
     * name ::= &lt;package name&gt; | &lt;package name ending in &quot;.*&quot;&gt; | *
     * </pre>
     *
     * Examples:
     *
     * <pre>
     * org.osgi.service.http
     * javax.servlet.*
     * *
     * </pre>
     *
     * For the {@code import} action, the name can also be a filter expression.
     * The filter gives access to the following attributes:
     * <ul>
     * <li>signer - A Distinguished Name chain used to sign the exporting
     * bundle. Wildcards in a DN are not matched according to the filter string
     * rules, but according to the rules defined for a DN chain.</li>
     * <li>location - The location of the exporting bundle.</li>
     * <li>id - The bundle ID of the exporting bundle.</li>
     * <li>name - The symbolic name of the exporting bundle.</li>
     * <li>package.name - The name of the requested package.</li>
     * </ul>
     * Filter attribute names are processed in a case sensitive manner.
     *
     * <p>
     * Package Permissions are granted over all possible versions of a package.
     *
     * A bundle that needs to export a package must have the appropriate
     * {@code PackagePermission} for that package; similarly, a bundle that
     * needs to import a package must have the appropriate
     * {@code PackagePermssion} for that package.
     * <p>
     * Permission is granted for both classes and resources.
     *
     * @param name
     * 		Package name or filter expression. A filter expression can
     * 		only be specified if the specified action is {@code import}.
     * @param actions
     * 		{@code exportonly},{@code import} (canonical order).
     * @throws IllegalArgumentException
     * 		If the specified name is a filter
     * 		expression and either the specified action is not {@code import}
     * 		or the filter has an invalid syntax.
     */
    public PackagePermission(String name, String actions) {
        this(name, parseActions(actions));
        if ((filter != null) && ((action_mask & ACTION_ALL) != ACTION_IMPORT)) {
            throw new IllegalArgumentException("invalid action string for filter expression");
        }
    }

    /**
     * Creates a new requested {@code PackagePermission} object to be used by
     * code that must perform {@code checkPermission} for the {@code import}
     * action. {@code PackagePermission} objects created with this constructor
     * cannot be added to a {@code PackagePermission} permission collection.
     *
     * @param name
     * 		The name of the requested package to import.
     * @param exportingBundle
     * 		The bundle exporting the requested package.
     * @param actions
     * 		The action {@code import}.
     * @throws IllegalArgumentException
     * 		If the specified action is not
     * 		{@code import} or the name is a filter expression.
     * @since 1.5
     */
    public PackagePermission(String name, Bundle exportingBundle, String actions) {
        super(name);
        setTransients(name, parseActions(actions));
        this.bundle = exportingBundle;
        if (exportingBundle == null) {
            throw new IllegalArgumentException("bundle must not be null");
        }
        if (filter != null) {
            throw new IllegalArgumentException("invalid name");
        }
        if ((action_mask & ACTION_ALL) != ACTION_IMPORT) {
            throw new IllegalArgumentException("invalid action string");
        }
    }

    /**
     * Package private constructor used by PackagePermissionCollection.
     *
     * @param name
     * 		package name
     * @param mask
     * 		action mask
     */
    PackagePermission(String name, int mask) {
        super(name);
        setTransients(name, mask);
        this.bundle = null;
    }

    /**
     * Called by constructors and when deserialized.
     *
     * @param mask
     * 		action mask
     */
    private void setTransients(String name, int mask) {
        if ((mask == ACTION_NONE) || ((mask & ACTION_ALL) != mask)) {
            throw new IllegalArgumentException("invalid action string");
        }
        action_mask = mask;
        filter = parseFilter(name);
    }

    /**
     * Parse action string into action mask.
     *
     * @param actions
     * 		Action string.
     * @return action mask.
     */
    private static int parseActions(String actions) {
        boolean seencomma = false;
        int mask = ACTION_NONE;
        if (actions == null) {
            return mask;
        }
        char[] a = actions.toCharArray();
        int i = a.length - 1;
        if (i < 0)
            return mask;

        while (i != (-1)) {
            char c;
            // skip whitespace
            while ((i != (-1)) && ((((((c = a[i]) == ' ') || (c == '\r')) || (c == '\n')) || (c == '\f')) || (c == '\t')))
                i--;

            // check for the known strings
            int matchlen;
            if (((((((i >= 5) && ((a[i - 5] == 'i') || (a[i - 5] == 'I'))) && ((a[i - 4] == 'm') || (a[i - 4] == 'M'))) && ((a[i - 3] == 'p') || (a[i - 3] == 'P'))) && ((a[i - 2] == 'o') || (a[i - 2] == 'O'))) && ((a[i - 1] == 'r') || (a[i - 1] == 'R'))) && ((a[i] == 't') || (a[i] == 'T'))) {
                matchlen = 6;
                mask |= ACTION_IMPORT;
            } else if (((((((i >= 5) && ((a[i - 5] == 'e') || (a[i - 5] == 'E'))) && ((a[i - 4] == 'x') || (a[i - 4] == 'X'))) && ((a[i - 3] == 'p') || (a[i - 3] == 'P'))) && ((a[i - 2] == 'o') || (a[i - 2] == 'O'))) && ((a[i - 1] == 'r') || (a[i - 1] == 'R'))) && ((a[i] == 't') || (a[i] == 'T'))) {
                matchlen = 6;
                mask |= ACTION_EXPORT | ACTION_IMPORT;
            } else if (((((((((((i >= 9) && ((a[i - 9] == 'e') || (a[i - 9] == 'E'))) && ((a[i - 8] == 'x') || (a[i - 8] == 'X'))) && ((a[i - 7] == 'p') || (a[i - 7] == 'P'))) && ((a[i - 6] == 'o') || (a[i - 6] == 'O'))) && ((a[i - 5] == 'r') || (a[i - 5] == 'R'))) && ((a[i - 4] == 't') || (a[i - 4] == 'T'))) && ((a[i - 3] == 'o') || (a[i - 3] == 'O'))) && ((a[i - 2] == 'n') || (a[i - 2] == 'N'))) && ((a[i - 1] == 'l') || (a[i - 1] == 'L'))) && ((a[i] == 'y') || (a[i] == 'Y'))) {
                matchlen = 10;
                mask |= ACTION_EXPORT;
            } else {
                // parse error
                throw new IllegalArgumentException("invalid permission: " + actions);
            }
            // make sure we didn't just match the tail of a word
            // like "ackbarfimport". Also, skip to the comma.
            seencomma = false;
            while ((i >= matchlen) && (!seencomma)) {
                switch (a[i - matchlen]) {
                    case ',' :
                        seencomma = true;
                        /* FALLTHROUGH */
                    case ' ' :
                    case '\r' :
                    case '\n' :
                    case '\f' :
                    case '\t' :
                        break;
                    default :
                        throw new IllegalArgumentException("invalid permission: " + actions);
                }
                i--;
            } 
            // point i at the location of the comma minus one (or -1).
            i -= matchlen;
        } 
        if (seencomma) {
            throw new IllegalArgumentException("invalid permission: " + actions);
        }
        return mask;
    }

    /**
     * Parse filter string into a Filter object.
     *
     * @param filterString
     * 		The filter string to parse.
     * @return a Filter for this bundle. If the specified filterString is not a
    filter expression, then {@code null} is returned.
     * @throws IllegalArgumentException
     * 		If the filter syntax is invalid.
     */
    private static Filter parseFilter(String filterString) {
        filterString = filterString.trim();
        if (filterString.charAt(0) != '(') {
            return null;
        }
        try {
            return FrameworkUtil.createFilter(filterString);
        } catch (InvalidSyntaxException e) {
            IllegalArgumentException iae = new IllegalArgumentException("invalid filter");
            iae.initCause(e);
            throw iae;
        }
    }

    /**
     * Determines if the specified permission is implied by this object.
     *
     * <p>
     * This method checks that the package name of the target is implied by the
     * package name of this object. The list of {@code PackagePermission}
     * actions must either match or allow for the list of the target object to
     * imply the target {@code PackagePermission} action.
     * <p>
     * The permission to export a package implies the permission to import the
     * named package.
     *
     * <pre>
     * x.y.*,&quot;export&quot; -&gt; x.y.z,&quot;export&quot; is true
     * *,&quot;import&quot; -&gt; x.y, &quot;import&quot;      is true
     * *,&quot;export&quot; -&gt; x.y, &quot;import&quot;      is true
     * x.y,&quot;export&quot; -&gt; x.y.z, &quot;export&quot;  is false
     * </pre>
     *
     * @param p
     * 		The requested permission.
     * @return {@code true} if the specified permission is implied by this
    object; {@code false} otherwise.
     */
    @Override
    public boolean implies(Permission p) {
        if (!(p instanceof PackagePermission)) {
            return false;
        }
        PackagePermission requested = ((PackagePermission) (p));
        if (bundle != null) {
            return false;
        }
        // if requested permission has a filter, then it is an invalid argument
        if (requested.filter != null) {
            return false;
        }
        return implies0(requested, ACTION_NONE);
    }

    /**
     * Internal implies method. Used by the implies and the permission
     * collection implies methods.
     *
     * @param requested
     * 		The requested PackagePermission which has already be
     * 		validated as a proper argument. The requested PackagePermission
     * 		must not have a filter expression.
     * @param effective
     * 		The effective actions with which to start.
     * @return {@code true} if the specified permission is implied by this
    object; {@code false} otherwise.
     */
    boolean implies0(PackagePermission requested, int effective) {
        /* check actions first - much faster */
        effective |= action_mask;
        final int desired = requested.action_mask;
        if ((effective & desired) != desired) {
            return false;
        }
        /* Get filter if any */
        Filter f = filter;
        if (f == null) {
            return super.implies(requested);
        }
        return f.matches(requested.getProperties());
    }

    /**
     * Returns the canonical string representation of the
     * {@code PackagePermission} actions.
     *
     * <p>
     * Always returns present {@code PackagePermission} actions in the following
     * order: {@code EXPORTONLY},{@code IMPORT}.
     *
     * @return Canonical string representation of the {@code PackagePermission}
    actions.
     */
    @Override
    public String getActions() {
        String result = actions;
        if (result == null) {
            StringBuffer sb = new StringBuffer();
            boolean comma = false;
            int mask = action_mask;
            if ((mask & ACTION_EXPORT) == ACTION_EXPORT) {
                sb.append(EXPORTONLY);
                comma = true;
            }
            if ((mask & ACTION_IMPORT) == ACTION_IMPORT) {
                if (comma)
                    sb.append(',');

                sb.append(IMPORT);
            }
            actions = result = sb.toString();
        }
        return result;
    }

    /**
     * Returns a new {@code PermissionCollection} object suitable for storing
     * {@code PackagePermission} objects.
     *
     * @return A new {@code PermissionCollection} object.
     */
    @Override
    public PermissionCollection newPermissionCollection() {
        return new PackagePermissionCollection();
    }

    /**
     * Determines the equality of two {@code PackagePermission} objects.
     *
     * This method checks that specified package has the same package name and
     * {@code PackagePermission} actions as this {@code PackagePermission}
     * object.
     *
     * @param obj
     * 		The object to test for equality with this
     * 		{@code PackagePermission} object.
     * @return {@code true} if {@code obj} is a {@code PackagePermission}, and
    has the same package name and actions as this
    {@code PackagePermission} object; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PackagePermission)) {
            return false;
        }
        PackagePermission pp = ((PackagePermission) (obj));
        return ((action_mask == pp.action_mask) && getName().equals(pp.getName())) && ((bundle == pp.bundle) || ((bundle != null) && bundle.equals(pp.bundle)));
    }

    /**
     * Returns the hash code value for this object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        int h = (31 * 17) + getName().hashCode();
        h = (31 * h) + getActions().hashCode();
        if (bundle != null) {
            h = (31 * h) + bundle.hashCode();
        }
        return h;
    }

    /**
     * WriteObject is called to save the state of this permission object to a
     * stream. The actions are serialized, and the superclass takes care of the
     * name.
     */
    private synchronized void writeObject(ObjectOutputStream s) throws IOException {
        if (bundle != null) {
            throw new NotSerializableException("cannot serialize");
        }
        // Write out the actions. The superclass takes care of the name
        // call getActions to make sure actions field is initialized
        if (actions == null)
            getActions();

        s.defaultWriteObject();
    }

    /**
     * readObject is called to restore the state of this permission from a
     * stream.
     */
    private synchronized void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        // Read in the action, then initialize the rest
        s.defaultReadObject();
        setTransients(getName(), parseActions(actions));
    }

    /**
     * Called by {@link PackagePermission#implies(Permission)}. This method is
     * only called on a requested permission which cannot have a filter set.
     *
     * @return a map of properties for this permission.
     */
    private Map<String, Object> getProperties() {
        Map<String, Object> result = properties;
        if (result != null) {
            return result;
        }
        final Map<String, Object> map = new HashMap<String, Object>(5);
        map.put("package.name", getName());
        if (bundle != null) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    map.put("id", new Long(bundle.getBundleId()));
                    map.put("location", bundle.getLocation());
                    String name = bundle.getSymbolicName();
                    if (name != null) {
                        map.put("name", name);
                    }
                    SignerProperty signer = new SignerProperty(bundle);
                    if (signer.isBundleSigned()) {
                        map.put("signer", signer);
                    }
                    return null;
                }
            });
        }
        return properties = map;
    }
}