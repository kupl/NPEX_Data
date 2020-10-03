package spoon.reflect.visitor;


public class AccessibleVariablesFinder {
    private spoon.reflect.declaration.CtElement expression;

    public AccessibleVariablesFinder(spoon.reflect.declaration.CtElement expression) {
        this.expression = expression;
    }

    public java.util.List<spoon.reflect.declaration.CtVariable> find() {
        if (expression.isParentInitialized()) {
            return getVariable(expression.getParent());
        }
        return java.util.Collections.emptyList();
    }

    private java.util.List<spoon.reflect.declaration.CtVariable> getVariable(final spoon.reflect.declaration.CtElement parent) {
        final java.util.List<spoon.reflect.declaration.CtVariable> variables = new java.util.ArrayList<>();
        if (parent == null) {
            return variables;
        }
        class VariableScanner extends spoon.reflect.visitor.CtInheritanceScanner {
            @java.lang.Override
            public void visitCtStatementList(spoon.reflect.code.CtStatementList e) {
                for (int i = 0; i < (e.getStatements().size()); i++) {
                    spoon.reflect.code.CtStatement ctStatement = e.getStatements().get(i);
                    if ((ctStatement.getPosition()) == null) {
                    }
                    if (((ctStatement.getPosition()) != null) && ((ctStatement.getPosition().getSourceStart()) > (expression.getPosition().getSourceEnd()))) {
                        break;
                    }
                    if (ctStatement instanceof spoon.reflect.declaration.CtVariable) {
                        variables.add(((spoon.reflect.declaration.CtVariable) (ctStatement)));
                    }
                }
                super.visitCtStatementList(e);
            }

            @java.lang.Override
            public <T> void scanCtType(spoon.reflect.declaration.CtType<T> type) {
                java.util.List<spoon.reflect.declaration.CtField<?>> fields = type.getFields();
                for (int i = 0; i < (fields.size()); i++) {
                    spoon.reflect.declaration.CtField<?> ctField = fields.get(i);
                    if ((ctField.hasModifier(spoon.reflect.declaration.ModifierKind.PUBLIC)) || (ctField.hasModifier(spoon.reflect.declaration.ModifierKind.PROTECTED))) {
                        variables.add(ctField);
                    }else
                        if (ctField.hasModifier(spoon.reflect.declaration.ModifierKind.PRIVATE)) {
                            if (expression.hasParent(type)) {
                                variables.add(ctField);
                            }
                        }else
                            if (expression.getParent(spoon.reflect.declaration.CtPackage.class).equals(type.getParent(spoon.reflect.declaration.CtPackage.class))) {
                                variables.add(ctField);
                            }
                        
                    
                }
                spoon.reflect.reference.CtTypeReference<?> superclass = type.getSuperclass();
                if (superclass != null) {
                    variables.addAll(getVariable(superclass.getTypeDeclaration()));
                }
                java.util.Set<spoon.reflect.reference.CtTypeReference<?>> superInterfaces = type.getSuperInterfaces();
                for (java.util.Iterator<spoon.reflect.reference.CtTypeReference<?>> iterator = superInterfaces.iterator(); iterator.hasNext();) {
                    spoon.reflect.reference.CtTypeReference<?> typeReference = iterator.next();
                    variables.addAll(getVariable(typeReference.getTypeDeclaration()));
                }
                super.scanCtType(type);
            }

            @java.lang.Override
            public void visitCtTryWithResource(spoon.reflect.code.CtTryWithResource e) {
                variables.addAll(e.getResources());
                super.visitCtTryWithResource(e);
            }

            @java.lang.Override
            public void scanCtExecutable(spoon.reflect.declaration.CtExecutable e) {
                variables.addAll(e.getParameters());
                super.scanCtExecutable(e);
            }

            @java.lang.Override
            public void visitCtFor(spoon.reflect.code.CtFor e) {
                for (spoon.reflect.code.CtStatement ctStatement : e.getForInit()) {
                    this.scan(ctStatement);
                }
                super.visitCtFor(e);
            }

            @java.lang.Override
            public void visitCtForEach(spoon.reflect.code.CtForEach e) {
                variables.add(e.getVariable());
                super.visitCtForEach(e);
            }

            @java.lang.Override
            public void visitCtMethod(spoon.reflect.declaration.CtMethod e) {
                this.scan(e.getBody());
                super.visitCtMethod(e);
            }

            @java.lang.Override
            public void visitCtLocalVariable(spoon.reflect.code.CtLocalVariable e) {
                variables.add(e);
                super.visitCtLocalVariable(e);
            }

            @java.lang.Override
            public void visitCtCatch(spoon.reflect.code.CtCatch e) {
                variables.add(e.getParameter());
                super.visitCtCatch(e);
            }
        }
        new VariableScanner().scan(parent);
        return variables;
    }
}

