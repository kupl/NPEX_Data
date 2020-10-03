package org.springframework.data.querydsl;

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

    private static final long serialVersionUID = 1181990824L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSpecialUser specialUser = new QSpecialUser("specialUser");

    public final QUser _super;

    // inherited
    public final QAddress address;

    //inherited
    public final ListPath<Address, QAddress> addresses;

    //inherited
    public final DateTimePath<java.util.Date> dateOfBirth;

    //inherited
    public final StringPath firstname;

    //inherited
    public final NumberPath<Long> inceptionYear;

    //inherited
    public final StringPath lastname;

    //inherited
    public final ListPath<String, StringPath> nickNames;

    public final StringPath specialProperty = createString("specialProperty");

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
        this.address = _super.address;
        this.addresses = _super.addresses;
        this.dateOfBirth = _super.dateOfBirth;
        this.firstname = _super.firstname;
        this.inceptionYear = _super.inceptionYear;
        this.lastname = _super.lastname;
        this.nickNames = _super.nickNames;
    }

}

