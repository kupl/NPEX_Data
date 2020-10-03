package spoon.reflect.annotations;


@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value = { java.lang.annotation.ElementType.FIELD })
public @interface MetamodelPropertyField {
    spoon.reflect.path.CtRole[] role();
}

