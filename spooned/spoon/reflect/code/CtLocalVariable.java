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
package spoon.reflect.code;


/**
 * This code element defines a local variable definition (within an executable
 * body).
 *
 * Example:
 * <pre>
 *     // defines a local variable x
 *     int x = 0;
 * </pre>
 *
 * With Java 10, the local variable inference is now authorized, then the following code is valid too in a block scope:
 *
 * <pre>
 *     // local variable in Java 10
 *     var x = 0;
 * </pre>
 *
 * @param <T>
 * 		type of the variable
 * @see spoon.reflect.declaration.CtExecutable
 */
public interface CtLocalVariable<T> extends spoon.reflect.code.CtRHSReceiver<T> , spoon.reflect.code.CtStatement , spoon.reflect.declaration.CtVariable<T> {
    /* (non-Javadoc)

    @see spoon.reflect.declaration.CtNamedElement#getReference()
     */
    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtLocalVariableReference<T> getReference();

    /**
     * Useful proxy to {@link #getDefaultExpression()}.
     */
    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.code.CtExpression<T> getAssignment();

    @java.lang.Override
    spoon.reflect.code.CtLocalVariable<T> clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <U extends spoon.reflect.code.CtRHSReceiver<T>> U setAssignment(spoon.reflect.code.CtExpression<T> assignment);

    /**
     * Return true if this variable's type is not explicitely defined in the source code, but was using the `var` keyword of Java 10.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.IS_INFERRED)
    boolean isInferred();

    /**
     * Set true if the variable must be inferred.
     * Warning: this method should only be used if compliance level is set to 10 or more.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.IS_INFERRED)
    <U extends spoon.reflect.code.CtLocalVariable<T>> U setInferred(boolean inferred);
}

