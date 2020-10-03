package spoon.reflect.declaration;


public interface CtModifiable extends spoon.reflect.declaration.CtElement {
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.MODIFIER)
    java.util.Set<spoon.reflect.declaration.ModifierKind> getModifiers();

    boolean hasModifier(spoon.reflect.declaration.ModifierKind modifier);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.MODIFIER)
    <T extends spoon.reflect.declaration.CtModifiable> T setModifiers(java.util.Set<spoon.reflect.declaration.ModifierKind> modifiers);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.MODIFIER)
    <T extends spoon.reflect.declaration.CtModifiable> T addModifier(spoon.reflect.declaration.ModifierKind modifier);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.MODIFIER)
    boolean removeModifier(spoon.reflect.declaration.ModifierKind modifier);

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.MODIFIER)
    <T extends spoon.reflect.declaration.CtModifiable> T setVisibility(spoon.reflect.declaration.ModifierKind visibility);

    @spoon.support.DerivedProperty
    spoon.reflect.declaration.ModifierKind getVisibility();
}

