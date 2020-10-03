package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleWithTimestampVersion is a Querydsl query type for SampleWithTimestampVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleWithTimestampVersion extends EntityPathBase<SampleWithTimestampVersion> {

    private static final long serialVersionUID = -1870573924L;

    public static final QSampleWithTimestampVersion sampleWithTimestampVersion = new QSampleWithTimestampVersion("sampleWithTimestampVersion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> version = createDateTime("version", java.sql.Timestamp.class);

    public QSampleWithTimestampVersion(String variable) {
        super(SampleWithTimestampVersion.class, forVariable(variable));
    }

    public QSampleWithTimestampVersion(Path<? extends SampleWithTimestampVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleWithTimestampVersion(PathMetadata metadata) {
        super(SampleWithTimestampVersion.class, metadata);
    }

}

