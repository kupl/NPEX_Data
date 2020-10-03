package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PrimitivePerson.class)
public abstract class PrimitivePerson_ {

	public static volatile SetAttribute<PrimitivePerson, PrimitiveDocument> ownedDocuments;
	public static volatile SingularAttribute<PrimitivePerson, String> name;
	public static volatile SingularAttribute<PrimitivePerson, Long> id;
	public static volatile SingularAttribute<PrimitivePerson, PrimitiveDocument> partnerDocument;

}

