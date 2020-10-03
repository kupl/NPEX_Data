package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Parent.class)
public abstract class Parent_ {

	public static volatile SetAttribute<Parent, Child> children;
	public static volatile SingularAttribute<Parent, Long> id;

}

