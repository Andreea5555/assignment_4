package src;

import Domain.Ruby;
import Domain.Valuable;
import main.Deposit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DepositTest {
    @Test
    public void testAddTreasure() {
        Deposit deposit = Deposit.getInstance();
        Valuable valuable = new Ruby();
        try {
            deposit.depositValuable(valuable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Valuable valuable1 = null;
        try {
            valuable1 = deposit.takeValuable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(valuable, valuable1);
    }
}
