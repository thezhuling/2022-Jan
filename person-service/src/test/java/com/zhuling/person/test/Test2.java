package com.zhuling.person.test;

public class Test2 {
    private static int num = 0;
    private final static Object lock = new Object();


    public static void main(String[] args) {
        new Thread(new TurningRunner(), "A").start();
        new Thread(new TurningRunner(), "B").start();
    }

    static class TurningRunner implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            while (num < 100) {
                synchronized (lock) {
                    System.out.println("线程" + Thread.currentThread().getName() + ":" + num++);
                    lock.notify();
                    if (num <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
    }
}
