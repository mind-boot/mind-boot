package com.mind.core;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.*;

/**
 * mind-boot应用
 *
 * @author caoyong
 * @version 1.0.0
 * @since 2019-06-26 10:28
 **/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
public @interface MindBootApplication {

}
