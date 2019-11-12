package com.learn.java.Thread;

/**
 * @Created with IDEA
 * @author:longming
 * @Date:2019/6/25
 * @Time:15:45
 */
public class InturrecptTest extends Thread {

    private boolean stopFlag = false;

    public boolean isStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(boolean stopFlag) {
        this.stopFlag = stopFlag;
    }

    @Override
    public void run(){
        super.run();
        for(int i=0; i<500000; i++){
            if(stopFlag) {
                System.out.println("线程已经终止， for循环不再执行");
                break;
            }
            System.out.println("i="+(i+1));
        }
    }
}

class Run {
    public static void main(String args[]){
        InturrecptTest thread = new InturrecptTest();
        thread.start();
        try {
            Thread.sleep(1000);
            thread.stop();
            // thread.setStopFlag(true);
            // thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}