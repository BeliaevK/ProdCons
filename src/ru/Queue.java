package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class Queue {
    private ArrayList<Integer> list;
    private boolean valueSet =  false;
    Integer element;

    public Queue(ArrayList<Integer> list) {
        this.list = list;
    }

    public void setElement(Integer element){
        this.element = element;
        list.add(element);
    }

    synchronized void checkElement (){
        while (!valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Исключение типа InterruptedException перехвачено");
            }

            valueSet = true;
            notifyAll();
    }

    synchronized Integer getElement() {
        while (valueSet)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Исключение типа InterruptedException перехвачено");
            }
        valueSet = false;
        notifyAll();
        if (list.size() > 0){
            try {
                return list.remove(0);
            }catch (IndexOutOfBoundsException e){
                System.out.println("Нет такой позиции");
            }
        }
        return null;
    }
}
