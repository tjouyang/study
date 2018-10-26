package com.ouyang.think_in_java4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnno {

    byte byteValue() default 0;
    short shortValue() default 0;
    int intValue() default 0;
    long longValue() default 0;
    char charValue() default 0;
    float floatValue() default 0.0f;
    double doubleValue() default 0.0;
    boolean boolValue() default false;

    Class classValue() default Object.class;
    InnerEnum enumValue() default InnerEnum.INNER;
    InnerAnno annoValue() default @InnerAnno;

    InnerEnum[] enumsValue() default {};
    int[] intsValue() default {}; // 省略其他数组...

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.SOURCE)
    @interface InnerAnno{}

    enum InnerEnum{
        INNER, OUTTER
    }
}


