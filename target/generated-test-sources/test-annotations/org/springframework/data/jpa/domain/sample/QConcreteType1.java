package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConcreteType1 is a Querydsl query type for ConcreteType1
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConcreteType1 extends EntityPathBase<ConcreteType1> {

    private static final long serialVersionUID = 409758312L;

    public static final QConcreteType1 concreteType1 = new QConcreteType1("concreteType1");

    public final QAbstractMappedType _super = new QAbstractMappedType(this);

    //inherited
    public final StringPath attribute1 = _super.attribute1;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Long> version = _super.version;

    public QConcreteType1(String variable) {
        super(ConcreteType1.class, forVariable(variable));
    }

    public QConcreteType1(Path<? extends ConcreteType1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConcreteType1(PathMetadata metadata) {
        super(ConcreteType1.class, metadata);
    }

}

