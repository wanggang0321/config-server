package com.ppdtbb.queue001;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class UseQueue {

    public static void main(String[] args) {

//        ConcurrentLinkedDeque<String> q = new ConcurrentLinkedDeque<String>();
//        q.offer("a");
//        q.offer("b");
//        q.offer("c");
//        q.offer("d");
//        q.add("e");
//        System.out.println(q.poll());
//        System.out.println(q.size());
//        System.out.println(q.peek());
//        System.out.println(q.size());

        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<String>(5);

    }

}
