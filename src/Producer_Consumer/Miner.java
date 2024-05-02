package Producer_Consumer;

import Domain.Valuable;
import main.*;

import static java.lang.Thread.sleep;

public class Miner implements Runnable
{
  private Mine mine;
  private Deposit deposit;
  private Log logger;

  public Miner()
  {
    this.mine= Mine.getInstance();
    this.deposit = Deposit.getInstance();
    this.logger = Log.getInstance();
  }

  @Override public synchronized void run()
  {
    logger.print("The miner is going to work");
    while (!mine.isEmpty())
    {
      logger.print("The miner starts mining");
      try
      {
        sleep(1000);

        Valuable valuable = mine.mine();
        logger.print("Producer_Consumer.Miner has mined "+valuable.getValuableType());

        deposit.depositValuable(valuable);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}
