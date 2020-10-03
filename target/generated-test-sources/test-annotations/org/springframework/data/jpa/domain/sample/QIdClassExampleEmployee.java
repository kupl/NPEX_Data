package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIdClassExampleEmployee is a Querydsl query type for IdClassExampleEmployee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIdClassExampleEmployee extends EntityPathBase<IdClassExampleEmployee> {

    private static final long serialVersionUID = 1112189541L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIdClassExampleEmployee idClassExampleEmployee = new QIdClassExampleEmployee("idClassExampleEmployee");

    public final QIdClassExampleDepartment department;

    public final NumberPath<Long> empId = createNumber("empId", Long.class);

    public final StringPath name = createString("name");

    public QIdClassExampleEmployee(String variable) {
        this(IdClassExampleEmployee.class, forVariable(variable), INITS);
    }

    public QIdClassExampleEmployee(Path<? extends IdClassExampleEmployee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIdClassExampleEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIdClassExampleEmployee(PathMetadata metadata, PathInits inits) {
        this(IdClassExampleEmployee.class, metadata, inits);
    }

    public QIdClassExampleEmployee(Class<? extends IdClassExampleEmployee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QIdClassExampleDepartment(forProperty("department")) : null;
    }

}

