package spoon.reflect.reference;


public interface CtReference extends spoon.reflect.declaration.CtElement {
    java.lang.String getSimpleName();

    <T extends spoon.reflect.reference.CtReference> T setSimpleName(java.lang.String simpleName);

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtElement getDeclaration();

    @java.lang.Override
    spoon.reflect.reference.CtReference clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E setComments(java.util.List<spoon.reflect.code.CtComment> comments);
}

