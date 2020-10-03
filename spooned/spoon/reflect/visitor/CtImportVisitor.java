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
package spoon.reflect.visitor;


/**
 * This interface defines the visitor for the different types of CtImport
 */
public interface CtImportVisitor {
    /**
     * Called for import like:
     * <code>import apackage.Type;</code>
     */
    <T> void visitTypeImport(spoon.reflect.reference.CtTypeReference<T> typeReference);

    /**
     * Called for import like:
     * <code>import apackage.Type.staticMethod;</code>
     */
    <T> void visitMethodImport(spoon.reflect.reference.CtExecutableReference<T> executableReference);

    /**
     * Called for import like:
     * <code>import apackage.Type.staticField;</code>
     */
    <T> void visitFieldImport(spoon.reflect.reference.CtFieldReference<T> fieldReference);

    /**
     * Called for import like:
     * <code>import apackage.*;</code>
     */
    void visitAllTypesImport(spoon.reflect.reference.CtPackageReference packageReference);

    /**
     * Called for import like:
     * <code>import apackage.Type.*;</code>
     */
    <T> void visitAllStaticMembersImport(spoon.reflect.reference.CtTypeMemberWildcardImportReference typeReference);
}

