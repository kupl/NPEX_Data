package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPrimitiveVersionProperty is a Querydsl query type for PrimitiveVersionProperty
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPrimitiveVersionProperty extends EntityPathBase<PrimitiveVersionProperty> {

    private static final long serialVersionUID = 1163825008L;

    public static final QPrimitiveVersionProperty primitiveVersionProperty = new QPrimitiveVersionProperty("primitiveVersionProperty");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath someValue = createString("someValue");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QPrimitiveVersionProperty(String variable) {
        super(PrimitiveVersionProperty.class, forVariable(variable));
    }

    public QPrimitiveVersionProperty(Path<? extends PrimitiveVersionProperty> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPrimitiveVersionProperty(PathMetadata metadata) {
        super(PrimitiveVersionProperty.class, metadata);
    }

}

