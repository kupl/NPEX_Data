package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QIdClassExampleDepartment is a Querydsl query type for IdClassExampleDepartment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QIdClassExampleDepartment extends EntityPathBase<IdClassExampleDepartment> {

    private static final long serialVersionUID = 47445321L;

    public static final QIdClassExampleDepartment idClassExampleDepartment = new QIdClassExampleDepartment("idClassExampleDepartment");

    public final NumberPath<Long> departmentId = createNumber("departmentId", Long.class);

    public final StringPath name = createString("name");

    public QIdClassExampleDepartment(String variable) {
        super(IdClassExampleDepartment.class, forVariable(variable));
    }

    public QIdClassExampleDepartment(Path<? extends IdClassExampleDepartment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIdClassExampleDepartment(PathMetadata metadata) {
        super(IdClassExampleDepartment.class, metadata);
    }

}

