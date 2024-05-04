package ReaderWriter;

import LoggerSingleton.Log;
import Proxy.TreasureRoomGuardsman;
import ReaderWriter.AccessManager.Door;

public class Accountant implements Reader, Runnable
{
  private final Door door;

  public Accountant(Door door) {
    this.door = door;
  }

  @Override public int look()
  {
    TreasureRoomGuardsman guardsman = door.getGuardsman();
    return guardsman.look(this);
  }

  @Override public void run()
  {
    while (true) {
      try
      {
        Reader reader = door.requestRead();
        Log.getInstance().log("Accountant counted " + reader.look() + " gems in the treasury");
        door.releaseRead();
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
