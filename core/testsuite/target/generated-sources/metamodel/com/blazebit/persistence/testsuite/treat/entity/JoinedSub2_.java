package com.blazebit.persistence.testsuite.treat.entity;

import com.blazebit.persistence.testsuite.entity.IntIdEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(JoinedSub2.class)
public abstract class JoinedSub2_ extends com.blazebit.persistence.testsuite.treat.entity.JoinedBase_ {

	public static volatile SetAttribute<JoinedSub2, JoinedSub2> children2;
	public static volatile MapAttribute<JoinedSub2, JoinedBase, JoinedBase> map2;
	public static volatile ListAttribute<JoinedSub2, JoinedBase> list2;
	public static volatile SingularAttribute<JoinedSub2, Integer> sub2Value;
	public static volatile SingularAttribute<JoinedSub2, JoinedEmbeddableSub2> embeddable2;
	public static volatile SingularAttribute<JoinedSub2, IntIdEntity> relation2;
	public static volatile SingularAttribute<JoinedSub2, IntValueEmbeddable> sub2Embeddable;
	public static volatile SingularAttribute<JoinedSub2, JoinedBase> parent2;

}

