package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Order.class)
public abstract class Order_ {

	public static volatile SingularAttribute<Order, Long> id;
	public static volatile SingularAttribute<Order, Customer> customer;

}

