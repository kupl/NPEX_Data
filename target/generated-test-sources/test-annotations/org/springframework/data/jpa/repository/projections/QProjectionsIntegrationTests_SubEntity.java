package org.springframework.data.jpa.repository.projections;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProjectionsIntegrationTests_SubEntity is a Querydsl query type for SubEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProjectionsIntegrationTests_SubEntity extends EntityPathBase<ProjectionsIntegrationTests.SubEntity> {

    private static final long serialVersionUID = -2004558104L;

    public static final QProjectionsIntegrationTests_SubEntity subEntity = new QProjectionsIntegrationTests_SubEntity("subEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath otherAttribute = createString("otherAttribute");

    public QProjectionsIntegrationTests_SubEntity(String variable) {
        super(ProjectionsIntegrationTests.SubEntity.class, forVariable(variable));
    }

    public QProjectionsIntegrationTests_SubEntity(Path<? extends ProjectionsIntegrationTests.SubEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectionsIntegrationTests_SubEntity(PathMetadata metadata) {
        super(ProjectionsIntegrationTests.SubEntity.class, metadata);
    }

}

