package Producer_Consumer;

import Domain.Valuable;
import Proxy.Door;
import Writer_Reader.Writer;
import main.Deposit;
import main.Log;
import main.Mine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Thread.sleep;

public class Valuable_Transporter implements Runnable, Writer {
    private Log log;
    private Deposit deposit;
    private ArrayList<Valuable> valuables;
    private Door door;

    public Valuable_Transporter(Door door) {
        valuables = new ArrayList<>();
        deposit = Deposit.getInstance();
        log = Log.getInstance();
        this.door = door;
    }

    @Override
    public void run() {
        Random random = new Random();
        int number = random.nextInt(5) + 1;
        System.out.println("Number of valuables to transport: " + number);
        while (true) {
            try {
                if (valuables.isEmpty() && this.deposit.getSize() >= number) {
                    System.out.println("Taking valuables from deposit of size" + this.deposit.getSize());
                    Valuable[] valFromDeposit = this.deposit.takeValuables(number);
                    System.out.println("Valuables taken from deposit: " + Arrays.toString(valFromDeposit));
                    valuables.addAll(Arrays.asList(valFromDeposit));
                    System.out.println("TAKEN valuables from deposit of size" + this.deposit.getSize());
                }
                while (!valuables.isEmpty()) {
                    System.out.println("Transporting valuables to treasure room");
                    var val = valuables.remove(0);
                    door.requestWrite().add(val, this);
                    door.releaseWrite();
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
