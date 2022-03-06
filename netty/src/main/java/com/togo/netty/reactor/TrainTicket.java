package com.togo.netty.reactor;

/**
 * @author : taiyn
 * Date    : 2021/3/25
 * Time    : 8:26 下午
 * ---------------------------------------
 * Desc    :
 */
public class TrainTicket implements Runnable {

    private int trainTicketNum = 10;

    public int getTrainTicketNum() {
        return trainTicketNum;
    }

    @Override
    public void run() {
        if (trainTicketNum > 0) {
            System.out.println(Thread.currentThread().getName() + " sold " + trainTicketNum--);
        }
    }

    public static void main(String[] args) {

        TrainTicket trainTicket = new TrainTicket();
        int i = 0;
        while (trainTicket.getTrainTicketNum() > 1) {
            new Thread(trainTicket, i++ + "").start();
            new Thread(trainTicket, i++ + "").start();
            new Thread(trainTicket, i++ + "").start();
            new Thread(trainTicket, i++ + "").start();
        }
    }
}
