package org.springframework.data.jpa.domain.sample;

import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SampleWithTimestampVersion.class)
public abstract class SampleWithTimestampVersion_ {

	public static volatile SingularAttribute<SampleWithTimestampVersion, Long> id;
	public static volatile SingularAttribute<SampleWithTimestampVersion, Timestamp> version;

}

