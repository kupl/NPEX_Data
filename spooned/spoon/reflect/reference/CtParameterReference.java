package spoon.reflect.reference;


public interface CtParameterReference<T> extends spoon.reflect.reference.CtVariableReference<T> {
    spoon.reflect.reference.CtExecutableReference<?> getDeclaringExecutable();

    <C extends spoon.reflect.reference.CtParameterReference<T>> C setDeclaringExecutable(spoon.reflect.reference.CtExecutableReference<?> executable);

    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtParameter<T> getDeclaration();

    @java.lang.Override
    spoon.reflect.reference.CtParameterReference<T> clone();
}

