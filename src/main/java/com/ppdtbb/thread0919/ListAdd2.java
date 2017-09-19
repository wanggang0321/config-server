package com.ppdtbb.thread0919;

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

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    for(int i=0;i<10;i++) {
                        list2.add();
                        System.out.println("当前线程：" + Thread.currentThread().getName() + " 添加了一个元素！");

                        Thread.sleep(500);

                        if(list2.size()==5) {
                            System.out.println("发出通知");
                            countDownLatch.countDown();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(list.size()!=5) {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止...");
                    throw new RuntimeException();
                }
            }
        }, "t2");

        t2.start();
        t1.start();
    }

}
