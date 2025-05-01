package com.deatr.xylli.speatr.infra;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Transactional
@Service
public @interface ModifyingMethod {

    @AliasFor(annotation = Transactional.class)
    Propagation propagation() default Propagation.REQUIRED;
}
