package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OrderPosition.class)
public abstract class OrderPosition_ {

	public static volatile SingularAttribute<OrderPosition, OrderPositionHead> head;
	public static volatile SingularAttribute<OrderPosition, OrderPositionId> id;
	public static volatile SingularAttribute<OrderPosition, Order> order;

}

