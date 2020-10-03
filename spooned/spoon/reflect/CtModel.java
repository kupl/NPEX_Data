package spoon.reflect;


public interface CtModel extends java.io.Serializable {
    spoon.reflect.declaration.CtPackage getRootPackage();

    java.util.Collection<spoon.reflect.declaration.CtType<?>> getAllTypes();

    java.util.Collection<spoon.reflect.declaration.CtPackage> getAllPackages();

    void processWith(spoon.processing.Processor<?> processor);

    <E extends spoon.reflect.declaration.CtElement> java.util.List<E> getElements(spoon.reflect.visitor.Filter<E> filter);
}

