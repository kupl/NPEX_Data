package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MailMessage.class)
public abstract class MailMessage_ {

	public static volatile SingularAttribute<MailMessage, MailSender> mailSender;
	public static volatile SingularAttribute<MailMessage, Long> id;
	public static volatile SingularAttribute<MailMessage, String> content;

}

