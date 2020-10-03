package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnnotatedAuditableUser is a Querydsl query type for AnnotatedAuditableUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAnnotatedAuditableUser extends EntityPathBase<AnnotatedAuditableUser> {

    private static final long serialVersionUID = -1796818318L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnnotatedAuditableUser annotatedAuditableUser = new QAnnotatedAuditableUser("annotatedAuditableUser");

    public final QAbstractAnnotatedAuditable _super;

    //inherited
    public final DateTimePath<java.util.Date> createAt;

    // inherited
    public final QAuditableUser createdBy;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final DateTimePath<java.util.Date> lastModifiedAt;

    // inherited
    public final QAuditableUser lastModifiedBy;

    public QAnnotatedAuditableUser(String variable) {
        this(AnnotatedAuditableUser.class, forVariable(variable), INITS);
    }

    public QAnnotatedAuditableUser(Path<? extends AnnotatedAuditableUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnnotatedAuditableUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnnotatedAuditableUser(PathMetadata metadata, PathInits inits) {
        this(AnnotatedAuditableUser.class, metadata, inits);
    }

    public QAnnotatedAuditableUser(Class<? extends AnnotatedAuditableUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QAbstractAnnotatedAuditable(type, metadata, inits);
        this.createAt = _super.createAt;
        this.createdBy = _super.createdBy;
        this.id = _super.id;
        this.lastModifiedAt = _super.lastModifiedAt;
        this.lastModifiedBy = _super.lastModifiedBy;
    }

}

