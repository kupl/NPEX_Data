package com.blazebit.persistence.spring.data.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Document.class)
public abstract class Document_ {

	public static volatile SingularAttribute<Document, Person> owner;
	public static volatile SingularAttribute<Document, String> name;
	public static volatile SingularAttribute<Document, String> description;
	public static volatile SingularAttribute<Document, Long> id;
	public static volatile SingularAttribute<Document, Long> age;

}

