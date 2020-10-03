package spoon.test.imports.testclasses;


public class ToBeModified {
    /**
     * This method contains List, but it will be removed during refactoring
     */
    public void m() {
        java.util.List<?> x;
    }
}

