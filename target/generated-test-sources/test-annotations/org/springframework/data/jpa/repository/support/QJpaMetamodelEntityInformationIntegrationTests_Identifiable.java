package org.springframework.data.jpa.repository.support;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJpaMetamodelEntityInformationIntegrationTests_Identifiable is a Querydsl query type for Identifiable
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QJpaMetamodelEntityInformationIntegrationTests_Identifiable extends EntityPathBase<JpaMetamodelEntityInformationIntegrationTests.Identifiable> {

    private static final long serialVersionUID = 516556618L;

    public static final QJpaMetamodelEntityInformationIntegrationTests_Identifiable identifiable = new QJpaMetamodelEntityInformationIntegrationTests_Identifiable("identifiable");

    public final NumberPath<Long> feedRunId = createNumber("feedRunId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QJpaMetamodelEntityInformationIntegrationTests_Identifiable(String variable) {
        super(JpaMetamodelEntityInformationIntegrationTests.Identifiable.class, forVariable(variable));
    }

    public QJpaMetamodelEntityInformationIntegrationTests_Identifiable(Path<? extends JpaMetamodelEntityInformationIntegrationTests.Identifiable> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJpaMetamodelEntityInformationIntegrationTests_Identifiable(PathMetadata metadata) {
        super(JpaMetamodelEntityInformationIntegrationTests.Identifiable.class, metadata);
    }

}

