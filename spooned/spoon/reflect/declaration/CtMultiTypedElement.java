package spoon.reflect.declaration;


public interface CtMultiTypedElement extends spoon.reflect.declaration.CtElement {
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TYPE)
    <T extends spoon.reflect.declaration.CtMultiTypedElement> T addMultiType(spoon.reflect.reference.CtTypeReference<?> ref);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TYPE)
    boolean removeMultiType(spoon.reflect.reference.CtTypeReference<?> ref);

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.TYPE)
    java.util.List<spoon.reflect.reference.CtTypeReference<?>> getMultiTypes();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TYPE)
    <T extends spoon.reflect.declaration.CtMultiTypedElement> T setMultiTypes(java.util.List<spoon.reflect.reference.CtTypeReference<?>> types);
}

