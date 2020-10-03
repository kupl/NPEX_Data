package spoon.reflect.reference;


public interface CtTypeParameterReference extends spoon.reflect.reference.CtTypeReference<java.lang.Object> {
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.IS_UPPER)
    boolean isUpper();

    <T extends spoon.reflect.reference.CtTypeParameterReference> T setBounds(java.util.List<spoon.reflect.reference.CtTypeReference<?>> bounds);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.IS_UPPER)
    <T extends spoon.reflect.reference.CtTypeParameterReference> T setUpper(boolean upper);

    <T extends spoon.reflect.reference.CtTypeParameterReference> T addBound(spoon.reflect.reference.CtTypeReference<?> bound);

    boolean removeBound(spoon.reflect.reference.CtTypeReference<?> bound);

    spoon.reflect.reference.CtTypeReference<?> getBoundingType();

    <T extends spoon.reflect.reference.CtTypeParameterReference> T setBoundingType(spoon.reflect.reference.CtTypeReference<?> superType);

    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtTypeParameter getDeclaration();

    @java.lang.Override
    spoon.reflect.reference.CtTypeParameterReference clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <T extends spoon.reflect.reference.CtActualTypeContainer> T setActualTypeArguments(java.util.List<? extends spoon.reflect.reference.CtTypeReference<?>> actualTypeArguments);
}

