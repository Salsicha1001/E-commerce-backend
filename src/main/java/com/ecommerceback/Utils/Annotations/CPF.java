package com.ecommerceback.Utils.Annotations;

import com.ecommerceback.Model.Util.CpfValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CPF {

    String message() default "CPF Inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
