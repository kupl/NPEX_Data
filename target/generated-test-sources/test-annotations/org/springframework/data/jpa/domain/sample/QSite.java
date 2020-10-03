package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSite is a Querydsl query type for Site
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSite extends EntityPathBase<Site> {

    private static final long serialVersionUID = 1918775505L;

    public static final QSite site = new QSite("site");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public QSite(String variable) {
        super(Site.class, forVariable(variable));
    }

    public QSite(Path<? extends Site> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSite(PathMetadata metadata) {
        super(Site.class, metadata);
    }

}

