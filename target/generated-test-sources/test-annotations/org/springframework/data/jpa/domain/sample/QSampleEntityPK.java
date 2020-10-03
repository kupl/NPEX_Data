package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleEntityPK is a Querydsl query type for SampleEntityPK
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QSampleEntityPK extends BeanPath<SampleEntityPK> {

    private static final long serialVersionUID = -712868366L;

    public static final QSampleEntityPK sampleEntityPK = new QSampleEntityPK("sampleEntityPK");

    public final StringPath first = createString("first");

    public final StringPath second = createString("second");

    public QSampleEntityPK(String variable) {
        super(SampleEntityPK.class, forVariable(variable));
    }

    public QSampleEntityPK(Path<? extends SampleEntityPK> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleEntityPK(PathMetadata metadata) {
        super(SampleEntityPK.class, metadata);
    }

}

