package com.tim.springEL;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Admin on 2017/3/7.
 */
public class ELMain {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig resourceService = context.getBean(ELConfig.class);
        resourceService.outputResource();
        context.close();
    }
}
