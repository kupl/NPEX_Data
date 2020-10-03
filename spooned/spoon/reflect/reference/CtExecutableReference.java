package spoon.reflect.reference;


public interface CtExecutableReference<T> extends spoon.reflect.reference.CtActualTypeContainer , spoon.reflect.reference.CtReference {
    java.lang.String CONSTRUCTOR_NAME = "<init>";

    java.lang.String LAMBDA_NAME_PREFIX = "lambda$";

    java.lang.String UNKNOWN_TYPE = "<unknown>";

    boolean isConstructor();

    java.lang.reflect.Method getActualMethod();

    java.lang.reflect.Constructor<?> getActualConstructor();

    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtExecutable<T> getDeclaration();

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtExecutable<T> getExecutableDeclaration();

    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtTypeReference<?> getDeclaringType();

    spoon.reflect.reference.CtTypeReference<T> getType();

    java.util.List<spoon.reflect.reference.CtTypeReference<?>> getParameters();

    <C extends spoon.reflect.reference.CtExecutableReference<T>> C setParameters(java.util.List<spoon.reflect.reference.CtTypeReference<?>> parameters);

    boolean isOverriding(spoon.reflect.reference.CtExecutableReference<?> executable);

    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtExecutableReference<?> getOverridingExecutable();

    <S extends T> spoon.reflect.reference.CtExecutableReference<S> getOverridingExecutable(spoon.reflect.reference.CtTypeReference<?> subType);

    boolean isStatic();

    <C extends spoon.reflect.reference.CtExecutableReference<T>> C setDeclaringType(spoon.reflect.reference.CtTypeReference<?> declaringType);

    <C extends spoon.reflect.reference.CtExecutableReference<T>> C setStatic(boolean b);

    <C extends spoon.reflect.reference.CtExecutableReference<T>> C setType(spoon.reflect.reference.CtTypeReference<T> type);

    boolean isFinal();

    java.lang.String getSignature();

    void replace(spoon.reflect.reference.CtExecutableReference<?> reference);

    @java.lang.Override
    spoon.reflect.reference.CtExecutableReference<T> clone();
}

