package org.springframework.data.jpa.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaPersistentPropertyImplUnitTests_SampleEmbedded is a Querydsl query type for SampleEmbedded
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QJpaPersistentPropertyImplUnitTests_SampleEmbedded extends BeanPath<JpaPersistentPropertyImplUnitTests.SampleEmbedded> {

    private static final long serialVersionUID = 516503324L;

    public static final QJpaPersistentPropertyImplUnitTests_SampleEmbedded sampleEmbedded = new QJpaPersistentPropertyImplUnitTests_SampleEmbedded("sampleEmbedded");

    public QJpaPersistentPropertyImplUnitTests_SampleEmbedded(String variable) {
        super(JpaPersistentPropertyImplUnitTests.SampleEmbedded.class, forVariable(variable));
    }

    public QJpaPersistentPropertyImplUnitTests_SampleEmbedded(Path<? extends JpaPersistentPropertyImplUnitTests.SampleEmbedded> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaPersistentPropertyImplUnitTests_SampleEmbedded(PathMetadata metadata) {
        super(JpaPersistentPropertyImplUnitTests.SampleEmbedded.class, metadata);
    }

}

