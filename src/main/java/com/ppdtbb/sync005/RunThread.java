package com.ppdtbb.sync005;

/**
 * valitale关键字
 */
public class RunThread {

    private volatile boolean flage = true;

    public void setFlage(boolean flage) {
        this.flage = flage;
    }

    private void run() {
        int i = 0;
        while(flage == true) {
            //
//            try {
//                Thread.sleep(600);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            i++;
//            System.out.println("i is :" + i + "flage is :" + flage);
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) {
        final RunThread rt = new RunThread();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                rt.run();
            }
        });
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rt.setFlage(false);
        System.out.println("flage的值设置为了false！");
        System.out.println("flage的值是：" + rt.flage);
    }

}
