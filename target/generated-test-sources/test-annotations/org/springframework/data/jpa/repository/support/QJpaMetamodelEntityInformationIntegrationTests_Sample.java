package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaMetamodelEntityInformationIntegrationTests_Sample is a Querydsl query type for Sample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJpaMetamodelEntityInformationIntegrationTests_Sample extends EntityPathBase<JpaMetamodelEntityInformationIntegrationTests.Sample> {

    private static final long serialVersionUID = 929832350L;

    public static final QJpaMetamodelEntityInformationIntegrationTests_Sample sample = new QJpaMetamodelEntityInformationIntegrationTests_Sample("sample");

    public final QJpaMetamodelEntityInformationIntegrationTests_Identifiable _super = new QJpaMetamodelEntityInformationIntegrationTests_Identifiable(this);

    //inherited
    public final NumberPath<Long> feedRunId = _super.feedRunId;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public QJpaMetamodelEntityInformationIntegrationTests_Sample(String variable) {
        super(JpaMetamodelEntityInformationIntegrationTests.Sample.class, forVariable(variable));
    }

    public QJpaMetamodelEntityInformationIntegrationTests_Sample(Path<? extends JpaMetamodelEntityInformationIntegrationTests.Sample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaMetamodelEntityInformationIntegrationTests_Sample(PathMetadata metadata) {
        super(JpaMetamodelEntityInformationIntegrationTests.Sample.class, metadata);
    }

}

