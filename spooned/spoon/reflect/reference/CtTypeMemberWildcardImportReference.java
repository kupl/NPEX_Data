/**
 * Copyright (C) 2006-2018 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.reflect.reference;


/**
 * This interface defines a import reference to all static type members of a type.<br>
 * Example:
 * <code>somePackage.Type.*;</code>
 */
public interface CtTypeMemberWildcardImportReference extends spoon.reflect.reference.CtReference {
    /**
     * Returns the fully qualified name of type followed by `.*`
     */
    @spoon.support.DerivedProperty
    java.lang.String getSimpleName();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <T extends spoon.reflect.reference.CtReference> T setSimpleName(java.lang.String simpleName);

    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.TYPE_REF)
    spoon.reflect.reference.CtTypeReference<?> getTypeReference();

    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.TYPE_REF)
    spoon.reflect.reference.CtTypeMemberWildcardImportReference setTypeReference(spoon.reflect.reference.CtTypeReference<?> typeReference);

    @java.lang.Override
    spoon.reflect.reference.CtTypeMemberWildcardImportReference clone();

    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtType<?> getDeclaration();

    @java.lang.Override
    @spoon.support.DerivedProperty
    java.util.List<spoon.reflect.declaration.CtAnnotation<? extends java.lang.annotation.Annotation>> getAnnotations();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E addAnnotation(spoon.reflect.declaration.CtAnnotation<? extends java.lang.annotation.Annotation> annotation);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    boolean removeAnnotation(spoon.reflect.declaration.CtAnnotation<? extends java.lang.annotation.Annotation> annotation);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E setAnnotations(java.util.List<spoon.reflect.declaration.CtAnnotation<? extends java.lang.annotation.Annotation>> annotation);

    @java.lang.Override
    @spoon.support.DerivedProperty
    boolean isImplicit();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E setImplicit(boolean b);
}

