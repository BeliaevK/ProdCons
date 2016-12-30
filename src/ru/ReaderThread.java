package ru;

/**
 * Created by Scala on 28.12.2016.
 */
public class ReaderThread extends Thread {

    private Integer number;
    private int position;
    private final Queue queue;



    public ReaderThread(String name, Queue queue,int position) {
        super(name);
        this.queue = queue;
        this.position = position;
        new Thread(this).start();
    }

    @Override
    public void run() {
       synchronized (queue){
            System.out.println(getName() + ", хочет извлечь число.");
            number = queue.getElement(position);
            while (true){
                //System.out.println(isAlive());
                if (number == null) {
                System.out.println(getName() + ", ждет пока очередь заполнится.");
                    try {
                        //queue.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }else {
                System.out.println(getName() + ", извлек число: " + number);
            }
                System.out.println(getName() + ", возобновил работу.");
                number = queue.getElement(position);
            }
            }
        }
    }

