package tests.entities;

import com.ibm.icu.impl.Assert;
import entities.Account;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount(){
        double amount = 200.0;

        double expectedValue = 196.0;

        Account acc = AccountFactory.createEmpty();

        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegatiiveAmount(){
        double expectedValue = 100.00;
        Account acc = AccountFactory.createEmpty(expectedValue);

        double amount = -200.0;


        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithDrawShouldClearBalanceAndReturnFullBalance() {
        double expectedValue = 0.0;
        double initialBalance = 800.0;
        Account acc = AccountFactory.createEmpty(initialBalance);

        double result = acc.fullWithDraw();

        Assertions.assertEquals(expectedValue, acc.getBalance());
        Assertions.assertEquals(result, initialBalance);
    }

    @Test
    public void withDrawShouldDecreaseBalanceWhenSufficiantBalance(){
        Account acc = AccountFactory.createEmpty(800.00);

        acc.withdraw(500);

        Assertions.assertEquals(300.00, acc.getBalance());
    }

    @Test
    public void withDrawShouldThrowExceptionWhenInsufficiantBalance(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = AccountFactory.createEmpty(800.00);
            acc.withdraw(900);
        });
    }
}
