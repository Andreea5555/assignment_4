import Producer_Consumer.Miner;
import Producer_Consumer.Valuable_Transporter;
import Proxy.Door;
import Proxy.TreasureRoom;
import Proxy.TreasureRoomGuardsman;
import Writer_Reader.Accountant;
import Writer_Reader.King;

public class Start {
    public static void main(String[] args) {
        Miner miner = new Miner();
        TreasureRoom treasureRoom = new TreasureRoom();
        TreasureRoomGuardsman guard = new TreasureRoomGuardsman(treasureRoom);
        Door door = new Door(guard);
        Valuable_Transporter transporter = new Valuable_Transporter(door);
        King king = new King(door);
        Accountant accountant = new Accountant(door);

        Thread thread1 = new Thread(miner);
        Thread thread2 = new Thread(transporter);
        Thread thread3 = new Thread(king);
        Thread thread4 = new Thread(accountant);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
