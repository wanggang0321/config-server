package com.ppdtbb.thread0916;

/**
 * 当一个对象被当作锁时，这个对象内的属性发生变化不会影响锁的使用
 */
public class ModifyLock {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public synchronized void changeAttribute(String name, int age) {
        try {

            System.out.println("当前线程 ：" + Thread.currentThread().getName() + " 开始");
            this.setName(name);
            this.setAge(age);
            System.out.println(Thread.currentThread().getName() + " name is : " + this.getName()
                    + " age is : " + this.getAge());

            Thread.sleep(2000);
            System.out.println("当前线程 ：" + Thread.currentThread().getName() + " 结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        final ModifyLock mdl = new ModifyLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mdl.changeAttribute("张三", 20);
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mdl.changeAttribute("张三", 20);
            }
        }, "t2");

        t1.start();
        t2.start();
    }

}
