package compilation;


/**
 * Simple Processor to demonstrate <code>--precompile</code> issue
 *
 * @author Michael Stocker
 * @since 0.1.0
 */
public class SimpleProcessor extends spoon.processing.AbstractProcessor<spoon.reflect.declaration.CtType<?>> {
    @java.lang.Override
    public void process(spoon.reflect.declaration.CtType<?> element) {
        java.lang.System.out.println(((">> Hello: " + (element.getSimpleName())) + " <<"));
    }
}

