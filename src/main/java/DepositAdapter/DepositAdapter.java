package DepositAdapter;

import MineMultiton.ValuableStone;
import LoggerSingleton.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class DepositAdapter implements DepositInterface
{
  private final BlockingQueue<ValuableStone> queue;

  public DepositAdapter() {
    this.queue = new LinkedBlockingDeque<>(20);
  }

  @Override synchronized public void addStonesToDeposit(String name)
  {
    try
    {
      while (queue.size() >= 20) {
        Log.getInstance().log("Miner waiting");
        wait();
      }

      queue.put(new ValuableStone(name));
      Log.getInstance().log("Miner working: added " + name + " to deposit");
      notifyAll();
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException("Failed to add a valuable to the deposit");
    }
  }

  @Override public synchronized ValuableStone takeStone()
  {
    try
    {
      while (this.queue.isEmpty()) {
        Log.getInstance().log("Transporter waiting");
        wait();
      }

      ValuableStone stone = queue.take();
      Log.getInstance().log("Transporter working: removed " + stone.getName() + " from deposit");
      notifyAll();

      return stone;
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RuntimeException("Failed to take a valuable from the deposit");
    }
  }
}
