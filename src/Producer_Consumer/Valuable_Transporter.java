package Producer_Consumer;

import Domain.Valuable;
import Proxy.Door;
import Proxy.TreasureRoomGuardsman;
import Writer_Reader.AccessManager;
import Writer_Reader.Writer;
import main.Deposit;
import main.Log;
import main.Mine;

import java.util.ArrayList;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Valuable_Transporter implements Runnable, Writer
{
  private Log log;
  private Deposit deposit;
  private ArrayList<Valuable> valuables;
  private int capacity;
//  private Writer writer;
  private TreasureRoomGuardsman guardsman;

//  public Valuable_Transporter(Door door)
//  {
//    valuables=new ArrayList<>();
//    deposit=Deposit.getInstance();
//    log=Log.getInstance();
//    this.door=door;
//  }

  public Valuable_Transporter(TreasureRoomGuardsman guardsman)
  {
    valuables=new ArrayList<>();
    deposit=Deposit.getInstance();
    log=Log.getInstance();
//    this.writer=writer;
    this.guardsman = guardsman;
  }

  @Override public void run()
  {
    Random random=new Random();
    int number= random.nextInt(50);
      try
      {
        System.out.println(number);
        for(int i=0;i<number;i++)
        {
          for (int j = 0; j <= number; j++)
          {
            valuables.add(deposit.takeValuable());
          }
          //here we add the writer part
          System.out.println(valuables);
          while(!valuables.isEmpty()){
//            Writer writer = accessManager.requestWrite();
            guardsman.add(valuables.get(i), this);
            valuables.remove(i);
          }
          sleep(1000);
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }

  @Override public Valuable retrieve(int index, Object object)
  {
    return this.guardsman.retrieve(index, this);
  }

  @Override public int look(Object object)
  {
    return this.guardsman.look(object);
  }

  @Override public void add(Valuable valuable, Object object)
  {
    this.guardsman.add(valuable, object);
  }
}
