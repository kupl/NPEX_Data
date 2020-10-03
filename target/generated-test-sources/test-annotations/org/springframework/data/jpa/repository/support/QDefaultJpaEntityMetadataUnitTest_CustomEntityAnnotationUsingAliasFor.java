package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor is a Querydsl query type for CustomEntityAnnotationUsingAliasFor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor extends EntityPathBase<DefaultJpaEntityMetadataUnitTest.CustomEntityAnnotationUsingAliasFor> {

    private static final long serialVersionUID = 31438049L;

    public static final QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor customEntityAnnotationUsingAliasFor = new QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor("customEntityAnnotationUsingAliasFor");

    public QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor(String variable) {
        super(DefaultJpaEntityMetadataUnitTest.CustomEntityAnnotationUsingAliasFor.class, forVariable(variable));
    }

    public QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor(Path<? extends DefaultJpaEntityMetadataUnitTest.CustomEntityAnnotationUsingAliasFor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultJpaEntityMetadataUnitTest_CustomEntityAnnotationUsingAliasFor(PathMetadata metadata) {
        super(DefaultJpaEntityMetadataUnitTest.CustomEntityAnnotationUsingAliasFor.class, metadata);
    }

}

