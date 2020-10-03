package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmbeddableTestEntity.class)
public abstract class EmbeddableTestEntity_ {

	public static volatile SingularAttribute<EmbeddableTestEntity, EmbeddableTestEntityId> id;
	public static volatile SingularAttribute<EmbeddableTestEntity, EmbeddableTestEntityEmbeddable> embeddable;

}

