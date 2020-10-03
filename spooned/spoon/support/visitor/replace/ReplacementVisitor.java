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
package spoon.support.visitor.replace;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import spoon.SpoonException;
import spoon.generating.replace.ReplaceListListener;
import spoon.generating.replace.ReplaceListener;
import spoon.generating.replace.ReplaceMapListener;
import spoon.generating.replace.ReplaceSetListener;
import spoon.reflect.code.CtAbstractInvocation;
import spoon.reflect.code.CtAnnotationFieldAccess;
import spoon.reflect.code.CtArrayAccess;
import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtArrayWrite;
import spoon.reflect.code.CtAssert;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtBodyHolder;
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
import spoon.reflect.code.CtRHSReceiver;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtStatementList;
import spoon.reflect.code.CtSuperAccess;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtSynchronized;
import spoon.reflect.code.CtTargetedExpression;
import spoon.reflect.code.CtThisAccess;
import spoon.reflect.code.CtThrow;
import spoon.reflect.code.CtTry;
import spoon.reflect.code.CtTryWithResource;
import spoon.reflect.code.CtTypeAccess;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.CtVariableAccess;
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
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtFormalTypeDeclarer;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtMultiTypedElement;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.declaration.CtTypedElement;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.reference.CtActualTypeContainer;
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
import spoon.reflect.reference.CtVariableReference;
import spoon.reflect.reference.CtWildcardReference;
import spoon.reflect.visitor.CtScanner;
/**
 * Used to replace an element by another one.
 *
 * This class is generated automatically by the processor {@link spoon.generating.ReplacementVisitorGenerator}.
 */
public class ReplacementVisitor extends CtScanner {
    public static void replace(CtElement original, CtElement replace) {
        try {
            new ReplacementVisitor(original, replace).scan(original.getParent());
        } catch (SpoonException ignore) {
        }
    }

    private CtElement original;

    private CtElement replace;

    private ReplacementVisitor(CtElement original, CtElement replace) {
        this.original = original;
        this.replace = replace;
    }

    private <K, V extends CtElement> void replaceInMapIfExist(Map<K, V> mapProtected, ReplaceMapListener listener) {
        Map<K, V> map = new HashMap<>(mapProtected);
        V shouldBeDeleted = null;
        K key = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue() == original) {
                shouldBeDeleted = entry.getValue();
                key = entry.getKey();
                break;
            }
        }
        if (shouldBeDeleted != null) {
            if (replace != null) {
                map.put(key, ((V) (replace)));
                replace.setParent(shouldBeDeleted.getParent());
            } else {
                map.remove(key);
            }
            listener.set(map);
        }
    }

    private <T extends CtElement> void replaceInSetIfExist(Set<T> setProtected, ReplaceSetListener listener) {
        Set<T> set = new HashSet<>(setProtected);
        T shouldBeDeleted = null;
        for (T element : set) {
            if (element == original) {
                shouldBeDeleted = element;
                break;
            }
        }
        if (shouldBeDeleted != null) {
            set.remove(shouldBeDeleted);
            if (replace != null) {
                set.add(((T) (replace)));
                replace.setParent(shouldBeDeleted.getParent());
            }
            listener.set(set);
        }
    }

    private <T extends CtElement> void replaceInListIfExist(List<T> listProtected, ReplaceListListener listener) {
        List<T> list = new ArrayList<>(listProtected);
        T shouldBeDeleted = null;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == original) {
                index = i;
                shouldBeDeleted = list.get(i);
                break;
            }
        }
        if (shouldBeDeleted != null) {
            if (replace != null) {
                list.set(index, ((T) (replace)));
                replace.setParent(shouldBeDeleted.getParent());
            } else {
                list.remove(index);
            }
            listener.set(list);
        }
    }

    private void replaceElementIfExist(CtElement candidate, ReplaceListener listener) {
        if (candidate == original) {
            listener.set(replace);
            if (replace != null) {
                replace.setParent(candidate.getParent());
            }
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypedElementTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtTypedElement element;

        CtTypedElementTypeReplaceListener(CtTypedElement element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtElementCommentsReplaceListener implements ReplaceListListener<List> {
        private final CtElement element;

        CtElementCommentsReplaceListener(CtElement element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setComments(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAnnotationAnnotationTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtAnnotation element;

        CtAnnotationAnnotationTypeReplaceListener(CtAnnotation element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setAnnotationType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtElementAnnotationsReplaceListener implements ReplaceListListener<List> {
        private final CtElement element;

        CtElementAnnotationsReplaceListener(CtElement element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setAnnotations(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAnnotationValuesReplaceListener implements ReplaceMapListener<Map> {
        private final CtAnnotation element;

        CtAnnotationValuesReplaceListener(CtAnnotation element) {
            this.element = element;
        }

        @Override
        public void set(Map replace) {
            this.element.setValues(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <A extends Annotation> void visitCtAnnotation(final CtAnnotation<A> annotation) {
        replaceElementIfExist(annotation.getType(), new CtTypedElementTypeReplaceListener(annotation));
        replaceInListIfExist(annotation.getComments(), new CtElementCommentsReplaceListener(annotation));
        replaceElementIfExist(annotation.getAnnotationType(), new CtAnnotationAnnotationTypeReplaceListener(annotation));
        replaceInListIfExist(annotation.getAnnotations(), new CtElementAnnotationsReplaceListener(annotation));
        replaceInMapIfExist(annotation.getValues(), new CtAnnotationValuesReplaceListener(annotation));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeTypeMembersReplaceListener implements ReplaceListListener<List> {
        private final CtType element;

        CtTypeTypeMembersReplaceListener(CtType element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setTypeMembers(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <A extends Annotation> void visitCtAnnotationType(final CtAnnotationType<A> annotationType) {
        replaceInListIfExist(annotationType.getAnnotations(), new CtElementAnnotationsReplaceListener(annotationType));
        replaceInListIfExist(annotationType.getTypeMembers(), new CtTypeTypeMembersReplaceListener(annotationType));
        replaceInListIfExist(annotationType.getComments(), new CtElementCommentsReplaceListener(annotationType));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableBodyReplaceListener implements ReplaceListener<CtBlock> {
        private final CtBodyHolder element;

        CtExecutableBodyReplaceListener(CtBodyHolder element) {
            this.element = element;
        }

        @Override
        public void set(CtBlock replace) {
            this.element.setBody(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtAnonymousExecutable(final CtAnonymousExecutable anonymousExec) {
        replaceInListIfExist(anonymousExec.getAnnotations(), new CtElementAnnotationsReplaceListener(anonymousExec));
        replaceElementIfExist(anonymousExec.getBody(), new CtExecutableBodyReplaceListener(anonymousExec));
        replaceInListIfExist(anonymousExec.getComments(), new CtElementCommentsReplaceListener(anonymousExec));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExpressionTypeCastsReplaceListener implements ReplaceListListener<List> {
        private final CtExpression element;

        CtExpressionTypeCastsReplaceListener(CtExpression element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setTypeCasts(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTargetedExpressionTargetReplaceListener implements ReplaceListener<CtExpression> {
        private final CtTargetedExpression element;

        CtTargetedExpressionTargetReplaceListener(CtTargetedExpression element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setTarget(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtArrayAccessIndexExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtArrayAccess element;

        CtArrayAccessIndexExpressionReplaceListener(CtArrayAccess element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setIndexExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtArrayRead(final CtArrayRead<T> arrayRead) {
        replaceInListIfExist(arrayRead.getAnnotations(), new CtElementAnnotationsReplaceListener(arrayRead));
        replaceElementIfExist(arrayRead.getType(), new CtTypedElementTypeReplaceListener(arrayRead));
        replaceInListIfExist(arrayRead.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(arrayRead));
        replaceElementIfExist(arrayRead.getTarget(), new CtTargetedExpressionTargetReplaceListener(arrayRead));
        replaceElementIfExist(arrayRead.getIndexExpression(), new CtArrayAccessIndexExpressionReplaceListener(arrayRead));
        replaceInListIfExist(arrayRead.getComments(), new CtElementCommentsReplaceListener(arrayRead));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtArrayWrite(final CtArrayWrite<T> arrayWrite) {
        replaceInListIfExist(arrayWrite.getAnnotations(), new CtElementAnnotationsReplaceListener(arrayWrite));
        replaceElementIfExist(arrayWrite.getType(), new CtTypedElementTypeReplaceListener(arrayWrite));
        replaceInListIfExist(arrayWrite.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(arrayWrite));
        replaceElementIfExist(arrayWrite.getTarget(), new CtTargetedExpressionTargetReplaceListener(arrayWrite));
        replaceElementIfExist(arrayWrite.getIndexExpression(), new CtArrayAccessIndexExpressionReplaceListener(arrayWrite));
        replaceInListIfExist(arrayWrite.getComments(), new CtElementCommentsReplaceListener(arrayWrite));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeReferencePackageReplaceListener implements ReplaceListener<CtPackageReference> {
        private final CtTypeReference element;

        CtTypeReferencePackageReplaceListener(CtTypeReference element) {
            this.element = element;
        }

        @Override
        public void set(CtPackageReference replace) {
            this.element.setPackage(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeReferenceDeclaringTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtTypeReference element;

        CtTypeReferenceDeclaringTypeReplaceListener(CtTypeReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setDeclaringType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtArrayTypeReferenceComponentTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtArrayTypeReference element;

        CtArrayTypeReferenceComponentTypeReplaceListener(CtArrayTypeReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setComponentType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtActualTypeContainerActualTypeArgumentsReplaceListener implements ReplaceListListener<List> {
        private final CtActualTypeContainer element;

        CtActualTypeContainerActualTypeArgumentsReplaceListener(CtActualTypeContainer element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setActualTypeArguments(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtArrayTypeReference(final CtArrayTypeReference<T> reference) {
        replaceInListIfExist(reference.getComments(), new CtElementCommentsReplaceListener(reference));
        replaceElementIfExist(reference.getPackage(), new CtTypeReferencePackageReplaceListener(reference));
        replaceElementIfExist(reference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(reference));
        replaceElementIfExist(reference.getComponentType(), new CtArrayTypeReferenceComponentTypeReplaceListener(reference));
        replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAssertAssertExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtAssert element;

        CtAssertAssertExpressionReplaceListener(CtAssert element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setAssertExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAssertExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtAssert element;

        CtAssertExpressionReplaceListener(CtAssert element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtAssert(final CtAssert<T> asserted) {
        replaceInListIfExist(asserted.getAnnotations(), new CtElementAnnotationsReplaceListener(asserted));
        replaceElementIfExist(asserted.getAssertExpression(), new CtAssertAssertExpressionReplaceListener(asserted));
        replaceElementIfExist(asserted.getExpression(), new CtAssertExpressionReplaceListener(asserted));
        replaceInListIfExist(asserted.getComments(), new CtElementCommentsReplaceListener(asserted));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAssignmentAssignedReplaceListener implements ReplaceListener<CtExpression> {
        private final CtAssignment element;

        CtAssignmentAssignedReplaceListener(CtAssignment element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setAssigned(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtRHSReceiverAssignmentReplaceListener implements ReplaceListener<CtExpression> {
        private final CtRHSReceiver element;

        CtRHSReceiverAssignmentReplaceListener(CtRHSReceiver element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setAssignment(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T, A extends T> void visitCtAssignment(final CtAssignment<T, A> assignement) {
        replaceInListIfExist(assignement.getAnnotations(), new CtElementAnnotationsReplaceListener(assignement));
        replaceElementIfExist(assignement.getType(), new CtTypedElementTypeReplaceListener(assignement));
        replaceInListIfExist(assignement.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(assignement));
        replaceElementIfExist(assignement.getAssigned(), new CtAssignmentAssignedReplaceListener(assignement));
        replaceElementIfExist(assignement.getAssignment(), new CtRHSReceiverAssignmentReplaceListener(assignement));
        replaceInListIfExist(assignement.getComments(), new CtElementCommentsReplaceListener(assignement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtBinaryOperatorLeftHandOperandReplaceListener implements ReplaceListener<CtExpression> {
        private final CtBinaryOperator element;

        CtBinaryOperatorLeftHandOperandReplaceListener(CtBinaryOperator element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setLeftHandOperand(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtBinaryOperatorRightHandOperandReplaceListener implements ReplaceListener<CtExpression> {
        private final CtBinaryOperator element;

        CtBinaryOperatorRightHandOperandReplaceListener(CtBinaryOperator element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setRightHandOperand(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtBinaryOperator(final CtBinaryOperator<T> operator) {
        replaceInListIfExist(operator.getAnnotations(), new CtElementAnnotationsReplaceListener(operator));
        replaceElementIfExist(operator.getType(), new CtTypedElementTypeReplaceListener(operator));
        replaceInListIfExist(operator.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(operator));
        replaceElementIfExist(operator.getLeftHandOperand(), new CtBinaryOperatorLeftHandOperandReplaceListener(operator));
        replaceElementIfExist(operator.getRightHandOperand(), new CtBinaryOperatorRightHandOperandReplaceListener(operator));
        replaceInListIfExist(operator.getComments(), new CtElementCommentsReplaceListener(operator));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtStatementListStatementsReplaceListener implements ReplaceListListener<List> {
        private final CtStatementList element;

        CtStatementListStatementsReplaceListener(CtStatementList element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setStatements(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <R> void visitCtBlock(final CtBlock<R> block) {
        replaceInListIfExist(block.getAnnotations(), new CtElementAnnotationsReplaceListener(block));
        replaceInListIfExist(block.getStatements(), new CtStatementListStatementsReplaceListener(block));
        replaceInListIfExist(block.getComments(), new CtElementCommentsReplaceListener(block));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtBreak(final CtBreak breakStatement) {
        replaceInListIfExist(breakStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(breakStatement));
        replaceInListIfExist(breakStatement.getComments(), new CtElementCommentsReplaceListener(breakStatement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtCaseCaseExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtCase element;

        CtCaseCaseExpressionReplaceListener(CtCase element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setCaseExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <S> void visitCtCase(final CtCase<S> caseStatement) {
        replaceInListIfExist(caseStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(caseStatement));
        replaceElementIfExist(caseStatement.getCaseExpression(), new CtCaseCaseExpressionReplaceListener(caseStatement));
        replaceInListIfExist(caseStatement.getStatements(), new CtStatementListStatementsReplaceListener(caseStatement));
        replaceInListIfExist(caseStatement.getComments(), new CtElementCommentsReplaceListener(caseStatement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtCatchParameterReplaceListener implements ReplaceListener<CtCatchVariable> {
        private final CtCatch element;

        CtCatchParameterReplaceListener(CtCatch element) {
            this.element = element;
        }

        @Override
        public void set(CtCatchVariable replace) {
            this.element.setParameter(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtCatchBodyReplaceListener implements ReplaceListener<CtBlock> {
        private final CtBodyHolder element;

        CtCatchBodyReplaceListener(CtBodyHolder element) {
            this.element = element;
        }

        @Override
        public void set(CtBlock replace) {
            this.element.setBody(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtCatch(final CtCatch catchBlock) {
        replaceInListIfExist(catchBlock.getAnnotations(), new CtElementAnnotationsReplaceListener(catchBlock));
        replaceElementIfExist(catchBlock.getParameter(), new CtCatchParameterReplaceListener(catchBlock));
        replaceElementIfExist(catchBlock.getBody(), new CtCatchBodyReplaceListener(catchBlock));
        replaceInListIfExist(catchBlock.getComments(), new CtElementCommentsReplaceListener(catchBlock));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeInformationSuperclassReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtType element;

        CtTypeInformationSuperclassReplaceListener(CtType element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setSuperclass(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeInformationSuperInterfacesReplaceListener implements ReplaceSetListener<Set> {
        private final CtType element;

        CtTypeInformationSuperInterfacesReplaceListener(CtType element) {
            this.element = element;
        }

        @Override
        public void set(Set replace) {
            this.element.setSuperInterfaces(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener implements ReplaceListListener<List> {
        private final CtFormalTypeDeclarer element;

        CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(CtFormalTypeDeclarer element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setFormalCtTypeParameters(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtClass(final CtClass<T> ctClass) {
        replaceInListIfExist(ctClass.getAnnotations(), new CtElementAnnotationsReplaceListener(ctClass));
        replaceElementIfExist(ctClass.getSuperclass(), new CtTypeInformationSuperclassReplaceListener(ctClass));
        replaceInSetIfExist(ctClass.getSuperInterfaces(), new CtTypeInformationSuperInterfacesReplaceListener(ctClass));
        replaceInListIfExist(ctClass.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(ctClass));
        replaceInListIfExist(ctClass.getTypeMembers(), new CtTypeTypeMembersReplaceListener(ctClass));
        replaceInListIfExist(ctClass.getComments(), new CtElementCommentsReplaceListener(ctClass));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtTypeParameter(CtTypeParameter typeParameter) {
        replaceInListIfExist(typeParameter.getAnnotations(), new CtElementAnnotationsReplaceListener(typeParameter));
        replaceElementIfExist(typeParameter.getSuperclass(), new CtTypeInformationSuperclassReplaceListener(typeParameter));
        replaceInListIfExist(typeParameter.getComments(), new CtElementCommentsReplaceListener(typeParameter));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtConditionalConditionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtConditional element;

        CtConditionalConditionReplaceListener(CtConditional element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setCondition(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtConditionalThenExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtConditional element;

        CtConditionalThenExpressionReplaceListener(CtConditional element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setThenExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtConditionalElseExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtConditional element;

        CtConditionalElseExpressionReplaceListener(CtConditional element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setElseExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtConditional(final CtConditional<T> conditional) {
        replaceElementIfExist(conditional.getType(), new CtTypedElementTypeReplaceListener(conditional));
        replaceInListIfExist(conditional.getAnnotations(), new CtElementAnnotationsReplaceListener(conditional));
        replaceElementIfExist(conditional.getCondition(), new CtConditionalConditionReplaceListener(conditional));
        replaceElementIfExist(conditional.getThenExpression(), new CtConditionalThenExpressionReplaceListener(conditional));
        replaceElementIfExist(conditional.getElseExpression(), new CtConditionalElseExpressionReplaceListener(conditional));
        replaceInListIfExist(conditional.getComments(), new CtElementCommentsReplaceListener(conditional));
        replaceInListIfExist(conditional.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(conditional));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableParametersReplaceListener implements ReplaceListListener<List> {
        private final CtExecutable element;

        CtExecutableParametersReplaceListener(CtExecutable element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setParameters(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableThrownTypesReplaceListener implements ReplaceSetListener<Set> {
        private final CtExecutable element;

        CtExecutableThrownTypesReplaceListener(CtExecutable element) {
            this.element = element;
        }

        @Override
        public void set(Set replace) {
            this.element.setThrownTypes(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtConstructor(final CtConstructor<T> c) {
        replaceInListIfExist(c.getAnnotations(), new CtElementAnnotationsReplaceListener(c));
        replaceInListIfExist(c.getParameters(), new CtExecutableParametersReplaceListener(c));
        replaceInSetIfExist(c.getThrownTypes(), new CtExecutableThrownTypesReplaceListener(c));
        replaceInListIfExist(c.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(c));
        replaceElementIfExist(c.getBody(), new CtExecutableBodyReplaceListener(c));
        replaceInListIfExist(c.getComments(), new CtElementCommentsReplaceListener(c));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtContinueLabelledStatementReplaceListener implements ReplaceListener<CtStatement> {
        private final CtContinue element;

        CtContinueLabelledStatementReplaceListener(CtContinue element) {
            this.element = element;
        }

        @Override
        public void set(CtStatement replace) {
            this.element.setLabelledStatement(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtContinue(final CtContinue continueStatement) {
        replaceInListIfExist(continueStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(continueStatement));
        replaceElementIfExist(continueStatement.getLabelledStatement(), new CtContinueLabelledStatementReplaceListener(continueStatement));
        replaceInListIfExist(continueStatement.getComments(), new CtElementCommentsReplaceListener(continueStatement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtDoLoopingExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtDo element;

        CtDoLoopingExpressionReplaceListener(CtDo element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setLoopingExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtLoopBodyReplaceListener implements ReplaceListener<CtStatement> {
        private final CtBodyHolder element;

        CtLoopBodyReplaceListener(CtBodyHolder element) {
            this.element = element;
        }

        @Override
        public void set(CtStatement replace) {
            this.element.setBody(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtDo(final CtDo doLoop) {
        replaceInListIfExist(doLoop.getAnnotations(), new CtElementAnnotationsReplaceListener(doLoop));
        replaceElementIfExist(doLoop.getLoopingExpression(), new CtDoLoopingExpressionReplaceListener(doLoop));
        replaceElementIfExist(doLoop.getBody(), new CtLoopBodyReplaceListener(doLoop));
        replaceInListIfExist(doLoop.getComments(), new CtElementCommentsReplaceListener(doLoop));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtEnumEnumValuesReplaceListener implements ReplaceListListener<List> {
        private final CtEnum element;

        CtEnumEnumValuesReplaceListener(CtEnum element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setEnumValues(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T extends Enum<?>> void visitCtEnum(final CtEnum<T> ctEnum) {
        replaceInListIfExist(ctEnum.getAnnotations(), new CtElementAnnotationsReplaceListener(ctEnum));
        replaceInSetIfExist(ctEnum.getSuperInterfaces(), new CtTypeInformationSuperInterfacesReplaceListener(ctEnum));
        replaceInListIfExist(ctEnum.getTypeMembers(), new CtTypeTypeMembersReplaceListener(ctEnum));
        replaceInListIfExist(ctEnum.getEnumValues(), new CtEnumEnumValuesReplaceListener(ctEnum));
        replaceInListIfExist(ctEnum.getComments(), new CtElementCommentsReplaceListener(ctEnum));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableReferenceDeclaringTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtExecutableReference element;

        CtExecutableReferenceDeclaringTypeReplaceListener(CtExecutableReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setDeclaringType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableReferenceTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtExecutableReference element;

        CtExecutableReferenceTypeReplaceListener(CtExecutableReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableReferenceParametersReplaceListener implements ReplaceListListener<List> {
        private final CtExecutableReference element;

        CtExecutableReferenceParametersReplaceListener(CtExecutableReference element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setParameters(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtExecutableReference(final CtExecutableReference<T> reference) {
        replaceElementIfExist(reference.getDeclaringType(), new CtExecutableReferenceDeclaringTypeReplaceListener(reference));
        replaceElementIfExist(reference.getType(), new CtExecutableReferenceTypeReplaceListener(reference));
        replaceInListIfExist(reference.getParameters(), new CtExecutableReferenceParametersReplaceListener(reference));
        replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
        replaceInListIfExist(reference.getComments(), new CtElementCommentsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtVariableDefaultExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtVariable element;

        CtVariableDefaultExpressionReplaceListener(CtVariable element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setDefaultExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtField(final CtField<T> f) {
        replaceInListIfExist(f.getAnnotations(), new CtElementAnnotationsReplaceListener(f));
        replaceElementIfExist(f.getType(), new CtTypedElementTypeReplaceListener(f));
        replaceElementIfExist(f.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(f));
        replaceInListIfExist(f.getComments(), new CtElementCommentsReplaceListener(f));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtEnumValue(final CtEnumValue<T> enumValue) {
        replaceInListIfExist(enumValue.getAnnotations(), new CtElementAnnotationsReplaceListener(enumValue));
        replaceElementIfExist(enumValue.getType(), new CtTypedElementTypeReplaceListener(enumValue));
        replaceElementIfExist(enumValue.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(enumValue));
        replaceInListIfExist(enumValue.getComments(), new CtElementCommentsReplaceListener(enumValue));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtThisAccess(final CtThisAccess<T> thisAccess) {
        replaceInListIfExist(thisAccess.getComments(), new CtElementCommentsReplaceListener(thisAccess));
        replaceInListIfExist(thisAccess.getAnnotations(), new CtElementAnnotationsReplaceListener(thisAccess));
        replaceElementIfExist(thisAccess.getType(), new CtTypedElementTypeReplaceListener(thisAccess));
        replaceInListIfExist(thisAccess.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(thisAccess));
        replaceElementIfExist(thisAccess.getTarget(), new CtTargetedExpressionTargetReplaceListener(thisAccess));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtVariableAccessTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtTypedElement element;

        CtVariableAccessTypeReplaceListener(CtTypedElement element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAnnotationFieldAccessVariableReplaceListener implements ReplaceListener<CtFieldReference> {
        private final CtVariableAccess element;

        CtAnnotationFieldAccessVariableReplaceListener(CtVariableAccess element) {
            this.element = element;
        }

        @Override
        public void set(CtFieldReference replace) {
            this.element.setVariable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtAnnotationFieldAccess(final CtAnnotationFieldAccess<T> annotationFieldAccess) {
        replaceInListIfExist(annotationFieldAccess.getComments(), new CtElementCommentsReplaceListener(annotationFieldAccess));
        replaceInListIfExist(annotationFieldAccess.getAnnotations(), new CtElementAnnotationsReplaceListener(annotationFieldAccess));
        replaceInListIfExist(annotationFieldAccess.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(annotationFieldAccess));
        replaceElementIfExist(annotationFieldAccess.getTarget(), new CtTargetedExpressionTargetReplaceListener(annotationFieldAccess));
        replaceElementIfExist(annotationFieldAccess.getType(), new CtVariableAccessTypeReplaceListener(annotationFieldAccess));
        replaceElementIfExist(annotationFieldAccess.getVariable(), new CtAnnotationFieldAccessVariableReplaceListener(annotationFieldAccess));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtFieldReferenceDeclaringTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtFieldReference element;

        CtFieldReferenceDeclaringTypeReplaceListener(CtFieldReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setDeclaringType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtVariableReferenceTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtVariableReference element;

        CtVariableReferenceTypeReplaceListener(CtVariableReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtFieldReference(final CtFieldReference<T> reference) {
        replaceElementIfExist(reference.getDeclaringType(), new CtFieldReferenceDeclaringTypeReplaceListener(reference));
        replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtForForInitReplaceListener implements ReplaceListListener<List> {
        private final CtFor element;

        CtForForInitReplaceListener(CtFor element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setForInit(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtForExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtFor element;

        CtForExpressionReplaceListener(CtFor element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtForForUpdateReplaceListener implements ReplaceListListener<List> {
        private final CtFor element;

        CtForForUpdateReplaceListener(CtFor element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setForUpdate(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtFor(final CtFor forLoop) {
        replaceInListIfExist(forLoop.getAnnotations(), new CtElementAnnotationsReplaceListener(forLoop));
        replaceInListIfExist(forLoop.getForInit(), new CtForForInitReplaceListener(forLoop));
        replaceElementIfExist(forLoop.getExpression(), new CtForExpressionReplaceListener(forLoop));
        replaceInListIfExist(forLoop.getForUpdate(), new CtForForUpdateReplaceListener(forLoop));
        replaceElementIfExist(forLoop.getBody(), new CtLoopBodyReplaceListener(forLoop));
        replaceInListIfExist(forLoop.getComments(), new CtElementCommentsReplaceListener(forLoop));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtForEachVariableReplaceListener implements ReplaceListener<CtLocalVariable> {
        private final CtForEach element;

        CtForEachVariableReplaceListener(CtForEach element) {
            this.element = element;
        }

        @Override
        public void set(CtLocalVariable replace) {
            this.element.setVariable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtForEachExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtForEach element;

        CtForEachExpressionReplaceListener(CtForEach element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtForEach(final CtForEach foreach) {
        replaceInListIfExist(foreach.getAnnotations(), new CtElementAnnotationsReplaceListener(foreach));
        replaceElementIfExist(foreach.getVariable(), new CtForEachVariableReplaceListener(foreach));
        replaceElementIfExist(foreach.getExpression(), new CtForEachExpressionReplaceListener(foreach));
        replaceElementIfExist(foreach.getBody(), new CtLoopBodyReplaceListener(foreach));
        replaceInListIfExist(foreach.getComments(), new CtElementCommentsReplaceListener(foreach));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtIfConditionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtIf element;

        CtIfConditionReplaceListener(CtIf element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setCondition(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtIfThenStatementReplaceListener implements ReplaceListener<CtStatement> {
        private final CtIf element;

        CtIfThenStatementReplaceListener(CtIf element) {
            this.element = element;
        }

        @Override
        public void set(CtStatement replace) {
            this.element.setThenStatement(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtIfElseStatementReplaceListener implements ReplaceListener<CtStatement> {
        private final CtIf element;

        CtIfElseStatementReplaceListener(CtIf element) {
            this.element = element;
        }

        @Override
        public void set(CtStatement replace) {
            this.element.setElseStatement(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtIf(final CtIf ifElement) {
        replaceInListIfExist(ifElement.getAnnotations(), new CtElementAnnotationsReplaceListener(ifElement));
        replaceElementIfExist(ifElement.getCondition(), new CtIfConditionReplaceListener(ifElement));
        replaceElementIfExist(((CtStatement) (ifElement.getThenStatement())), new CtIfThenStatementReplaceListener(ifElement));
        replaceElementIfExist(((CtStatement) (ifElement.getElseStatement())), new CtIfElseStatementReplaceListener(ifElement));
        replaceInListIfExist(ifElement.getComments(), new CtElementCommentsReplaceListener(ifElement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtInterface(final CtInterface<T> intrface) {
        replaceInListIfExist(intrface.getAnnotations(), new CtElementAnnotationsReplaceListener(intrface));
        replaceInSetIfExist(intrface.getSuperInterfaces(), new CtTypeInformationSuperInterfacesReplaceListener(intrface));
        replaceInListIfExist(intrface.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(intrface));
        replaceInListIfExist(intrface.getTypeMembers(), new CtTypeTypeMembersReplaceListener(intrface));
        replaceInListIfExist(intrface.getComments(), new CtElementCommentsReplaceListener(intrface));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAbstractInvocationExecutableReplaceListener implements ReplaceListener<CtExecutableReference> {
        private final CtAbstractInvocation element;

        CtAbstractInvocationExecutableReplaceListener(CtAbstractInvocation element) {
            this.element = element;
        }

        @Override
        public void set(CtExecutableReference replace) {
            this.element.setExecutable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAbstractInvocationArgumentsReplaceListener implements ReplaceListListener<List> {
        private final CtAbstractInvocation element;

        CtAbstractInvocationArgumentsReplaceListener(CtAbstractInvocation element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setArguments(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtInvocation(final CtInvocation<T> invocation) {
        replaceInListIfExist(invocation.getAnnotations(), new CtElementAnnotationsReplaceListener(invocation));
        replaceInListIfExist(invocation.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(invocation));
        replaceElementIfExist(invocation.getTarget(), new CtTargetedExpressionTargetReplaceListener(invocation));
        replaceElementIfExist(invocation.getExecutable(), new CtAbstractInvocationExecutableReplaceListener(invocation));
        replaceInListIfExist(invocation.getArguments(), new CtAbstractInvocationArgumentsReplaceListener(invocation));
        replaceInListIfExist(invocation.getComments(), new CtElementCommentsReplaceListener(invocation));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtLiteral(final CtLiteral<T> literal) {
        replaceInListIfExist(literal.getAnnotations(), new CtElementAnnotationsReplaceListener(literal));
        replaceElementIfExist(literal.getType(), new CtTypedElementTypeReplaceListener(literal));
        replaceInListIfExist(literal.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(literal));
        replaceInListIfExist(literal.getComments(), new CtElementCommentsReplaceListener(literal));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtLocalVariable(final CtLocalVariable<T> localVariable) {
        replaceInListIfExist(localVariable.getAnnotations(), new CtElementAnnotationsReplaceListener(localVariable));
        replaceElementIfExist(localVariable.getType(), new CtTypedElementTypeReplaceListener(localVariable));
        replaceElementIfExist(localVariable.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(localVariable));
        replaceInListIfExist(localVariable.getComments(), new CtElementCommentsReplaceListener(localVariable));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtLocalVariableReference(final CtLocalVariableReference<T> reference) {
        replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtMultiTypedElementMultiTypesReplaceListener implements ReplaceListListener<List> {
        private final CtMultiTypedElement element;

        CtMultiTypedElementMultiTypesReplaceListener(CtMultiTypedElement element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setMultiTypes(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtCatchVariable(final CtCatchVariable<T> catchVariable) {
        replaceInListIfExist(catchVariable.getComments(), new CtElementCommentsReplaceListener(catchVariable));
        replaceInListIfExist(catchVariable.getAnnotations(), new CtElementAnnotationsReplaceListener(catchVariable));
        replaceElementIfExist(catchVariable.getDefaultExpression(), new CtVariableDefaultExpressionReplaceListener(catchVariable));
        replaceElementIfExist(catchVariable.getType(), new CtTypedElementTypeReplaceListener(catchVariable));
        replaceInListIfExist(catchVariable.getMultiTypes(), new CtMultiTypedElementMultiTypesReplaceListener(catchVariable));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtCatchVariableReference(final CtCatchVariableReference<T> reference) {
        replaceInListIfExist(reference.getComments(), new CtElementCommentsReplaceListener(reference));
        replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtMethod(final CtMethod<T> m) {
        replaceInListIfExist(m.getAnnotations(), new CtElementAnnotationsReplaceListener(m));
        replaceInListIfExist(m.getFormalCtTypeParameters(), new CtFormalTypeDeclarerFormalCtTypeParametersReplaceListener(m));
        replaceElementIfExist(m.getType(), new CtTypedElementTypeReplaceListener(m));
        replaceInListIfExist(m.getParameters(), new CtExecutableParametersReplaceListener(m));
        replaceInSetIfExist(m.getThrownTypes(), new CtExecutableThrownTypesReplaceListener(m));
        replaceElementIfExist(m.getBody(), new CtExecutableBodyReplaceListener(m));
        replaceInListIfExist(m.getComments(), new CtElementCommentsReplaceListener(m));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtAnnotationMethodDefaultExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtAnnotationMethod element;

        CtAnnotationMethodDefaultExpressionReplaceListener(CtAnnotationMethod element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setDefaultExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtAnnotationMethod(CtAnnotationMethod<T> annotationMethod) {
        replaceInListIfExist(annotationMethod.getAnnotations(), new CtElementAnnotationsReplaceListener(annotationMethod));
        replaceElementIfExist(annotationMethod.getType(), new CtTypedElementTypeReplaceListener(annotationMethod));
        replaceElementIfExist(annotationMethod.getDefaultExpression(), new CtAnnotationMethodDefaultExpressionReplaceListener(annotationMethod));
        replaceInListIfExist(annotationMethod.getComments(), new CtElementCommentsReplaceListener(annotationMethod));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtNewArrayElementsReplaceListener implements ReplaceListListener<List> {
        private final CtNewArray element;

        CtNewArrayElementsReplaceListener(CtNewArray element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setElements(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtNewArrayDimensionExpressionsReplaceListener implements ReplaceListListener<List> {
        private final CtNewArray element;

        CtNewArrayDimensionExpressionsReplaceListener(CtNewArray element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setDimensionExpressions(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtNewArray(final CtNewArray<T> newArray) {
        replaceInListIfExist(newArray.getAnnotations(), new CtElementAnnotationsReplaceListener(newArray));
        replaceElementIfExist(newArray.getType(), new CtTypedElementTypeReplaceListener(newArray));
        replaceInListIfExist(newArray.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(newArray));
        replaceInListIfExist(newArray.getElements(), new CtNewArrayElementsReplaceListener(newArray));
        replaceInListIfExist(newArray.getDimensionExpressions(), new CtNewArrayDimensionExpressionsReplaceListener(newArray));
        replaceInListIfExist(newArray.getComments(), new CtElementCommentsReplaceListener(newArray));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtConstructorCall(final CtConstructorCall<T> ctConstructorCall) {
        replaceInListIfExist(ctConstructorCall.getAnnotations(), new CtElementAnnotationsReplaceListener(ctConstructorCall));
        replaceInListIfExist(ctConstructorCall.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(ctConstructorCall));
        replaceElementIfExist(ctConstructorCall.getExecutable(), new CtAbstractInvocationExecutableReplaceListener(ctConstructorCall));
        replaceElementIfExist(ctConstructorCall.getTarget(), new CtTargetedExpressionTargetReplaceListener(ctConstructorCall));
        replaceInListIfExist(ctConstructorCall.getArguments(), new CtAbstractInvocationArgumentsReplaceListener(ctConstructorCall));
        replaceInListIfExist(ctConstructorCall.getComments(), new CtElementCommentsReplaceListener(ctConstructorCall));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtNewClassAnonymousClassReplaceListener implements ReplaceListener<CtClass> {
        private final CtNewClass element;

        CtNewClassAnonymousClassReplaceListener(CtNewClass element) {
            this.element = element;
        }

        @Override
        public void set(CtClass replace) {
            this.element.setAnonymousClass(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtNewClass(final CtNewClass<T> newClass) {
        replaceInListIfExist(newClass.getAnnotations(), new CtElementAnnotationsReplaceListener(newClass));
        replaceInListIfExist(newClass.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(newClass));
        replaceElementIfExist(newClass.getExecutable(), new CtAbstractInvocationExecutableReplaceListener(newClass));
        replaceElementIfExist(newClass.getTarget(), new CtTargetedExpressionTargetReplaceListener(newClass));
        replaceInListIfExist(newClass.getArguments(), new CtAbstractInvocationArgumentsReplaceListener(newClass));
        replaceElementIfExist(newClass.getAnonymousClass(), new CtNewClassAnonymousClassReplaceListener(newClass));
        replaceInListIfExist(newClass.getComments(), new CtElementCommentsReplaceListener(newClass));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtLambdaExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtLambda element;

        CtLambdaExpressionReplaceListener(CtLambda element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtLambda(final CtLambda<T> lambda) {
        replaceInListIfExist(lambda.getAnnotations(), new CtElementAnnotationsReplaceListener(lambda));
        replaceElementIfExist(lambda.getType(), new CtTypedElementTypeReplaceListener(lambda));
        replaceInListIfExist(lambda.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(lambda));
        replaceInListIfExist(lambda.getParameters(), new CtExecutableParametersReplaceListener(lambda));
        replaceInSetIfExist(lambda.getThrownTypes(), new CtExecutableThrownTypesReplaceListener(lambda));
        replaceElementIfExist(lambda.getBody(), new CtExecutableBodyReplaceListener(lambda));
        replaceElementIfExist(lambda.getExpression(), new CtLambdaExpressionReplaceListener(lambda));
        replaceInListIfExist(lambda.getComments(), new CtElementCommentsReplaceListener(lambda));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtExecutableReferenceExpressionExecutableReplaceListener implements ReplaceListener<CtExecutableReference> {
        private final CtExecutableReferenceExpression element;

        CtExecutableReferenceExpressionExecutableReplaceListener(CtExecutableReferenceExpression element) {
            this.element = element;
        }

        @Override
        public void set(CtExecutableReference replace) {
            this.element.setExecutable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T, E extends CtExpression<?>> void visitCtExecutableReferenceExpression(final CtExecutableReferenceExpression<T, E> expression) {
        replaceInListIfExist(expression.getComments(), new CtElementCommentsReplaceListener(expression));
        replaceInListIfExist(expression.getAnnotations(), new CtElementAnnotationsReplaceListener(expression));
        replaceElementIfExist(expression.getType(), new CtTypedElementTypeReplaceListener(expression));
        replaceInListIfExist(expression.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(expression));
        replaceElementIfExist(expression.getExecutable(), new CtExecutableReferenceExpressionExecutableReplaceListener(expression));
        replaceElementIfExist(expression.getTarget(), new CtTargetedExpressionTargetReplaceListener(expression));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T, A extends T> void visitCtOperatorAssignment(final CtOperatorAssignment<T, A> assignment) {
        replaceInListIfExist(assignment.getAnnotations(), new CtElementAnnotationsReplaceListener(assignment));
        replaceElementIfExist(assignment.getType(), new CtTypedElementTypeReplaceListener(assignment));
        replaceInListIfExist(assignment.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(assignment));
        replaceElementIfExist(assignment.getAssigned(), new CtAssignmentAssignedReplaceListener(assignment));
        replaceElementIfExist(assignment.getAssignment(), new CtRHSReceiverAssignmentReplaceListener(assignment));
        replaceInListIfExist(assignment.getComments(), new CtElementCommentsReplaceListener(assignment));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtPackagePackagesReplaceListener implements ReplaceSetListener<Set> {
        private final CtPackage element;

        CtPackagePackagesReplaceListener(CtPackage element) {
            this.element = element;
        }

        @Override
        public void set(Set replace) {
            this.element.setPackages(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtPackageTypesReplaceListener implements ReplaceSetListener<Set> {
        private final CtPackage element;

        CtPackageTypesReplaceListener(CtPackage element) {
            this.element = element;
        }

        @Override
        public void set(Set replace) {
            this.element.setTypes(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtPackage(final CtPackage ctPackage) {
        replaceInListIfExist(ctPackage.getAnnotations(), new CtElementAnnotationsReplaceListener(ctPackage));
        replaceInSetIfExist(ctPackage.getPackages(), new CtPackagePackagesReplaceListener(ctPackage));
        replaceInSetIfExist(ctPackage.getTypes(), new CtPackageTypesReplaceListener(ctPackage));
        replaceInListIfExist(ctPackage.getComments(), new CtElementCommentsReplaceListener(ctPackage));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtPackageReference(final CtPackageReference reference) {
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtParameter(final CtParameter<T> parameter) {
        replaceInListIfExist(parameter.getAnnotations(), new CtElementAnnotationsReplaceListener(parameter));
        replaceElementIfExist(parameter.getType(), new CtTypedElementTypeReplaceListener(parameter));
        replaceInListIfExist(parameter.getComments(), new CtElementCommentsReplaceListener(parameter));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtParameterReferenceDeclaringExecutableReplaceListener implements ReplaceListener<CtExecutableReference> {
        private final CtParameterReference element;

        CtParameterReferenceDeclaringExecutableReplaceListener(CtParameterReference element) {
            this.element = element;
        }

        @Override
        public void set(CtExecutableReference replace) {
            this.element.setDeclaringExecutable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtParameterReference(final CtParameterReference<T> reference) {
        replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
        replaceElementIfExist(reference.getDeclaringExecutable(), new CtParameterReferenceDeclaringExecutableReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtReturnReturnedExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtReturn element;

        CtReturnReturnedExpressionReplaceListener(CtReturn element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setReturnedExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <R> void visitCtReturn(final CtReturn<R> returnStatement) {
        replaceInListIfExist(returnStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(returnStatement));
        replaceElementIfExist(returnStatement.getReturnedExpression(), new CtReturnReturnedExpressionReplaceListener(returnStatement));
        replaceInListIfExist(returnStatement.getComments(), new CtElementCommentsReplaceListener(returnStatement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <R> void visitCtStatementList(final CtStatementList statements) {
        replaceInListIfExist(statements.getAnnotations(), new CtElementAnnotationsReplaceListener(statements));
        replaceInListIfExist(statements.getStatements(), new CtStatementListStatementsReplaceListener(statements));
        replaceInListIfExist(statements.getComments(), new CtElementCommentsReplaceListener(statements));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtSwitchSelectorReplaceListener implements ReplaceListener<CtExpression> {
        private final CtSwitch element;

        CtSwitchSelectorReplaceListener(CtSwitch element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setSelector(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtSwitchCasesReplaceListener implements ReplaceListListener<List> {
        private final CtSwitch element;

        CtSwitchCasesReplaceListener(CtSwitch element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setCases(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <S> void visitCtSwitch(final CtSwitch<S> switchStatement) {
        replaceInListIfExist(switchStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(switchStatement));
        replaceElementIfExist(switchStatement.getSelector(), new CtSwitchSelectorReplaceListener(switchStatement));
        replaceInListIfExist(switchStatement.getCases(), new CtSwitchCasesReplaceListener(switchStatement));
        replaceInListIfExist(switchStatement.getComments(), new CtElementCommentsReplaceListener(switchStatement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtSynchronizedExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtSynchronized element;

        CtSynchronizedExpressionReplaceListener(CtSynchronized element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtSynchronizedBlockReplaceListener implements ReplaceListener<CtBlock> {
        private final CtSynchronized element;

        CtSynchronizedBlockReplaceListener(CtSynchronized element) {
            this.element = element;
        }

        @Override
        public void set(CtBlock replace) {
            this.element.setBlock(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtSynchronized(final CtSynchronized synchro) {
        replaceInListIfExist(synchro.getAnnotations(), new CtElementAnnotationsReplaceListener(synchro));
        replaceElementIfExist(synchro.getExpression(), new CtSynchronizedExpressionReplaceListener(synchro));
        replaceElementIfExist(synchro.getBlock(), new CtSynchronizedBlockReplaceListener(synchro));
        replaceInListIfExist(synchro.getComments(), new CtElementCommentsReplaceListener(synchro));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtThrowThrownExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtThrow element;

        CtThrowThrownExpressionReplaceListener(CtThrow element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setThrownExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtThrow(final CtThrow throwStatement) {
        replaceInListIfExist(throwStatement.getAnnotations(), new CtElementAnnotationsReplaceListener(throwStatement));
        replaceElementIfExist(throwStatement.getThrownExpression(), new CtThrowThrownExpressionReplaceListener(throwStatement));
        replaceInListIfExist(throwStatement.getComments(), new CtElementCommentsReplaceListener(throwStatement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTryBodyReplaceListener implements ReplaceListener<CtBlock> {
        private final CtBodyHolder element;

        CtTryBodyReplaceListener(CtBodyHolder element) {
            this.element = element;
        }

        @Override
        public void set(CtBlock replace) {
            this.element.setBody(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTryCatchersReplaceListener implements ReplaceListListener<List> {
        private final CtTry element;

        CtTryCatchersReplaceListener(CtTry element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setCatchers(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTryFinalizerReplaceListener implements ReplaceListener<CtBlock> {
        private final CtTry element;

        CtTryFinalizerReplaceListener(CtTry element) {
            this.element = element;
        }

        @Override
        public void set(CtBlock replace) {
            this.element.setFinalizer(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtTry(final CtTry tryBlock) {
        replaceInListIfExist(tryBlock.getAnnotations(), new CtElementAnnotationsReplaceListener(tryBlock));
        replaceElementIfExist(tryBlock.getBody(), new CtTryBodyReplaceListener(tryBlock));
        replaceInListIfExist(tryBlock.getCatchers(), new CtTryCatchersReplaceListener(tryBlock));
        replaceElementIfExist(tryBlock.getFinalizer(), new CtTryFinalizerReplaceListener(tryBlock));
        replaceInListIfExist(tryBlock.getComments(), new CtElementCommentsReplaceListener(tryBlock));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTryWithResourceResourcesReplaceListener implements ReplaceListListener<List> {
        private final CtTryWithResource element;

        CtTryWithResourceResourcesReplaceListener(CtTryWithResource element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setResources(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtTryWithResource(final CtTryWithResource tryWithResource) {
        replaceInListIfExist(tryWithResource.getAnnotations(), new CtElementAnnotationsReplaceListener(tryWithResource));
        replaceInListIfExist(tryWithResource.getResources(), new CtTryWithResourceResourcesReplaceListener(tryWithResource));
        replaceElementIfExist(tryWithResource.getBody(), new CtTryBodyReplaceListener(tryWithResource));
        replaceInListIfExist(tryWithResource.getCatchers(), new CtTryCatchersReplaceListener(tryWithResource));
        replaceElementIfExist(tryWithResource.getFinalizer(), new CtTryFinalizerReplaceListener(tryWithResource));
        replaceInListIfExist(tryWithResource.getComments(), new CtElementCommentsReplaceListener(tryWithResource));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeParameterReferenceBoundingTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtTypeParameterReference element;

        CtTypeParameterReferenceBoundingTypeReplaceListener(CtTypeParameterReference element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setBoundingType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtTypeParameterReference(final CtTypeParameterReference ref) {
        replaceElementIfExist(ref.getPackage(), new CtTypeReferencePackageReplaceListener(ref));
        replaceElementIfExist(ref.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(ref));
        replaceInListIfExist(ref.getAnnotations(), new CtElementAnnotationsReplaceListener(ref));
        replaceElementIfExist(ref.getBoundingType(), new CtTypeParameterReferenceBoundingTypeReplaceListener(ref));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtWildcardReference(CtWildcardReference wildcardReference) {
        replaceElementIfExist(wildcardReference.getPackage(), new CtTypeReferencePackageReplaceListener(wildcardReference));
        replaceElementIfExist(wildcardReference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(wildcardReference));
        replaceInListIfExist(wildcardReference.getAnnotations(), new CtElementAnnotationsReplaceListener(wildcardReference));
        replaceElementIfExist(wildcardReference.getBoundingType(), new CtTypeParameterReferenceBoundingTypeReplaceListener(wildcardReference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtIntersectionTypeReferenceBoundsReplaceListener implements ReplaceListListener<List> {
        private final CtIntersectionTypeReference element;

        CtIntersectionTypeReferenceBoundsReplaceListener(CtIntersectionTypeReference element) {
            this.element = element;
        }

        @Override
        public void set(List replace) {
            this.element.setBounds(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtIntersectionTypeReference(final CtIntersectionTypeReference<T> reference) {
        replaceElementIfExist(reference.getPackage(), new CtTypeReferencePackageReplaceListener(reference));
        replaceElementIfExist(reference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
        replaceInListIfExist(reference.getBounds(), new CtIntersectionTypeReferenceBoundsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtTypeReference(final CtTypeReference<T> reference) {
        replaceElementIfExist(reference.getPackage(), new CtTypeReferencePackageReplaceListener(reference));
        replaceElementIfExist(reference.getDeclaringType(), new CtTypeReferenceDeclaringTypeReplaceListener(reference));
        replaceInListIfExist(reference.getActualTypeArguments(), new CtActualTypeContainerActualTypeArgumentsReplaceListener(reference));
        replaceInListIfExist(reference.getAnnotations(), new CtElementAnnotationsReplaceListener(reference));
        replaceInListIfExist(reference.getComments(), new CtElementCommentsReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtTypeAccessAccessedTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtTypeAccess element;

        CtTypeAccessAccessedTypeReplaceListener(CtTypeAccess element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setAccessedType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtTypeAccess(final CtTypeAccess<T> typeAccess) {
        replaceInListIfExist(typeAccess.getAnnotations(), new CtElementAnnotationsReplaceListener(typeAccess));
        replaceInListIfExist(typeAccess.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(typeAccess));
        replaceElementIfExist(typeAccess.getAccessedType(), new CtTypeAccessAccessedTypeReplaceListener(typeAccess));
        replaceInListIfExist(typeAccess.getComments(), new CtElementCommentsReplaceListener(typeAccess));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtUnaryOperatorOperandReplaceListener implements ReplaceListener<CtExpression> {
        private final CtUnaryOperator element;

        CtUnaryOperatorOperandReplaceListener(CtUnaryOperator element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setOperand(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtUnaryOperator(final CtUnaryOperator<T> operator) {
        replaceInListIfExist(operator.getAnnotations(), new CtElementAnnotationsReplaceListener(operator));
        replaceElementIfExist(operator.getType(), new CtTypedElementTypeReplaceListener(operator));
        replaceInListIfExist(operator.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(operator));
        replaceElementIfExist(operator.getOperand(), new CtUnaryOperatorOperandReplaceListener(operator));
        replaceInListIfExist(operator.getComments(), new CtElementCommentsReplaceListener(operator));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtVariableAccessVariableReplaceListener implements ReplaceListener<CtVariableReference> {
        private final CtVariableAccess element;

        CtVariableAccessVariableReplaceListener(CtVariableAccess element) {
            this.element = element;
        }

        @Override
        public void set(CtVariableReference replace) {
            this.element.setVariable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtVariableRead(final CtVariableRead<T> variableRead) {
        replaceInListIfExist(variableRead.getAnnotations(), new CtElementAnnotationsReplaceListener(variableRead));
        replaceInListIfExist(variableRead.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(variableRead));
        replaceElementIfExist(variableRead.getVariable(), new CtVariableAccessVariableReplaceListener(variableRead));
        replaceInListIfExist(variableRead.getComments(), new CtElementCommentsReplaceListener(variableRead));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtVariableWrite(final CtVariableWrite<T> variableWrite) {
        replaceInListIfExist(variableWrite.getAnnotations(), new CtElementAnnotationsReplaceListener(variableWrite));
        replaceInListIfExist(variableWrite.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(variableWrite));
        replaceElementIfExist(variableWrite.getVariable(), new CtVariableAccessVariableReplaceListener(variableWrite));
        replaceInListIfExist(variableWrite.getComments(), new CtElementCommentsReplaceListener(variableWrite));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtWhileLoopingExpressionReplaceListener implements ReplaceListener<CtExpression> {
        private final CtWhile element;

        CtWhileLoopingExpressionReplaceListener(CtWhile element) {
            this.element = element;
        }

        @Override
        public void set(CtExpression replace) {
            this.element.setLoopingExpression(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtWhile(final CtWhile whileLoop) {
        replaceInListIfExist(whileLoop.getAnnotations(), new CtElementAnnotationsReplaceListener(whileLoop));
        replaceElementIfExist(whileLoop.getLoopingExpression(), new CtWhileLoopingExpressionReplaceListener(whileLoop));
        replaceElementIfExist(whileLoop.getBody(), new CtLoopBodyReplaceListener(whileLoop));
        replaceInListIfExist(whileLoop.getComments(), new CtElementCommentsReplaceListener(whileLoop));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtCodeSnippetExpression(final CtCodeSnippetExpression<T> expression) {
        replaceElementIfExist(expression.getType(), new CtTypedElementTypeReplaceListener(expression));
        replaceInListIfExist(expression.getComments(), new CtElementCommentsReplaceListener(expression));
        replaceInListIfExist(expression.getAnnotations(), new CtElementAnnotationsReplaceListener(expression));
        replaceInListIfExist(expression.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(expression));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtCodeSnippetStatement(final CtCodeSnippetStatement statement) {
        replaceInListIfExist(statement.getComments(), new CtElementCommentsReplaceListener(statement));
        replaceInListIfExist(statement.getAnnotations(), new CtElementAnnotationsReplaceListener(statement));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtUnboundVariableReference(final CtUnboundVariableReference<T> reference) {
        replaceElementIfExist(reference.getType(), new CtVariableReferenceTypeReplaceListener(reference));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtFieldAccessVariableReplaceListener implements ReplaceListener<CtFieldReference> {
        private final CtVariableAccess element;

        CtFieldAccessVariableReplaceListener(CtVariableAccess element) {
            this.element = element;
        }

        @Override
        public void set(CtFieldReference replace) {
            this.element.setVariable(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtFieldRead(final CtFieldRead<T> fieldRead) {
        replaceInListIfExist(fieldRead.getAnnotations(), new CtElementAnnotationsReplaceListener(fieldRead));
        replaceInListIfExist(fieldRead.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(fieldRead));
        replaceElementIfExist(fieldRead.getTarget(), new CtTargetedExpressionTargetReplaceListener(fieldRead));
        replaceElementIfExist(fieldRead.getVariable(), new CtFieldAccessVariableReplaceListener(fieldRead));
        replaceInListIfExist(fieldRead.getComments(), new CtElementCommentsReplaceListener(fieldRead));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtFieldWrite(final CtFieldWrite<T> fieldWrite) {
        replaceInListIfExist(fieldWrite.getAnnotations(), new CtElementAnnotationsReplaceListener(fieldWrite));
        replaceInListIfExist(fieldWrite.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(fieldWrite));
        replaceElementIfExist(fieldWrite.getTarget(), new CtTargetedExpressionTargetReplaceListener(fieldWrite));
        replaceElementIfExist(fieldWrite.getVariable(), new CtFieldAccessVariableReplaceListener(fieldWrite));
        replaceInListIfExist(fieldWrite.getComments(), new CtElementCommentsReplaceListener(fieldWrite));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    class CtSuperAccessTypeReplaceListener implements ReplaceListener<CtTypeReference> {
        private final CtTypedElement element;

        CtSuperAccessTypeReplaceListener(CtTypedElement element) {
            this.element = element;
        }

        @Override
        public void set(CtTypeReference replace) {
            this.element.setType(replace);
        }
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public <T> void visitCtSuperAccess(final CtSuperAccess<T> f) {
        replaceElementIfExist(f.getType(), new CtSuperAccessTypeReplaceListener(f));
        replaceInListIfExist(f.getComments(), new CtElementCommentsReplaceListener(f));
        replaceInListIfExist(f.getAnnotations(), new CtElementAnnotationsReplaceListener(f));
        replaceInListIfExist(f.getTypeCasts(), new CtExpressionTypeCastsReplaceListener(f));
        replaceElementIfExist(f.getTarget(), new CtTargetedExpressionTargetReplaceListener(f));
        replaceElementIfExist(f.getVariable(), new CtVariableAccessVariableReplaceListener(f));
    }

    // auto-generated, see spoon.generating.ReplacementVisitorGenerator
    @Override
    public void visitCtComment(final CtComment comment) {
        replaceInListIfExist(comment.getComments(), new CtElementCommentsReplaceListener(comment));
        replaceInListIfExist(comment.getAnnotations(), new CtElementAnnotationsReplaceListener(comment));
    }
}