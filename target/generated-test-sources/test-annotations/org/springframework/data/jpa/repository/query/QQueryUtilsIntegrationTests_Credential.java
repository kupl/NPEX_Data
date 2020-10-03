package org.springframework.data.jpa.repository.query;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QQueryUtilsIntegrationTests_Credential is a Querydsl query type for Credential
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQueryUtilsIntegrationTests_Credential extends EntityPathBase<QueryUtilsIntegrationTests.Credential> {

    private static final long serialVersionUID = 1310986805L;

    public static final QQueryUtilsIntegrationTests_Credential credential = new QQueryUtilsIntegrationTests_Credential("credential");

    public final StringPath id = createString("id");

    public final StringPath uid = createString("uid");

    public QQueryUtilsIntegrationTests_Credential(String variable) {
        super(QueryUtilsIntegrationTests.Credential.class, forVariable(variable));
    }

    public QQueryUtilsIntegrationTests_Credential(Path<? extends QueryUtilsIntegrationTests.Credential> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQueryUtilsIntegrationTests_Credential(PathMetadata metadata) {
        super(QueryUtilsIntegrationTests.Credential.class, metadata);
    }

}

