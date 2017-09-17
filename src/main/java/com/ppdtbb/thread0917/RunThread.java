package com.ppdtbb.thread0917;

public class RunThread {

    /**
     * 1. 如果不使用volatile关键字，在子线程运行期间主线程修改属性值，不会对子线程产生影响，原因是子线程有自己独立的内存空间，其中有主内存中的变量副本
     * 2. isRunning变量如果被volatile关键字修饰，则当变量改变时强制线程执行引擎去主内存中读取
     */
    /** volatile */
    private static volatile boolean isRunning = true;

    public void runRun() {

        System.out.println("Thread is running!");
        while(isRunning) {

        }
        System.out.println("Thread is stopped!");


    }

    public static void main(String[] args) {
        RunThread rt = new RunThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                rt.runRun();
            }
        });

        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isRunning = false;
        System.out.println("isRunning 设置为了false！");
    }

}
