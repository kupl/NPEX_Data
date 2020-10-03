package spoon.test.imports.testclasses;


/**
 * Created by thomas on 11/09/15.
 */
public class ClassWithInvocation {
    public ClassWithInvocation() {
        test(spoon.test.annotation.testclasses.GlobalAnnotation.class);
    }

    public java.lang.String test(java.lang.Class cl) {
        return cl.getCanonicalName();
    }
}

