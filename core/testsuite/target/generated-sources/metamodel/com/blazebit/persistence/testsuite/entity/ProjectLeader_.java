package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProjectLeader.class)
public abstract class ProjectLeader_ {

	public static volatile SetAttribute<ProjectLeader, Project> leadedProjects;
	public static volatile SingularAttribute<ProjectLeader, String> name;
	public static volatile SingularAttribute<ProjectLeader, Long> id;
	public static volatile SingularAttribute<ProjectLeader, Project> currentProject;

}

