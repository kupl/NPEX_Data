package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PrimitiveDocument.class)
public abstract class PrimitiveDocument_ {

	public static volatile SingularAttribute<PrimitiveDocument, PrimitivePerson> owner;
	public static volatile ListAttribute<PrimitiveDocument, PrimitivePerson> peopleListBag;
	public static volatile SingularAttribute<PrimitiveDocument, PrimitiveDocument> parent;
	public static volatile SingularAttribute<PrimitiveDocument, Boolean> deleted;
	public static volatile SetAttribute<PrimitiveDocument, PrimitivePerson> partners;
	public static volatile CollectionAttribute<PrimitiveDocument, PrimitivePerson> peopleCollectionBag;
	public static volatile SingularAttribute<PrimitiveDocument, String> name;
	public static volatile SingularAttribute<PrimitiveDocument, Long> id;
	public static volatile ListAttribute<PrimitiveDocument, PrimitivePerson> people;
	public static volatile MapAttribute<PrimitiveDocument, Integer, PrimitivePerson> contacts;

}

