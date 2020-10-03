package com.blazebit.persistence.testsuite.entity;

import java.sql.Blob;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BlobEntity.class)
public abstract class BlobEntity_ extends com.blazebit.persistence.testsuite.entity.LongSequenceEntity_ {

	public static volatile SingularAttribute<BlobEntity, Blob> blob;
	public static volatile SingularAttribute<BlobEntity, String> name;
	public static volatile SingularAttribute<BlobEntity, Date> lastModified;
	public static volatile SingularAttribute<BlobEntity, Long> version;

}

