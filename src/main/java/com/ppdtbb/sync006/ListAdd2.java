package com.ppdtbb.sync006;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * wait、notify方法，wait释放锁，notify不释放锁
 */
public class ListAdd2 {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("aaa");
    }
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {

        final ListAdd2 list2 = new ListAdd2();

        //使用wait和notify的时候，一定要配合着synchronized关键字去使用
        final Object lock = new Object();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized (lock) {
                    for(int i=0;i<10;i++) {
                        list2.add();
                        try {
                            System.out.println("当前线程："+Thread.currentThread().getName()+"添加了一个元素");
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(list2.size()==5) {
                            //lock.notify();
                            countDownLatch.countDown();
                            System.out.println("t2你可以执行了，玩吧！");
                        }
                    }
                //}
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized (lock) {
                    if(list2.size()!=5) {
                        try {
                            //lock.wait();
                            countDownLatch.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知！list2.size is :" + list2.size());
               // }
            }
        }, "t2");

        t2.start();
        t1.start();
    }

}
