package ru;

import java.util.List;

/**
 * Created by Scala on 28.12.2016.
 */
public class ThreadsDispatcher implements Runnable  {
    private List<Integer> list;

    public ThreadsDispatcher(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true)

        if (list.size() < 0){

        }

    }
}
