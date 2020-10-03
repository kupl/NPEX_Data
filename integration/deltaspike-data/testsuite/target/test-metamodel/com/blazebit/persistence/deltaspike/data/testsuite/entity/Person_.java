package com.blazebit.persistence.deltaspike.data.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, Person> parent;
	public static volatile SingularAttribute<Person, Address> address;
	public static volatile SetAttribute<Person, Person> children;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, Long> id;
	public static volatile SingularAttribute<Person, Integer> position;

}

