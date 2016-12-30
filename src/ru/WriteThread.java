package ru;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Scala on 28.12.2016.
 */
public class WriteThread extends Thread {
    private final Queue queue;
    private Random random = new Random();
    private ArrayList<Integer> list;

    public WriteThread(String name,Queue queue, ArrayList<Integer> list) {
        super(name);
        this.list = list;
        this.queue = queue;
        new Thread(this).start();
    }


    @Override
    public void run() {
        System.out.println(getName() + ", запущен.");
     //   synchronized (queue) {
            while (true) {
                    try {
                        for (int i = 0; i < random.nextInt(5); i++) {
                            queue.setElement(i);
                            System.out.println("Добавлен элемент: " + i + "; " + "Длина массива: " + list.size());
                        }
                      //  queue.wait();
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println("Исключение типа InterruptedException перехвачено");
                    }
           // }
        }
    }
}
