package com.ppdtbb.thread0924;

public class Outer {

    static {
        System.out.println("load outer class......");
    }

    static class Inner {

        static {
            System.out.println("load inner class......");
        }

        static void innerPrint() {
            System.out.println("I am inner method......");
        }

    }

    public static void main(String[] args) {

        Outer outer = new Outer();
        System.out.println("===================分隔线===================");

        Outer.Inner.innerPrint();
    }

}
