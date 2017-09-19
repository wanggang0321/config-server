package com.ppdtbb.thread0919;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    //初始化一个容器
    private List<String> list = new LinkedList<String>();

    //初始化一个计数器
    private AtomicInteger ai = new AtomicInteger(0);

    //最小长度
    private int minLength = 0;

    //最大长度
    private int maxLength;

    //声明一个锁
    Object lock = new Object();

    public MyQueue(int size) {
        this.maxLength = size;
    }

    public void add(String value) {

        synchronized (lock) {

            while (list.size()==maxLength) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.add(value);

            ai.incrementAndGet();

            lock.notify();

            System.out.println("新加入的元素：" + value);
        }
    }

    public String take() {

        String retValue = "";

        synchronized (lock) {
            while (list.size()==minLength) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            retValue = list.remove(0);

            ai.decrementAndGet();

            lock.notify();

            System.out.println("被移除的元素：" + retValue);
        }

        return retValue;
    }

    public int getSize() {
        return this.ai.get();
    }

    public static void main(String[] args) {

        MyQueue mq = new MyQueue(5);
        mq.add("1");
        mq.add("2");
        mq.add("3");
        mq.add("4");

        System.out.println("当前容器的长度：" + mq.getSize());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mq.add("5");
                mq.add("6");
            }
        }, "t1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String value = mq.take();
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 取出来的值：" + value);
                String value2 = mq.take();
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 取出来的值：" + value2);
            }
        }, "t2");

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }

}
