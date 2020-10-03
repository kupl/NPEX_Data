package spoon.reflect.path.impl;


public class CtNamedPathElement extends spoon.reflect.path.impl.AbstractPathElement<spoon.reflect.declaration.CtElement, spoon.reflect.declaration.CtElement> {
    private class NameScanner extends spoon.reflect.visitor.CtInheritanceScanner {
        private java.util.Collection<spoon.reflect.declaration.CtElement> results = new java.util.LinkedList<>();

        NameScanner() {
        }

        @java.lang.Override
        public void scanCtElement(spoon.reflect.declaration.CtElement e) {
            if ((spoon.reflect.path.impl.CtNamedPathElement.WILDCARD.equals(pattern)) || (spoon.reflect.path.impl.CtNamedPathElement.RECURSIVE_WILCARD.equals(pattern))) {
                results.add(e);
            }else
                if ((e instanceof spoon.reflect.declaration.CtNamedElement) && (((spoon.reflect.declaration.CtNamedElement) (e)).getSimpleName().matches(pattern))) {
                    results.add(e);
                }
            
        }

        private void recurse(java.util.Collection<? extends spoon.reflect.declaration.CtElement> elements) {
            scan(elements);
            for (spoon.reflect.declaration.CtElement element : elements) {
                recurse(getChilds(element));
            }
        }

        public java.util.Collection<spoon.reflect.declaration.CtElement> getResults() {
            return results;
        }
    }

    public static final java.lang.String STRING = ".";

    public static final java.lang.String WILDCARD = "*";

    public static final java.lang.String RECURSIVE_WILCARD = "**";

    private final java.lang.String pattern;

    public CtNamedPathElement(java.lang.String pattern) {
        this.pattern = pattern;
    }

    public java.lang.String getPattern() {
        return pattern;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((spoon.reflect.path.impl.CtNamedPathElement.STRING) + (getPattern())) + (getParamString());
    }

    @java.lang.Override
    public java.util.Collection<spoon.reflect.declaration.CtElement> getElements(java.util.Collection<spoon.reflect.declaration.CtElement> roots) {
        java.util.Collection<spoon.reflect.declaration.CtElement> results = new java.util.ArrayList<>();
        for (spoon.reflect.declaration.CtElement element : roots) {
            results.addAll(scanElements(getChilds(element)));
        }
        return results;
    }

    public java.util.Collection<spoon.reflect.declaration.CtElement> scanElements(java.util.Collection<? extends spoon.reflect.declaration.CtElement> roots) {
        spoon.reflect.path.impl.CtNamedPathElement.NameScanner nameScanner = new spoon.reflect.path.impl.CtNamedPathElement.NameScanner();
        if (spoon.reflect.path.impl.CtNamedPathElement.RECURSIVE_WILCARD.equals(pattern)) {
            nameScanner.recurse(roots);
        }else {
            nameScanner.scan(roots);
        }
        return nameScanner.getResults();
    }
}

