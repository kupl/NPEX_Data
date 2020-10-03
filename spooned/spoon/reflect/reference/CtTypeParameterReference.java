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
 * This interface defines a reference to a type parameter (aka generics).
 */
public interface CtTypeParameterReference extends spoon.reflect.reference.CtTypeReference<java.lang.Object> {
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
    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtTypeReference<?> getBoundingType();

    /**
     * Returns the {@link CtTypeParameter}, a {@link CtTypeParameter}, that declares the type parameter
     * referenced or <code>null</code> if the reference is not in a context where such type parameter is declared.
     * See also {@link #getTypeParameterDeclaration()} which has a different semantic.
     */
    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtTypeParameter getDeclaration();

    // overriding the return type
    @java.lang.Override
    spoon.reflect.reference.CtTypeParameterReference clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <T extends spoon.reflect.reference.CtActualTypeContainer> T setActualTypeArguments(java.util.List<? extends spoon.reflect.reference.CtTypeReference<?>> actualTypeArguments);

    /**
     * Returns true if this has the default bounding type that is java.lang.Object (which basically means that there is no bound)
     */
    @spoon.support.DerivedProperty
    boolean isDefaultBoundingType();
}

