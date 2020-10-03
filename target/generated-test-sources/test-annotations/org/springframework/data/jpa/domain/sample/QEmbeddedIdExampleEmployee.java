package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmbeddedIdExampleEmployee is a Querydsl query type for EmbeddedIdExampleEmployee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmbeddedIdExampleEmployee extends EntityPathBase<EmbeddedIdExampleEmployee> {

    private static final long serialVersionUID = -445384983L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmbeddedIdExampleEmployee embeddedIdExampleEmployee = new QEmbeddedIdExampleEmployee("embeddedIdExampleEmployee");

    public final QEmbeddedIdExampleDepartment department;

    public final QEmbeddedIdExampleEmployeePK employeePk;

    public final StringPath name = createString("name");

    public QEmbeddedIdExampleEmployee(String variable) {
        this(EmbeddedIdExampleEmployee.class, forVariable(variable), INITS);
    }

    public QEmbeddedIdExampleEmployee(Path<? extends EmbeddedIdExampleEmployee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmbeddedIdExampleEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmbeddedIdExampleEmployee(PathMetadata metadata, PathInits inits) {
        this(EmbeddedIdExampleEmployee.class, metadata, inits);
    }

    public QEmbeddedIdExampleEmployee(Class<? extends EmbeddedIdExampleEmployee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QEmbeddedIdExampleDepartment(forProperty("department")) : null;
        this.employeePk = inits.isInitialized("employeePk") ? new QEmbeddedIdExampleEmployeePK(forProperty("employeePk")) : null;
    }

}

