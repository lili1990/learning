package jobs.annotation;

/**
 * Created by lili19289 on 2016/9/14.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Run a job at specified intervale
 * Example, @Every("1h")
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Every {
    String value();
}
