package spoon.reflect.reference;


public interface CtActualTypeContainer {
    java.util.List<spoon.reflect.reference.CtTypeReference<?>> getActualTypeArguments();

    <T extends spoon.reflect.reference.CtActualTypeContainer> T setActualTypeArguments(java.util.List<? extends spoon.reflect.reference.CtTypeReference<?>> actualTypeArguments);

    <T extends spoon.reflect.reference.CtActualTypeContainer> T addActualTypeArgument(spoon.reflect.reference.CtTypeReference<?> actualTypeArgument);

    boolean removeActualTypeArgument(spoon.reflect.reference.CtTypeReference<?> actualTypeArgument);
}

