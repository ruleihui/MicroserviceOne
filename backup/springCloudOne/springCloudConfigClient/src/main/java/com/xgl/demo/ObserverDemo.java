package com.xgl.demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
 *ObserverDemo
 *
 *@author 87990
 *@email
 *@date 2019/9/23
 */
public class ObserverDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Observable observable = new Observable();
        Method setChanged = observable.getClass().getDeclaredMethod("setChanged");
        //增加订阅者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object value) {
                System.out.println(value);
            }
        });
        setChanged.setAccessible(true);
        setChanged.invoke(observable);
        //发布者通知,订阅者是被动感知的(推模式)
        observable.notifyObservers("Hello,World");
    }

    private static void echoIterator() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {//通过循环,主动获取(拉)
            System.out.println(iterator.next());
        }
    }
}
