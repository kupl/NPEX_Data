package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMailMessage is a Querydsl query type for MailMessage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMailMessage extends EntityPathBase<MailMessage> {

    private static final long serialVersionUID = -1009465978L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMailMessage mailMessage = new QMailMessage("mailMessage");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMailSender mailSender;

    public QMailMessage(String variable) {
        this(MailMessage.class, forVariable(variable), INITS);
    }

    public QMailMessage(Path<? extends MailMessage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMailMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMailMessage(PathMetadata metadata, PathInits inits) {
        this(MailMessage.class, metadata, inits);
    }

    public QMailMessage(Class<? extends MailMessage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mailSender = inits.isInitialized("mailSender") ? new QMailSender(forProperty("mailSender"), inits.get("mailSender")) : null;
    }

}

