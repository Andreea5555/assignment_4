package ProducerConsumer;

import DepositAdapter.DepositAdapter;
import LoggerSingleton.Log;
import MineMultiton.ValuableStone;
import Proxy.TreasureRoomGuardsman;
import ReaderWriter.AccessManager.Door;
import ReaderWriter.Writer;

import java.util.ArrayList;
import java.util.Random;

public class ValuablesTransporter implements Runnable, Writer
{
  private final DepositAdapter deposit;
  private final Door door;
  private final ArrayList<ValuableStone> stones;

  public ValuablesTransporter(DepositAdapter deposit, Door door) {
    this.deposit = deposit;
    this.door = door;
    this.stones = new ArrayList<>();
  }

  @Override public void run()
  {
    while (true) {
      Random random = new Random();
      int target = random.nextInt(151) + 50;
      for (int i = 0; i < target; i++)
      {
        stones.add(deposit.takeStone());
      }
      Log.getInstance().log("Transporter taking " + target + " stones from the deposit");
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

      try
      {
        Writer writer = door.requestWrite(0);
        for (int i = 0; i < target; i++)
        {
          writer.add(stones.get(i));
        }
        Log.getInstance().log("Transporter adding stones to the treasure room");
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }

      stones.clear();
      door.releaseWrite();
    }
  }

  @Override public void add(ValuableStone stone)
  {
    TreasureRoomGuardsman guardsman = door.getGuardsman();
    guardsman.add(stone, this);
  }

  @Override public ValuableStone retrieve()
  {
    //not the transporter's role
    return null;
  }
}
