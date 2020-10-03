package spoon.test.imports.testclasses;


/**
 * Created by nicolas on 11/02/2015.
 */
public class MultiCatch {
    public void test() {
        try {
        } catch (java.lang.ArithmeticException | java.security.AccessControlException e) {
        }
    }
}

