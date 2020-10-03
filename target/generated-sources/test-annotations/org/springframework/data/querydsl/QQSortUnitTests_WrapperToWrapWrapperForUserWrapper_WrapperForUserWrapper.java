package org.springframework.data.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper is a Querydsl query type for WrapperForUserWrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper extends EntityPathBase<QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper> {

    private static final long serialVersionUID = -331413534L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper wrapperForUserWrapper = new QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper("wrapperForUserWrapper");

    public final QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper wrapper;

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper(String variable) {
        this(QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.class, forVariable(variable), INITS);
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper(Path<? extends QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper(PathMetadata metadata, PathInits inits) {
        this(QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper.class, metadata, inits);
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper(Class<? extends QSortUnitTests.WrapperToWrapWrapperForUserWrapper.WrapperForUserWrapper> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.wrapper = inits.isInitialized("wrapper") ? new QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper_UserWrapper(forProperty("wrapper"), inits.get("wrapper")) : null;
    }

}

