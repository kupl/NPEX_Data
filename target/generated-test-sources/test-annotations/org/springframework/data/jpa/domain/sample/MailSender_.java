package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MailSender.class)
public abstract class MailSender_ {

	public static volatile SingularAttribute<MailSender, MailUser> mailUser;
	public static volatile SingularAttribute<MailSender, String> name;
	public static volatile SingularAttribute<MailSender, Long> id;

}

