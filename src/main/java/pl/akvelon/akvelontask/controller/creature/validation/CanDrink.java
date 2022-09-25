package pl.akvelon.akvelontask.controller.creature.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = CanDrinkValidator.class
)
public @interface CanDrink {
    String message() default "{javax.validation.constraints.CanDrink.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
