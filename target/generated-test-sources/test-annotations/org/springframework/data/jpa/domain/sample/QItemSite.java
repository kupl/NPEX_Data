package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QItemSite is a Querydsl query type for ItemSite
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemSite extends EntityPathBase<ItemSite> {

    private static final long serialVersionUID = -513832572L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QItemSite itemSite = new QItemSite("itemSite");

    public final QItem item;

    public final QSite site;

    public QItemSite(String variable) {
        this(ItemSite.class, forVariable(variable), INITS);
    }

    public QItemSite(Path<? extends ItemSite> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QItemSite(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QItemSite(PathMetadata metadata, PathInits inits) {
        this(ItemSite.class, metadata, inits);
    }

    public QItemSite(Class<? extends ItemSite> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.item = inits.isInitialized("item") ? new QItem(forProperty("item")) : null;
        this.site = inits.isInitialized("site") ? new QSite(forProperty("site")) : null;
    }

}

