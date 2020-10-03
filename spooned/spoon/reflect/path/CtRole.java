/**
 * Copyright (C) 2006-2018 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.path;


/**
 * Identifies the roles of attributes of spoon model.
 */
public enum CtRole {

    NAME,
    TYPE,
    MULTI_TYPE,
    DECLARING_TYPE,
    DECLARED_TYPE_REF,
    DECLARED_MODULE_REF,
    PACKAGE_DECLARATION,
    DECLARED_IMPORT,
    CONTAINED_TYPE,
    BODY,
    IS_SHADOW,
    BOUND,
    // in reference only
    BOUNDING_TYPE,
    // in reference only
    IS_FINAL,
    // in reference only
    IS_STATIC,
    // in reference only
    IS_UPPER,
    // in reference only
    IS_IMPLICIT,
    IS_DEFAULT,
    IS_VARARGS,
    DEFAULT_EXPRESSION,
    THEN,
    ELSE,
    PACKAGE_REF,
    SUB_PACKAGE,
    CONDITION,
    RIGHT_OPERAND,
    LEFT_OPERAND,
    LABEL,
    CASE,
    OPERATOR_KIND,
    PARAMETER,
    ARGUMENT_TYPE,
    EXPRESSION,
    TARGET,
    VARIABLE,
    FINALIZER,
    THROWN,
    ASSIGNMENT,
    ASSIGNED,
    MODIFIER,
    COMMENT,
    ANNOTATION_TYPE,
    INTERFACE,
    ANNOTATION,
    STATEMENT,
    ARGUMENT,
    SUPER_TYPE,
    TYPE_MEMBER,
    NESTED_TYPE(spoon.reflect.path.CtRole.TYPE_MEMBER, ( obj) -> obj instanceof spoon.reflect.declaration.CtType),
    CONSTRUCTOR(spoon.reflect.path.CtRole.TYPE_MEMBER, ( obj) -> obj instanceof spoon.reflect.declaration.CtConstructor),
    METHOD(spoon.reflect.path.CtRole.TYPE_MEMBER, ( obj) -> obj instanceof spoon.reflect.declaration.CtMethod),
    ANNONYMOUS_EXECUTABLE(spoon.reflect.path.CtRole.TYPE_MEMBER, ( obj) -> obj instanceof spoon.reflect.declaration.CtAnonymousExecutable),
    FIELD(spoon.reflect.path.CtRole.TYPE_MEMBER, ( obj) -> obj instanceof spoon.reflect.declaration.CtField),
    EXECUTABLE_REF,
    CAST,
    VALUE,
    FOR_UPDATE,
    FOR_INIT,
    FOREACH_VARIABLE,
    TRY_RESOURCE,
    DIMENSION,
    CATCH,
    TARGET_LABEL,
    TYPE_PARAMETER,
    TYPE_ARGUMENT,
    COMMENT_TAG,
    COMMENT_CONTENT,
    COMMENT_TYPE,
    DOCUMENTATION_TYPE,
    JAVADOC_TAG_VALUE,
    POSITION,
    SNIPPET,
    ACCESSED_TYPE,
    IMPORT_REFERENCE,
    MODULE_DIRECTIVE,
    REQUIRED_MODULE(spoon.reflect.path.CtRole.MODULE_DIRECTIVE, ( obj) -> obj instanceof spoon.reflect.declaration.CtModuleRequirement),
    MODULE_REF,
    EXPORTED_PACKAGE(spoon.reflect.path.CtRole.MODULE_DIRECTIVE, ( obj) -> (obj instanceof spoon.reflect.declaration.CtPackageExport) && (!(((spoon.reflect.declaration.CtPackageExport) (obj)).isOpenedPackage()))),
    OPENED_PACKAGE(spoon.reflect.path.CtRole.MODULE_DIRECTIVE, ( obj) -> (obj instanceof spoon.reflect.declaration.CtPackageExport) && (((spoon.reflect.declaration.CtPackageExport) (obj)).isOpenedPackage())),
    SERVICE_TYPE(spoon.reflect.path.CtRole.MODULE_DIRECTIVE, ( obj) -> obj instanceof spoon.reflect.declaration.CtUsedService),
    IMPLEMENTATION_TYPE,
    PROVIDED_SERVICE(spoon.reflect.path.CtRole.MODULE_DIRECTIVE, ( obj) -> obj instanceof spoon.reflect.declaration.CtProvidedService),
    IS_INFERRED,
    TYPE_REF;
    private final spoon.reflect.path.CtRole superRole;

    private final java.util.List<spoon.reflect.path.CtRole> subRoles;

    private final java.util.function.Predicate<java.lang.Object> predicate;

    private java.util.List<spoon.reflect.path.CtRole> initSubRoles;

    CtRole() {
        this(null, null);
    }

    CtRole(spoon.reflect.path.CtRole superRole, java.util.function.Predicate<java.lang.Object> predicate) {
        this.superRole = superRole;
        this.initSubRoles = new java.util.ArrayList<>(0);
        this.subRoles = java.util.Collections.unmodifiableList(this.initSubRoles);
        this.predicate = predicate;
        if (superRole != null) {
            superRole.initSubRoles.add(this);
        }
    }

    static {
        // after all are initialized, avoid further modification
        for (spoon.reflect.path.CtRole role : spoon.reflect.path.CtRole.values()) {
            role.initSubRoles = null;
        }
    }

    /**
     * Get the {@link CtRole} associated to the field name
     *
     * @param name
     * 		
     * @return 
     */
    public static spoon.reflect.path.CtRole fromName(java.lang.String name) {
        for (spoon.reflect.path.CtRole role : spoon.reflect.path.CtRole.values()) {
            if ((role.getCamelCaseName().toLowerCase().equals(name.toLowerCase())) || (role.name().equals(name))) {
                return role;
            }
        }
        return null;
    }

    /**
     * Get the camel case representation of the name
     *
     * @return the name in camel case
     */
    public java.lang.String getCamelCaseName() {
        java.lang.String s = name().toLowerCase();
        java.lang.String[] tokens = s.split("_");
        if ((tokens.length) == 1) {
            return s;
        } else {
            java.lang.StringBuilder buffer = new java.lang.StringBuilder(tokens[0]);
            for (int i = 1; i < (tokens.length); i++) {
                java.lang.String t = tokens[i];
                buffer.append(java.lang.Character.toUpperCase(t.charAt(0)));
                buffer.append(t.substring(1));
            }
            return buffer.toString();
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return getCamelCaseName();
    }

    /**
     *
     *
     * @return the CtRole which is the real holder of this virtual CtRole or null if there is no super role.
     * For example {@link #TYPE_MEMBER} is super role of {@link #CONSTRUCTOR}, {@link #FIELD}, {@link #METHOD}, {@link #NESTED_TYPE}
     */
    public spoon.reflect.path.CtRole getSuperRole() {
        return superRole;
    }

    /**
     *
     *
     * @return sub roles of this super role or empty array if there is no sub role.
     * For example {@link #TYPE_MEMBER} is super role of {@link #CONSTRUCTOR}, {@link #FIELD}, {@link #METHOD}, {@link #NESTED_TYPE}
     */
    public java.util.List<spoon.reflect.path.CtRole> getSubRoles() {
        return subRoles;
    }

    /**
     *
     *
     * @return sub role of this role, which match `item`.
     * 
     * <pre><code>
     * CtMethod method = ...
     * CtRole role = CtRole.TYPE_MEMBER.getMatchingSubRoleFor(method);
     * </code></pre>
     */
    @spoon.support.Internal
    public spoon.reflect.path.CtRole getMatchingSubRoleFor(spoon.reflect.declaration.CtElement item) {
        if (item == null) {
            throw new spoon.SpoonException("Cannot detect sub role for null.");
        }
        for (spoon.reflect.path.CtRole subRole : this.subRoles) {
            if (subRole.predicate.test(item)) {
                return subRole;
            }
        }
        throw new spoon.SpoonException(((("There is no sub role of CtRole." + (name())) + " for item class ") + (item.getClass())));
    }
}

