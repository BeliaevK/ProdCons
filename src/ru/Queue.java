package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class Queue {
    private ArrayList<Integer> list;
    private boolean valueSet =  false;
    private Integer element;
    private Integer number;

    public Queue(ArrayList<Integer> list) {
        this.list = list;
    }

    public void setElement(Integer element){
        this.element = element;
        list.add(element);
    }

    synchronized void checkElement (String name) throws InterruptedException {
        while (!valueSet)
            try {
                if (list.get(0) != null) {
                    valueSet = true;
                    notify();
                   // wait();
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(name + ", ждет пока очередь заполнится.");
                valueSet = true;
                wait();
                notify();
            }
    }

    synchronized void getElement(String name) throws InterruptedException {
        while (valueSet) {
            try {
            if (list.get(0) == null){
                System.out.println(name + ", ждет пока очередь заполнится>>>.");
                valueSet = false;
                notify();
                wait();
            }
            if (list.size() > 0) {
                System.out.println(name + ", возобновил работу.");
                System.out.println(name + ", извлек число " + list.remove(0));
                //valueSet = false;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(name + ", ждет пока очередь заполнится.");
                valueSet = false;
                wait();
                notify();

            }
        }
    }
}

