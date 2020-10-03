package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultJpaEntityMetadataUnitTest_Bar is a Querydsl query type for Bar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDefaultJpaEntityMetadataUnitTest_Bar extends EntityPathBase<DefaultJpaEntityMetadataUnitTest.Bar> {

    private static final long serialVersionUID = 314982458L;

    public static final QDefaultJpaEntityMetadataUnitTest_Bar bar = new QDefaultJpaEntityMetadataUnitTest_Bar("bar");

    public QDefaultJpaEntityMetadataUnitTest_Bar(String variable) {
        super(DefaultJpaEntityMetadataUnitTest.Bar.class, forVariable(variable));
    }

    public QDefaultJpaEntityMetadataUnitTest_Bar(Path<? extends DefaultJpaEntityMetadataUnitTest.Bar> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultJpaEntityMetadataUnitTest_Bar(PathMetadata metadata) {
        super(DefaultJpaEntityMetadataUnitTest.Bar.class, metadata);
    }

}

