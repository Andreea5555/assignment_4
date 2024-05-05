package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DepositTest {
    private Deposit deposit;
    private Valuable valuable;

    @BeforeEach
    void setUp() {
        Deposit.resetInstance();
        this.deposit = Deposit.getInstance(10);
        this.valuable = Mockito.mock(Valuable.class);
    }
    @Test
    void singleton_property() {
        Deposit anotherInstance = Deposit.getInstance(10);
        assertSame(deposit, anotherInstance, "Both calls should return the same instance");
    }
    @Test
    void deposit_valuable() throws InterruptedException {
        deposit.depositValuable(valuable);
        Valuable retrieved = deposit.takeValuable();
        assertSame(valuable, retrieved, "Deposited and retrieved valuable should be the same");
    }
    @Test
    void take_valuable() throws InterruptedException {
        deposit = Deposit.getInstance(10);

        deposit.depositValuable(valuable);
        Valuable retrieved = deposit.takeValuable();

        assertSame(valuable, retrieved, "The retrieved valuable should be the same as the one deposited");
    }

    @Test
    void deposit_full_capacity() {
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 10; i++) { // Assuming the capacity is 10
                deposit.depositValuable(valuable);
            }
        }, "Should not throw any exception when depositing up to capacity");
    }

}