package ru;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Scala on 28.12.2016.
 */
public class WriteThread extends Thread {
    private Queue queue;
    private Random random = new Random();
    private ArrayList<Integer> list;
    private int count;

    public WriteThread(String name,Queue queue, ArrayList<Integer> list) {
        super(name);
        this.list = list;
        this.queue = queue;
        new Thread(this).start();
    }


    @Override
    public void run() {
            while (true) {
                try {
                    for (int i = 0; i < random.nextInt(5); i++) {
                        count++;
                       // list.add(count);
                        queue.setElement(count);
                        System.out.println("Добавлен элемент: " + count + "; " + "Длина массива: " + list.size());
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Исключение типа InterruptedException перехвачено");
                }
            }
    }
}
