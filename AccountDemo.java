package gr.aueb.sev.chapter11and12;

import java.io.FileNotFoundException;

public class AccountDemo {
    public static void main(String[] args) {

        Account alice = new Account();
        Account bob = new Account(1, "GR123", "Dylan", "Bob", "123", 100D);

        try {
            alice.deposit(1000);
            alice.withdraw(500);
            System.out.println(alice.getAccountState());
        } catch (NegativeAmountException e1) {

            System.out.println("Something went wrong with the transaction...");
        }catch (InsufficientBalanceException e2) {
            System.out.println(e2.getMessage());
        }catch (FileNotFoundException e3){
            System.out.println(e3.getMessage());

        }
    }

}