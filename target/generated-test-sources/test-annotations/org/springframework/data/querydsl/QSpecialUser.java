package org.springframework.data.querydsl;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import com.querydsl.core.types.dsl.PathInits;
import static com.querydsl.core.types.PathMetadataFactory.*;
/**
 * QSpecialUser is a Querydsl query type for SpecialUser
 */
@javax.annotation.Generated("com.querydsl.codegen.EntitySerializer")
public class QSpecialUser extends com.querydsl.core.types.dsl.EntityPathBase<org.springframework.data.querydsl.SpecialUser> {
    private static final long serialVersionUID = 1181990824L;

    private static final com.querydsl.core.types.dsl.PathInits INITS = com.querydsl.core.types.dsl.PathInits.DIRECT2;

    public static final org.springframework.data.querydsl.QSpecialUser specialUser = new org.springframework.data.querydsl.QSpecialUser("specialUser");

    public final org.springframework.data.querydsl.QUser _super;

    // inherited
    public final org.springframework.data.querydsl.QAddress address;

    // inherited
    public final com.querydsl.core.types.dsl.ListPath<org.springframework.data.querydsl.Address, org.springframework.data.querydsl.QAddress> addresses;

    // inherited
    public final com.querydsl.core.types.dsl.DateTimePath<java.util.Date> dateOfBirth;

    // inherited
    public final com.querydsl.core.types.dsl.StringPath firstname;

    // inherited
    public final com.querydsl.core.types.dsl.NumberPath<java.lang.Long> inceptionYear;

    // inherited
    public final com.querydsl.core.types.dsl.StringPath lastname;

    // inherited
    public final com.querydsl.core.types.dsl.ListPath<java.lang.String, com.querydsl.core.types.dsl.StringPath> nickNames;

    public final com.querydsl.core.types.dsl.StringPath specialProperty = createString("specialProperty");

    public QSpecialUser(java.lang.String variable) {
        this(org.springframework.data.querydsl.SpecialUser.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable), org.springframework.data.querydsl.QSpecialUser.INITS);
    }

    public QSpecialUser(com.querydsl.core.types.Path<? extends org.springframework.data.querydsl.SpecialUser> path) {
        this(path.getType(), path.getMetadata(), com.querydsl.core.types.dsl.PathInits.getFor(path.getMetadata(), org.springframework.data.querydsl.QSpecialUser.INITS));
    }

    public QSpecialUser(com.querydsl.core.types.PathMetadata metadata) {
        this(metadata, com.querydsl.core.types.dsl.PathInits.getFor(metadata, org.springframework.data.querydsl.QSpecialUser.INITS));
    }

    public QSpecialUser(com.querydsl.core.types.PathMetadata metadata, com.querydsl.core.types.dsl.PathInits inits) {
        this(org.springframework.data.querydsl.SpecialUser.class, metadata, inits);
    }

    public QSpecialUser(java.lang.Class<? extends org.springframework.data.querydsl.SpecialUser> type, com.querydsl.core.types.PathMetadata metadata, com.querydsl.core.types.dsl.PathInits inits) {
        super(type, metadata, inits);
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 63, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 64, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 65, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 63, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 66, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 67, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 64, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 68, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 69, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 65, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 70, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 63, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 71, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 66, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 72, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 73, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 67, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 74, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 64, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 75, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 68, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 76, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 77, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 69, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 78, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 65, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 79, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 70, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 80, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 63, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 81, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 71, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 82, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 66, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 83, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 72, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 84, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 85, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 73, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 86, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 67, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 87, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 74, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 88, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 64, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 89, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 75, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 90, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 68, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 91, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 76, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 92, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 61, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 93, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 77, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 94, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 69, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 95, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 78, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 96, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 65, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 97, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 79, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 98, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 70, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 99, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 80, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 100, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 63, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 101, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 81, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 102, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 71, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 103, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 82, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 104, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 66, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 105, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 83, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 106, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 72, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 107, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 84, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 108, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 109, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 85, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 110, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 73, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 111, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 86, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 112, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 67, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 113, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 87, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 114, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 74, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 115, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 88, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 116, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 64, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 117, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 89, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 118, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 75, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 119, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 90, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 120, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 68, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 121, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 91, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 122, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 76, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 123, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 92, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 124, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 68, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 125, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 93, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 126, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 77, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 127, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 94, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 128, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 69, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 129, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 95, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 130, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 78, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 131, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 96, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 132, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 65, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 133, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 97, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 134, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 79, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 135, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 98, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 136, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 70, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 137, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 99, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 138, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 80, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 139, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 100, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 140, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 63, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 141, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 101, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 142, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 81, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 143, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 102, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 144, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 71, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 145, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 103, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 146, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 82, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 147, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 104, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 148, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 66, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 149, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 105, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 150, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 83, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 151, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 106, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 152, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 72, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 153, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 107, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 154, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 84, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 155, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 108, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 156, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 62, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 157, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 109, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 158, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 85, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 159, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 110, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 160, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 73, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 161, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 111, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 162, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 86, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 163, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 112, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 164, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 67, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 165, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 113, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 166, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 87, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 167, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 114, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 168, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 74, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 169, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 115, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 170, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 88, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 171, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 116, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 172, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 64, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 173, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 117, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 174, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 89, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 175, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 118, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 176, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 75, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 177, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 119, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 178, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 90, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 179, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 120, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 180, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 68, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 181, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 121, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 182, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 91, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 183, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 122, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 184, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 76, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 185, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 123, Element: println");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 186, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 92, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 187, Element: println");
        java.lang.System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 124, Element: <init>");
        System.out.println("[CALLSITE] Filepath: target/generated-test-sources/test-annotations/org/springframework/data/querydsl/QSpecialUser.java, Line: 188, Element: <init>");
        this._super = new org.springframework.data.querydsl.QUser(type, metadata, inits);
        this.address = _super.address;
        this.addresses = _super.addresses;
        this.dateOfBirth = _super.dateOfBirth;
        this.firstname = _super.firstname;
        this.inceptionYear = _super.inceptionYear;
        this.lastname = _super.lastname;
        this.nickNames = _super.nickNames;
    }
}