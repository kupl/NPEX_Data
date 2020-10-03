package org.springframework.data.jpa.domain.sample;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IdClassExampleEmployee.class)
public abstract class IdClassExampleEmployee_ {

	public static volatile SingularAttribute<IdClassExampleEmployee, Long> empId;
	public static volatile SingularAttribute<IdClassExampleEmployee, String> name;
	public static volatile SingularAttribute<IdClassExampleEmployee, IdClassExampleDepartment> department;

}

