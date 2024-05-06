package Writer_Reader;

import Proxy.Door;
import main.Log;

import static java.lang.Thread.sleep;

public class Accountant implements Reader, Runnable {
    private Log logger;
    private Door door;

    public Accountant(Door door) {
        this.logger = Log.getInstance();
        this.door = door;
    }

    public int getCount() throws InterruptedException {
        System.out.println("Accountant.getCount");
        var count = door.requestRead().look(this);
        door.releaseRead();
        return count;
    }

    @Override
    public void run() {
        while (true) {
            try {
                logger.print("the accountant says that the count is " + getCount());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
