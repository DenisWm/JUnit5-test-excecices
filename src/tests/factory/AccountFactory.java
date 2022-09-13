package tests.factory;

import entities.Account;
import org.checkerframework.checker.units.qual.A;

public class AccountFactory {

    public static Account createEmpty (){
        return new Account(1L, 0.0);
    }

    public static Account createEmpty (double initialBalance){
        return new Account(1L, initialBalance);
    }
}
