package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVersionedUser is a Querydsl query type for VersionedUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVersionedUser extends EntityPathBase<VersionedUser> {

    private static final long serialVersionUID = -1288771176L;

    public static final QVersionedUser versionedUser = new QVersionedUser("versionedUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QVersionedUser(String variable) {
        super(VersionedUser.class, forVariable(variable));
    }

    public QVersionedUser(Path<? extends VersionedUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVersionedUser(PathMetadata metadata) {
        super(VersionedUser.class, metadata);
    }

}

