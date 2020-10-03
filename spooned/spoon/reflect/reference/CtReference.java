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
package spoon.reflect.reference;


/**
 * This is the root interface for named program element references. References
 * can point to program element built in the model or not. In the latter case,
 * introspection methods fall back on runtime reflection (
 * <code>java.lang.reflect</code>) to access the program information, as long as
 * available in the classpath.
 *
 * @see spoon.reflect.declaration.CtElement
 */
public interface CtReference extends spoon.reflect.declaration.CtElement {
    /**
     * Gets the simple name of referenced element.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.NAME)
    java.lang.String getSimpleName();

    /**
     * Sets the name of referenced element.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.NAME)
    <T extends spoon.reflect.reference.CtReference> T setSimpleName(java.lang.String simpleName);

    /**
     * Returns the declaration that corresponds to the referenced element only
     * if the declaration is in the analyzed source files.
     * It is strongly advised to use the more robust {@link CtTypeReference#getTypeDeclaration()} and {@link CtExecutableReference#getExecutableDeclaration()} that never return null.
     *
     * @return referenced element or null if element is not in the source path (aka input resource).
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtElement getDeclaration();

    @java.lang.Override
    spoon.reflect.reference.CtReference clone();

    /**
     * comments are not possible for references
     */
    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E setComments(java.util.List<spoon.reflect.code.CtComment> comments);
}

