package com.blazebit.persistence.testsuite.treat.entity;

import com.blazebit.persistence.testsuite.entity.IntIdEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SingleTableSub2.class)
public abstract class SingleTableSub2_ extends com.blazebit.persistence.testsuite.treat.entity.SingleTableBase_ {

	public static volatile SetAttribute<SingleTableSub2, SingleTableSub2> children2;
	public static volatile MapAttribute<SingleTableSub2, SingleTableBase, SingleTableBase> map2;
	public static volatile ListAttribute<SingleTableSub2, SingleTableBase> list2;
	public static volatile SingularAttribute<SingleTableSub2, Integer> sub2Value;
	public static volatile SingularAttribute<SingleTableSub2, SingleTableEmbeddableSub2> embeddable2;
	public static volatile SingularAttribute<SingleTableSub2, IntIdEntity> relation2;
	public static volatile SingularAttribute<SingleTableSub2, IntValueEmbeddable> sub2Embeddable;
	public static volatile SingularAttribute<SingleTableSub2, SingleTableBase> parent2;

}

