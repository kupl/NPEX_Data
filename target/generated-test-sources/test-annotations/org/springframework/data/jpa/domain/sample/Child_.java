package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Child.class)
public abstract class Child_ {

	public static volatile SingularAttribute<Child, Long> id;
	public static volatile SetAttribute<Child, Parent> parents;

}

