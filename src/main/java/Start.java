import DepositAdapter.DepositAdapter;
import MineMultiton.Mine;
import ProducerConsumer.Miner;
import ProducerConsumer.ValuablesTransporter;
import Proxy.TreasureRoom;
import ReaderWriter.AccessManager.Door;
import ReaderWriter.Accountant;
import ReaderWriter.King;

public class Start
{
  public static void main(String[] args)
  {
    Mine mine = new Mine();

    DepositAdapter deposit = new DepositAdapter();

    Miner miner1 = new Miner(deposit, mine);
    Miner miner2 = new Miner(deposit, mine);

    TreasureRoom treasureRoom = new TreasureRoom();

    Door door = new Door(deposit, treasureRoom);

    ValuablesTransporter transporter1 = new ValuablesTransporter(deposit, door);
    ValuablesTransporter transporter2 = new ValuablesTransporter(deposit, door);

    Accountant accountant1 = new Accountant(door);
    Accountant accountant2 = new Accountant(door);

    King king = new King(door);

    Thread minerThread1 = new Thread(miner1);
    Thread minerThread2 = new Thread(miner2);
    Thread transporterThread1 = new Thread(transporter1);
    Thread transporterThread2 = new Thread(transporter2);
    Thread accountantThread1 = new Thread(accountant1);
    Thread accountantThread2 = new Thread(accountant2);
    Thread kingThread = new Thread(king);

    minerThread1.start();
    minerThread2.start();
    transporterThread1.start();
    transporterThread2.start();
    accountantThread1.start();
    accountantThread2.start();
//    kingThread.start();
  }
}
