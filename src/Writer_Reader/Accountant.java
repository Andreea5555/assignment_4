package Writer_Reader;

import Domain.Valuable;
import Proxy.TreasureRoomGuardsman;
import main.Log;

import static java.lang.Thread.sleep;

public class Accountant implements Runnable, Reader
{
private Log logger;
private TreasureRoomGuardsman guardsman;

//  public Accountant(Door door)
//  {
//    this.logger = Log.getInstance();
//    this.door=door;
//  }
public Accountant(TreasureRoomGuardsman guardsman)
{
  this.logger = Log.getInstance();
  this.guardsman = guardsman;
}

  public Accountant()
  {
    this.logger = Log.getInstance();
  }

// public int getCount() throws InterruptedException
// {
//    return door.requestRead().look(this);
// }
  @Override public void run()
  {
//    while(true){
      try
      {
//        Reader reader = accessManager.requestRead();
        logger.print("the accountant says that the count is "+ guardsman.look(this));
        sleep(1000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
//      finally
//      {
//        accessManager.releaseRead();
//      }
//    }
  }

  @Override public Valuable retrieve(int index, Object object)
  {
    return this.guardsman.retrieve(index, this);
  }

  @Override public int look(Object object)
  {
    return this.guardsman.look(this);
  }
}
