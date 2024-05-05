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
    public void run() {
        //Make the king read the treasure room until it's empty and hold a party if he has 100 jewels
        while (true) {
            try {
                var treasure = door.requestWrite();
                var jewels = treasure.look(this);
                if (jewels >= 10) {
                    System.out.println("The king is holding a party");
                    for (int i = 0; i < 10; i++) {
                        treasure.retrieve(i, this);
                    }
                    door.releaseWrite();
                    sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
