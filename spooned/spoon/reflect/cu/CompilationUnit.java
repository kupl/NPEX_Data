package spoon.reflect.cu;


public interface CompilationUnit extends spoon.processing.FactoryAccessor {
    java.io.File getFile();

    void setFile(java.io.File file);

    java.util.List<java.io.File> getBinaryFiles();

    java.util.List<spoon.reflect.declaration.CtType<?>> getDeclaredTypes();

    void setDeclaredTypes(java.util.List<spoon.reflect.declaration.CtType<?>> types);

    spoon.reflect.declaration.CtPackage getDeclaredPackage();

    void setDeclaredPackage(spoon.reflect.declaration.CtPackage ctPackage);

    spoon.reflect.declaration.CtType<?> getMainType();

    java.lang.String getOriginalSourceCode();

    int beginOfLineIndex(int index);

    int nextLineIndex(int index);

    int getTabCount(int index);
}

