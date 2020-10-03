package spoon.reflect.declaration;


public interface CtTypeMember extends spoon.reflect.declaration.CtModifiable {
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtType<?> getDeclaringType();

    @spoon.support.DerivedProperty
    <T> spoon.reflect.declaration.CtType<T> getTopLevelType();
}

