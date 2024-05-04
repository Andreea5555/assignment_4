package ProducerConsumer;

import DepositAdapter.DepositAdapter;
import MineMultiton.ValuableMultiton;
import MineMultiton.Mine;

public class Miner implements Runnable
{
  private final DepositAdapter deposit;
  private final Mine mine;

  public Miner(DepositAdapter deposit, Mine mine)
  {
    this.deposit = deposit;
    this.mine = mine;
  }

  @Override public void run()
  {
    while (true) {
      deposit.addStonesToDeposit("Stone" + (ValuableMultiton.getSize() + 1));
      mine.generateStone();
      try
      {
        Thread.sleep(500);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
