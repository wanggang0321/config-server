package com.ppdtbb.thread0820;

public class MyThread extends Thread {

    private int num = 5;

    public void run() {
        num--;
        System.out.println("Thread name is :" + Thread.currentThread().getName() + "，num is：" + num);
    }

    public static void main(String[] args) {
        MyThread th = new MyThread();
        Thread t1 = new Thread(th, "t1");
        Thread t2 = new Thread(th, "t2");
        Thread t3 = new Thread(th, "t3");
        Thread t4 = new Thread(th, "t4");
        Thread t5 = new Thread(th, "t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
