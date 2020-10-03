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
package spoon.reflect.visitor;


public class PrintingContext {
    private long NEXT_FOR_VARIABLE = 1 << 0;

    private long IGNORE_GENERICS = 1 << 1;

    private long SKIP_ARRAY = 1 << 2;

    private long IGNORE_STATIC_ACCESS = 1 << 3;

    private long IGNORE_ENCLOSING_CLASS = 1 << 4;

    private long FORCE_WILDCARD_GENERICS = 1 << 5;

    private long FIRST_FOR_VARIABLE = 1 << 6;

    private long state;

    private spoon.reflect.code.CtStatement statement;

    /**
     *
     *
     * @return true if we are printing first variable declaration of CtFor statement
     */
    public boolean isFirstForVariable() {
        return ((state) & (FIRST_FOR_VARIABLE)) != 0L;
    }

    /**
     *
     *
     * @return true if we are printing second or next variable declaration of CtFor statement
     */
    public boolean isNextForVariable() {
        return ((state) & (NEXT_FOR_VARIABLE)) != 0L;
    }

    public boolean ignoreGenerics() {
        return ((state) & (IGNORE_GENERICS)) != 0L;
    }

    public boolean skipArray() {
        return ((state) & (SKIP_ARRAY)) != 0L;
    }

    public boolean ignoreStaticAccess() {
        return ((state) & (IGNORE_STATIC_ACCESS)) != 0L;
    }

    public boolean ignoreEnclosingClass() {
        return ((state) & (IGNORE_ENCLOSING_CLASS)) != 0L;
    }

    public boolean forceWildcardGenerics() {
        return ((state) & (FORCE_WILDCARD_GENERICS)) != 0L;
    }

    /**
     *
     *
     * @return true if `stmt` has to be handled as statement in current printing context
     */
    public boolean isStatement(spoon.reflect.code.CtStatement stmt) {
        return (this.statement) == stmt;
    }

    public class Writable implements java.lang.AutoCloseable {
        private long oldState;

        private spoon.reflect.code.CtStatement oldStatement;

        protected Writable() {
            oldState = state;
            oldStatement = statement;
        }

        @java.lang.Override
        public void close() {
            state = oldState;
            statement = oldStatement;
        }

        /**
         *
         *
         * @param v
         * 		use true if printing first variable declaration of CtFor statement
         */
        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T isFirstForVariable(boolean v) {
            setState(FIRST_FOR_VARIABLE, v);
            return ((T) (this));
        }

        /**
         *
         *
         * @param v
         * 		use true if printing second or next variable declaration of CtFor statement
         */
        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T isNextForVariable(boolean v) {
            setState(NEXT_FOR_VARIABLE, v);
            return ((T) (this));
        }

        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T ignoreGenerics(boolean v) {
            setState(IGNORE_GENERICS, v);
            return ((T) (this));
        }

        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T skipArray(boolean v) {
            setState(SKIP_ARRAY, v);
            return ((T) (this));
        }

        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T ignoreStaticAccess(boolean v) {
            setState(IGNORE_STATIC_ACCESS, v);
            return ((T) (this));
        }

        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T ignoreEnclosingClass(boolean v) {
            setState(IGNORE_ENCLOSING_CLASS, v);
            return ((T) (this));
        }

        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T forceWildcardGenerics(boolean v) {
            setState(FORCE_WILDCARD_GENERICS, v);
            return ((T) (this));
        }

        /**
         * There are statements (e.g. invocation), which may play role of expression too.
         * They have to be suffixed by semicolon depending on the printing context.
         * Call this method to inform printer that invocation is used as statement.
         *
         * @param stmt
         * 		the instance of the actually printed statement.
         * 		Such statement will be finished by semicolon.
         */
        public <T extends spoon.reflect.visitor.PrintingContext.Writable> T setStatement(spoon.reflect.code.CtStatement stmt) {
            statement = stmt;
            return ((T) (this));
        }

        private void setState(long mask, boolean v) {
            state = (v) ? (state) | mask : (state) & (~mask);
        }
    }

    public spoon.reflect.visitor.PrintingContext.Writable modify() {
        return new spoon.reflect.visitor.PrintingContext.Writable();
    }

    java.util.Deque<spoon.reflect.visitor.CacheBasedConflictFinder> currentThis = new java.util.ArrayDeque<>();

    /**
     *
     *
     * @return top level type
     */
    public spoon.reflect.reference.CtTypeReference<?> getCurrentTypeReference() {
        if ((currentTopLevel) != null) {
            spoon.reflect.visitor.CacheBasedConflictFinder tc = getCurrentTypeContext();
            if (tc != null) {
                return tc.typeRef;
            }
            return currentTopLevel.getReference();
        }
        return null;
    }

    private spoon.reflect.visitor.CacheBasedConflictFinder getCurrentTypeContext() {
        if (((currentThis) != null) && (!(currentThis.isEmpty()))) {
            return currentThis.peek();
        }
        return null;
    }

    public void pushCurrentThis(spoon.reflect.declaration.CtType<?> type) {
        currentThis.push(new spoon.reflect.visitor.CacheBasedConflictFinder(type));
    }

    public void popCurrentThis() {
        currentThis.pop();
    }

    java.util.Deque<spoon.reflect.declaration.CtElement> elementStack = new java.util.ArrayDeque<>();

    java.util.Deque<spoon.reflect.code.CtExpression<?>> parenthesedExpression = new java.util.ArrayDeque<>();

    spoon.reflect.declaration.CtType<?> currentTopLevel;

    @java.lang.Override
    public java.lang.String toString() {
        return ("context.ignoreGenerics: " + (ignoreGenerics())) + "\n";
    }

    /**
     *
     *
     * @param typeRef
     * 		
     * @return true if typeRef is equal to current (actually printed) Type (currentThis)
     */
    public boolean isInCurrentScope(spoon.reflect.reference.CtTypeReference<?> typeRef) {
        spoon.reflect.reference.CtTypeReference<?> currentTypeRef = getCurrentTypeReference();
        return typeRef.equals(currentTypeRef);
    }
}

