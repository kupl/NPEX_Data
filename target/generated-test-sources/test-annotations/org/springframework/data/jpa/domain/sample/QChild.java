package org.springframework.data.jpa.domain.sample;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChild is a Querydsl query type for Child
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChild extends EntityPathBase<Child> {

    private static final long serialVersionUID = -662317870L;

    public static final QChild child = new QChild("child");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final SetPath<Parent, QParent> parents = this.<Parent, QParent>createSet("parents", Parent.class, QParent.class, PathInits.DIRECT2);

    public QChild(String variable) {
        super(Child.class, forVariable(variable));
    }

    public QChild(Path<? extends Child> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChild(PathMetadata metadata) {
        super(Child.class, metadata);
    }

}

