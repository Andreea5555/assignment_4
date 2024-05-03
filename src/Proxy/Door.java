package Proxy;

import Domain.Valuable;
import Producer_Consumer.Valuable_Transporter;
import Proxy.Treasury;
import Writer_Reader.*;

public class Door implements AccessManager
{
    private int readers;
    private int writers;
    private int current;
    private int next;
//    private Treasury treasure;
    private Reader accountant;
    private Valuable_Transporter transporter;
    private Writer king;

    //probably one more readerWriter(king)

//    public Door(Treasury treasure) {
//        readers = 0;
//        writers = 0;
//        this.treasure = treasure;
//    }

//    public Door(Valuable_Transporter writer, Accountant reader) {
//        readers = 0;
//        writers = 0;
//        current = 0;
//        next = 0;
//        this.writer = writer;
//        this.reader = reader;
//    }
    public Door(TreasureRoomGuardsman guardsman) {
        readers = 0;
        writers = 0;
        current = 0;
        next = 0;
        this.accountant = new Accountant(guardsman);
        this.transporter = new Valuable_Transporter(guardsman);
        this.king = new King(this);
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized Valuable_Transporter requestWrite() throws InterruptedException {
        int myNumber = next;
        next++;
        while (myNumber != current) {
            wait();
        }
        while (readers > 0 || writers > 0) {
            wait();
        }
        writers++;
        current++;
        notifyAll();

        return transporter;
    }

    @Override
    public synchronized void releaseWrite() {
        writers--;
        if (writers == 0){
            notifyAll();
        }
    }

    @Override
    public synchronized Reader requestRead() throws InterruptedException {
        int myNumber = next;
        next++;
        while (myNumber != current) {
            wait();
        }
        while (writers > 0) {
            wait();
        }
        readers++;
        current++;
        notifyAll();

        return accountant;
    }
}
