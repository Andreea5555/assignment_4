package main;

import Domain.Valuable;

import java.util.concurrent.ArrayBlockingQueue;

public class Deposit
{

    private static Deposit instance;
    private int capacity;
    private ArrayBlockingQueue<Valuable> jewels;
    private Log logger;

  private Deposit()
  { capacity=70;
    this.logger=Log.getInstance();
    this.jewels=new ArrayBlockingQueue<>(capacity);
  }
  public synchronized static Deposit getInstance(){
    if(instance==null){
      instance=new Deposit();
    }
    return instance;
  }
  public void depositValuable(Valuable valuable) throws InterruptedException
  {
    jewels.put(valuable);
    logger.print("Producer_Consumer.Miner deposits");
  }
  public Valuable takeValuable() throws InterruptedException{
    logger.print("The transporter takes the valuables ");
   return jewels.take();
  }
}
