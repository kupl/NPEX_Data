/**
 * Copyright (C) 2006-2017 INRIA and contributors
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
package spoon.support.visitor.clone;
import java.lang.annotation.Annotation;
import spoon.reflect.code.CtAnnotationFieldAccess;
import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtArrayWrite;
import spoon.reflect.code.CtAssert;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtBreak;
import spoon.reflect.code.CtCase;
import spoon.reflect.code.CtCatch;
import spoon.reflect.code.CtCatchVariable;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtConditional;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtContinue;
import spoon.reflect.code.CtDo;
import spoon.reflect.code.CtExecutableReferenceExpression;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldRead;
import spoon.reflect.code.CtFieldWrite;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtLambda;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtNewArray;
import spoon.reflect.code.CtNewClass;
import spoon.reflect.code.CtOperatorAssignment;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtStatementList;
import spoon.reflect.code.CtSuperAccess;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtSynchronized;
import spoon.reflect.code.CtThisAccess;
import spoon.reflect.code.CtThrow;
import spoon.reflect.code.CtTry;
import spoon.reflect.code.CtTryWithResource;
import spoon.reflect.code.CtTypeAccess;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.code.CtVariableWrite;
import spoon.reflect.code.CtWhile;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtAnnotationMethod;
import spoon.reflect.declaration.CtAnnotationType;
import spoon.reflect.declaration.CtAnonymousExecutable;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtEnum;
import spoon.reflect.declaration.CtEnumValue;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtCatchVariableReference;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtIntersectionTypeReference;
import spoon.reflect.reference.CtLocalVariableReference;
import spoon.reflect.reference.CtPackageReference;
import spoon.reflect.reference.CtParameterReference;
import spoon.reflect.reference.CtTypeParameterReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.reference.CtUnboundVariableReference;
import spoon.reflect.reference.CtWildcardReference;
import spoon.reflect.visitor.CtScanner;
import spoon.support.visitor.equals.CloneHelper;
/**
 * Used to clone a given element.
 *
 * This class is generated automatically by the processor {@link spoon.generating.CloneVisitorGenerator}.
 */
public class CloneVisitor extends CtScanner {
    private final CloneBuilder builder = new CloneBuilder();

    private CtElement other;

    public <T extends CtElement> T getClone() {
        return ((T) (other));
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <A extends Annotation> void visitCtAnnotation(final CtAnnotation<A> annotation) {
        CtAnnotation<A> aCtAnnotation = CloneBuilder.build(this.builder, annotation, annotation.getFactory().Core().createAnnotation());
        aCtAnnotation.setType(CloneHelper.clone(annotation.getType()));
        aCtAnnotation.setComments(CloneHelper.clone(annotation.getComments()));
        aCtAnnotation.setAnnotationType(CloneHelper.clone(annotation.getAnnotationType()));
        aCtAnnotation.setAnnotations(CloneHelper.clone(annotation.getAnnotations()));
        aCtAnnotation.setValues(CloneHelper.clone(annotation.getValues()));
        this.other = aCtAnnotation;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <A extends Annotation> void visitCtAnnotationType(final CtAnnotationType<A> annotationType) {
        CtAnnotationType<A> aCtAnnotationType = CloneBuilder.build(this.builder, annotationType, annotationType.getFactory().Core().createAnnotationType());
        aCtAnnotationType.setAnnotations(CloneHelper.clone(annotationType.getAnnotations()));
        aCtAnnotationType.setTypeMembers(CloneHelper.clone(annotationType.getTypeMembers()));
        aCtAnnotationType.setComments(CloneHelper.clone(annotationType.getComments()));
        this.other = aCtAnnotationType;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtAnonymousExecutable(final CtAnonymousExecutable anonymousExec) {
        CtAnonymousExecutable aCtAnonymousExecutable = CloneBuilder.build(this.builder, anonymousExec, anonymousExec.getFactory().Core().createAnonymousExecutable());
        aCtAnonymousExecutable.setAnnotations(CloneHelper.clone(anonymousExec.getAnnotations()));
        aCtAnonymousExecutable.setBody(CloneHelper.clone(anonymousExec.getBody()));
        aCtAnonymousExecutable.setComments(CloneHelper.clone(anonymousExec.getComments()));
        this.other = aCtAnonymousExecutable;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtArrayRead(final CtArrayRead<T> arrayRead) {
        CtArrayRead<T> aCtArrayRead = CloneBuilder.build(this.builder, arrayRead, arrayRead.getFactory().Core().createArrayRead());
        aCtArrayRead.setAnnotations(CloneHelper.clone(arrayRead.getAnnotations()));
        aCtArrayRead.setType(CloneHelper.clone(arrayRead.getType()));
        aCtArrayRead.setTypeCasts(CloneHelper.clone(arrayRead.getTypeCasts()));
        aCtArrayRead.setTarget(CloneHelper.clone(arrayRead.getTarget()));
        aCtArrayRead.setIndexExpression(CloneHelper.clone(arrayRead.getIndexExpression()));
        aCtArrayRead.setComments(CloneHelper.clone(arrayRead.getComments()));
        this.other = aCtArrayRead;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtArrayWrite(final CtArrayWrite<T> arrayWrite) {
        CtArrayWrite<T> aCtArrayWrite = CloneBuilder.build(this.builder, arrayWrite, arrayWrite.getFactory().Core().createArrayWrite());
        aCtArrayWrite.setAnnotations(CloneHelper.clone(arrayWrite.getAnnotations()));
        aCtArrayWrite.setType(CloneHelper.clone(arrayWrite.getType()));
        aCtArrayWrite.setTypeCasts(CloneHelper.clone(arrayWrite.getTypeCasts()));
        aCtArrayWrite.setTarget(CloneHelper.clone(arrayWrite.getTarget()));
        aCtArrayWrite.setIndexExpression(CloneHelper.clone(arrayWrite.getIndexExpression()));
        aCtArrayWrite.setComments(CloneHelper.clone(arrayWrite.getComments()));
        this.other = aCtArrayWrite;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtArrayTypeReference(final CtArrayTypeReference<T> reference) {
        CtArrayTypeReference<T> aCtArrayTypeReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createArrayTypeReference());
        aCtArrayTypeReference.setComments(CloneHelper.clone(reference.getComments()));
        aCtArrayTypeReference.setPackage(CloneHelper.clone(reference.getPackage()));
        aCtArrayTypeReference.setDeclaringType(CloneHelper.clone(reference.getDeclaringType()));
        aCtArrayTypeReference.setComponentType(CloneHelper.clone(reference.getComponentType()));
        aCtArrayTypeReference.setActualTypeArguments(CloneHelper.clone(reference.getActualTypeArguments()));
        aCtArrayTypeReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        this.other = aCtArrayTypeReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtAssert(final CtAssert<T> asserted) {
        CtAssert<T> aCtAssert = CloneBuilder.build(this.builder, asserted, asserted.getFactory().Core().createAssert());
        aCtAssert.setAnnotations(CloneHelper.clone(asserted.getAnnotations()));
        aCtAssert.setAssertExpression(CloneHelper.clone(asserted.getAssertExpression()));
        aCtAssert.setExpression(CloneHelper.clone(asserted.getExpression()));
        aCtAssert.setComments(CloneHelper.clone(asserted.getComments()));
        this.other = aCtAssert;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T, A extends T> void visitCtAssignment(final CtAssignment<T, A> assignement) {
        CtAssignment<T, A> aCtAssignment = CloneBuilder.build(this.builder, assignement, assignement.getFactory().Core().createAssignment());
        aCtAssignment.setAnnotations(CloneHelper.clone(assignement.getAnnotations()));
        aCtAssignment.setType(CloneHelper.clone(assignement.getType()));
        aCtAssignment.setTypeCasts(CloneHelper.clone(assignement.getTypeCasts()));
        aCtAssignment.setAssigned(CloneHelper.clone(assignement.getAssigned()));
        aCtAssignment.setAssignment(CloneHelper.clone(assignement.getAssignment()));
        aCtAssignment.setComments(CloneHelper.clone(assignement.getComments()));
        this.other = aCtAssignment;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtBinaryOperator(final CtBinaryOperator<T> operator) {
        CtBinaryOperator<T> aCtBinaryOperator = CloneBuilder.build(this.builder, operator, operator.getFactory().Core().createBinaryOperator());
        aCtBinaryOperator.setAnnotations(CloneHelper.clone(operator.getAnnotations()));
        aCtBinaryOperator.setType(CloneHelper.clone(operator.getType()));
        aCtBinaryOperator.setTypeCasts(CloneHelper.clone(operator.getTypeCasts()));
        aCtBinaryOperator.setLeftHandOperand(CloneHelper.clone(operator.getLeftHandOperand()));
        aCtBinaryOperator.setRightHandOperand(CloneHelper.clone(operator.getRightHandOperand()));
        aCtBinaryOperator.setComments(CloneHelper.clone(operator.getComments()));
        this.other = aCtBinaryOperator;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <R> void visitCtBlock(final CtBlock<R> block) {
        CtBlock<R> aCtBlock = CloneBuilder.build(this.builder, block, block.getFactory().Core().createBlock());
        aCtBlock.setAnnotations(CloneHelper.clone(block.getAnnotations()));
        aCtBlock.setStatements(CloneHelper.clone(block.getStatements()));
        aCtBlock.setComments(CloneHelper.clone(block.getComments()));
        this.other = aCtBlock;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtBreak(final CtBreak breakStatement) {
        CtBreak aCtBreak = CloneBuilder.build(this.builder, breakStatement, breakStatement.getFactory().Core().createBreak());
        aCtBreak.setAnnotations(CloneHelper.clone(breakStatement.getAnnotations()));
        aCtBreak.setComments(CloneHelper.clone(breakStatement.getComments()));
        this.other = aCtBreak;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <S> void visitCtCase(final CtCase<S> caseStatement) {
        CtCase<S> aCtCase = CloneBuilder.build(this.builder, caseStatement, caseStatement.getFactory().Core().createCase());
        aCtCase.setAnnotations(CloneHelper.clone(caseStatement.getAnnotations()));
        aCtCase.setCaseExpression(CloneHelper.clone(caseStatement.getCaseExpression()));
        aCtCase.setStatements(CloneHelper.clone(caseStatement.getStatements()));
        aCtCase.setComments(CloneHelper.clone(caseStatement.getComments()));
        this.other = aCtCase;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtCatch(final CtCatch catchBlock) {
        CtCatch aCtCatch = CloneBuilder.build(this.builder, catchBlock, catchBlock.getFactory().Core().createCatch());
        aCtCatch.setAnnotations(CloneHelper.clone(catchBlock.getAnnotations()));
        aCtCatch.setParameter(CloneHelper.clone(catchBlock.getParameter()));
        aCtCatch.setBody(CloneHelper.clone(catchBlock.getBody()));
        aCtCatch.setComments(CloneHelper.clone(catchBlock.getComments()));
        this.other = aCtCatch;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtClass(final CtClass<T> ctClass) {
        CtClass<T> aCtClass = CloneBuilder.build(this.builder, ctClass, ctClass.getFactory().Core().createClass());
        aCtClass.setAnnotations(CloneHelper.clone(ctClass.getAnnotations()));
        aCtClass.setSuperclass(CloneHelper.clone(ctClass.getSuperclass()));
        aCtClass.setSuperInterfaces(CloneHelper.clone(ctClass.getSuperInterfaces()));
        aCtClass.setFormalCtTypeParameters(CloneHelper.clone(ctClass.getFormalCtTypeParameters()));
        aCtClass.setTypeMembers(CloneHelper.clone(ctClass.getTypeMembers()));
        aCtClass.setComments(CloneHelper.clone(ctClass.getComments()));
        this.other = aCtClass;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public void visitCtTypeParameter(CtTypeParameter typeParameter) {
        CtTypeParameter aCtTypeParameter = CloneBuilder.build(this.builder, typeParameter, typeParameter.getFactory().Core().createTypeParameter());
        aCtTypeParameter.setAnnotations(CloneHelper.clone(typeParameter.getAnnotations()));
        aCtTypeParameter.setSuperclass(CloneHelper.clone(typeParameter.getSuperclass()));
        aCtTypeParameter.setComments(CloneHelper.clone(typeParameter.getComments()));
        this.other = aCtTypeParameter;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtConditional(final CtConditional<T> conditional) {
        CtConditional<T> aCtConditional = CloneBuilder.build(this.builder, conditional, conditional.getFactory().Core().createConditional());
        aCtConditional.setType(CloneHelper.clone(conditional.getType()));
        aCtConditional.setAnnotations(CloneHelper.clone(conditional.getAnnotations()));
        aCtConditional.setCondition(CloneHelper.clone(conditional.getCondition()));
        aCtConditional.setThenExpression(CloneHelper.clone(conditional.getThenExpression()));
        aCtConditional.setElseExpression(CloneHelper.clone(conditional.getElseExpression()));
        aCtConditional.setComments(CloneHelper.clone(conditional.getComments()));
        aCtConditional.setTypeCasts(CloneHelper.clone(conditional.getTypeCasts()));
        this.other = aCtConditional;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtConstructor(final CtConstructor<T> c) {
        CtConstructor<T> aCtConstructor = CloneBuilder.build(this.builder, c, c.getFactory().Core().createConstructor());
        aCtConstructor.setAnnotations(CloneHelper.clone(c.getAnnotations()));
        aCtConstructor.setParameters(CloneHelper.clone(c.getParameters()));
        aCtConstructor.setThrownTypes(CloneHelper.clone(c.getThrownTypes()));
        aCtConstructor.setFormalCtTypeParameters(CloneHelper.clone(c.getFormalCtTypeParameters()));
        aCtConstructor.setBody(CloneHelper.clone(c.getBody()));
        aCtConstructor.setComments(CloneHelper.clone(c.getComments()));
        this.other = aCtConstructor;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtContinue(final CtContinue continueStatement) {
        CtContinue aCtContinue = CloneBuilder.build(this.builder, continueStatement, continueStatement.getFactory().Core().createContinue());
        aCtContinue.setAnnotations(CloneHelper.clone(continueStatement.getAnnotations()));
        aCtContinue.setLabelledStatement(CloneHelper.clone(continueStatement.getLabelledStatement()));
        aCtContinue.setComments(CloneHelper.clone(continueStatement.getComments()));
        this.other = aCtContinue;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtDo(final CtDo doLoop) {
        CtDo aCtDo = CloneBuilder.build(this.builder, doLoop, doLoop.getFactory().Core().createDo());
        aCtDo.setAnnotations(CloneHelper.clone(doLoop.getAnnotations()));
        aCtDo.setLoopingExpression(CloneHelper.clone(doLoop.getLoopingExpression()));
        aCtDo.setBody(CloneHelper.clone(doLoop.getBody()));
        aCtDo.setComments(CloneHelper.clone(doLoop.getComments()));
        this.other = aCtDo;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T extends Enum<?>> void visitCtEnum(final CtEnum<T> ctEnum) {
        CtEnum<T> aCtEnum = CloneBuilder.build(this.builder, ctEnum, ctEnum.getFactory().Core().createEnum());
        aCtEnum.setAnnotations(CloneHelper.clone(ctEnum.getAnnotations()));
        aCtEnum.setSuperInterfaces(CloneHelper.clone(ctEnum.getSuperInterfaces()));
        aCtEnum.setTypeMembers(CloneHelper.clone(ctEnum.getTypeMembers()));
        aCtEnum.setEnumValues(CloneHelper.clone(ctEnum.getEnumValues()));
        aCtEnum.setComments(CloneHelper.clone(ctEnum.getComments()));
        this.other = aCtEnum;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtExecutableReference(final CtExecutableReference<T> reference) {
        CtExecutableReference<T> aCtExecutableReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createExecutableReference());
        aCtExecutableReference.setDeclaringType(CloneHelper.clone(reference.getDeclaringType()));
        aCtExecutableReference.setType(CloneHelper.clone(reference.getType()));
        aCtExecutableReference.setParameters(CloneHelper.clone(reference.getParameters()));
        aCtExecutableReference.setActualTypeArguments(CloneHelper.clone(reference.getActualTypeArguments()));
        aCtExecutableReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        aCtExecutableReference.setComments(CloneHelper.clone(reference.getComments()));
        this.other = aCtExecutableReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtField(final CtField<T> f) {
        CtField<T> aCtField = CloneBuilder.build(this.builder, f, f.getFactory().Core().createField());
        aCtField.setAnnotations(CloneHelper.clone(f.getAnnotations()));
        aCtField.setType(CloneHelper.clone(f.getType()));
        aCtField.setDefaultExpression(CloneHelper.clone(f.getDefaultExpression()));
        aCtField.setComments(CloneHelper.clone(f.getComments()));
        this.other = aCtField;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtEnumValue(final CtEnumValue<T> enumValue) {
        CtEnumValue<T> aCtEnumValue = CloneBuilder.build(this.builder, enumValue, enumValue.getFactory().Core().createEnumValue());
        aCtEnumValue.setAnnotations(CloneHelper.clone(enumValue.getAnnotations()));
        aCtEnumValue.setType(CloneHelper.clone(enumValue.getType()));
        aCtEnumValue.setDefaultExpression(CloneHelper.clone(enumValue.getDefaultExpression()));
        aCtEnumValue.setComments(CloneHelper.clone(enumValue.getComments()));
        this.other = aCtEnumValue;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtThisAccess(final CtThisAccess<T> thisAccess) {
        CtThisAccess<T> aCtThisAccess = CloneBuilder.build(this.builder, thisAccess, thisAccess.getFactory().Core().createThisAccess());
        aCtThisAccess.setComments(CloneHelper.clone(thisAccess.getComments()));
        aCtThisAccess.setAnnotations(CloneHelper.clone(thisAccess.getAnnotations()));
        aCtThisAccess.setType(CloneHelper.clone(thisAccess.getType()));
        aCtThisAccess.setTypeCasts(CloneHelper.clone(thisAccess.getTypeCasts()));
        aCtThisAccess.setTarget(CloneHelper.clone(thisAccess.getTarget()));
        this.other = aCtThisAccess;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtAnnotationFieldAccess(final CtAnnotationFieldAccess<T> annotationFieldAccess) {
        CtAnnotationFieldAccess<T> aCtAnnotationFieldAccess = CloneBuilder.build(this.builder, annotationFieldAccess, annotationFieldAccess.getFactory().Core().createAnnotationFieldAccess());
        aCtAnnotationFieldAccess.setComments(CloneHelper.clone(annotationFieldAccess.getComments()));
        aCtAnnotationFieldAccess.setAnnotations(CloneHelper.clone(annotationFieldAccess.getAnnotations()));
        aCtAnnotationFieldAccess.setTypeCasts(CloneHelper.clone(annotationFieldAccess.getTypeCasts()));
        aCtAnnotationFieldAccess.setTarget(CloneHelper.clone(annotationFieldAccess.getTarget()));
        aCtAnnotationFieldAccess.setType(CloneHelper.clone(annotationFieldAccess.getType()));
        aCtAnnotationFieldAccess.setVariable(CloneHelper.clone(annotationFieldAccess.getVariable()));
        this.other = aCtAnnotationFieldAccess;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtFieldReference(final CtFieldReference<T> reference) {
        CtFieldReference<T> aCtFieldReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createFieldReference());
        aCtFieldReference.setDeclaringType(CloneHelper.clone(reference.getDeclaringType()));
        aCtFieldReference.setType(CloneHelper.clone(reference.getType()));
        aCtFieldReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        this.other = aCtFieldReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtFor(final CtFor forLoop) {
        CtFor aCtFor = CloneBuilder.build(this.builder, forLoop, forLoop.getFactory().Core().createFor());
        aCtFor.setAnnotations(CloneHelper.clone(forLoop.getAnnotations()));
        aCtFor.setForInit(CloneHelper.clone(forLoop.getForInit()));
        aCtFor.setExpression(CloneHelper.clone(forLoop.getExpression()));
        aCtFor.setForUpdate(CloneHelper.clone(forLoop.getForUpdate()));
        aCtFor.setBody(CloneHelper.clone(forLoop.getBody()));
        aCtFor.setComments(CloneHelper.clone(forLoop.getComments()));
        this.other = aCtFor;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtForEach(final CtForEach foreach) {
        CtForEach aCtForEach = CloneBuilder.build(this.builder, foreach, foreach.getFactory().Core().createForEach());
        aCtForEach.setAnnotations(CloneHelper.clone(foreach.getAnnotations()));
        aCtForEach.setVariable(CloneHelper.clone(foreach.getVariable()));
        aCtForEach.setExpression(CloneHelper.clone(foreach.getExpression()));
        aCtForEach.setBody(CloneHelper.clone(foreach.getBody()));
        aCtForEach.setComments(CloneHelper.clone(foreach.getComments()));
        this.other = aCtForEach;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtIf(final CtIf ifElement) {
        CtIf aCtIf = CloneBuilder.build(this.builder, ifElement, ifElement.getFactory().Core().createIf());
        aCtIf.setAnnotations(CloneHelper.clone(ifElement.getAnnotations()));
        aCtIf.setCondition(CloneHelper.clone(ifElement.getCondition()));
        aCtIf.setThenStatement(CloneHelper.clone(((CtStatement) (ifElement.getThenStatement()))));
        aCtIf.setElseStatement(CloneHelper.clone(((CtStatement) (ifElement.getElseStatement()))));
        aCtIf.setComments(CloneHelper.clone(ifElement.getComments()));
        this.other = aCtIf;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtInterface(final CtInterface<T> intrface) {
        CtInterface<T> aCtInterface = CloneBuilder.build(this.builder, intrface, intrface.getFactory().Core().createInterface());
        aCtInterface.setAnnotations(CloneHelper.clone(intrface.getAnnotations()));
        aCtInterface.setSuperInterfaces(CloneHelper.clone(intrface.getSuperInterfaces()));
        aCtInterface.setFormalCtTypeParameters(CloneHelper.clone(intrface.getFormalCtTypeParameters()));
        aCtInterface.setTypeMembers(CloneHelper.clone(intrface.getTypeMembers()));
        aCtInterface.setComments(CloneHelper.clone(intrface.getComments()));
        this.other = aCtInterface;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtInvocation(final CtInvocation<T> invocation) {
        CtInvocation<T> aCtInvocation = CloneBuilder.build(this.builder, invocation, invocation.getFactory().Core().createInvocation());
        aCtInvocation.setAnnotations(CloneHelper.clone(invocation.getAnnotations()));
        aCtInvocation.setTypeCasts(CloneHelper.clone(invocation.getTypeCasts()));
        aCtInvocation.setTarget(CloneHelper.clone(invocation.getTarget()));
        aCtInvocation.setExecutable(CloneHelper.clone(invocation.getExecutable()));
        aCtInvocation.setArguments(CloneHelper.clone(invocation.getArguments()));
        aCtInvocation.setComments(CloneHelper.clone(invocation.getComments()));
        this.other = aCtInvocation;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtLiteral(final CtLiteral<T> literal) {
        CtLiteral<T> aCtLiteral = CloneBuilder.build(this.builder, literal, literal.getFactory().Core().createLiteral());
        aCtLiteral.setAnnotations(CloneHelper.clone(literal.getAnnotations()));
        aCtLiteral.setType(CloneHelper.clone(literal.getType()));
        aCtLiteral.setTypeCasts(CloneHelper.clone(literal.getTypeCasts()));
        aCtLiteral.setComments(CloneHelper.clone(literal.getComments()));
        this.other = aCtLiteral;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtLocalVariable(final CtLocalVariable<T> localVariable) {
        CtLocalVariable<T> aCtLocalVariable = CloneBuilder.build(this.builder, localVariable, localVariable.getFactory().Core().createLocalVariable());
        aCtLocalVariable.setAnnotations(CloneHelper.clone(localVariable.getAnnotations()));
        aCtLocalVariable.setType(CloneHelper.clone(localVariable.getType()));
        aCtLocalVariable.setDefaultExpression(CloneHelper.clone(localVariable.getDefaultExpression()));
        aCtLocalVariable.setComments(CloneHelper.clone(localVariable.getComments()));
        this.other = aCtLocalVariable;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtLocalVariableReference(final CtLocalVariableReference<T> reference) {
        CtLocalVariableReference<T> aCtLocalVariableReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createLocalVariableReference());
        aCtLocalVariableReference.setType(CloneHelper.clone(reference.getType()));
        aCtLocalVariableReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        this.other = aCtLocalVariableReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtCatchVariable(final CtCatchVariable<T> catchVariable) {
        CtCatchVariable<T> aCtCatchVariable = CloneBuilder.build(this.builder, catchVariable, catchVariable.getFactory().Core().createCatchVariable());
        aCtCatchVariable.setComments(CloneHelper.clone(catchVariable.getComments()));
        aCtCatchVariable.setAnnotations(CloneHelper.clone(catchVariable.getAnnotations()));
        aCtCatchVariable.setDefaultExpression(CloneHelper.clone(catchVariable.getDefaultExpression()));
        aCtCatchVariable.setType(CloneHelper.clone(catchVariable.getType()));
        aCtCatchVariable.setMultiTypes(CloneHelper.clone(catchVariable.getMultiTypes()));
        this.other = aCtCatchVariable;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtCatchVariableReference(final CtCatchVariableReference<T> reference) {
        CtCatchVariableReference<T> aCtCatchVariableReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createCatchVariableReference());
        aCtCatchVariableReference.setComments(CloneHelper.clone(reference.getComments()));
        aCtCatchVariableReference.setType(CloneHelper.clone(reference.getType()));
        aCtCatchVariableReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        this.other = aCtCatchVariableReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtMethod(final CtMethod<T> m) {
        CtMethod<T> aCtMethod = CloneBuilder.build(this.builder, m, m.getFactory().Core().createMethod());
        aCtMethod.setAnnotations(CloneHelper.clone(m.getAnnotations()));
        aCtMethod.setFormalCtTypeParameters(CloneHelper.clone(m.getFormalCtTypeParameters()));
        aCtMethod.setType(CloneHelper.clone(m.getType()));
        aCtMethod.setParameters(CloneHelper.clone(m.getParameters()));
        aCtMethod.setThrownTypes(CloneHelper.clone(m.getThrownTypes()));
        aCtMethod.setBody(CloneHelper.clone(m.getBody()));
        aCtMethod.setComments(CloneHelper.clone(m.getComments()));
        this.other = aCtMethod;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtAnnotationMethod(CtAnnotationMethod<T> annotationMethod) {
        CtAnnotationMethod<T> aCtAnnotationMethod = CloneBuilder.build(this.builder, annotationMethod, annotationMethod.getFactory().Core().createAnnotationMethod());
        aCtAnnotationMethod.setAnnotations(CloneHelper.clone(annotationMethod.getAnnotations()));
        aCtAnnotationMethod.setType(CloneHelper.clone(annotationMethod.getType()));
        aCtAnnotationMethod.setDefaultExpression(CloneHelper.clone(annotationMethod.getDefaultExpression()));
        aCtAnnotationMethod.setComments(CloneHelper.clone(annotationMethod.getComments()));
        this.other = aCtAnnotationMethod;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtNewArray(final CtNewArray<T> newArray) {
        CtNewArray<T> aCtNewArray = CloneBuilder.build(this.builder, newArray, newArray.getFactory().Core().createNewArray());
        aCtNewArray.setAnnotations(CloneHelper.clone(newArray.getAnnotations()));
        aCtNewArray.setType(CloneHelper.clone(newArray.getType()));
        aCtNewArray.setTypeCasts(CloneHelper.clone(newArray.getTypeCasts()));
        aCtNewArray.setElements(CloneHelper.clone(newArray.getElements()));
        aCtNewArray.setDimensionExpressions(CloneHelper.clone(newArray.getDimensionExpressions()));
        aCtNewArray.setComments(CloneHelper.clone(newArray.getComments()));
        this.other = aCtNewArray;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtConstructorCall(final CtConstructorCall<T> ctConstructorCall) {
        CtConstructorCall<T> aCtConstructorCall = CloneBuilder.build(this.builder, ctConstructorCall, ctConstructorCall.getFactory().Core().createConstructorCall());
        aCtConstructorCall.setAnnotations(CloneHelper.clone(ctConstructorCall.getAnnotations()));
        aCtConstructorCall.setTypeCasts(CloneHelper.clone(ctConstructorCall.getTypeCasts()));
        aCtConstructorCall.setExecutable(CloneHelper.clone(ctConstructorCall.getExecutable()));
        aCtConstructorCall.setTarget(CloneHelper.clone(ctConstructorCall.getTarget()));
        aCtConstructorCall.setArguments(CloneHelper.clone(ctConstructorCall.getArguments()));
        aCtConstructorCall.setComments(CloneHelper.clone(ctConstructorCall.getComments()));
        this.other = aCtConstructorCall;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtNewClass(final CtNewClass<T> newClass) {
        CtNewClass<T> aCtNewClass = CloneBuilder.build(this.builder, newClass, newClass.getFactory().Core().createNewClass());
        aCtNewClass.setAnnotations(CloneHelper.clone(newClass.getAnnotations()));
        aCtNewClass.setTypeCasts(CloneHelper.clone(newClass.getTypeCasts()));
        aCtNewClass.setExecutable(CloneHelper.clone(newClass.getExecutable()));
        aCtNewClass.setTarget(CloneHelper.clone(newClass.getTarget()));
        aCtNewClass.setArguments(CloneHelper.clone(newClass.getArguments()));
        aCtNewClass.setAnonymousClass(CloneHelper.clone(newClass.getAnonymousClass()));
        aCtNewClass.setComments(CloneHelper.clone(newClass.getComments()));
        this.other = aCtNewClass;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtLambda(final CtLambda<T> lambda) {
        CtLambda<T> aCtLambda = CloneBuilder.build(this.builder, lambda, lambda.getFactory().Core().createLambda());
        aCtLambda.setAnnotations(CloneHelper.clone(lambda.getAnnotations()));
        aCtLambda.setType(CloneHelper.clone(lambda.getType()));
        aCtLambda.setTypeCasts(CloneHelper.clone(lambda.getTypeCasts()));
        aCtLambda.setParameters(CloneHelper.clone(lambda.getParameters()));
        aCtLambda.setThrownTypes(CloneHelper.clone(lambda.getThrownTypes()));
        aCtLambda.setBody(CloneHelper.clone(lambda.getBody()));
        aCtLambda.setExpression(CloneHelper.clone(lambda.getExpression()));
        aCtLambda.setComments(CloneHelper.clone(lambda.getComments()));
        this.other = aCtLambda;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(final CtExecutableReferenceExpression<T, E> expression) {
        CtExecutableReferenceExpression<T, E> aCtExecutableReferenceExpression = CloneBuilder.build(this.builder, expression, expression.getFactory().Core().createExecutableReferenceExpression());
        aCtExecutableReferenceExpression.setComments(CloneHelper.clone(expression.getComments()));
        aCtExecutableReferenceExpression.setAnnotations(CloneHelper.clone(expression.getAnnotations()));
        aCtExecutableReferenceExpression.setType(CloneHelper.clone(expression.getType()));
        aCtExecutableReferenceExpression.setTypeCasts(CloneHelper.clone(expression.getTypeCasts()));
        aCtExecutableReferenceExpression.setExecutable(CloneHelper.clone(expression.getExecutable()));
        aCtExecutableReferenceExpression.setTarget(CloneHelper.clone(expression.getTarget()));
        this.other = aCtExecutableReferenceExpression;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T, A extends T> void visitCtOperatorAssignment(final CtOperatorAssignment<T, A> assignment) {
        CtOperatorAssignment<T, A> aCtOperatorAssignment = CloneBuilder.build(this.builder, assignment, assignment.getFactory().Core().createOperatorAssignment());
        aCtOperatorAssignment.setAnnotations(CloneHelper.clone(assignment.getAnnotations()));
        aCtOperatorAssignment.setType(CloneHelper.clone(assignment.getType()));
        aCtOperatorAssignment.setTypeCasts(CloneHelper.clone(assignment.getTypeCasts()));
        aCtOperatorAssignment.setAssigned(CloneHelper.clone(assignment.getAssigned()));
        aCtOperatorAssignment.setAssignment(CloneHelper.clone(assignment.getAssignment()));
        aCtOperatorAssignment.setComments(CloneHelper.clone(assignment.getComments()));
        this.other = aCtOperatorAssignment;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtPackage(final CtPackage ctPackage) {
        CtPackage aCtPackage = CloneBuilder.build(this.builder, ctPackage, ctPackage.getFactory().Core().createPackage());
        aCtPackage.setAnnotations(CloneHelper.clone(ctPackage.getAnnotations()));
        aCtPackage.setPackages(CloneHelper.clone(ctPackage.getPackages()));
        aCtPackage.setTypes(CloneHelper.clone(ctPackage.getTypes()));
        aCtPackage.setComments(CloneHelper.clone(ctPackage.getComments()));
        this.other = aCtPackage;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtPackageReference(final CtPackageReference reference) {
        CtPackageReference aCtPackageReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createPackageReference());
        aCtPackageReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        this.other = aCtPackageReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtParameter(final CtParameter<T> parameter) {
        CtParameter<T> aCtParameter = CloneBuilder.build(this.builder, parameter, parameter.getFactory().Core().createParameter());
        aCtParameter.setAnnotations(CloneHelper.clone(parameter.getAnnotations()));
        aCtParameter.setType(CloneHelper.clone(parameter.getType()));
        aCtParameter.setComments(CloneHelper.clone(parameter.getComments()));
        this.other = aCtParameter;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtParameterReference(final CtParameterReference<T> reference) {
        CtParameterReference<T> aCtParameterReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createParameterReference());
        aCtParameterReference.setType(CloneHelper.clone(reference.getType()));
        aCtParameterReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        aCtParameterReference.setDeclaringExecutable(CloneHelper.clone(reference.getDeclaringExecutable()));
        this.other = aCtParameterReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <R> void visitCtReturn(final CtReturn<R> returnStatement) {
        CtReturn<R> aCtReturn = CloneBuilder.build(this.builder, returnStatement, returnStatement.getFactory().Core().createReturn());
        aCtReturn.setAnnotations(CloneHelper.clone(returnStatement.getAnnotations()));
        aCtReturn.setReturnedExpression(CloneHelper.clone(returnStatement.getReturnedExpression()));
        aCtReturn.setComments(CloneHelper.clone(returnStatement.getComments()));
        this.other = aCtReturn;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <R> void visitCtStatementList(final CtStatementList statements) {
        CtStatementList aCtStatementList = CloneBuilder.build(this.builder, statements, statements.getFactory().Core().createStatementList());
        aCtStatementList.setAnnotations(CloneHelper.clone(statements.getAnnotations()));
        aCtStatementList.setStatements(CloneHelper.clone(statements.getStatements()));
        aCtStatementList.setComments(CloneHelper.clone(statements.getComments()));
        this.other = aCtStatementList;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <S> void visitCtSwitch(final CtSwitch<S> switchStatement) {
        CtSwitch<S> aCtSwitch = CloneBuilder.build(this.builder, switchStatement, switchStatement.getFactory().Core().createSwitch());
        aCtSwitch.setAnnotations(CloneHelper.clone(switchStatement.getAnnotations()));
        aCtSwitch.setSelector(CloneHelper.clone(switchStatement.getSelector()));
        aCtSwitch.setCases(CloneHelper.clone(switchStatement.getCases()));
        aCtSwitch.setComments(CloneHelper.clone(switchStatement.getComments()));
        this.other = aCtSwitch;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtSynchronized(final CtSynchronized synchro) {
        CtSynchronized aCtSynchronized = CloneBuilder.build(this.builder, synchro, synchro.getFactory().Core().createSynchronized());
        aCtSynchronized.setAnnotations(CloneHelper.clone(synchro.getAnnotations()));
        aCtSynchronized.setExpression(CloneHelper.clone(synchro.getExpression()));
        aCtSynchronized.setBlock(CloneHelper.clone(synchro.getBlock()));
        aCtSynchronized.setComments(CloneHelper.clone(synchro.getComments()));
        this.other = aCtSynchronized;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtThrow(final CtThrow throwStatement) {
        CtThrow aCtThrow = CloneBuilder.build(this.builder, throwStatement, throwStatement.getFactory().Core().createThrow());
        aCtThrow.setAnnotations(CloneHelper.clone(throwStatement.getAnnotations()));
        aCtThrow.setThrownExpression(CloneHelper.clone(throwStatement.getThrownExpression()));
        aCtThrow.setComments(CloneHelper.clone(throwStatement.getComments()));
        this.other = aCtThrow;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtTry(final CtTry tryBlock) {
        CtTry aCtTry = CloneBuilder.build(this.builder, tryBlock, tryBlock.getFactory().Core().createTry());
        aCtTry.setAnnotations(CloneHelper.clone(tryBlock.getAnnotations()));
        aCtTry.setBody(CloneHelper.clone(tryBlock.getBody()));
        aCtTry.setCatchers(CloneHelper.clone(tryBlock.getCatchers()));
        aCtTry.setFinalizer(CloneHelper.clone(tryBlock.getFinalizer()));
        aCtTry.setComments(CloneHelper.clone(tryBlock.getComments()));
        this.other = aCtTry;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public void visitCtTryWithResource(final CtTryWithResource tryWithResource) {
        CtTryWithResource aCtTryWithResource = CloneBuilder.build(this.builder, tryWithResource, tryWithResource.getFactory().Core().createTryWithResource());
        aCtTryWithResource.setAnnotations(CloneHelper.clone(tryWithResource.getAnnotations()));
        aCtTryWithResource.setResources(CloneHelper.clone(tryWithResource.getResources()));
        aCtTryWithResource.setBody(CloneHelper.clone(tryWithResource.getBody()));
        aCtTryWithResource.setCatchers(CloneHelper.clone(tryWithResource.getCatchers()));
        aCtTryWithResource.setFinalizer(CloneHelper.clone(tryWithResource.getFinalizer()));
        aCtTryWithResource.setComments(CloneHelper.clone(tryWithResource.getComments()));
        this.other = aCtTryWithResource;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtTypeParameterReference(final CtTypeParameterReference ref) {
        CtTypeParameterReference aCtTypeParameterReference = CloneBuilder.build(this.builder, ref, ref.getFactory().Core().createTypeParameterReference());
        aCtTypeParameterReference.setPackage(CloneHelper.clone(ref.getPackage()));
        aCtTypeParameterReference.setDeclaringType(CloneHelper.clone(ref.getDeclaringType()));
        aCtTypeParameterReference.setAnnotations(CloneHelper.clone(ref.getAnnotations()));
        aCtTypeParameterReference.setBoundingType(CloneHelper.clone(ref.getBoundingType()));
        this.other = aCtTypeParameterReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public void visitCtWildcardReference(CtWildcardReference wildcardReference) {
        CtWildcardReference aCtWildcardReference = CloneBuilder.build(this.builder, wildcardReference, wildcardReference.getFactory().Core().createWildcardReference());
        aCtWildcardReference.setPackage(CloneHelper.clone(wildcardReference.getPackage()));
        aCtWildcardReference.setDeclaringType(CloneHelper.clone(wildcardReference.getDeclaringType()));
        aCtWildcardReference.setAnnotations(CloneHelper.clone(wildcardReference.getAnnotations()));
        aCtWildcardReference.setBoundingType(CloneHelper.clone(wildcardReference.getBoundingType()));
        this.other = aCtWildcardReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtIntersectionTypeReference(final CtIntersectionTypeReference<T> reference) {
        CtIntersectionTypeReference<T> aCtIntersectionTypeReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createIntersectionTypeReference());
        aCtIntersectionTypeReference.setPackage(CloneHelper.clone(reference.getPackage()));
        aCtIntersectionTypeReference.setDeclaringType(CloneHelper.clone(reference.getDeclaringType()));
        aCtIntersectionTypeReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        aCtIntersectionTypeReference.setBounds(CloneHelper.clone(reference.getBounds()));
        this.other = aCtIntersectionTypeReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtTypeReference(final CtTypeReference<T> reference) {
        CtTypeReference<T> aCtTypeReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createTypeReference());
        aCtTypeReference.setPackage(CloneHelper.clone(reference.getPackage()));
        aCtTypeReference.setDeclaringType(CloneHelper.clone(reference.getDeclaringType()));
        aCtTypeReference.setActualTypeArguments(CloneHelper.clone(reference.getActualTypeArguments()));
        aCtTypeReference.setAnnotations(CloneHelper.clone(reference.getAnnotations()));
        aCtTypeReference.setComments(CloneHelper.clone(reference.getComments()));
        this.other = aCtTypeReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtTypeAccess(final CtTypeAccess<T> typeAccess) {
        CtTypeAccess<T> aCtTypeAccess = CloneBuilder.build(this.builder, typeAccess, typeAccess.getFactory().Core().createTypeAccess());
        aCtTypeAccess.setAnnotations(CloneHelper.clone(typeAccess.getAnnotations()));
        aCtTypeAccess.setTypeCasts(CloneHelper.clone(typeAccess.getTypeCasts()));
        aCtTypeAccess.setAccessedType(CloneHelper.clone(typeAccess.getAccessedType()));
        aCtTypeAccess.setComments(CloneHelper.clone(typeAccess.getComments()));
        this.other = aCtTypeAccess;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtUnaryOperator(final CtUnaryOperator<T> operator) {
        CtUnaryOperator<T> aCtUnaryOperator = CloneBuilder.build(this.builder, operator, operator.getFactory().Core().createUnaryOperator());
        aCtUnaryOperator.setAnnotations(CloneHelper.clone(operator.getAnnotations()));
        aCtUnaryOperator.setType(CloneHelper.clone(operator.getType()));
        aCtUnaryOperator.setTypeCasts(CloneHelper.clone(operator.getTypeCasts()));
        aCtUnaryOperator.setOperand(CloneHelper.clone(operator.getOperand()));
        aCtUnaryOperator.setComments(CloneHelper.clone(operator.getComments()));
        this.other = aCtUnaryOperator;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtVariableRead(final CtVariableRead<T> variableRead) {
        CtVariableRead<T> aCtVariableRead = CloneBuilder.build(this.builder, variableRead, variableRead.getFactory().Core().createVariableRead());
        aCtVariableRead.setAnnotations(CloneHelper.clone(variableRead.getAnnotations()));
        aCtVariableRead.setTypeCasts(CloneHelper.clone(variableRead.getTypeCasts()));
        aCtVariableRead.setVariable(CloneHelper.clone(variableRead.getVariable()));
        aCtVariableRead.setComments(CloneHelper.clone(variableRead.getComments()));
        this.other = aCtVariableRead;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtVariableWrite(final CtVariableWrite<T> variableWrite) {
        CtVariableWrite<T> aCtVariableWrite = CloneBuilder.build(this.builder, variableWrite, variableWrite.getFactory().Core().createVariableWrite());
        aCtVariableWrite.setAnnotations(CloneHelper.clone(variableWrite.getAnnotations()));
        aCtVariableWrite.setTypeCasts(CloneHelper.clone(variableWrite.getTypeCasts()));
        aCtVariableWrite.setVariable(CloneHelper.clone(variableWrite.getVariable()));
        aCtVariableWrite.setComments(CloneHelper.clone(variableWrite.getComments()));
        this.other = aCtVariableWrite;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtWhile(final CtWhile whileLoop) {
        CtWhile aCtWhile = CloneBuilder.build(this.builder, whileLoop, whileLoop.getFactory().Core().createWhile());
        aCtWhile.setAnnotations(CloneHelper.clone(whileLoop.getAnnotations()));
        aCtWhile.setLoopingExpression(CloneHelper.clone(whileLoop.getLoopingExpression()));
        aCtWhile.setBody(CloneHelper.clone(whileLoop.getBody()));
        aCtWhile.setComments(CloneHelper.clone(whileLoop.getComments()));
        this.other = aCtWhile;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtCodeSnippetExpression(final CtCodeSnippetExpression<T> expression) {
        CtCodeSnippetExpression<T> aCtCodeSnippetExpression = CloneBuilder.build(this.builder, expression, expression.getFactory().Core().createCodeSnippetExpression());
        aCtCodeSnippetExpression.setType(CloneHelper.clone(expression.getType()));
        aCtCodeSnippetExpression.setComments(CloneHelper.clone(expression.getComments()));
        aCtCodeSnippetExpression.setAnnotations(CloneHelper.clone(expression.getAnnotations()));
        aCtCodeSnippetExpression.setTypeCasts(CloneHelper.clone(expression.getTypeCasts()));
        this.other = aCtCodeSnippetExpression;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public void visitCtCodeSnippetStatement(final CtCodeSnippetStatement statement) {
        CtCodeSnippetStatement aCtCodeSnippetStatement = CloneBuilder.build(this.builder, statement, statement.getFactory().Core().createCodeSnippetStatement());
        aCtCodeSnippetStatement.setComments(CloneHelper.clone(statement.getComments()));
        aCtCodeSnippetStatement.setAnnotations(CloneHelper.clone(statement.getAnnotations()));
        this.other = aCtCodeSnippetStatement;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    public <T> void visitCtUnboundVariableReference(final CtUnboundVariableReference<T> reference) {
        CtUnboundVariableReference<T> aCtUnboundVariableReference = CloneBuilder.build(this.builder, reference, reference.getFactory().Core().createUnboundVariableReference());
        aCtUnboundVariableReference.setType(CloneHelper.clone(reference.getType()));
        this.other = aCtUnboundVariableReference;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtFieldRead(final CtFieldRead<T> fieldRead) {
        CtFieldRead<T> aCtFieldRead = CloneBuilder.build(this.builder, fieldRead, fieldRead.getFactory().Core().createFieldRead());
        aCtFieldRead.setAnnotations(CloneHelper.clone(fieldRead.getAnnotations()));
        aCtFieldRead.setTypeCasts(CloneHelper.clone(fieldRead.getTypeCasts()));
        aCtFieldRead.setTarget(CloneHelper.clone(fieldRead.getTarget()));
        aCtFieldRead.setVariable(CloneHelper.clone(fieldRead.getVariable()));
        aCtFieldRead.setComments(CloneHelper.clone(fieldRead.getComments()));
        this.other = aCtFieldRead;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtFieldWrite(final CtFieldWrite<T> fieldWrite) {
        CtFieldWrite<T> aCtFieldWrite = CloneBuilder.build(this.builder, fieldWrite, fieldWrite.getFactory().Core().createFieldWrite());
        aCtFieldWrite.setAnnotations(CloneHelper.clone(fieldWrite.getAnnotations()));
        aCtFieldWrite.setTypeCasts(CloneHelper.clone(fieldWrite.getTypeCasts()));
        aCtFieldWrite.setTarget(CloneHelper.clone(fieldWrite.getTarget()));
        aCtFieldWrite.setVariable(CloneHelper.clone(fieldWrite.getVariable()));
        aCtFieldWrite.setComments(CloneHelper.clone(fieldWrite.getComments()));
        this.other = aCtFieldWrite;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public <T> void visitCtSuperAccess(final CtSuperAccess<T> f) {
        CtSuperAccess<T> aCtSuperAccess = CloneBuilder.build(this.builder, f, f.getFactory().Core().createSuperAccess());
        aCtSuperAccess.setType(CloneHelper.clone(f.getType()));
        aCtSuperAccess.setComments(CloneHelper.clone(f.getComments()));
        aCtSuperAccess.setAnnotations(CloneHelper.clone(f.getAnnotations()));
        aCtSuperAccess.setTypeCasts(CloneHelper.clone(f.getTypeCasts()));
        aCtSuperAccess.setTarget(CloneHelper.clone(f.getTarget()));
        aCtSuperAccess.setVariable(CloneHelper.clone(f.getVariable()));
        this.other = aCtSuperAccess;
    }

    // auto-generated, see spoon.generating.CloneVisitorGenerator
    @Override
    public void visitCtComment(final CtComment comment) {
        CtComment aCtComment = CloneBuilder.build(this.builder, comment, comment.getFactory().Core().createComment());
        aCtComment.setComments(CloneHelper.clone(comment.getComments()));
        aCtComment.setAnnotations(CloneHelper.clone(comment.getAnnotations()));
        this.other = aCtComment;
    }
}