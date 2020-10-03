package com.blazebit.persistence.testsuite.treat.entity;

import com.blazebit.persistence.testsuite.entity.IntIdEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JoinedSub1.class)
public abstract class JoinedSub1_ extends com.blazebit.persistence.testsuite.treat.entity.JoinedBase_ {

	public static volatile ListAttribute<JoinedSub1, JoinedBase> list1;
	public static volatile SingularAttribute<JoinedSub1, JoinedBase> parent1;
	public static volatile SingularAttribute<JoinedSub1, Integer> sub1Value;
	public static volatile SingularAttribute<JoinedSub1, IntValueEmbeddable> sub1Embeddable;
	public static volatile SetAttribute<JoinedSub1, JoinedSub1> children1;
	public static volatile MapAttribute<JoinedSub1, JoinedBase, JoinedBase> map1;
	public static volatile SingularAttribute<JoinedSub1, JoinedEmbeddableSub1> embeddable1;
	public static volatile SingularAttribute<JoinedSub1, IntIdEntity> relation1;

}

