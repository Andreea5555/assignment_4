package Producer_Consumer;

import Domain.Valuable;
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

  public Valuable_Transporter()
  {
    valuables=new ArrayList<>();
    deposit=Deposit.getInstance();
    log=Log.getInstance();
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
          valuables.remove(i);
          sleep(1000);
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
