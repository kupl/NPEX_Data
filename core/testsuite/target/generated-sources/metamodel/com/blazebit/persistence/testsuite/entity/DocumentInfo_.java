package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DocumentInfo.class)
public abstract class DocumentInfo_ {

	public static volatile SingularAttribute<DocumentInfo, DocumentForOneToOne> document;
	public static volatile SingularAttribute<DocumentInfo, Long> id;
	public static volatile SingularAttribute<DocumentInfo, String> someInfo;

}

