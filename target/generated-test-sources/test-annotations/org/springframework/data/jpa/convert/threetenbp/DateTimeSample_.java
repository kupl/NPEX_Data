package org.springframework.data.jpa.convert.threetenbp;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;

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

