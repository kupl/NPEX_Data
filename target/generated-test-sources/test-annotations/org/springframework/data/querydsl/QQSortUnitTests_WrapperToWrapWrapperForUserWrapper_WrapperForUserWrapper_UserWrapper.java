package org.springframework.data.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper is a Querydsl query type for UserWrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper extends EntityPathBase<QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.UserWrapper> {

    private static final long serialVersionUID = -1123481060L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper userWrapper = new QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper("userWrapper");

    public final QUser user;

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper(String variable) {
        this(QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.UserWrapper.class, forVariable(variable), INITS);
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper(Path<? extends QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.UserWrapper> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper(PathMetadata metadata, PathInits inits) {
        this(QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.UserWrapper.class, metadata, inits);
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper(Class<? extends QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.UserWrapper> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

