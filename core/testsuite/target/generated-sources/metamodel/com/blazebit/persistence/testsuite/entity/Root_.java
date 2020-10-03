package com.blazebit.persistence.testsuite.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Root.class)
public abstract class Root_ {

	public static volatile ListAttribute<Root, IndexedNode> indexedNodesMany;
	public static volatile ListAttribute<Root, IndexedEmbeddable> indexedNodesElementCollection;
	public static volatile MapAttribute<Root, String, KeyedNode> keyedNodesMany;
	public static volatile MapAttribute<Root, String, KeyedNode> keyedNodesManyDuplicate;
	public static volatile ListAttribute<Root, IndexedNode> indexedNodes;
	public static volatile SingularAttribute<Root, String> name;
	public static volatile ListAttribute<Root, IndexedNode> indexedNodesManyDuplicate;
	public static volatile MapAttribute<Root, String, KeyedNode> keyedNodes;
	public static volatile SingularAttribute<Root, Integer> id;
	public static volatile MapAttribute<Root, String, KeyedEmbeddable> keyedNodesElementCollection;

}

