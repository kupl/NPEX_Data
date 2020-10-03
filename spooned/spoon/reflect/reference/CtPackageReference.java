package spoon.reflect.reference;


public interface CtPackageReference extends spoon.reflect.reference.CtReference {
    @spoon.support.DerivedProperty
    spoon.reflect.declaration.CtPackage getDeclaration();

    java.lang.Package getActualPackage();

    void replace(spoon.reflect.reference.CtPackageReference packageReference);

    boolean isUnnamedPackage();

    @java.lang.Override
    spoon.reflect.reference.CtPackageReference clone();
}

