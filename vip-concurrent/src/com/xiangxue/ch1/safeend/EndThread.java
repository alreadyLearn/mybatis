package com.xiangxue.ch1.safeend;

public class EndThread {
    private static class UseThread extends Thread{
        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threaname = Thread.currentThread().getName();
            while (!isInterrupted()){
                System.out.println(threaname+"is run");
            }
            System.out.println(threaname+"interrupt flag is "+ isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.setDaemon(true);
        endThread.start();
        Thread.sleep(20);
        
        endThread.interrupt();
    }
}