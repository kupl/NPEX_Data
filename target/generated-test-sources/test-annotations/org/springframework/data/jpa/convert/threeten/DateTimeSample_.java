package org.springframework.data.jpa.convert.threeten;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DateTimeSample.class)
public abstract class DateTimeSample_ {

	public static volatile SingularAttribute<DateTimeSample, LocalDateTime> localDateTime;
	public static volatile SingularAttribute<DateTimeSample, LocalTime> localTime;
	public static volatile SingularAttribute<DateTimeSample, ZoneId> zoneId;
	public static volatile SingularAttribute<DateTimeSample, Long> id;
	public static volatile SingularAttribute<DateTimeSample, LocalDate> localDate;
	public static volatile SingularAttribute<DateTimeSample, Instant> instant;

}

