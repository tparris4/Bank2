package com.example.mypackage;


    public class BankingAccount {
        //alt enter on bankaccount
        private String firstName;
        private String lastName;
        private double balance;

        public static final int CHECKING = 1;
        public static final int SAVINGS = 2;

        private int accountType;

        public BankingAccount(String firstName, String lastName, double balance, int typeOfAccount) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.balance = balance;
            this.accountType = typeOfAccount;
        }

        //the branch argument is true iff the customer is performing the transcaction
        //at a branch with a teller
        //false if the customer is performing an transaction at an atm
        public double deposit(double amount, boolean branch){
            balance += amount;
            return balance;
        }


        //the branch argument is true iff the customer is performing the transcaction
        //at a branch with a teller
        //false if the customer is performing an transaction at an atm
        public double withdrawal(double amount, boolean branch){
            if((amount > 500.00) && !branch){
                throw new IllegalArgumentException();
            }

            balance -= amount;
            return balance;
            //bank only allows withdrawals up to 500

        }

        public double getBalance(){
            return balance;
        }

        public boolean isChecking(){
            return accountType == CHECKING;
        }
}
