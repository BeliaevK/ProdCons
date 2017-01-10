package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class Queue {
    private ArrayList<Integer> list;
    private boolean valueSet =  false;

    public Queue(ArrayList<Integer> list) {
        this.list = list;
    }

    public void setElement(Integer element){
        list.add(element);
    }

    synchronized void checkElement (String name) throws InterruptedException {
        while (!valueSet)
            try {
                if (list.get(0) != null) {
                    Thread.sleep(1000);
                    valueSet = true;
                    notifyAll();
                    wait();
                } else Thread.sleep(1000);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(name + ", ждет пока очередь заполнится.");
                valueSet = true;
             //   System.out.println(name + ", до notify");
                notifyAll();
            //    System.out.println(name + ", после notify");
            //    System.out.println(name + ", до wait");
                wait();
           //     System.out.println(name + ", после wait");
            }
    }

    synchronized void getElement(String name) throws InterruptedException {
        while (valueSet) {
            try {
            if (list.size() > 0) {
                System.out.println(name + ", возобновил  работу.");
                System.out.println(name + ", извлек число " + list.remove(0));
              //  System.out.println(name + ", до notify");
                notifyAll();
              //  System.out.println(name + ", после notify");
              //  System.out.println(name + ", до wait");
                wait();
               // System.out.println(name + ", после wait");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(name + ", ждет пока очередь заполнится.");
                valueSet = false;
              //  System.out.println(name + ", до notify");
                notify();
               // System.out.println(name + ", после notify");
               // System.out.println(name + ", до wait");
                wait();
                //System.out.println(name + ", после wait");
            }
        }
    }
}

