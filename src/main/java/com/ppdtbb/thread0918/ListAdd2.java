package com.ppdtbb.thread0918;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ListAdd2 {

    private volatile static List list = new ArrayList();

    public void add() {
        list.add("bjsxt");
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        final ListAdd2 list2 = new ListAdd2();

        //1 实例化出来一个lock
        //当使用wait 和 nofity 的时候，一定要配合着synchronized关键字去使用

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++) {
                    try {
                        list2.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加了一个元素...");
                        Thread.sleep(500);
                        if(list2.size()==5) {
                            System.out.println("已经发出通知....");
                            countDownLatch.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(list2.size()!=5) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程：");
                }
            }
        }, "t2");

        t2.start();
        t1.start();
    }

}
