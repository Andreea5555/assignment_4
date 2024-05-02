import Producer_Consumer.Miner;
import Producer_Consumer.Valuable_Transporter;
import Proxy.Door;
import Proxy.TreasureRoom;
import Proxy.TreasureRoomGuardsman;
import Proxy.Treasury;
import main.Deposit;

public class Start
{
  public static void main(String[] args)
  {
    Deposit deposit= Deposit.getInstance();
    Miner miner=new Miner();
    TreasureRoom treasureRoom=new TreasureRoom();
    TreasureRoomGuardsman guard=new TreasureRoomGuardsman(treasureRoom);
    Door door= new Door(guard);
    Valuable_Transporter transporter=new Valuable_Transporter(door);

    Thread thread1=new Thread(miner);
    Thread thread2=new Thread(transporter);
    thread1.start();
    thread2.start();
  }
}
