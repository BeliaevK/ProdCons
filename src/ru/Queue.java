package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class Queue {
    private ArrayList<Integer> list;

    public Queue(ArrayList<Integer> list) {
        this.list = list;
    }

    public void setElement(Integer element){
        list.add(element);
    }

    public Integer getElement() {
        if (list.size() > 0){
            return list.remove(0);
        }
        return null;
    }
}
