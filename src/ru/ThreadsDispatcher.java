package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class ThreadsDispatcher extends Thread  {
    private ArrayList<Integer> list;
    private final Queue queue;

    public ThreadsDispatcher(String name, Queue queue, ArrayList<Integer> list) {
        super(name);
        this.queue = queue;
        this.list = list;
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (queue) {
            System.out.println(getName() + ", запущен.");
            try {
            while (true) {
                if (list.size() > 0) {
                    queue.notifyAll();
                    System.out.println("Я тут!!!!!!!");
                    Thread.sleep(1000);
                   // System.out.println(isAlive());
                }else {
                    Thread.sleep(1000);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
}
