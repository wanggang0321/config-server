package com.ppdtbb.thread0920;

/**
 * 饿汉式单例
 *
 * http://blog.csdn.net/jason0539/article/details/23297037/
 */
public class Singleton1 {

    private Singleton1() {

    }

    private static final Singleton1 single = new Singleton1();

    //静态工厂方法
    public static Singleton1 getInstance() {
        return single;
    }

}
