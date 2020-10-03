package spoon.reflect.reference;


public interface CtArrayTypeReference<T> extends spoon.reflect.reference.CtTypeReference<T> {
    spoon.reflect.reference.CtTypeReference<?> getComponentType();

    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtTypeReference<?> getArrayType();

    <C extends spoon.reflect.reference.CtArrayTypeReference<T>> C setComponentType(spoon.reflect.reference.CtTypeReference<?> componentType);

    @spoon.support.DerivedProperty
    int getDimensionCount();

    java.lang.String getSimpleName();

    @java.lang.Override
    spoon.reflect.reference.CtArrayTypeReference<T> clone();
}

