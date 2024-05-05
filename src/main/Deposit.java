package main;

import Domain.Valuable;

import java.util.concurrent.ArrayBlockingQueue;

public class Deposit {
    private static Deposit instance;
    private int capacity;
    private ArrayBlockingQueue<Valuable> jewels;
    private Log logger;

    private Deposit() {
        capacity = 70;
        this.logger = Log.getInstance();
        this.jewels = new ArrayBlockingQueue<>(capacity);
    }

    public static Deposit getInstance() {
        if (instance == null) {
            instance = new Deposit();
        }
        return instance;
    }

    public synchronized void depositValuable(Valuable valuable) throws InterruptedException {
        jewels.put(valuable);
        logger.print("Producer_Consumer.Miner deposits");
    }

    public synchronized Valuable takeValuable() throws InterruptedException {
        logger.print("The transporter takes the valuables ");
        return jewels.take();
    }

    public synchronized int getSize() throws InterruptedException {
        return jewels.size();
    }

    public synchronized Valuable[] takeValuables(int number) {
        Valuable[] valuables = new Valuable[number];
        for (int i = 0; i < number; i++) {
            try {
                valuables[i] = jewels.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return valuables;
    }
}
