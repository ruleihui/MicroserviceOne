package com.xgl.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 *SpringEventListenerDemo
 *
 *@author 87990
 *@email
 *@date 2019/9/23
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        //Annotation驱动Spring上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册监听器
        context.addApplicationListener(new ApplicationListener<CustomApplicationEvent>() {
            @Override//监听器得到事件
            public void onApplicationEvent(CustomApplicationEvent event) {
                System.out.println(event.getSource());
            }
        });

        context.refresh();
        //发布事件
        context.publishEvent(new CustomApplicationEvent("Hello,World"));
    }

    private static class CustomApplicationEvent extends ApplicationEvent {

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public CustomApplicationEvent(Object source) {
            super(source);
        }
    }
}
