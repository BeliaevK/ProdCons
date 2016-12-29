package ru;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Scala on 28.12.2016.
 */
public class WriteThread extends Thread {
    private Queue queue;
    private Random random = new Random();
    ArrayList<Integer> list;

    public WriteThread(String name,Queue queue, ArrayList<Integer> list) {
        super(name);
        this.list = list;
        this.queue = queue;
        new Thread(this).start();
    }


    @Override
    public void run() {

        while (true){
            while (true){
                try {
                    for (int i = 0; i < 4; i++) {
                    queue.setElement(i);
                        System.out.println("Добавлен элемент: " + i +"; " + "Длина массива: " + list.size());
                    }
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Исключение типа InterruptedException перехвачено");
                }
            }
        }
    }
}
