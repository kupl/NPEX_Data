package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(VersionedUser.class)
public abstract class VersionedUser_ {

	public static volatile SingularAttribute<VersionedUser, Long> id;
	public static volatile SingularAttribute<VersionedUser, Long> version;

}

