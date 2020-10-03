package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditableUser.class)
public abstract class AuditableUser_ extends org.springframework.data.jpa.domain.AbstractAuditable_ {

	public static volatile SingularAttribute<AuditableUser, String> firstname;
	public static volatile SetAttribute<AuditableUser, AuditableRole> roles;

}

