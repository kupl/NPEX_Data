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
package spoon.reflect.declaration;


/**
 * Defines a compilation unit. In Java, a compilation unit can contain only one
 * public type declaration and other secondary types declarations (not public).
 */
@spoon.support.Experimental
public interface CtCompilationUnit extends spoon.reflect.declaration.CtElement {
    enum UNIT_TYPE {

        TYPE_DECLARATION,
        PACKAGE_DECLARATION,
        MODULE_DECLARATION,
        UNKNOWN;}

    /**
     * Returns the declaration type of the compilation unit.
     */
    spoon.reflect.declaration.CtCompilationUnit.UNIT_TYPE getUnitType();

    /**
     * Gets the file that corresponds to this compilation unit if any (contains
     * the source code).
     */
    java.io.File getFile();

    /**
     * Sets the file that corresponds to this compilation unit.
     */
    spoon.reflect.declaration.CtCompilationUnit setFile(java.io.File file);

    /**
     *
     *
     * @return array of offsets in the origin source file, where occurs line separator
     */
    int[] getLineSeparatorPositions();

    /**
     *
     *
     * @param lineSeparatorPositions
     * 		array of offsets in the origin source file, where occurs line separator
     */
    spoon.reflect.declaration.CtCompilationUnit setLineSeparatorPositions(int[] lineSeparatorPositions);

    /**
     * Gets all binary (.class) files that corresponds to this compilation unit
     * and have been created by calling
     * {@link spoon.SpoonModelBuilder#compile(spoon.SpoonModelBuilder.InputType...)}.
     */
    java.util.List<java.io.File> getBinaryFiles();

    /**
     * Gets all the types declared in this compilation unit.
     */
    @spoon.support.DerivedProperty
    java.util.List<spoon.reflect.declaration.CtType<?>> getDeclaredTypes();

    /**
     * Gets references to all the types declared in this compilation unit.
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.DECLARED_TYPE_REF)
    java.util.List<spoon.reflect.reference.CtTypeReference<?>> getDeclaredTypeReferences();

    /**
     * Sets the references to types declared in this compilation unit.
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.DECLARED_TYPE_REF)
    spoon.reflect.declaration.CtCompilationUnit setDeclaredTypeReferences(java.util.List<spoon.reflect.reference.CtTypeReference<?>> types);

    /**
     * Sets the types declared in this compilation unit.
     * It is here for backward compatibility.
     * It calls internally {@link #setDeclaredTypeReferences(List)}
     * so the {@link CtCompilationUnit} contains type reference only.
     * It doesn't contain whole type, which belongs to it's CtPackage in primary `java concept` model.
     * Note that {@link CtCompilationUnit} represents a secondary model related to mapping of java modules, packages and types to file system.
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtCompilationUnit setDeclaredTypes(java.util.List<spoon.reflect.declaration.CtType<?>> types);

    /**
     * Add a type to the list of declared types.
     * It is here for backward compatibility.
     * It calls internally {@link #addDeclaredTypeReference(CtTypeReference)}
     * so the {@link CtCompilationUnit} contains type reference only.
     * It doesn't contain whole type, which belongs to it's CtPackage in primary `java concept` model.
     * Note that {@link CtCompilationUnit} represents a secondary model related to mapping of java modules, packages and types to file system.
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtCompilationUnit addDeclaredType(spoon.reflect.declaration.CtType<?> type);

    /**
     * Add a type reference to the list of declared types
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.DECLARED_TYPE_REF)
    spoon.reflect.declaration.CtCompilationUnit addDeclaredTypeReference(spoon.reflect.reference.CtTypeReference<?> type);

    /**
     * Gets the declared module if the compilationUnit is "module-info.java"
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtModule getDeclaredModule();

    /**
     * Gets the declared module reference if the compilationUnit is "module-info.java"
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.DECLARED_MODULE_REF)
    spoon.reflect.reference.CtModuleReference getDeclaredModuleReference();

    /**
     * Sets the declared module if the compilationUnit is "module-info.java"
     * It is here for backward compatibility.
     * It internally calls {@link #setDeclaredModuleReference(CtModuleReference)}
     * It doesn't contain whole CtModule, which belongs to CtModel in primary `java concept` model.
     * Note that {@link CtCompilationUnit} represents a secondary model related to mapping of java modules, packages and types to file system.
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtCompilationUnit setDeclaredModule(spoon.reflect.declaration.CtModule module);

    /**
     * Sets the declared module reference if the compilationUnit is "module-info.java"
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.DECLARED_MODULE_REF)
    spoon.reflect.declaration.CtCompilationUnit setDeclaredModuleReference(spoon.reflect.reference.CtModuleReference module);

    /**
     * Gets the declared package
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtPackage getDeclaredPackage();

    /**
     *
     *
     * @return the package declaration
     */
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.PACKAGE_DECLARATION)
    spoon.reflect.declaration.CtPackageDeclaration getPackageDeclaration();

    /**
     * Sets the package declaration using the instance of CtPackage.
     * It is here for backward compatibility.
     * It calls internally {@link #setPackageDeclaration(CtPackageDeclaration)}
     * It doesn't contain whole CtPackage, which belongs to it's parent package or to CtModule in primary `java concept` model.
     * Note that {@link CtCompilationUnit} represents a secondary model related to mapping of java modules, packages and types to file system.
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtCompilationUnit setDeclaredPackage(spoon.reflect.declaration.CtPackage ctPackage);

    /**
     * Sets the package declaration
     */
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.PACKAGE_DECLARATION)
    spoon.reflect.declaration.CtCompilationUnit setPackageDeclaration(spoon.reflect.declaration.CtPackageDeclaration packageDeclaration);

    /**
     * Searches and returns the main type (the type which has the same name as
     * the file).
     */
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtType<?> getMainType();

    /**
     * Gets the original source code as a string.
     */
    java.lang.String getOriginalSourceCode();

    /**
     * Get the imports computed for this CU.
     * WARNING: This method is tagged as experimental, as its signature and/or usage might change in future release.
     *
     * @return All the imports from the original source code
     */
    @spoon.support.Experimental
    @spoon.reflect.annotations.PropertyGetter(role = spoon.reflect.path.CtRole.DECLARED_IMPORT)
    java.util.List<spoon.reflect.declaration.CtImport> getImports();

    @java.lang.Override
    spoon.reflect.declaration.CtCompilationUnit clone();

    /**
     * Set the imports of this CU
     * WARNING: This method is tagged as experimental, as its signature and/or usage might change in future release.
     *
     * @param imports
     * 		All the imports of the original source code
     */
    @spoon.support.Experimental
    @spoon.reflect.annotations.PropertySetter(role = spoon.reflect.path.CtRole.DECLARED_IMPORT)
    spoon.reflect.declaration.CtCompilationUnit setImports(java.util.Collection<spoon.reflect.declaration.CtImport> imports);

    @java.lang.Override
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtElement getParent();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E setParent(E parent);

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <E extends spoon.reflect.declaration.CtElement> E setPosition(spoon.reflect.cu.SourcePosition position);
}

