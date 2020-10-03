package org.springframework.data.jpa.domain.sample;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> firstname;
	public static volatile SingularAttribute<User, Address> address;
	public static volatile SingularAttribute<User, User> manager;
	public static volatile SetAttribute<User, Role> roles;
	public static volatile SingularAttribute<User, Boolean> active;
	public static volatile SingularAttribute<User, Date> dateOfBirth;
	public static volatile SingularAttribute<User, String> lastname;
	public static volatile SingularAttribute<User, Date> createdAt;
	public static volatile SingularAttribute<User, String> emailAddress;
	public static volatile SingularAttribute<User, byte[]> binaryData;
	public static volatile SetAttribute<User, User> colleagues;
	public static volatile SetAttribute<User, String> attributes;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, Integer> age;

}

