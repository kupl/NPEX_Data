package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PolymorphicBase.class)
public abstract class PolymorphicBase_ {

	public static volatile SingularAttribute<PolymorphicBase, PolymorphicBase> parent;
	public static volatile SetAttribute<PolymorphicBase, PolymorphicBase> children;
	public static volatile SingularAttribute<PolymorphicBase, String> name;
	public static volatile SingularAttribute<PolymorphicBase, Long> id;
	public static volatile ListAttribute<PolymorphicBase, PolymorphicBase> list;
	public static volatile MapAttribute<PolymorphicBase, String, PolymorphicBase> map;

}

