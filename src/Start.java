import Producer_Consumer.Miner;
import Producer_Consumer.Valuable_Transporter;
import Proxy.Door;
import Proxy.TreasureRoom;
import Proxy.TreasureRoomGuardsman;
import Proxy.Treasury;
import Writer_Reader.*;
import main.Deposit;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    Miner miner=new Miner();
    TreasureRoom treasureRoom=new TreasureRoom();
    TreasureRoomGuardsman guard=new TreasureRoomGuardsman(treasureRoom);
    //writer -> transporter
    //reader -> accountant
//    Valuable_Transporter transporter = new Valuable_Transporter(guard);
//    Accountant accountant = new Accountant(guard);
    AccessManager door = new Door(guard);
    Valuable_Transporter transporter = door.requestWrite();
//    King king = new King(door);

    Thread thread1=new Thread(miner);
    Thread thread2=new Thread(door.requestWrite()));
//    Thread thread3 = new Thread(king);
    Thread thread4=new Thread(accountant);
    thread1.start();
    thread2.start();
//    thread3.start();
    thread4.start();
  }
}
