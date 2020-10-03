package org.springframework.data.jpa.convert.threeten;

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

    private static final long serialVersionUID = 185838153L;

    public static final QDateTimeSample dateTimeSample = new QDateTimeSample("dateTimeSample");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.Instant> instant = createDateTime("instant", java.time.Instant.class);

    public final DatePath<java.time.LocalDate> localDate = createDate("localDate", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> localDateTime = createDateTime("localDateTime", java.time.LocalDateTime.class);

    public final TimePath<java.time.LocalTime> localTime = createTime("localTime", java.time.LocalTime.class);

    public final SimplePath<java.time.ZoneId> zoneId = createSimple("zoneId", java.time.ZoneId.class);

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

