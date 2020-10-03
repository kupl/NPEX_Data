package spoon.reflect.factory;


public class CompilationUnitFactory extends spoon.reflect.factory.SubFactory {
    private transient java.util.Map<java.lang.String, spoon.reflect.cu.CompilationUnit> cachedCompilationUnits = new java.util.TreeMap<>();

    public CompilationUnitFactory(spoon.reflect.factory.Factory factory) {
        super(factory);
    }

    public java.util.Map<java.lang.String, spoon.reflect.cu.CompilationUnit> getMap() {
        return cachedCompilationUnits;
    }

    public spoon.reflect.cu.CompilationUnit create() {
        spoon.reflect.cu.CompilationUnit cu = factory.Core().createCompilationUnit();
        return cu;
    }

    public spoon.reflect.cu.CompilationUnit create(java.lang.String filePath) {
        spoon.reflect.cu.CompilationUnit cu = cachedCompilationUnits.get(filePath);
        if (cu == null) {
            if (filePath.startsWith(spoon.support.compiler.jdt.JDTSnippetCompiler.SNIPPET_FILENAME_PREFIX)) {
                cu = factory.Core().createCompilationUnit();
                cachedCompilationUnits.put(filePath, cu);
                return cu;
            }
            cu = factory.Core().createCompilationUnit();
            cu.setFile(new java.io.File(filePath));
            cachedCompilationUnits.put(filePath, cu);
        }
        return cu;
    }

    public spoon.reflect.cu.CompilationUnit removeFromCache(java.lang.String filePath) {
        return cachedCompilationUnits.remove(filePath);
    }
}

