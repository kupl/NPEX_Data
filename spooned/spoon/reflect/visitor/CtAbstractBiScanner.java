package spoon.reflect.visitor;


public abstract class CtAbstractBiScanner extends spoon.reflect.visitor.CtAbstractVisitor {
    protected java.util.Deque<spoon.reflect.declaration.CtElement> stack = new java.util.ArrayDeque<>();

    protected boolean isNotEqual = false;

    protected void enter(spoon.reflect.declaration.CtElement e) {
    }

    protected void exit(spoon.reflect.declaration.CtElement e) {
    }

    public boolean biScan(java.util.Collection<? extends spoon.reflect.declaration.CtElement> elements, java.util.Collection<? extends spoon.reflect.declaration.CtElement> others) {
        if (isNotEqual) {
            return isNotEqual;
        }
        if (elements == null) {
            if (others != null) {
                return fail();
            }
            return isNotEqual;
        }else
            if (others == null) {
                return fail();
            }
        
        if ((elements.size()) != (others.size())) {
            return fail();
        }
        for (java.util.Iterator<? extends spoon.reflect.declaration.CtElement> firstIt = elements.iterator(), secondIt = others.iterator(); (firstIt.hasNext()) && (secondIt.hasNext());) {
            biScan(firstIt.next(), secondIt.next());
        }
        return isNotEqual;
    }

    public boolean biScan(spoon.reflect.declaration.CtElement element, spoon.reflect.declaration.CtElement other) {
        if (isNotEqual) {
            return isNotEqual;
        }
        if (element == null) {
            if (other != null) {
                return fail();
            }
            return isNotEqual;
        }else
            if (other == null) {
                return fail();
            }
        
        if (element == other) {
            return isNotEqual;
        }
        stack.push(other);
        try {
            element.accept(this);
        } catch (java.lang.ClassCastException e) {
            return fail();
        } finally {
            stack.pop();
        }
        return isNotEqual;
    }

    public boolean fail() {
        isNotEqual = true;
        return true;
    }
}

