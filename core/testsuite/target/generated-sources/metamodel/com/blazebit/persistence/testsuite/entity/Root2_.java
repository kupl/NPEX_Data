package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Root2.class)
public abstract class Root2_ {

	public static volatile ListAttribute<Root2, IndexedNode2> indexedNodesMappedBy;
	public static volatile SingularAttribute<Root2, Integer> id;
	public static volatile MapAttribute<Root2, String, KeyedNode2> keyedNodesMappedBy;

}

