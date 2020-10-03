package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomAbstractPersistable is a Querydsl query type for CustomAbstractPersistable
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomAbstractPersistable extends EntityPathBase<CustomAbstractPersistable> {

    private static final long serialVersionUID = -936126159L;

    public static final QCustomAbstractPersistable customAbstractPersistable = new QCustomAbstractPersistable("customAbstractPersistable");

    public final org.springframework.data.jpa.domain.QAbstractPersistable _super = new org.springframework.data.jpa.domain.QAbstractPersistable(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCustomAbstractPersistable(String variable) {
        super(CustomAbstractPersistable.class, forVariable(variable));
    }

    public QCustomAbstractPersistable(Path<? extends CustomAbstractPersistable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomAbstractPersistable(PathMetadata metadata) {
        super(CustomAbstractPersistable.class, metadata);
    }

}

