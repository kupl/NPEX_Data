package org.springframework.data.jpa.convert.threetenbp;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDateTimeSample is a Querydsl query type for DateTimeSample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDateTimeSample extends EntityPathBase<DateTimeSample> {

    private static final long serialVersionUID = 232503995L;

    public static final QDateTimeSample dateTimeSample = new QDateTimeSample("dateTimeSample");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ComparablePath<org.threeten.bp.Instant> instant = createComparable("instant", org.threeten.bp.Instant.class);

    public final ComparablePath<org.threeten.bp.LocalDate> localDate = createComparable("localDate", org.threeten.bp.LocalDate.class);

    public final ComparablePath<org.threeten.bp.LocalDateTime> localDateTime = createComparable("localDateTime", org.threeten.bp.LocalDateTime.class);

    public final ComparablePath<org.threeten.bp.LocalTime> localTime = createComparable("localTime", org.threeten.bp.LocalTime.class);

    public final SimplePath<org.threeten.bp.ZoneId> zoneId = createSimple("zoneId", org.threeten.bp.ZoneId.class);

    public QDateTimeSample(String variable) {
        super(DateTimeSample.class, forVariable(variable));
    }

    public QDateTimeSample(Path<? extends DateTimeSample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDateTimeSample(PathMetadata metadata) {
        super(DateTimeSample.class, metadata);
    }

}

