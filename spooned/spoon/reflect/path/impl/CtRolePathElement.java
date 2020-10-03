package spoon.reflect.path.impl;


public class CtRolePathElement extends spoon.reflect.path.impl.AbstractPathElement<spoon.reflect.declaration.CtElement, spoon.reflect.declaration.CtElement> {
    private class RoleVisitor extends spoon.reflect.visitor.CtInheritanceScanner {
        private java.util.Collection<spoon.reflect.declaration.CtElement> matchs = new java.util.LinkedList<>();

        private RoleVisitor() {
        }

        @java.lang.Override
        public <R> void scanCtExecutable(spoon.reflect.declaration.CtExecutable<R> e) {
            super.scanCtExecutable(e);
            switch (role) {
                case BODY :
                    if ((e.getBody()) != null) {
                        if ((getArguments().containsKey("index")) && ((e.getBody().getStatements().size()) > (java.lang.Integer.parseInt(getArguments().get("index"))))) {
                            matchs.add(e.getBody().getStatements().get(java.lang.Integer.parseInt(getArguments().get("index"))));
                        }else {
                            matchs.addAll(e.getBody().getStatements());
                        }
                    }
            }
        }

        @java.lang.Override
        public <T> void visitCtField(spoon.reflect.declaration.CtField<T> e) {
            super.visitCtField(e);
            if (((role) == (spoon.reflect.path.CtRole.DEFAULT_EXPRESSION)) && ((e.getDefaultExpression()) != null)) {
                matchs.add(e.getDefaultExpression());
            }
        }

        @java.lang.Override
        public void visitCtIf(spoon.reflect.code.CtIf e) {
            super.visitCtIf(e);
            switch (role) {
                case THEN :
                    if ((e.getThenStatement()) != null) {
                        matchs.add(e.getThenStatement());
                    }
                case ELSE :
                    if ((e.getElseStatement()) != null) {
                        matchs.add(e.getElseStatement());
                    }
            }
        }
    }

    public static final java.lang.String STRING = "#";

    private final spoon.reflect.path.CtRole role;

    public CtRolePathElement(spoon.reflect.path.CtRole role) {
        this.role = role;
    }

    public spoon.reflect.path.CtRole getRole() {
        return role;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((spoon.reflect.path.impl.CtRolePathElement.STRING) + (role.toString())) + (getParamString());
    }

    @java.lang.Override
    public java.util.Collection<spoon.reflect.declaration.CtElement> getElements(java.util.Collection<spoon.reflect.declaration.CtElement> roots) {
        spoon.reflect.path.impl.CtRolePathElement.RoleVisitor visitor = new spoon.reflect.path.impl.CtRolePathElement.RoleVisitor();
        visitor.scan(roots);
        return visitor.matchs;
    }
}

