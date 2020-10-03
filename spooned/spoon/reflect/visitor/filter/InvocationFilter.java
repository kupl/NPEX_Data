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
package spoon.reflect.visitor.filter;


/**
 * This simple filter matches all the accesses to a given executable or any
 * executable that overrides it.
 */
public class InvocationFilter implements spoon.reflect.visitor.Filter<spoon.reflect.code.CtInvocation<?>> {
    private spoon.reflect.reference.CtExecutableReference<?> executable;

    /**
     * Creates a new invocation filter.
     *
     * @param executable
     * 		the executable to be tested for being invoked
     */
    public InvocationFilter(spoon.reflect.reference.CtExecutableReference<?> executable) {
        this.executable = executable;
    }

    /**
     * Creates a new invocation filter.
     *
     * @param method
     * 		the executable to be tested for being invoked.
     */
    public InvocationFilter(spoon.reflect.declaration.CtMethod<?> method) {
        this(method.getReference());
    }

    @java.lang.Override
    public boolean matches(spoon.reflect.code.CtInvocation<?> invocation) {
        return invocation.getExecutable().isOverriding(executable);
    }
}

