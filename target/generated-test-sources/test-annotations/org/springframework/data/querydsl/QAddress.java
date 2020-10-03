package org.springframework.data.querydsl;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.*;
import static com.querydsl.core.types.PathMetadataFactory.*;
/**
 * QAddress is a Querydsl query type for Address
 */
@javax.annotation.Generated("com.querydsl.codegen.EntitySerializer")
public class QAddress extends com.querydsl.core.types.dsl.EntityPathBase<org.springframework.data.querydsl.Address> {
    private static final long serialVersionUID = 1091641720L;

    public static final org.springframework.data.querydsl.QAddress address = new org.springframework.data.querydsl.QAddress("address");

    public final com.querydsl.core.types.dsl.StringPath city = createString("city");

    public final com.querydsl.core.types.dsl.ArrayPath<java.lang.Double[], java.lang.Double> lonLat = createArray("lonLat", java.lang.Double[].class);

    public final com.querydsl.core.types.dsl.StringPath street = createString("street");

    public QAddress(java.lang.String variable) {
        super(org.springframework.data.querydsl.Address.class, com.querydsl.core.types.PathMetadataFactory.forVariable(variable));
    }

    public QAddress(com.querydsl.core.types.Path<? extends org.springframework.data.querydsl.Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(com.querydsl.core.types.PathMetadata metadata) {
        super(org.springframework.data.querydsl.Address.class, metadata);
    }
}