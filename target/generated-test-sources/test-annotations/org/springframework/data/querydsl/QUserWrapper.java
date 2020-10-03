package org.springframework.data.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserWrapper is a Querydsl query type for UserWrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserWrapper extends EntityPathBase<UserWrapper> {

    private static final long serialVersionUID = -946959924L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserWrapper userWrapper = new QUserWrapper("userWrapper");

    public final QUser user;

    public QUserWrapper(String variable) {
        this(UserWrapper.class, forVariable(variable), INITS);
    }

    public QUserWrapper(Path<? extends UserWrapper> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserWrapper(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserWrapper(PathMetadata metadata, PathInits inits) {
        this(UserWrapper.class, metadata, inits);
    }

    public QUserWrapper(Class<? extends UserWrapper> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

