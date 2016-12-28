package ru;

import java.util.Random;

/**
 * Created by Scala on 28.12.2016.
 */
public class ReaderThread implements Runnable {
    private Queue queue;
    private boolean run;
    private Random random = new Random();

    public ReaderThread(Queue queue) {
        this.queue = queue;
        new Thread(this,"Заполнитель").start();
    }

    @Override
    public void run() {

    }
}
