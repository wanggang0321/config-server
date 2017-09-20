package com.ppdtbb.thread0920;

/**
 * 使用wait/notify方式实现的线程安全，性能将受到很大影响
 */
public class ConnThreadLocal {

    private ThreadLocal<String> th = new ThreadLocal<String>();

    public void setTh(String value) {
        th.set(value);
    }

    public String getTh() {
        String value = th.get();
        System.out.println(Thread.currentThread().getName() + " 取到的值是：" + value);
        return value;
    }

    public static void main(String[] args) {

        ConnThreadLocal ct = new ConnThreadLocal();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.setTh("张三");
                ct.getTh();
            }
        }, "t1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ct.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t2.start();
    }

}
