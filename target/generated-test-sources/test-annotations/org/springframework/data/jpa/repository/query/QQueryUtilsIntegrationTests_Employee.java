package org.springframework.data.jpa.repository.query;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQueryUtilsIntegrationTests_Employee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQueryUtilsIntegrationTests_Employee extends EntityPathBase<QueryUtilsIntegrationTests.Employee> {

    private static final long serialVersionUID = 1226829836L;

    public static final QQueryUtilsIntegrationTests_Employee employee = new QQueryUtilsIntegrationTests_Employee("employee");

    public final SetPath<QueryUtilsIntegrationTests.Credential, QQueryUtilsIntegrationTests_Credential> credentials = this.<QueryUtilsIntegrationTests.Credential, QQueryUtilsIntegrationTests_Credential>createSet("credentials", QueryUtilsIntegrationTests.Credential.class, QQueryUtilsIntegrationTests_Credential.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public QQueryUtilsIntegrationTests_Employee(String variable) {
        super(QueryUtilsIntegrationTests.Employee.class, forVariable(variable));
    }

    public QQueryUtilsIntegrationTests_Employee(Path<? extends QueryUtilsIntegrationTests.Employee> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQueryUtilsIntegrationTests_Employee(PathMetadata metadata) {
        super(QueryUtilsIntegrationTests.Employee.class, metadata);
    }

}

