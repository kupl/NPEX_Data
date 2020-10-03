package org.springframework.data.querydsl;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQSortUnitTests_WrapperToWrapWrapperForUserWrapper is a Querydsl query type for WrapperToWrapWrapperForUserWrapper
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QQSortUnitTests_WrapperToWrapWrapperForUserWrapper extends EntityPathBase<QSortUnitTests.WrapperToWrapWrapperForUserWrapper> {

    private static final long serialVersionUID = 903562430L;

    private static final PathInits INITS = new PathInits("*", "wrapperForUserWrapper.wrapper.user");

    public static final QQSortUnitTests_WrapperToWrapWrapperForUserWrapper wrapperToWrapWrapperForUserWrapper = new QQSortUnitTests_WrapperToWrapWrapperForUserWrapper("wrapperToWrapWrapperForUserWrapper");

    public final QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper wrapperForUserWrapper;

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper(String variable) {
        this(QSortUnitTests.WrapperToWrapWrapperForUserWrapper.class, forVariable(variable), INITS);
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper(Path<? extends QSortUnitTests.WrapperToWrapWrapperForUserWrapper> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper(PathMetadata metadata, PathInits inits) {
        this(QSortUnitTests.WrapperToWrapWrapperForUserWrapper.class, metadata, inits);
    }

    public QQSortUnitTests_WrapperToWrapWrapperForUserWrapper(Class<? extends QSortUnitTests.WrapperToWrapWrapperForUserWrapper> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.wrapperForUserWrapper = inits.isInitialized("wrapperForUserWrapper") ? new QQSortUnitTests_WrapperToWrapWrapperForUserWrapper_WrapperForUserWrapper(forProperty("wrapperForUserWrapper"), inits.get("wrapperForUserWrapper")) : null;
    }

}

