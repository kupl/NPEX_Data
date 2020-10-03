package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleWithPrimitiveId is a Querydsl query type for SampleWithPrimitiveId
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleWithPrimitiveId extends EntityPathBase<SampleWithPrimitiveId> {

    private static final long serialVersionUID = -2127231896L;

    public static final QSampleWithPrimitiveId sampleWithPrimitiveId = new QSampleWithPrimitiveId("sampleWithPrimitiveId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QSampleWithPrimitiveId(String variable) {
        super(SampleWithPrimitiveId.class, forVariable(variable));
    }

    public QSampleWithPrimitiveId(Path<? extends SampleWithPrimitiveId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleWithPrimitiveId(PathMetadata metadata) {
        super(SampleWithPrimitiveId.class, metadata);
    }

}

