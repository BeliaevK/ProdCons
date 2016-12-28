package ru;

import java.util.Random;

/**
 * Created by Scala on 28.12.2016.
 */
public class WriteThread implements Runnable {
    private Thread thread;
    private Queue queue;
    private Random random = new Random();

    public WriteThread(Queue queue) {
        this.queue = queue;
        new Thread(this,"Заполнитель").start();
    }

    @Override
    public void run() {

        while (true){
            while (true){
                try {
                    for (int i = 0; i < 4; i++) {
                    queue.setElement(i);
                    }
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Исключение типа InterruptedException перехвачено");
                }
            }
        }
    }
}
