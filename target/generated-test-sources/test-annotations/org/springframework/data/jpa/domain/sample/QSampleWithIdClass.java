package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSampleWithIdClass is a Querydsl query type for SampleWithIdClass
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSampleWithIdClass extends EntityPathBase<SampleWithIdClass> {

    private static final long serialVersionUID = -1608899549L;

    public static final QSampleWithIdClass sampleWithIdClass = new QSampleWithIdClass("sampleWithIdClass");

    public final NumberPath<Long> first = createNumber("first", Long.class);

    public final NumberPath<Long> second = createNumber("second", Long.class);

    public QSampleWithIdClass(String variable) {
        super(SampleWithIdClass.class, forVariable(variable));
    }

    public QSampleWithIdClass(Path<? extends SampleWithIdClass> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSampleWithIdClass(PathMetadata metadata) {
        super(SampleWithIdClass.class, metadata);
    }

}

