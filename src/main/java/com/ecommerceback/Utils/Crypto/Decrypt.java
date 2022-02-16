package com.ecommerceback.Utils.Crypto;


import com.ecommerceback.Utils.ValidCPF.CpfValidator;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Decrypt {
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
