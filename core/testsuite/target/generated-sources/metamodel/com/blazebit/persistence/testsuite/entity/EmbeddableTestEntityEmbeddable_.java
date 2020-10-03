package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmbeddableTestEntityEmbeddable.class)
public abstract class EmbeddableTestEntityEmbeddable_ {

	public static volatile MapAttribute<EmbeddableTestEntityEmbeddable, String, NameObject> elementCollection;
	public static volatile MapAttribute<EmbeddableTestEntityEmbeddable, String, IntIdEntity> manyToMany;
	public static volatile SingularAttribute<EmbeddableTestEntityEmbeddable, EmbeddableTestEntityNestedEmbeddable> nestedEmbeddable;
	public static volatile SetAttribute<EmbeddableTestEntityEmbeddable, EmbeddableTestEntity> oneToMany;
	public static volatile SingularAttribute<EmbeddableTestEntityEmbeddable, EmbeddableTestEntity> manyToOne;

}

