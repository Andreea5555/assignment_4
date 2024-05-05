package main;

import Domain.Valuable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class DepositTest {
    private Deposit deposit;
    private Valuable valuable;

    @BeforeEach
    void setUp() {
        this.deposit = Deposit.getInstance();
        this.valuable = Mockito.mock(Valuable.class);
    }
    @Test
    void singleton_property() {
        Deposit anotherInstance = Deposit.getInstance();
        Assertions.assertSame(deposit, anotherInstance, "Both calls should return the same instance");
    }
    @Test
    void deposit_valuable() throws InterruptedException {
        deposit.depositValuable(valuable);
        Valuable retrieved = deposit.takeValuable();
        Assertions.assertSame(valuable, retrieved, "Deposited and retrieved valuable should be the same");
    }
    @Test
    void take_valuable() throws InterruptedException {
        deposit = Deposit.getInstance();

        deposit.depositValuable(valuable);
        Valuable retrieved = deposit.takeValuable();

        Assertions.assertEquals(valuable, retrieved, "The retrieved valuable should be the same as the one deposited");
    }

    @Test
    void deposit_full_capacity() {
        Assertions.assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) { // Assuming the capacity is 10
                deposit.depositValuable(valuable);
            }
        }, "Should not throw any exception when depositing up to capacity");
    }

}