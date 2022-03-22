package com.zhuling.person.factory;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/**
 * 并发测试工厂+ 单例
 */
public class SingletonFactoryTest {
    public static void main(String[] args) throws InterruptedException {
        SenderFactory emailSenderFactory = SenderFactoryManage.getSenderFactory(EmailSenderFactory.class);
        SenderFactory smsSenderFactory = SenderFactoryManage.getSenderFactory(SmsSenderFactory.class);
        Runnable taskTemp = () -> {
            Sender emailSender = Objects.requireNonNull(emailSenderFactory).getSender();
            Sender smsSender = Objects.requireNonNull(smsSenderFactory).getSender();
            System.out.println(emailSender);
            System.out.println(smsSender);
        };

        SingletonFactoryTest singletonFactoryTest = new SingletonFactoryTest();
        long time = singletonFactoryTest.startTaskAllInOnce(200, taskTemp);
        System.out.println("speedTime:" + time);
    }


    public long startTaskAllInOnce(int threadNums, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNums);
        for (int i = 0; i < threadNums; i++) {
            Thread t = new Thread(() -> {
                try {
                    // 使线程在此等待，当开始门打开时，一起涌入门中
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        // 将结束门减1，减到0时，就可以开启结束门了
                        endGate.countDown();
                    }
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            });
            t.start();
        }
        long startTime = System.nanoTime();
        System.out.println(startTime + " [" + Thread.currentThread() + "] All thread is ready, concurrent going...");
        // 因开启门只需一个开关，所以立马就开启开始门
        startGate.countDown();
        // 等等结束门开启
        endGate.await();
        long endTime = System.nanoTime();
        System.out.println(endTime + " [" + Thread.currentThread() + "] All thread is completed.");
        return endTime - startTime;
    }
}
