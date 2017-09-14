package com.ppdtbb.thread0914;

/**
 * synchronized锁重入
 */
public class SyncDubbo1 {

    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " method1..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " method2..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method3();
    }

    public synchronized void method3() {
        System.out.println(Thread.currentThread().getName() + " method3..");
    }

    public static void main(String[] args) {

        SyncDubbo1 sd = new SyncDubbo1();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                sd.method1();
            }
        }, "m1");

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                sd.method2();
            }
        }, "m2");

        t1.start();
        t2.start();
    }

}
