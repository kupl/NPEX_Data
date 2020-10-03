package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1918844245L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final BooleanPath active = createBoolean("active");

    public final QAddress address;

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final SetPath<String, StringPath> attributes = this.<String, StringPath>createSet("attributes", String.class, StringPath.class, PathInits.DIRECT2);

    public final ArrayPath<byte[], Byte> binaryData = createArray("binaryData", byte[].class);

    public final SetPath<User, QUser> colleagues = this.<User, QUser>createSet("colleagues", User.class, QUser.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DatePath<java.util.Date> dateOfBirth = createDate("dateOfBirth", java.util.Date.class);

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath firstname = createString("firstname");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastname = createString("lastname");

    public final QUser manager;

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.manager = inits.isInitialized("manager") ? new QUser(forProperty("manager"), inits.get("manager")) : null;
    }

}

