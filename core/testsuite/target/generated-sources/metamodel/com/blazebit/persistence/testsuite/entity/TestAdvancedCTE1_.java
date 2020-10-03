package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TestAdvancedCTE1.class)
public abstract class TestAdvancedCTE1_ {

	public static volatile SingularAttribute<TestAdvancedCTE1, RecursiveEntity> parent;
	public static volatile SingularAttribute<TestAdvancedCTE1, Integer> level;
	public static volatile SingularAttribute<TestAdvancedCTE1, String> name;
	public static volatile SingularAttribute<TestAdvancedCTE1, Long> id;
	public static volatile SingularAttribute<TestAdvancedCTE1, TestCTEEmbeddable> embeddable;
	public static volatile SingularAttribute<TestAdvancedCTE1, Long> parentId;

}

