package ReaderWriter;

import LoggerSingleton.Log;
import MineMultiton.ValuableStone;
import Proxy.TreasureRoomGuardsman;
import ReaderWriter.AccessManager.Door;

import java.util.ArrayList;
import java.util.Random;

public class King implements Runnable, Writer
{
  private final Door door;
  private final TreasureRoomGuardsman guardsman;
  private final ArrayList<ValuableStone> stones;

  public King(Door door) {
    this.door = door;
    this.guardsman = door.getGuardsman();
    this.stones = new ArrayList<>();
  }

  @Override public void add(ValuableStone stone)
  {
    guardsman.add(stone, this);
  }

  @Override public ValuableStone retrieve()
  {
    return guardsman.retrieve(this);
  }

  @Override public int look()
  {
    return guardsman.look(this);
  }

  @Override public void run()
  {
    while (true) {
      Random random = new Random();
      int target = random.nextInt(151) + 50;
      try
      {
        Writer writer = door.requestWrite(1);
        if (target < look()) {
          Log.getInstance().log("The king is taking " + target + " stones from the treasury");
          Thread.sleep(5000);
          for (int i = 0; i < target; i++)
          {
            this.stones.add(writer.retrieve());
          }

          Log.getInstance().log("The king is having his party");
          this.stones.clear();
          Thread.sleep(10000);

          Log.getInstance().log("The king has finished his party");
          Thread.sleep(10000);
        }
        else {
          Log.getInstance().log("There are not enough stones for the king to party");
          Thread.sleep(20000);
        }
        door.releaseWrite();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
