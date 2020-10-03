package org.springframework.data.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSimpleEntityPathResolverUnitTests_NamedUser is a Querydsl query type for NamedUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSimpleEntityPathResolverUnitTests_NamedUser extends EntityPathBase<SimpleEntityPathResolverUnitTests.NamedUser> {

    private static final long serialVersionUID = 623533079L;

    public static final QSimpleEntityPathResolverUnitTests_NamedUser namedUser = new QSimpleEntityPathResolverUnitTests_NamedUser("namedUser");

    public QSimpleEntityPathResolverUnitTests_NamedUser(String variable) {
        super(SimpleEntityPathResolverUnitTests.NamedUser.class, forVariable(variable));
    }

    public QSimpleEntityPathResolverUnitTests_NamedUser(Path<? extends SimpleEntityPathResolverUnitTests.NamedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSimpleEntityPathResolverUnitTests_NamedUser(PathMetadata metadata) {
        super(SimpleEntityPathResolverUnitTests.NamedUser.class, metadata);
    }

}

