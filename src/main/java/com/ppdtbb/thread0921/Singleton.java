package com.ppdtbb.thread0921;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * 懒汉式
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(null==singleton) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        }, "t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Singleton.getInstance().hashCode());
            }
        }, "t3");

        t1.start();
        t2.start();
        t3.start();
    }

}
