package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RecursiveEntity.class)
public abstract class RecursiveEntity_ {

	public static volatile SingularAttribute<RecursiveEntity, RecursiveEntity> parent;
	public static volatile SetAttribute<RecursiveEntity, RecursiveEntity> children;
	public static volatile SingularAttribute<RecursiveEntity, String> name;
	public static volatile SingularAttribute<RecursiveEntity, Long> id;

}

