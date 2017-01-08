package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class ReaderThread extends Thread {
    private Integer number;
    private final Queue queue;


    public ReaderThread(String name, Queue queue) {
        super(name);
        this.queue = queue;
        new Thread(this).start();
    }

    @Override
    public void run() {
        //   synchronized (queue) {
        System.out.println(getName() + ", хочет извлечь число.");
       // number = queue.getElement();
        while (true) {
/*            try {*/
                // System.out.println(isAlive());
                if (number == null) {
                    System.out.println(getName() + ", ждет пока очередь заполнится.");
                  //  Thread.sleep(5000);
//                    wait();
                    //number = queue.getElement();
                } else {
                    System.out.println(getName() + ", извлек число " + number);
                    //Thread.sleep(1000);
                }
                System.out.println(getName() + ", возобновил работу.");
                number = queue.getElement();
/*               } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/

                // }
          //  }
        }
    }
}