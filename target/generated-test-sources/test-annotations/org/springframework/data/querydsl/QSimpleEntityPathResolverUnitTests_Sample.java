package org.springframework.data.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSimpleEntityPathResolverUnitTests_Sample is a Querydsl query type for Sample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimpleEntityPathResolverUnitTests_Sample extends EntityPathBase<SimpleEntityPathResolverUnitTests.Sample> {

    private static final long serialVersionUID = 1158134039L;

    public static final QSimpleEntityPathResolverUnitTests_Sample sample = new QSimpleEntityPathResolverUnitTests_Sample("sample");

    public QSimpleEntityPathResolverUnitTests_Sample(String variable) {
        super(SimpleEntityPathResolverUnitTests.Sample.class, forVariable(variable));
    }

    public QSimpleEntityPathResolverUnitTests_Sample(Path<? extends SimpleEntityPathResolverUnitTests.Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleEntityPathResolverUnitTests_Sample(PathMetadata metadata) {
        super(SimpleEntityPathResolverUnitTests.Sample.class, metadata);
    }

}

