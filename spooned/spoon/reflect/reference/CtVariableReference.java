package spoon.reflect.reference;


public interface CtVariableReference<T> extends spoon.reflect.reference.CtReference {
    spoon.reflect.reference.CtTypeReference<T> getType();

    <C extends spoon.reflect.reference.CtVariableReference<T>> C setType(spoon.reflect.reference.CtTypeReference<T> type);

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtVariable<T> getDeclaration();

    java.util.Set<spoon.reflect.declaration.ModifierKind> getModifiers();

    void replace(spoon.reflect.reference.CtVariableReference<?> reference);

    @java.lang.Override
    spoon.reflect.reference.CtVariableReference<T> clone();
}

