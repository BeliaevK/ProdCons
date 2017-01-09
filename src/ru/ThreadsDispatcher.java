package ru;

/**
 * Created by Scala on 28.12.2016.
 */
public class ThreadsDispatcher extends Thread {
    private final Queue queue;


    public ThreadsDispatcher(String name, Queue queue) {
        super(name);
        this.queue = queue;
        new Thread(this).start();
    }

    @Override
    public void run() {
            System.out.println(getName() + ", запущен.");
            while (true) {
                try {
                    queue.checkElement(getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
    }
