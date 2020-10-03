package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends com.blazebit.persistence.testsuite.entity.LongSequenceEntity_ {

	public static volatile SetAttribute<Person, Document> ownedDocuments;
	public static volatile SingularAttribute<Person, Integer> defaultLanguage;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile MapAttribute<Person, Integer, String> localized;
	public static volatile SingularAttribute<Person, Person> friend;
	public static volatile SetAttribute<Person, Document> favoriteDocuments;
	public static volatile SingularAttribute<Person, Document> partnerDocument;
	public static volatile SingularAttribute<Person, NameObject> nameObject;
	public static volatile SingularAttribute<Person, Long> age;

}

