package org.springframework.data.jpa.repository.query;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQueryUtilsIntegrationTests_Merchant is a Querydsl query type for Merchant
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQueryUtilsIntegrationTests_Merchant extends EntityPathBase<QueryUtilsIntegrationTests.Merchant> {

    private static final long serialVersionUID = -471936218L;

    public static final QQueryUtilsIntegrationTests_Merchant merchant = new QQueryUtilsIntegrationTests_Merchant("merchant");

    public final SetPath<QueryUtilsIntegrationTests.Employee, QQueryUtilsIntegrationTests_Employee> employees = this.<QueryUtilsIntegrationTests.Employee, QQueryUtilsIntegrationTests_Employee>createSet("employees", QueryUtilsIntegrationTests.Employee.class, QQueryUtilsIntegrationTests_Employee.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public QQueryUtilsIntegrationTests_Merchant(String variable) {
        super(QueryUtilsIntegrationTests.Merchant.class, forVariable(variable));
    }

    public QQueryUtilsIntegrationTests_Merchant(Path<? extends QueryUtilsIntegrationTests.Merchant> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQueryUtilsIntegrationTests_Merchant(PathMetadata metadata) {
        super(QueryUtilsIntegrationTests.Merchant.class, metadata);
    }

}

