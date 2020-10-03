package spoon.reflect.declaration;


public interface CtAnnotation<A extends java.lang.annotation.Annotation> extends spoon.reflect.code.CtExpression<A> , spoon.reflect.declaration.CtShadowable {
    @spoon.support.DerivedProperty
    A getActualAnnotation();

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.ANNOTATION_TYPE)
    spoon.reflect.reference.CtTypeReference<A> getAnnotationType();

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.code.CtExpression> T getValue(java.lang.String key);

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.VALUE)
    java.util.Map<java.lang.String, spoon.reflect.code.CtExpression> getValues();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.ANNOTATION_TYPE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T setAnnotationType(spoon.reflect.reference.CtTypeReference<? extends java.lang.annotation.Annotation> type);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T setElementValues(java.util.Map<java.lang.String, java.lang.Object> values);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T setValues(java.util.Map<java.lang.String, spoon.reflect.code.CtExpression> values);

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtElement getAnnotatedElement();

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtAnnotatedElementType getAnnotatedElementType();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T addValue(java.lang.String elementName, java.lang.Object value);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T addValue(java.lang.String elementName, spoon.reflect.code.CtLiteral<?> value);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T addValue(java.lang.String elementName, spoon.reflect.code.CtNewArray<? extends spoon.reflect.code.CtExpression> value);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T addValue(java.lang.String elementName, spoon.reflect.code.CtFieldAccess<?> value);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.VALUE)
    <T extends spoon.reflect.declaration.CtAnnotation<A>> T addValue(java.lang.String elementName, spoon.reflect.declaration.CtAnnotation<?> value);

    @java.lang.Override
    spoon.reflect.declaration.CtAnnotation<A> clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.code.CtExpression<A>> C setTypeCasts(java.util.List<spoon.reflect.reference.CtTypeReference<?>> types);
}

