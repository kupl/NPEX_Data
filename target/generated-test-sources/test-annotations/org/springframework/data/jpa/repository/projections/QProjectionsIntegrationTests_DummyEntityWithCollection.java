package org.springframework.data.jpa.repository.projections;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProjectionsIntegrationTests_DummyEntityWithCollection is a Querydsl query type for DummyEntityWithCollection
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProjectionsIntegrationTests_DummyEntityWithCollection extends EntityPathBase<ProjectionsIntegrationTests.DummyEntityWithCollection> {

    private static final long serialVersionUID = 706252340L;

    public static final QProjectionsIntegrationTests_DummyEntityWithCollection dummyEntityWithCollection = new QProjectionsIntegrationTests_DummyEntityWithCollection("dummyEntityWithCollection");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath otherAttribute = createString("otherAttribute");

    public final ListPath<ProjectionsIntegrationTests.SubEntity, QProjectionsIntegrationTests_SubEntity> subs = this.<ProjectionsIntegrationTests.SubEntity, QProjectionsIntegrationTests_SubEntity>createList("subs", ProjectionsIntegrationTests.SubEntity.class, QProjectionsIntegrationTests_SubEntity.class, PathInits.DIRECT2);

    public QProjectionsIntegrationTests_DummyEntityWithCollection(String variable) {
        super(ProjectionsIntegrationTests.DummyEntityWithCollection.class, forVariable(variable));
    }

    public QProjectionsIntegrationTests_DummyEntityWithCollection(Path<? extends ProjectionsIntegrationTests.DummyEntityWithCollection> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProjectionsIntegrationTests_DummyEntityWithCollection(PathMetadata metadata) {
        super(ProjectionsIntegrationTests.DummyEntityWithCollection.class, metadata);
    }

}

