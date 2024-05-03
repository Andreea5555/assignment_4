package Writer_Reader;

import Domain.Valuable;
import Proxy.Door;

import static java.lang.Thread.sleep;

public class King implements Runnable, Reader, Writer {
    private Door door;

    public King(Door door) {
        this.door = door;
    }

    @Override
    public synchronized void run() {
        //Make the king read the treasure room until it's empty and hold a party if he has 100 jewels
        while (true) {
            try {
                var treasure = door.requestWrite();
                var jewels = treasure.look(this);
                if (jewels == 100) {
                    System.out.println("The king is holding a party");
                    for (int i = 0; i < 100; i++) {
                        treasure.retrieve(i, this);
                    }
                    sleep(1000);
                }
                else{
                    wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override public Valuable retrieve(int index, Object object)
    {
        return null;
    }

    @Override public int look(Object object)
    {
        return 0;
    }

    @Override public void add(Valuable valuable, Object object)
    {

    }
}
