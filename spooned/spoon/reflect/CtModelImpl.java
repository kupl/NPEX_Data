package spoon.reflect;


public class CtModelImpl implements spoon.reflect.CtModel {
    private static class CtRootPackage extends spoon.support.reflect.declaration.CtPackageImpl {
        {
            this.setSimpleName(spoon.reflect.declaration.CtPackage.TOP_LEVEL_PACKAGE_NAME);
            this.setParent(new spoon.support.reflect.declaration.CtElementImpl() {
                @java.lang.Override
                public void accept(spoon.reflect.visitor.CtVisitor visitor) {
                }

                @java.lang.Override
                public spoon.reflect.declaration.CtElement getParent() throws spoon.reflect.declaration.ParentNotInitializedException {
                    return null;
                }

                @java.lang.Override
                public spoon.reflect.factory.Factory getFactory() {
                    return spoon.reflect.CtModelImpl.CtRootPackage.this.getFactory();
                }
            });
        }

        @java.lang.Override
        public java.lang.String getSimpleName() {
            return super.getSimpleName();
        }

        @java.lang.Override
        public java.lang.String getQualifiedName() {
            return "";
        }

        @java.lang.Override
        public java.lang.String toString() {
            return spoon.reflect.declaration.CtPackage.TOP_LEVEL_PACKAGE_NAME;
        }
    }

    private static final long serialVersionUID = 1L;

    private final spoon.reflect.declaration.CtPackage rootPackage = new spoon.reflect.CtModelImpl.CtRootPackage();

    public CtModelImpl(spoon.reflect.factory.Factory f) {
        rootPackage.setFactory(f);
    }

    @java.lang.Override
    public spoon.reflect.declaration.CtPackage getRootPackage() {
        return rootPackage;
    }

    @java.lang.Override
    public java.util.Collection<spoon.reflect.declaration.CtType<?>> getAllTypes() {
        java.util.List<spoon.reflect.declaration.CtType<?>> types = new java.util.ArrayList<>();
        for (spoon.reflect.declaration.CtPackage pack : getAllPackages()) {
            types.addAll(pack.getTypes());
        }
        return types;
    }

    @java.lang.Override
    public java.util.Collection<spoon.reflect.declaration.CtPackage> getAllPackages() {
        return java.util.Collections.unmodifiableCollection(rootPackage.getElements(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.declaration.CtPackage.class)));
    }

    @java.lang.Override
    public void processWith(spoon.processing.Processor<?> processor) {
        spoon.support.QueueProcessingManager processingManager = new spoon.support.QueueProcessingManager(rootPackage.getFactory());
        processingManager.addProcessor(processor);
        processingManager.process(getRootPackage());
    }

    @java.lang.Override
    public <E extends spoon.reflect.declaration.CtElement> java.util.List<E> getElements(spoon.reflect.visitor.Filter<E> filter) {
        return getRootPackage().getElements(filter);
    }
}

