package com.blazebit.persistence.testsuite.entity;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Version.class)
public abstract class Version_ {

	public static volatile SingularAttribute<Version, Calendar> date;
	public static volatile SingularAttribute<Version, Document> document;
	public static volatile SingularAttribute<Version, Long> id;
	public static volatile SingularAttribute<Version, Integer> idx;
	public static volatile SingularAttribute<Version, String> url;

}

