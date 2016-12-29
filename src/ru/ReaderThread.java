package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class ReaderThread extends Thread {
    Integer number;
    private Queue queue;
    ArrayList<Integer> list;

    public ReaderThread(String name, Queue queue, ArrayList<Integer> list) {
        super(name);
        this.list = list;
        this.queue = queue;
        new Thread(this).start();
    }

    @Override
    public void run() {

        synchronized (queue){
            System.out.println(getName() + ", хочет извлечь число.");
            number = queue.getElement();
            while (number == null) {
                System.out.println(getName() + ", ждет пока очередь заполнится.");
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + ", возобновил работу.");
                number = queue.getElement();
            }
            System.out.println(getName() + ", извлек число" + number);
            }
        }


    }

