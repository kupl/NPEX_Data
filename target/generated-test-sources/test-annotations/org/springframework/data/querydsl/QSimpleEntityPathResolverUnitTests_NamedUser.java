package org.springframework.data.querydsl;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import static com.querydsl.core.types.PathMetadataFactory.*;
/**
 * QSimpleEntityPathResolverUnitTests_NamedUser is a Querydsl query type for NamedUser
 */
@javax.annotation.Generated("com.querydsl.codegen.EntitySerializer")
public class QSimpleEntityPathResolverUnitTests_NamedUser extends com.querydsl.core.types.dsl.EntityPathBase<org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.NamedUser> {
    private static final long serialVersionUID = 623533079L;

    public static final org.springframework.data.querydsl.QSimpleEntityPathResolverUnitTests_NamedUser namedUser = new org.springframework.data.querydsl.QSimpleEntityPathResolverUnitTests_NamedUser("namedUser");

    public QSimpleEntityPathResolverUnitTests_NamedUser(java.lang.String variable) {
        super(org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.NamedUser.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable));
    }

    public QSimpleEntityPathResolverUnitTests_NamedUser(com.querydsl.core.types.Path<? extends org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.NamedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleEntityPathResolverUnitTests_NamedUser(com.querydsl.core.types.PathMetadata metadata) {
        super(org.springframework.data.querydsl.SimpleEntityPathResolverUnitTests.NamedUser.class, metadata);
    }
}