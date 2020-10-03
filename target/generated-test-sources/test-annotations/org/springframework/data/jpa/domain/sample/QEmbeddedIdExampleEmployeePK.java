package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmbeddedIdExampleEmployeePK is a Querydsl query type for EmbeddedIdExampleEmployeePK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QEmbeddedIdExampleEmployeePK extends BeanPath<EmbeddedIdExampleEmployeePK> {

    private static final long serialVersionUID = 1481763492L;

    public static final QEmbeddedIdExampleEmployeePK embeddedIdExampleEmployeePK = new QEmbeddedIdExampleEmployeePK("embeddedIdExampleEmployeePK");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final NumberPath<Long> employeeId = createNumber("employeeId", Long.class);

    public QEmbeddedIdExampleEmployeePK(String variable) {
        super(EmbeddedIdExampleEmployeePK.class, forVariable(variable));
    }

    public QEmbeddedIdExampleEmployeePK(Path<? extends EmbeddedIdExampleEmployeePK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmbeddedIdExampleEmployeePK(PathMetadata metadata) {
        super(EmbeddedIdExampleEmployeePK.class, metadata);
    }

}

