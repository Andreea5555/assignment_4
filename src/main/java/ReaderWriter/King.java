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

  @Override public void run()
  {
    while (true) {
      Random random = new Random();
      int target = random.nextInt(151) + 50;
      String message = "The king is taking " + target + " stones from the treasury to make a party";
      try
      {
        Writer writer = door.requestWrite(1);
        for (int i = 0; i < target; i++)
        {
          ValuableStone stone;
          try {
            stone = writer.retrieve();
          }
          catch (ArrayIndexOutOfBoundsException e) {
            stone = null;
          }
          if (stone != null) {
            this.stones.add(stone);
          }
          else {
            for (int j = 0; j < i; j++)
            {
              writer.add(this.stones.get(j));
            }
            message = "There are not enough stones in the treasury for the king to make a party";
            break;
          }
        }
        Thread.sleep(5000);
        Log.getInstance().log(message);
        door.releaseWrite();
        stones.clear();
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
