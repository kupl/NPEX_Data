package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConcreteType2 is a Querydsl query type for ConcreteType2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcreteType2 extends EntityPathBase<ConcreteType2> {

    private static final long serialVersionUID = 409758313L;

    public static final QConcreteType2 concreteType2 = new QConcreteType2("concreteType2");

    public final QAbstractMappedType _super = new QAbstractMappedType(this);

    //inherited
    public final StringPath attribute1 = _super.attribute1;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QConcreteType2(String variable) {
        super(ConcreteType2.class, forVariable(variable));
    }

    public QConcreteType2(Path<? extends ConcreteType2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcreteType2(PathMetadata metadata) {
        super(ConcreteType2.class, metadata);
    }

}

