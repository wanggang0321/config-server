package com.ppdtbb.thread0912;

/**
 * 同步和异步
 */
public class MyObject {

    public synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * method2没有添加关键字synchronized，这时我们就说method1和method2是异步的
     * 如果method2加上了synchronized关键字，这时我们就说method1和method2是同步的
     */
    public void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        final MyObject mo = new MyObject();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                mo.method1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                mo.method2();
            }
        });

        t1.start();
        t2.start();
    }

}
