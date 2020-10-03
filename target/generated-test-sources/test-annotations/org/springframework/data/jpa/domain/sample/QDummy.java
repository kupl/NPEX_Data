package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDummy is a Querydsl query type for Dummy
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDummy extends EntityPathBase<Dummy> {

    private static final long serialVersionUID = -661003170L;

    public static final QDummy dummy = new QDummy("dummy");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QDummy(String variable) {
        super(Dummy.class, forVariable(variable));
    }

    public QDummy(Path<? extends Dummy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDummy(PathMetadata metadata) {
        super(Dummy.class, metadata);
    }

}

