package ru;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scala on 28.12.2016.
 */
public class Queue {
    private List<Integer> list;

    public Queue() {
        list = new  ArrayList<Integer>();
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
