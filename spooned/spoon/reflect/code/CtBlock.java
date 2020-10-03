package spoon.reflect.code;


public interface CtBlock<R> extends spoon.reflect.code.CtStatement , spoon.reflect.code.CtStatementList , spoon.template.TemplateParameter<R> {
    <T extends spoon.reflect.code.CtBlock<R>> T insertBegin(spoon.reflect.code.CtStatement statement);

    <T extends spoon.reflect.code.CtBlock<R>> T insertBegin(spoon.reflect.code.CtStatementList statements);

    <T extends spoon.reflect.code.CtBlock<R>> T insertEnd(spoon.reflect.code.CtStatement statement);

    <T extends spoon.reflect.code.CtBlock<R>> T insertEnd(spoon.reflect.code.CtStatementList statements);

    <T extends spoon.reflect.code.CtBlock<R>> T insertBefore(spoon.reflect.visitor.Filter<? extends spoon.reflect.code.CtStatement> insertionPoints, spoon.reflect.code.CtStatement statement);

    <T extends spoon.reflect.code.CtBlock<R>> T insertBefore(spoon.reflect.visitor.Filter<? extends spoon.reflect.code.CtStatement> insertionPoints, spoon.reflect.code.CtStatementList statements);

    <T extends spoon.reflect.code.CtBlock<R>> T insertAfter(spoon.reflect.visitor.Filter<? extends spoon.reflect.code.CtStatement> insertionPoints, spoon.reflect.code.CtStatement statement);

    <T extends spoon.reflect.code.CtBlock<R>> T insertAfter(spoon.reflect.visitor.Filter<? extends spoon.reflect.code.CtStatement> insertionPoints, spoon.reflect.code.CtStatementList statements);

    @spoon.support.DerivedProperty
    <T extends spoon.reflect.code.CtStatement> T getStatement(int i);

    @spoon.support.DerivedProperty
    <T extends spoon.reflect.code.CtStatement> T getLastStatement();

    <T extends R> void replace(spoon.reflect.code.CtBlock<T> element);

    @java.lang.Override
    spoon.reflect.code.CtBlock<R> clone();
}

