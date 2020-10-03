package com.blazebit.persistence.testsuite.entity;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Document.class)
public abstract class Document_ extends com.blazebit.persistence.testsuite.entity.Ownable_ {

	public static volatile MapAttribute<Document, Integer, Person> contacts2;
	public static volatile ListAttribute<Document, Person> peopleListBag;
	public static volatile SingularAttribute<Document, Document> parent;
	public static volatile SingularAttribute<Document, DocumentType> documentType;
	public static volatile SingularAttribute<Document, Calendar> creationDate2;
	public static volatile SingularAttribute<Document, Boolean> archived;
	public static volatile ListAttribute<Document, String> strings;
	public static volatile SingularAttribute<Document, NameObjectContainer> nameContainer;
	public static volatile MapAttribute<Document, String, NameObjectContainer> nameContainerMap;
	public static volatile SingularAttribute<Document, String> nonJoinable;
	public static volatile SingularAttribute<Document, byte[]> byteArray;
	public static volatile SingularAttribute<Document, Byte[]> wrappedByteArray;
	public static volatile SingularAttribute<Document, IntIdEntity> intIdEntity;
	public static volatile SingularAttribute<Document, Calendar> creationDate;
	public static volatile SingularAttribute<Document, Long> version;
	public static volatile ListAttribute<Document, Person> people;
	public static volatile SingularAttribute<Document, Date> lastModified2;
	public static volatile SingularAttribute<Document, Person> responsiblePerson;
	public static volatile ListAttribute<Document, NameObject> names;
	public static volatile MapAttribute<Document, String, NameObject> nameMap;
	public static volatile SingularAttribute<Document, Integer> defaultContact;
	public static volatile SetAttribute<Document, Version> versions;
	public static volatile SetAttribute<Document, Person> partners;
	public static volatile CollectionAttribute<Document, Person> peopleCollectionBag;
	public static volatile SingularAttribute<Document, Double> someValue;
	public static volatile ListAttribute<Document, NameObjectContainer> nameContainers;
	public static volatile SingularAttribute<Document, String> name;
	public static volatile SingularAttribute<Document, Date> lastModified;
	public static volatile SingularAttribute<Document, Integer> idx;
	public static volatile MapAttribute<Document, String, String> stringMap;
	public static volatile SingularAttribute<Document, NameObject> nameObject;
	public static volatile SingularAttribute<Document, Long> age;
	public static volatile MapAttribute<Document, Integer, Person> contacts;

}

