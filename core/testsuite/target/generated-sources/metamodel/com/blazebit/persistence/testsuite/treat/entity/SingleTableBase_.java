package com.blazebit.persistence.testsuite.treat.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SingleTableBase.class)
public abstract class SingleTableBase_ {

	public static volatile SingularAttribute<SingleTableBase, SingleTableBase> parent;
	public static volatile SetAttribute<SingleTableBase, SingleTableBase> children;
	public static volatile SingularAttribute<SingleTableBase, String> name;
	public static volatile SingularAttribute<SingleTableBase, Long> id;
	public static volatile ListAttribute<SingleTableBase, SingleTableBase> list;
	public static volatile SingularAttribute<SingleTableBase, Integer> value;
	public static volatile SingularAttribute<SingleTableBase, SingleTableEmbeddable> embeddable;
	public static volatile MapAttribute<SingleTableBase, SingleTableBase, SingleTableBase> map;

}

