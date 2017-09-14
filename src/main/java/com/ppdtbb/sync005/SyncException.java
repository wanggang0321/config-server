package com.ppdtbb.sync005;

public class SyncException {

    private void print(){
        int i = 0;
        while (true) {
            try {
                i++;
                Thread.sleep(500);
                System.out.println(i);
                if (i == 3) {
                    Integer.parseInt("a");
                }
                //Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                //throw new RuntimeException();
                //continue;
            }
        }
    }

    public static void main(String[] args) {
        final SyncException sync = new SyncException();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                //try {
                    sync.print();
                //} catch (Exception e) {
                //    e.printStackTrace();
                //}
            }
        }, "t1");

        thread.start();
    }

}
