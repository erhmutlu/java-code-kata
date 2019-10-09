package org.erhmutlu.kata;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeap {

    public static void main(String[] args) {
        Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(400);
        priorityQueue.add(20);

        System.out.println("Head value using peek function:" + priorityQueue.peek());
    }

}
