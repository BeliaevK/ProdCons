package ru;

/**
 * Created by Scala on 28.12.2016.
 */
public class ReaderThread extends Thread {
    private final Queue queue;

    public ReaderThread(String name, Queue queue) {
        super(name);
        this.queue = queue;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(getName() + ", хочет извлечь число.");
        while (true) {
            try {
                queue.getElement(getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}