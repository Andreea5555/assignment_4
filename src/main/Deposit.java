package main;

import Domain.Valuable;

import java.util.concurrent.ArrayBlockingQueue;

public class Deposit
{

    private static Deposit instance;
    private int capacity;
    private ArrayBlockingQueue<Valuable> jewels;
    private Log logger;

  private Deposit( int capacity)
  {
    this.capacity = capacity;
    this.jewels=new ArrayBlockingQueue<>(capacity);
  }
  public synchronized static Deposit getInstance(int capacity){
    if(instance==null){
      instance=new Deposit(capacity);
    }
    return instance;
  }
  public void depositValuable(Valuable valuable) throws InterruptedException
  {
    jewels.put(valuable);
    logger.print("Producer_Consumer.Miner deposits valuables or waits if the deposit is full");
  }
  public Valuable takeValuable() throws InterruptedException{
    logger.print("The transporter takes the valuables into the list or waits if there is not enough");
   return jewels.take();
  }
}
