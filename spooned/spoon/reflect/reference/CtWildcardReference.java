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
 * Represents a wildcard in generic type annotations, i.e. the "?" (e.g. the "?" in Collection&lt;?&gt; or Collection&lt;? extends List&gt;).
 */
public interface CtWildcardReference extends spoon.reflect.reference.CtTypeParameterReference {
    @java.lang.Override
    spoon.reflect.reference.CtWildcardReference clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.reference.CtReference> C setSimpleName(java.lang.String simpleName);

    /**
     * Returns {@code true} if the bounds are in <code>extends</code> clause.
     * {@code false} means a <code>super</code> clause.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.IS_UPPER)
    boolean isUpper();

    /**
     * Set to {@code true} to write <code>extends</code> clause for bounds types.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.IS_UPPER)
    <T extends spoon.reflect.reference.CtWildcardReference> T setUpper(boolean upper);

    /**
     * A type parameter can have an <code>extends</code> clause which declare
     * one ({@link CtTypeReference} or more ({@link CtIntersectionTypeReference} references.
     * <pre>
     *     // Extends with generics.
     *     T extends Interface1
     *     // Intersection type with generics.
     *     T extends Interface1 &amp; Interface2
     * </pre>
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.BOUNDING_TYPE)
    @java.lang.Override
    spoon.reflect.reference.CtTypeReference<?> getBoundingType();

    /**
     * Sets the <code>extends</code> clause of the type parameter.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.BOUNDING_TYPE)
    <T extends spoon.reflect.reference.CtWildcardReference> T setBoundingType(spoon.reflect.reference.CtTypeReference<?> superType);
}

