package ru;

import java.util.ArrayList;

/**
 * Created by Scala on 28.12.2016.
 */
public class PC {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue queue = new Queue(list);
        new WriteThread("Заполняющий поток",queue,list);
        new ReaderThread("Забирающий поток-1",queue,list);
        new ReaderThread("Забирающий поток-2",queue,list);
        new ReaderThread("Забирающий поток-3",queue,list);
        new ThreadsDispatcher("Проверяющий поток",queue,list);
    }
}
   /* Техническое задание.
       + Создать коллекцию объектов(на ваш выбор).
       + Реализовать поток который с периодичностью 2-5 секунд добавляет в коллекцию N объектов.(выводить сообщение о добавлении в консоль)
       + Реализовать ReaderThread забирающий из определенной ячейки коллекции объект при этом его удаляя, когда ячейка null вызываем у потока wait(). Поток должен выводить в консоль информацию об извлеченном объекте.
       + Запустить 3 потока ReaderThread в группе потоков которые следят за первыми тремя ячейками коллекции.
        Создать ThreadsDispatcher который периодически проверяет наличие объектов в коллекции и при их возникновении вызывает notifyAll() потоков ReaderThread. (также выводить в консоль о пробуждении потоков)
*/