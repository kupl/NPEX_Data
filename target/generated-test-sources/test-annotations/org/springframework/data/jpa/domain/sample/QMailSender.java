package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMailSender is a Querydsl query type for MailSender
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMailSender extends EntityPathBase<MailSender> {

    private static final long serialVersionUID = 1108879574L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMailSender mailSender = new QMailSender("mailSender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMailUser mailUser;

    public final StringPath name = createString("name");

    public QMailSender(String variable) {
        this(MailSender.class, forVariable(variable), INITS);
    }

    public QMailSender(Path<? extends MailSender> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMailSender(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMailSender(PathMetadata metadata, PathInits inits) {
        this(MailSender.class, metadata, inits);
    }

    public QMailSender(Class<? extends MailSender> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mailUser = inits.isInitialized("mailUser") ? new QMailUser(forProperty("mailUser")) : null;
    }

}

