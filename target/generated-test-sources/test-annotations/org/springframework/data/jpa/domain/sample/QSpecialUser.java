package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSpecialUser is a Querydsl query type for SpecialUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSpecialUser extends EntityPathBase<SpecialUser> {

    private static final long serialVersionUID = 1533893466L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpecialUser specialUser = new QSpecialUser("specialUser");

    public final QUser _super;

    //inherited
    public final BooleanPath active;

    // inherited
    public final QAddress address;

    //inherited
    public final NumberPath<Integer> age;

    //inherited
    public final SetPath<String, StringPath> attributes;

    //inherited
    public final ArrayPath<byte[], Byte> binaryData;

    //inherited
    public final SetPath<User, QUser> colleagues;

    //inherited
    public final DateTimePath<java.util.Date> createdAt;

    //inherited
    public final DatePath<java.util.Date> dateOfBirth;

    //inherited
    public final StringPath emailAddress;

    //inherited
    public final StringPath firstname;

    //inherited
    public final NumberPath<Integer> id;

    //inherited
    public final StringPath lastname;

    // inherited
    public final QUser manager;

    //inherited
    public final SetPath<Role, QRole> roles;

    public QSpecialUser(String variable) {
        this(SpecialUser.class, forVariable(variable), INITS);
    }

    public QSpecialUser(Path<? extends SpecialUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSpecialUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSpecialUser(PathMetadata metadata, PathInits inits) {
        this(SpecialUser.class, metadata, inits);
    }

    public QSpecialUser(Class<? extends SpecialUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QUser(type, metadata, inits);
        this.active = _super.active;
        this.address = _super.address;
        this.age = _super.age;
        this.attributes = _super.attributes;
        this.binaryData = _super.binaryData;
        this.colleagues = _super.colleagues;
        this.createdAt = _super.createdAt;
        this.dateOfBirth = _super.dateOfBirth;
        this.emailAddress = _super.emailAddress;
        this.firstname = _super.firstname;
        this.id = _super.id;
        this.lastname = _super.lastname;
        this.manager = _super.manager;
        this.roles = _super.roles;
    }

}

