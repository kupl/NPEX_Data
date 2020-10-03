package org.springframework.data.jpa.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity is a Querydsl query type for SampleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity extends EntityPathBase<ClasspathScanningPersistenceUnitPostProcessorUnitTests.SampleEntity> {

    private static final long serialVersionUID = 1986192332L;

    public static final QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity sampleEntity = new QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity("sampleEntity");

    public QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity(String variable) {
        super(ClasspathScanningPersistenceUnitPostProcessorUnitTests.SampleEntity.class, forVariable(variable));
    }

    public QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity(Path<? extends ClasspathScanningPersistenceUnitPostProcessorUnitTests.SampleEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QClasspathScanningPersistenceUnitPostProcessorUnitTests_SampleEntity(PathMetadata metadata) {
        super(ClasspathScanningPersistenceUnitPostProcessorUnitTests.SampleEntity.class, metadata);
    }

}

