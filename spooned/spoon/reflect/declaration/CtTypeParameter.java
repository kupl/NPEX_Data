package spoon.reflect.declaration;


public interface CtTypeParameter extends spoon.reflect.declaration.CtType<java.lang.Object> {
    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.reference.CtTypeParameterReference getReference();

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtFormalTypeDeclarer getTypeParameterDeclarer();

    @java.lang.Override
    spoon.reflect.declaration.CtTypeParameter clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <T extends spoon.reflect.declaration.CtFormalTypeDeclarer> T setFormalCtTypeParameters(java.util.List<spoon.reflect.declaration.CtTypeParameter> formalTypeParameters);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.declaration.CtType<java.lang.Object>> C setSuperInterfaces(java.util.Set<spoon.reflect.reference.CtTypeReference<?>> interfaces);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.declaration.CtType<java.lang.Object>> C setTypeMembers(java.util.List<spoon.reflect.declaration.CtTypeMember> members);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.declaration.CtType<java.lang.Object>> C setFields(java.util.List<spoon.reflect.declaration.CtField<?>> fields);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.declaration.CtType<java.lang.Object>> C setMethods(java.util.Set<spoon.reflect.declaration.CtMethod<?>> methods);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.declaration.CtType<java.lang.Object>> C setNestedTypes(java.util.Set<spoon.reflect.declaration.CtType<?>> nestedTypes);
}

