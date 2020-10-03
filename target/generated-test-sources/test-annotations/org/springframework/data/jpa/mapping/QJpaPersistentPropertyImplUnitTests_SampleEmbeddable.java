package org.springframework.data.jpa.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaPersistentPropertyImplUnitTests_SampleEmbeddable is a Querydsl query type for SampleEmbeddable
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QJpaPersistentPropertyImplUnitTests_SampleEmbeddable extends BeanPath<JpaPersistentPropertyImplUnitTests.SampleEmbeddable> {

    private static final long serialVersionUID = -1856629609L;

    public static final QJpaPersistentPropertyImplUnitTests_SampleEmbeddable sampleEmbeddable = new QJpaPersistentPropertyImplUnitTests_SampleEmbeddable("sampleEmbeddable");

    public QJpaPersistentPropertyImplUnitTests_SampleEmbeddable(String variable) {
        super(JpaPersistentPropertyImplUnitTests.SampleEmbeddable.class, forVariable(variable));
    }

    public QJpaPersistentPropertyImplUnitTests_SampleEmbeddable(Path<? extends JpaPersistentPropertyImplUnitTests.SampleEmbeddable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaPersistentPropertyImplUnitTests_SampleEmbeddable(PathMetadata metadata) {
        super(JpaPersistentPropertyImplUnitTests.SampleEmbeddable.class, metadata);
    }

}

