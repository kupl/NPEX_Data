package spoon.reflect.visitor;


public abstract class CtScanner implements spoon.reflect.visitor.CtVisitor {
    public CtScanner() {
        super();
    }

    protected void enter(spoon.reflect.declaration.CtElement e) {
    }

    protected void exit(spoon.reflect.declaration.CtElement e) {
    }

    public void scan(java.util.Collection<? extends spoon.reflect.declaration.CtElement> elements) {
        if (elements != null) {
            for (spoon.reflect.declaration.CtElement e : new java.util.ArrayList<>(elements)) {
                scan(e);
            }
        }
    }

    public void scan(spoon.reflect.declaration.CtElement element) {
        if (element != null) {
            element.accept(this);
        }
    }

    public <A extends java.lang.annotation.Annotation> void visitCtAnnotation(final spoon.reflect.declaration.CtAnnotation<A> annotation) {
        enter(annotation);
        scan(annotation.getType());
        scan(annotation.getComments());
        scan(annotation.getAnnotationType());
        scan(annotation.getAnnotations());
        scan(annotation.getValues());
        exit(annotation);
    }

    public void scan(java.lang.Object o) {
        if (o instanceof spoon.reflect.declaration.CtElement) {
            scan(((spoon.reflect.declaration.CtElement) (o)));
        }
        if (o instanceof java.util.Collection<?>) {
            for (java.lang.Object obj : ((java.util.Collection<?>) (o))) {
                scan(obj);
            }
        }
        if (o instanceof java.util.Map<?, ?>) {
            for (java.lang.Object obj : ((java.util.Map) (o)).values()) {
                scan(obj);
            }
        }
    }

    public <A extends java.lang.annotation.Annotation> void visitCtAnnotationType(final spoon.reflect.declaration.CtAnnotationType<A> annotationType) {
        enter(annotationType);
        scan(annotationType.getAnnotations());
        scan(annotationType.getTypeMembers());
        scan(annotationType.getComments());
        exit(annotationType);
    }

    public void visitCtAnonymousExecutable(final spoon.reflect.declaration.CtAnonymousExecutable anonymousExec) {
        enter(anonymousExec);
        scan(anonymousExec.getAnnotations());
        scan(anonymousExec.getBody());
        scan(anonymousExec.getComments());
        exit(anonymousExec);
    }

    @java.lang.Override
    public <T> void visitCtArrayRead(final spoon.reflect.code.CtArrayRead<T> arrayRead) {
        enter(arrayRead);
        scan(arrayRead.getAnnotations());
        scan(arrayRead.getType());
        scan(arrayRead.getTypeCasts());
        scan(arrayRead.getTarget());
        scan(arrayRead.getIndexExpression());
        scan(arrayRead.getComments());
        exit(arrayRead);
    }

    @java.lang.Override
    public <T> void visitCtArrayWrite(final spoon.reflect.code.CtArrayWrite<T> arrayWrite) {
        enter(arrayWrite);
        scan(arrayWrite.getAnnotations());
        scan(arrayWrite.getType());
        scan(arrayWrite.getTypeCasts());
        scan(arrayWrite.getTarget());
        scan(arrayWrite.getIndexExpression());
        scan(arrayWrite.getComments());
        exit(arrayWrite);
    }

    public <T> void visitCtArrayTypeReference(final spoon.reflect.reference.CtArrayTypeReference<T> reference) {
        enter(reference);
        scan(reference.getComments());
        scan(reference.getPackage());
        scan(reference.getDeclaringType());
        scan(reference.getComponentType());
        scan(reference.getActualTypeArguments());
        scan(reference.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtAssert(final spoon.reflect.code.CtAssert<T> asserted) {
        enter(asserted);
        scan(asserted.getAnnotations());
        scan(asserted.getAssertExpression());
        scan(asserted.getExpression());
        scan(asserted.getComments());
        exit(asserted);
    }

    public <T, A extends T> void visitCtAssignment(final spoon.reflect.code.CtAssignment<T, A> assignement) {
        enter(assignement);
        scan(assignement.getAnnotations());
        scan(assignement.getType());
        scan(assignement.getTypeCasts());
        scan(assignement.getAssigned());
        scan(assignement.getAssignment());
        scan(assignement.getComments());
        exit(assignement);
    }

    public <T> void visitCtBinaryOperator(final spoon.reflect.code.CtBinaryOperator<T> operator) {
        enter(operator);
        scan(operator.getAnnotations());
        scan(operator.getType());
        scan(operator.getTypeCasts());
        scan(operator.getLeftHandOperand());
        scan(operator.getRightHandOperand());
        scan(operator.getComments());
        exit(operator);
    }

    public <R> void visitCtBlock(final spoon.reflect.code.CtBlock<R> block) {
        enter(block);
        scan(block.getAnnotations());
        scan(block.getStatements());
        scan(block.getComments());
        exit(block);
    }

    public void visitCtBreak(final spoon.reflect.code.CtBreak breakStatement) {
        enter(breakStatement);
        scan(breakStatement.getAnnotations());
        scan(breakStatement.getComments());
        exit(breakStatement);
    }

    public <S> void visitCtCase(final spoon.reflect.code.CtCase<S> caseStatement) {
        enter(caseStatement);
        scan(caseStatement.getAnnotations());
        scan(caseStatement.getCaseExpression());
        scan(caseStatement.getStatements());
        scan(caseStatement.getComments());
        exit(caseStatement);
    }

    public void visitCtCatch(final spoon.reflect.code.CtCatch catchBlock) {
        enter(catchBlock);
        scan(catchBlock.getAnnotations());
        scan(catchBlock.getParameter());
        scan(catchBlock.getBody());
        scan(catchBlock.getComments());
        exit(catchBlock);
    }

    public <T> void visitCtClass(final spoon.reflect.declaration.CtClass<T> ctClass) {
        enter(ctClass);
        scan(ctClass.getAnnotations());
        scan(ctClass.getSuperclass());
        scan(ctClass.getSuperInterfaces());
        scan(ctClass.getFormalCtTypeParameters());
        scan(ctClass.getTypeMembers());
        scan(ctClass.getComments());
        exit(ctClass);
    }

    @java.lang.Override
    public void visitCtTypeParameter(spoon.reflect.declaration.CtTypeParameter typeParameter) {
        enter(typeParameter);
        scan(typeParameter.getAnnotations());
        scan(typeParameter.getSuperclass());
        scan(typeParameter.getComments());
        exit(typeParameter);
    }

    public <T> void visitCtConditional(final spoon.reflect.code.CtConditional<T> conditional) {
        enter(conditional);
        scan(conditional.getType());
        scan(conditional.getAnnotations());
        scan(conditional.getCondition());
        scan(conditional.getThenExpression());
        scan(conditional.getElseExpression());
        scan(conditional.getComments());
        scan(conditional.getTypeCasts());
        exit(conditional);
    }

    public <T> void visitCtConstructor(final spoon.reflect.declaration.CtConstructor<T> c) {
        enter(c);
        scan(c.getAnnotations());
        scan(c.getParameters());
        scan(c.getThrownTypes());
        scan(c.getFormalCtTypeParameters());
        scan(c.getBody());
        scan(c.getComments());
        exit(c);
    }

    public void visitCtContinue(final spoon.reflect.code.CtContinue continueStatement) {
        enter(continueStatement);
        scan(continueStatement.getAnnotations());
        scan(continueStatement.getComments());
        exit(continueStatement);
    }

    public void visitCtDo(final spoon.reflect.code.CtDo doLoop) {
        enter(doLoop);
        scan(doLoop.getAnnotations());
        scan(doLoop.getLoopingExpression());
        scan(doLoop.getBody());
        scan(doLoop.getComments());
        exit(doLoop);
    }

    public <T extends java.lang.Enum<?>> void visitCtEnum(final spoon.reflect.declaration.CtEnum<T> ctEnum) {
        enter(ctEnum);
        scan(ctEnum.getAnnotations());
        scan(ctEnum.getSuperInterfaces());
        scan(ctEnum.getTypeMembers());
        scan(ctEnum.getEnumValues());
        scan(ctEnum.getComments());
        exit(ctEnum);
    }

    public <T> void visitCtExecutableReference(final spoon.reflect.reference.CtExecutableReference<T> reference) {
        enter(reference);
        scan(reference.getDeclaringType());
        scan(reference.getType());
        scan(reference.getParameters());
        scan(reference.getActualTypeArguments());
        scan(reference.getAnnotations());
        scan(reference.getComments());
        exit(reference);
    }

    public <T> void visitCtField(final spoon.reflect.declaration.CtField<T> f) {
        enter(f);
        scan(f.getAnnotations());
        scan(f.getType());
        scan(f.getDefaultExpression());
        scan(f.getComments());
        exit(f);
    }

    @java.lang.Override
    public <T> void visitCtEnumValue(final spoon.reflect.declaration.CtEnumValue<T> enumValue) {
        enter(enumValue);
        scan(enumValue.getAnnotations());
        scan(enumValue.getType());
        scan(enumValue.getDefaultExpression());
        scan(enumValue.getComments());
        exit(enumValue);
    }

    @java.lang.Override
    public <T> void visitCtThisAccess(final spoon.reflect.code.CtThisAccess<T> thisAccess) {
        enter(thisAccess);
        scan(thisAccess.getComments());
        scan(thisAccess.getAnnotations());
        scan(thisAccess.getType());
        scan(thisAccess.getTypeCasts());
        scan(thisAccess.getTarget());
        exit(thisAccess);
    }

    public <T> void visitCtAnnotationFieldAccess(final spoon.reflect.code.CtAnnotationFieldAccess<T> annotationFieldAccess) {
        enter(annotationFieldAccess);
        scan(annotationFieldAccess.getComments());
        scan(annotationFieldAccess.getAnnotations());
        scan(annotationFieldAccess.getTypeCasts());
        scan(annotationFieldAccess.getTarget());
        scan(annotationFieldAccess.getType());
        scan(annotationFieldAccess.getVariable());
        exit(annotationFieldAccess);
    }

    public <T> void visitCtFieldReference(final spoon.reflect.reference.CtFieldReference<T> reference) {
        enter(reference);
        scan(reference.getDeclaringType());
        scan(reference.getType());
        scan(reference.getAnnotations());
        exit(reference);
    }

    public void visitCtFor(final spoon.reflect.code.CtFor forLoop) {
        enter(forLoop);
        scan(forLoop.getAnnotations());
        scan(forLoop.getForInit());
        scan(forLoop.getExpression());
        scan(forLoop.getForUpdate());
        scan(forLoop.getBody());
        scan(forLoop.getComments());
        exit(forLoop);
    }

    public void visitCtForEach(final spoon.reflect.code.CtForEach foreach) {
        enter(foreach);
        scan(foreach.getAnnotations());
        scan(foreach.getVariable());
        scan(foreach.getExpression());
        scan(foreach.getBody());
        scan(foreach.getComments());
        exit(foreach);
    }

    public void visitCtIf(final spoon.reflect.code.CtIf ifElement) {
        enter(ifElement);
        scan(ifElement.getAnnotations());
        scan(ifElement.getCondition());
        scan(((spoon.reflect.code.CtStatement) (ifElement.getThenStatement())));
        scan(((spoon.reflect.code.CtStatement) (ifElement.getElseStatement())));
        scan(ifElement.getComments());
        exit(ifElement);
    }

    public <T> void visitCtInterface(final spoon.reflect.declaration.CtInterface<T> intrface) {
        enter(intrface);
        scan(intrface.getAnnotations());
        scan(intrface.getSuperInterfaces());
        scan(intrface.getFormalCtTypeParameters());
        scan(intrface.getTypeMembers());
        scan(intrface.getComments());
        exit(intrface);
    }

    public <T> void visitCtInvocation(final spoon.reflect.code.CtInvocation<T> invocation) {
        enter(invocation);
        scan(invocation.getAnnotations());
        scan(invocation.getTypeCasts());
        scan(invocation.getTarget());
        scan(invocation.getExecutable());
        scan(invocation.getArguments());
        scan(invocation.getComments());
        exit(invocation);
    }

    public <T> void visitCtLiteral(final spoon.reflect.code.CtLiteral<T> literal) {
        enter(literal);
        scan(literal.getAnnotations());
        scan(literal.getType());
        scan(literal.getTypeCasts());
        scan(literal.getComments());
        exit(literal);
    }

    public <T> void visitCtLocalVariable(final spoon.reflect.code.CtLocalVariable<T> localVariable) {
        enter(localVariable);
        scan(localVariable.getAnnotations());
        scan(localVariable.getType());
        scan(localVariable.getDefaultExpression());
        scan(localVariable.getComments());
        exit(localVariable);
    }

    public <T> void visitCtLocalVariableReference(final spoon.reflect.reference.CtLocalVariableReference<T> reference) {
        enter(reference);
        scan(reference.getType());
        scan(reference.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtCatchVariable(final spoon.reflect.code.CtCatchVariable<T> catchVariable) {
        enter(catchVariable);
        scan(catchVariable.getComments());
        scan(catchVariable.getAnnotations());
        scan(catchVariable.getDefaultExpression());
        scan(catchVariable.getType());
        scan(catchVariable.getMultiTypes());
        exit(catchVariable);
    }

    public <T> void visitCtCatchVariableReference(final spoon.reflect.reference.CtCatchVariableReference<T> reference) {
        enter(reference);
        scan(reference.getComments());
        scan(reference.getType());
        scan(reference.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtMethod(final spoon.reflect.declaration.CtMethod<T> m) {
        enter(m);
        scan(m.getAnnotations());
        scan(m.getFormalCtTypeParameters());
        scan(m.getType());
        scan(m.getParameters());
        scan(m.getThrownTypes());
        scan(m.getBody());
        scan(m.getComments());
        exit(m);
    }

    @java.lang.Override
    public <T> void visitCtAnnotationMethod(spoon.reflect.declaration.CtAnnotationMethod<T> annotationMethod) {
        enter(annotationMethod);
        scan(annotationMethod.getAnnotations());
        scan(annotationMethod.getType());
        scan(annotationMethod.getDefaultExpression());
        scan(annotationMethod.getComments());
        exit(annotationMethod);
    }

    public <T> void visitCtNewArray(final spoon.reflect.code.CtNewArray<T> newArray) {
        enter(newArray);
        scan(newArray.getAnnotations());
        scan(newArray.getType());
        scan(newArray.getTypeCasts());
        scan(newArray.getElements());
        scan(newArray.getDimensionExpressions());
        scan(newArray.getComments());
        exit(newArray);
    }

    @java.lang.Override
    public <T> void visitCtConstructorCall(final spoon.reflect.code.CtConstructorCall<T> ctConstructorCall) {
        enter(ctConstructorCall);
        scan(ctConstructorCall.getAnnotations());
        scan(ctConstructorCall.getTypeCasts());
        scan(ctConstructorCall.getExecutable());
        scan(ctConstructorCall.getTarget());
        scan(ctConstructorCall.getArguments());
        scan(ctConstructorCall.getComments());
        exit(ctConstructorCall);
    }

    public <T> void visitCtNewClass(final spoon.reflect.code.CtNewClass<T> newClass) {
        enter(newClass);
        scan(newClass.getAnnotations());
        scan(newClass.getTypeCasts());
        scan(newClass.getExecutable());
        scan(newClass.getTarget());
        scan(newClass.getArguments());
        scan(newClass.getAnonymousClass());
        scan(newClass.getComments());
        exit(newClass);
    }

    @java.lang.Override
    public <T> void visitCtLambda(final spoon.reflect.code.CtLambda<T> lambda) {
        enter(lambda);
        scan(lambda.getAnnotations());
        scan(lambda.getType());
        scan(lambda.getTypeCasts());
        scan(lambda.getParameters());
        scan(lambda.getThrownTypes());
        scan(lambda.getBody());
        scan(lambda.getExpression());
        scan(lambda.getComments());
        exit(lambda);
    }

    @java.lang.Override
    public <T, E extends spoon.reflect.code.CtExpression<?>> void visitCtExecutableReferenceExpression(final spoon.reflect.code.CtExecutableReferenceExpression<T, E> expression) {
        enter(expression);
        scan(expression.getComments());
        scan(expression.getAnnotations());
        scan(expression.getType());
        scan(expression.getTypeCasts());
        scan(expression.getExecutable());
        scan(expression.getTarget());
        exit(expression);
    }

    public <T, A extends T> void visitCtOperatorAssignment(final spoon.reflect.code.CtOperatorAssignment<T, A> assignment) {
        enter(assignment);
        scan(assignment.getAnnotations());
        scan(assignment.getType());
        scan(assignment.getTypeCasts());
        scan(assignment.getAssigned());
        scan(assignment.getAssignment());
        scan(assignment.getComments());
        exit(assignment);
    }

    public void visitCtPackage(final spoon.reflect.declaration.CtPackage ctPackage) {
        enter(ctPackage);
        scan(ctPackage.getAnnotations());
        scan(ctPackage.getPackages());
        scan(ctPackage.getTypes());
        scan(ctPackage.getComments());
        exit(ctPackage);
    }

    public void visitCtPackageReference(final spoon.reflect.reference.CtPackageReference reference) {
        enter(reference);
        scan(reference.getAnnotations());
        exit(reference);
    }

    public <T> void visitCtParameter(final spoon.reflect.declaration.CtParameter<T> parameter) {
        enter(parameter);
        scan(parameter.getAnnotations());
        scan(parameter.getType());
        scan(parameter.getComments());
        exit(parameter);
    }

    public <T> void visitCtParameterReference(final spoon.reflect.reference.CtParameterReference<T> reference) {
        enter(reference);
        scan(reference.getType());
        scan(reference.getAnnotations());
        scan(reference.getDeclaringExecutable());
        exit(reference);
    }

    public <R> void visitCtReturn(final spoon.reflect.code.CtReturn<R> returnStatement) {
        enter(returnStatement);
        scan(returnStatement.getAnnotations());
        scan(returnStatement.getReturnedExpression());
        scan(returnStatement.getComments());
        exit(returnStatement);
    }

    public <R> void visitCtStatementList(final spoon.reflect.code.CtStatementList statements) {
        enter(statements);
        scan(statements.getAnnotations());
        scan(statements.getStatements());
        scan(statements.getComments());
        exit(statements);
    }

    public <S> void visitCtSwitch(final spoon.reflect.code.CtSwitch<S> switchStatement) {
        enter(switchStatement);
        scan(switchStatement.getAnnotations());
        scan(switchStatement.getSelector());
        scan(switchStatement.getCases());
        scan(switchStatement.getComments());
        exit(switchStatement);
    }

    public void visitCtSynchronized(final spoon.reflect.code.CtSynchronized synchro) {
        enter(synchro);
        scan(synchro.getAnnotations());
        scan(synchro.getExpression());
        scan(synchro.getBlock());
        scan(synchro.getComments());
        exit(synchro);
    }

    public void visitCtThrow(final spoon.reflect.code.CtThrow throwStatement) {
        enter(throwStatement);
        scan(throwStatement.getAnnotations());
        scan(throwStatement.getThrownExpression());
        scan(throwStatement.getComments());
        exit(throwStatement);
    }

    public void visitCtTry(final spoon.reflect.code.CtTry tryBlock) {
        enter(tryBlock);
        scan(tryBlock.getAnnotations());
        scan(tryBlock.getBody());
        scan(tryBlock.getCatchers());
        scan(tryBlock.getFinalizer());
        scan(tryBlock.getComments());
        exit(tryBlock);
    }

    @java.lang.Override
    public void visitCtTryWithResource(final spoon.reflect.code.CtTryWithResource tryWithResource) {
        enter(tryWithResource);
        scan(tryWithResource.getAnnotations());
        scan(tryWithResource.getResources());
        scan(tryWithResource.getBody());
        scan(tryWithResource.getCatchers());
        scan(tryWithResource.getFinalizer());
        scan(tryWithResource.getComments());
        exit(tryWithResource);
    }

    public void visitCtTypeParameterReference(final spoon.reflect.reference.CtTypeParameterReference ref) {
        enter(ref);
        scan(ref.getPackage());
        scan(ref.getDeclaringType());
        scan(ref.getAnnotations());
        scan(ref.getBoundingType());
        exit(ref);
    }

    @java.lang.Override
    public void visitCtWildcardReference(spoon.reflect.reference.CtWildcardReference wildcardReference) {
        enter(wildcardReference);
        scan(wildcardReference.getPackage());
        scan(wildcardReference.getDeclaringType());
        scan(wildcardReference.getAnnotations());
        scan(wildcardReference.getBoundingType());
        exit(wildcardReference);
    }

    @java.lang.Override
    public <T> void visitCtIntersectionTypeReference(final spoon.reflect.reference.CtIntersectionTypeReference<T> reference) {
        enter(reference);
        scan(reference.getPackage());
        scan(reference.getDeclaringType());
        scan(reference.getAnnotations());
        scan(reference.getBounds());
        exit(reference);
    }

    public <T> void visitCtTypeReference(final spoon.reflect.reference.CtTypeReference<T> reference) {
        enter(reference);
        scan(reference.getPackage());
        scan(reference.getDeclaringType());
        scan(reference.getActualTypeArguments());
        scan(reference.getAnnotations());
        scan(reference.getComments());
        exit(reference);
    }

    @java.lang.Override
    public <T> void visitCtTypeAccess(final spoon.reflect.code.CtTypeAccess<T> typeAccess) {
        enter(typeAccess);
        scan(typeAccess.getAnnotations());
        scan(typeAccess.getTypeCasts());
        scan(typeAccess.getAccessedType());
        scan(typeAccess.getComments());
        exit(typeAccess);
    }

    public <T> void visitCtUnaryOperator(final spoon.reflect.code.CtUnaryOperator<T> operator) {
        enter(operator);
        scan(operator.getAnnotations());
        scan(operator.getType());
        scan(operator.getTypeCasts());
        scan(operator.getOperand());
        scan(operator.getComments());
        exit(operator);
    }

    @java.lang.Override
    public <T> void visitCtVariableRead(final spoon.reflect.code.CtVariableRead<T> variableRead) {
        enter(variableRead);
        scan(variableRead.getAnnotations());
        scan(variableRead.getTypeCasts());
        scan(variableRead.getVariable());
        scan(variableRead.getComments());
        exit(variableRead);
    }

    @java.lang.Override
    public <T> void visitCtVariableWrite(final spoon.reflect.code.CtVariableWrite<T> variableWrite) {
        enter(variableWrite);
        scan(variableWrite.getAnnotations());
        scan(variableWrite.getTypeCasts());
        scan(variableWrite.getVariable());
        scan(variableWrite.getComments());
        exit(variableWrite);
    }

    public void visitCtWhile(final spoon.reflect.code.CtWhile whileLoop) {
        enter(whileLoop);
        scan(whileLoop.getAnnotations());
        scan(whileLoop.getLoopingExpression());
        scan(whileLoop.getBody());
        scan(whileLoop.getComments());
        exit(whileLoop);
    }

    public <T> void visitCtCodeSnippetExpression(final spoon.reflect.code.CtCodeSnippetExpression<T> expression) {
        enter(expression);
        scan(expression.getType());
        scan(expression.getComments());
        scan(expression.getAnnotations());
        scan(expression.getTypeCasts());
        exit(expression);
    }

    public void visitCtCodeSnippetStatement(final spoon.reflect.code.CtCodeSnippetStatement statement) {
        enter(statement);
        scan(statement.getComments());
        scan(statement.getAnnotations());
        exit(statement);
    }

    public <T> void visitCtUnboundVariableReference(final spoon.reflect.reference.CtUnboundVariableReference<T> reference) {
        enter(reference);
        scan(reference.getType());
        exit(reference);
    }

    @java.lang.Override
    public <T> void visitCtFieldRead(final spoon.reflect.code.CtFieldRead<T> fieldRead) {
        enter(fieldRead);
        scan(fieldRead.getAnnotations());
        scan(fieldRead.getTypeCasts());
        scan(fieldRead.getTarget());
        scan(fieldRead.getVariable());
        scan(fieldRead.getComments());
        exit(fieldRead);
    }

    @java.lang.Override
    public <T> void visitCtFieldWrite(final spoon.reflect.code.CtFieldWrite<T> fieldWrite) {
        enter(fieldWrite);
        scan(fieldWrite.getAnnotations());
        scan(fieldWrite.getTypeCasts());
        scan(fieldWrite.getTarget());
        scan(fieldWrite.getVariable());
        scan(fieldWrite.getComments());
        exit(fieldWrite);
    }

    @java.lang.Override
    public <T> void visitCtSuperAccess(final spoon.reflect.code.CtSuperAccess<T> f) {
        enter(f);
        scan(f.getType());
        scan(f.getComments());
        scan(f.getAnnotations());
        scan(f.getTypeCasts());
        scan(f.getTarget());
        scan(f.getVariable());
        exit(f);
    }

    @java.lang.Override
    public void visitCtComment(final spoon.reflect.code.CtComment comment) {
        enter(comment);
        scan(comment.getComments());
        scan(comment.getAnnotations());
        exit(comment);
    }

    @java.lang.Override
    public void visitCtJavaDoc(final spoon.reflect.code.CtJavaDoc javaDoc) {
        enter(javaDoc);
        scan(javaDoc.getComments());
        scan(javaDoc.getAnnotations());
        scan(javaDoc.getTags());
        exit(javaDoc);
    }

    @java.lang.Override
    public void visitCtJavaDocTag(final spoon.reflect.code.CtJavaDocTag docTag) {
        enter(docTag);
        scan(docTag.getComments());
        scan(docTag.getAnnotations());
        exit(docTag);
    }
}

