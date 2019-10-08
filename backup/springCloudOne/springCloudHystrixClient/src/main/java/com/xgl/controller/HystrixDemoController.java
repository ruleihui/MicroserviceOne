package com.xgl.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/*
 *HystrixDemoController
 *
 *@author 87990
 *@email
 *@date 2019/10/2
 */
@RestController
public class HystrixDemoController {

    @GetMapping("hello2")
    public String hello2() {
        return new HelloWorldCommand().execute();
    }

    /**
     * 编程的方式
     */
    private class HelloWorldCommand extends com.netflix.hystrix.HystrixCommand<String> {

        public HelloWorldCommand() {
            super(HystrixCommandGroupKey.Factory.asKey("hello,world"),
                    100);
        }

        @Override
        protected String run() throws Exception {
            int value = RandomUtils.nextInt(200);
            System.out.println("hello() costMS:" + value);
            Thread.sleep(value);
            return "hello";
        }

        @Override
        protected String getFallback() {
            return HystrixDemoController.this.errorContent();
        }
    }

    /**
     * 当{@link #hello()}方法调用超时或者失败,fallback方法{@link #errorContent()}
     * 作为替代返回
     *
     * @return
     */
    @GetMapping("hello")
    @HystrixCommand(fallbackMethod = "errorContent",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                    , value = "100")})
    public String hello() throws InterruptedException {
        //如果随机值大于100 则触发容错

        int value = RandomUtils.nextInt(200);
        System.out.println("hello() costMS:" + value);
        Thread.sleep(value);
        return "hello";
    }

    public String errorContent() {

        return "fault";
    }

    public static void main(String[] args) {
        System.out.println(RandomUtils.nextInt(200));
    }
}
