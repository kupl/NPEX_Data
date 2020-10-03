package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractMappedType is a Querydsl query type for AbstractMappedType
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractMappedType extends EntityPathBase<AbstractMappedType> {

    private static final long serialVersionUID = 676385241L;

    public static final QAbstractMappedType abstractMappedType = new QAbstractMappedType("abstractMappedType");

    public final StringPath attribute1 = createString("attribute1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QAbstractMappedType(String variable) {
        super(AbstractMappedType.class, forVariable(variable));
    }

    public QAbstractMappedType(Path<? extends AbstractMappedType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractMappedType(PathMetadata metadata) {
        super(AbstractMappedType.class, metadata);
    }

}

