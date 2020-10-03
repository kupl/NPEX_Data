package spoon.reflect.path;


public interface CtPath {
    <T extends spoon.reflect.declaration.CtElement> java.util.Collection<T> evaluateOn(java.util.Collection<? extends spoon.reflect.declaration.CtElement> startNode);
}

