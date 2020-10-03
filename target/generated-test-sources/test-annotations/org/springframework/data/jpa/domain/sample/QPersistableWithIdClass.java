package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPersistableWithIdClass is a Querydsl query type for PersistableWithIdClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPersistableWithIdClass extends EntityPathBase<PersistableWithIdClass> {

    private static final long serialVersionUID = -1953759629L;

    public static final QPersistableWithIdClass persistableWithIdClass = new QPersistableWithIdClass("persistableWithIdClass");

    public final NumberPath<Long> first = createNumber("first", Long.class);

    public final BooleanPath isNew = createBoolean("isNew");

    public final NumberPath<Long> second = createNumber("second", Long.class);

    public QPersistableWithIdClass(String variable) {
        super(PersistableWithIdClass.class, forVariable(variable));
    }

    public QPersistableWithIdClass(Path<? extends PersistableWithIdClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPersistableWithIdClass(PathMetadata metadata) {
        super(PersistableWithIdClass.class, metadata);
    }

}

