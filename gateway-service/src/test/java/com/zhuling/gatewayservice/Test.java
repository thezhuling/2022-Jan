package com.zhuling.gatewayservice;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    private static LinkedBlockingQueue<String> broker = new LinkedBlockingQueue<>();

    static String send(List<String> message) {
        broker.addAll(message);
        return "ok";
    }

    public static void main(String[] args) {
        List<String> message = Arrays.asList("a","b") ;
        String result = send(message);
        if (result.equals("ok")) {
            TimerTask timerTask= new TimerTask() {
                @Override
                public void run() {
                    System.out.print("执行完成");
                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask,2000);
            broker.forEach(x-> broker.remove(x));
        }
        broker.forEach(System.out::println);
    }
}
