package com.blazebit.persistence.testsuite.treat.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JoinedBase.class)
public abstract class JoinedBase_ {

	public static volatile SingularAttribute<JoinedBase, JoinedBase> parent;
	public static volatile SetAttribute<JoinedBase, JoinedBase> children;
	public static volatile SingularAttribute<JoinedBase, String> name;
	public static volatile SingularAttribute<JoinedBase, Long> id;
	public static volatile ListAttribute<JoinedBase, JoinedBase> list;
	public static volatile SingularAttribute<JoinedBase, Integer> value;
	public static volatile SingularAttribute<JoinedBase, JoinedEmbeddable> embeddable;
	public static volatile MapAttribute<JoinedBase, JoinedBase, JoinedBase> map;

}

