package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmbeddedIdExampleDepartment is a Querydsl query type for EmbeddedIdExampleDepartment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmbeddedIdExampleDepartment extends EntityPathBase<EmbeddedIdExampleDepartment> {

    private static final long serialVersionUID = -2133053235L;

    public static final QEmbeddedIdExampleDepartment embeddedIdExampleDepartment = new QEmbeddedIdExampleDepartment("embeddedIdExampleDepartment");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath name = createString("name");

    public QEmbeddedIdExampleDepartment(String variable) {
        super(EmbeddedIdExampleDepartment.class, forVariable(variable));
    }

    public QEmbeddedIdExampleDepartment(Path<? extends EmbeddedIdExampleDepartment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmbeddedIdExampleDepartment(PathMetadata metadata) {
        super(EmbeddedIdExampleDepartment.class, metadata);
    }

}

