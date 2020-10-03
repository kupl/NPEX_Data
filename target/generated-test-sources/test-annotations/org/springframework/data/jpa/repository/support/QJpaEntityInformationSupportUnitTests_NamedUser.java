package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaEntityInformationSupportUnitTests_NamedUser is a Querydsl query type for NamedUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJpaEntityInformationSupportUnitTests_NamedUser extends EntityPathBase<JpaEntityInformationSupportUnitTests.NamedUser> {

    private static final long serialVersionUID = 555294021L;

    public static final QJpaEntityInformationSupportUnitTests_NamedUser namedUser = new QJpaEntityInformationSupportUnitTests_NamedUser("namedUser");

    public QJpaEntityInformationSupportUnitTests_NamedUser(String variable) {
        super(JpaEntityInformationSupportUnitTests.NamedUser.class, forVariable(variable));
    }

    public QJpaEntityInformationSupportUnitTests_NamedUser(Path<? extends JpaEntityInformationSupportUnitTests.NamedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaEntityInformationSupportUnitTests_NamedUser(PathMetadata metadata) {
        super(JpaEntityInformationSupportUnitTests.NamedUser.class, metadata);
    }

}

