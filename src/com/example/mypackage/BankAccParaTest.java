package com.example.mypackage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccParaTest {

    //parameterized tests

    private BankingAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccParaTest(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup(){
        account = new BankingAccount("Tim", "Buch", 1000.00, BankingAccount.CHECKING);
        System.out.println("Running a test");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {10000.00, true, 2000.00},
//set of parameters you want to test versus value
        });
    }

    @Test
    public void getBalance_deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }
    
}
