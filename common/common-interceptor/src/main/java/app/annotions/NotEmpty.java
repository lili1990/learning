package app.annotions;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * Created by lili1990 on 17/3/7.
 */
@Documented
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface NotEmpty {
}
