package com.blazebit.persistence.testsuite.entity;

import java.util.Locale;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Workflow.class)
public abstract class Workflow_ {

	public static volatile SingularAttribute<Workflow, Locale> defaultLanguage;
	public static volatile SetAttribute<Workflow, Locale> supportedLocales;
	public static volatile MapAttribute<Workflow, Locale, LocalizedEntity> localized;
	public static volatile SingularAttribute<Workflow, Long> id;

}

