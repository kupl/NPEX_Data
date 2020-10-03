package spoon.reflect.code;


public interface CtExecutableReferenceExpression<T, E extends spoon.reflect.code.CtExpression<?>> extends spoon.reflect.code.CtTargetedExpression<T, E> {
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.EXECUTABLE)
    spoon.reflect.reference.CtExecutableReference<T> getExecutable();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.EXECUTABLE)
    <C extends spoon.reflect.code.CtExecutableReferenceExpression<T, E>> C setExecutable(spoon.reflect.reference.CtExecutableReference<T> executable);

    @java.lang.Override
    spoon.reflect.code.CtExecutableReferenceExpression<T, E> clone();
}

