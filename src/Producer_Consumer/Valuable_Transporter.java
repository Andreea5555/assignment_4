package Producer_Consumer;

import Domain.Valuable;
import Proxy.Door;
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
  private Door door;

  public Valuable_Transporter(Door door)
  {
    valuables=new ArrayList<>();
    deposit=Deposit.getInstance();
    log=Log.getInstance();
    this.door=door;
  }

  @Override public void run()
  {
    Random random=new Random();
    int number= random.nextInt(50);
      try
      {
        for(int i=0;i<number;i++)
        {
          for (int j = 0; j <= number; j++)
          {
            valuables.add(deposit.takeValuable());
          }
          //here we should add the writer part
          while(!valuables.isEmpty()){
            var treasureRoom = door.requestWrite();
            treasureRoom.add(valuables.get(i), this);
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
  }
