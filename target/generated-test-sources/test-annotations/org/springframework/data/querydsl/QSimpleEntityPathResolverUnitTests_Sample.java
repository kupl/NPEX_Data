package org.springframework.data.querydsl;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import static com.querydsl.core.types.PathMetadataFactory.*;
/**
 * QSimpleEntityPathResolverUnitTests_Sample is a Querydsl query type for Sample
 */
@javax.annotation.Generated("com.querydsl.codegen.EntitySerializer")
public class QSimpleEntityPathResolverUnitTests_Sample extends com.querydsl.core.types.dsl.EntityPathBase<org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.Sample> {
    private static final long serialVersionUID = 1158134039L;

    public static final org.springframework.data.querydsl.QSimpleEntityPathResolverUnitTests_Sample sample = new org.springframework.data.querydsl.QSimpleEntityPathResolverUnitTests_Sample("sample");

    public QSimpleEntityPathResolverUnitTests_Sample(java.lang.String variable) {
        super(org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.Sample.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable));
    }

    public QSimpleEntityPathResolverUnitTests_Sample(com.querydsl.core.types.Path<? extends org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleEntityPathResolverUnitTests_Sample(com.querydsl.core.types.PathMetadata metadata) {
        super(org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.Sample.class, metadata);
    }
}