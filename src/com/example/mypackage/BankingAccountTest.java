package com.example.mypackage;

import org.junit.*;

import static org.junit.Assert.*;

public class BankingAccountTest {

    private BankingAccount account;
    private static int count;


    @BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = ");
        System.out.println("count = " + count++);
    }

    @Before
    //tells junit to setup everytime you runa test (befoer all tests have started)
    public void setup(){
        account = new BankingAccount("Tim", "Buch", 1000.00, BankingAccount.CHECKING);
        System.out.println("Running a test");
    }

    @Test
    public void deposit() {
       // fail("This test has yet to be implemented");

       // BankingAccount account = new BankingAccount("Tim", "Buch", 1000.00, BankingAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
        //delta allows some leeway in the comparison
        //as long as expected and actual is within the delta, it is okay to use
        //important for doubles
    }

    @Test
    public void withdrawal_branch() throws Exception {
     // fail("This test has yet to be implemented");
        double balance = account.withdrawal(600.00, true);
        assertEquals(400.00, balance, 0);


    }
@Test(expected = IllegalArgumentException.class)
//tells method to expect an illegal arguement exception
public void withdrawal_notBranch() throws Exception {
    double balance = account.withdrawal(600.00, false);
    assertEquals(400.00, balance, 0);

}
    @Test
    public void getBalance_deposit() {
//        fail("This test has yet to be implemented");
//using to assert deposit

        BankingAccount account = new BankingAccount("Tim", "Buch", 1000.00, BankingAccount.CHECKING);
        account.deposit(200.00, true);
        //delta allows some leeway in the comparison
        //as long as expected and actual is within the delta, it is okay to use
        //important for doubles
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
//        fail("This test has yet to be implemented");


        BankingAccount account = new BankingAccount("Tim", "Buch", 1000.00, BankingAccount.CHECKING);
        account.withdrawal(200.00, true);
        //delta allows some leeway in the comparison
        //as long as expected and actual is within the delta, it is okay to use
        //important for doubles
        assertEquals(800.00, account.getBalance(), 0);
    }
    @Test
    public void isChecking_true(){
       // BankingAccount account = new BankingAccount("Tim", "Buch", 1000.00, BankingAccount.SAVINGS);
        assertTrue("The account is not a checking account", account.isChecking());
    }

    @AfterClass
    public static void afterClass(){
    System.out.println("This executes after any test cases. count = ");
        System.out.println("count = " + count++);


}

    @After
    public void teardown(){
    System.out.println("count = " + count++);
}

//before and afters are spooled into an IO and may appear out of order
//    @Test
//    public void dummyTest(){
//        assertEquals(20, 21);
//
//
//    }

}