package spoon.reflect.code;


public interface CtThrow extends spoon.reflect.code.CtCFlowBreak , spoon.template.TemplateParameter<java.lang.Void> {
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.THROWN)
    spoon.reflect.code.CtExpression<? extends java.lang.Throwable> getThrownExpression();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.THROWN)
    <T extends spoon.reflect.code.CtThrow> T setThrownExpression(spoon.reflect.code.CtExpression<? extends java.lang.Throwable> thrownExpression);

    @java.lang.Override
    spoon.reflect.code.CtThrow clone();
}

