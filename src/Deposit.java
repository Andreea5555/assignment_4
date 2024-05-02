import Domain.Valuable;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Deposit
{

    private static Deposit instance;
    private int capacity;
    private ArrayBlockingQueue<Valuable> jewels;

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
  }
  public Valuable takeValuable() throws InterruptedException{
   return jewels.take();
  }
}
