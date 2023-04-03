package main.java.com.dong.chap12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleAnnotation {
    String sampleString() default "";
    int sampleInt() default 1;
}
