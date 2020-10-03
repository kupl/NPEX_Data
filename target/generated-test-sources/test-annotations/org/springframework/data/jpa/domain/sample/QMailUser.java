package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMailUser is a Querydsl query type for MailUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMailUser extends EntityPathBase<MailUser> {

    private static final long serialVersionUID = -1701564756L;

    public static final QMailUser mailUser = new QMailUser("mailUser");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QMailUser(String variable) {
        super(MailUser.class, forVariable(variable));
    }

    public QMailUser(Path<? extends MailUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMailUser(PathMetadata metadata) {
        super(MailUser.class, metadata);
    }

}

