package ru;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scala on 28.12.2016.
 */
public class ThreadsDispatcher extends Thread {
    private ArrayList<Integer> list;
    private final Queue queue;
   // Thread.State ts = ReaderThread.currentThread().getState();


    public ThreadsDispatcher(String name, Queue queue, ArrayList<Integer> list) {
        super(name);
        this.queue = queue;
        this.list = list;
        new Thread(this).start();
    }

    @Override
    public void run() {
      // synchronized (queue) {
            System.out.println(getName() + ", запущен.");
            while (true) {
                //System.out.println(ts);
                //if(ts == Thread.State.RUNNABLE )
                    if (list.size() > 0) {
                        queue.checkElement();
                    }
/*                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }

      // }
    }
}
