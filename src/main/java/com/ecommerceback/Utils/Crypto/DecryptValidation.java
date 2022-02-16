package com.ecommerceback.Utils.Crypto;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DecryptValidation {
    @Around("@annotation(Decrypt)")
    public Object authorize(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("OIII");
        return joinPoint;
    }

}
