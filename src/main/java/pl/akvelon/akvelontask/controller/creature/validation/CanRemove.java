package pl.akvelon.akvelontask.controller.creature.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = CanRemoveValidator.class
)
public @interface CanRemove {
    String message() default "{javax.validation.constraints.CanRemove.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
