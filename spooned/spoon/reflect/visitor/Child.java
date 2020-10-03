package spoon.reflect.visitor;


@java.lang.annotation.Target(value = { java.lang.annotation.ElementType.METHOD })
public @interface Child {
    int order() default 0;
}

