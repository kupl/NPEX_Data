package com.blazebit.persistence.testsuite.treat.entity;

import com.blazebit.persistence.testsuite.entity.IntIdEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SingleTableSub1.class)
public abstract class SingleTableSub1_ extends com.blazebit.persistence.testsuite.treat.entity.SingleTableBase_ {

	public static volatile ListAttribute<SingleTableSub1, SingleTableBase> list1;
	public static volatile SingularAttribute<SingleTableSub1, SingleTableBase> parent1;
	public static volatile SingularAttribute<SingleTableSub1, Integer> sub1Value;
	public static volatile SingularAttribute<SingleTableSub1, IntValueEmbeddable> sub1Embeddable;
	public static volatile SetAttribute<SingleTableSub1, SingleTableSub1> children1;
	public static volatile MapAttribute<SingleTableSub1, SingleTableBase, SingleTableBase> map1;
	public static volatile SingularAttribute<SingleTableSub1, SingleTableEmbeddableSub1> embeddable1;
	public static volatile SingularAttribute<SingleTableSub1, IntIdEntity> relation1;

}

