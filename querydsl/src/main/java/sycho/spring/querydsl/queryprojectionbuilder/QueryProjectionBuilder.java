package sycho.spring.querydsl.queryprojectionbuilder;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Target({CONSTRUCTOR, TYPE})
@Retention(SOURCE)
public @interface QueryProjectionBuilder {
}
