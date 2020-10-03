package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAbstractAnnotatedAuditable is a Querydsl query type for AbstractAnnotatedAuditable
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractAnnotatedAuditable extends EntityPathBase<AbstractAnnotatedAuditable> {

    private static final long serialVersionUID = 2131604425L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAbstractAnnotatedAuditable abstractAnnotatedAuditable = new QAbstractAnnotatedAuditable("abstractAnnotatedAuditable");

    public final DateTimePath<java.util.Date> createAt = createDateTime("createAt", java.util.Date.class);

    public final QAuditableUser createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> lastModifiedAt = createDateTime("lastModifiedAt", java.util.Date.class);

    public final QAuditableUser lastModifiedBy;

    public QAbstractAnnotatedAuditable(String variable) {
        this(AbstractAnnotatedAuditable.class, forVariable(variable), INITS);
    }

    public QAbstractAnnotatedAuditable(Path<? extends AbstractAnnotatedAuditable> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAbstractAnnotatedAuditable(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAbstractAnnotatedAuditable(PathMetadata metadata, PathInits inits) {
        this(AbstractAnnotatedAuditable.class, metadata, inits);
    }

    public QAbstractAnnotatedAuditable(Class<? extends AbstractAnnotatedAuditable> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QAuditableUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.lastModifiedBy = inits.isInitialized("lastModifiedBy") ? new QAuditableUser(forProperty("lastModifiedBy"), inits.get("lastModifiedBy")) : null;
    }

}

