package com.ppdtbb.conn007;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    private LinkedList<String> list = new LinkedList<String>();

    private AtomicInteger count = new AtomicInteger();

    private final int minSize = 0;

    private final int maxSize;

    public MyQueue(int size) {
        this.maxSize = size;
    }

    private Object lock = new Object();

    private void put(String str) {
        synchronized (lock) {
            if(count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //1 加入元素
            list.add(str);
            //2 计数器累加
            count.incrementAndGet();
            //3 通知另外一个线程（唤醒）
            lock.notify();
            System.out.println("新加入的元素为：" + str);
        }
    }

    private String take() {
        String str = "";
        synchronized (lock) {
            while(count.get() == this.minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //1 做移除元素操作
            str = list.removeFirst();
            //2 计数器递减
            count.decrementAndGet();
            //3 唤醒另外一个线程
            lock.notify();
        }
        return str;
    }

    private int size() {
        return count.get();
    }

    public static void main(String[] args) {
        MyQueue mq = new MyQueue(5);
        mq.put("a");
        mq.put("b");
        mq.put("c");
        mq.put("d");
        mq.put("e");
        System.out.println("当前容器的长度是：" + mq.size());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mq.put("f");
                mq.put("g");
            }
        }, "t1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String s1 = mq.take();
                System.out.println("移除的元素是：" + s1);
                String s2 = mq.take();
                System.out.println("移除的元素是：" + s2);
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
