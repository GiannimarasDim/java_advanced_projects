package gr.aueb.sev.chapter11and12;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Account {
    private long id;
    private String iban;
    private String lastname;
    private String firstname;
    private String ssn;
    private double balance;


    public Account(){

    }

    public Account(long id, String iban, String lastname, String firstname, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.lastname = lastname;
        this.firstname = firstname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public Account(String iban, String ssn, double balance) {
        this.iban = iban;
        this.ssn = ssn;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //Business Logic
    /**
     * Deposits an amount to the account
     *
     * @param amount the amount of money to deposit
     * @throws Exception if negative amount
     */
    public void deposit(double amount) throws NegativeAmountException {
        if(amount>0){
            balance+=amount;
        }else{
            try{
                throw new NegativeAmountException(amount);
            }catch (NegativeAmountException e){
                System.err.println("negative amount");
                throw e;
            }
        }
    }

    /**
     * Withdraws a certain amount of money from the account.
     *
     * @param amount the amount of money to withdraw
     * @throws Exception if insufficient balance
     */

    public void withdraw(double amount) throws InsufficientBalanceException, FileNotFoundException {
        if(!isSsnValid(ssn)){
            logErrorMessage(new PrintStream("C:/tmp/ssn-error-log.txt"),"Ssn is not valid");
            return;

        }
        if(amount<=balance){
            balance-=amount;
        }else{
            try{
                throw new InsufficientBalanceException(balance,amount);
            }catch (InsufficientBalanceException e){
                System.err.println("Insufficient amount");
                throw e;
            }
        }


    }

    /**
     * Gets the ammount's balance
     *
     * @return the balance of the ammount
     */
    public double getAccountBalance(){
        return getBalance();
    }

    /**
     * Prints account's state
     *
     * @return the state of the account
     */
    public String getAccountState(){

        return "Id: "+ id + ", Firstaname: "+ firstname+",Lastname: "+lastname+",Iban: "+iban+",Ssn: " + ssn
                +",Balamce"+balance;
    }

    private void logErrorMessage(PrintStream ps,String message){
        ps.println(message);
    }

    private boolean isSsnValid(String ssn){
        if(ssn!=null) return false;
        return this.ssn.equals(ssn);
    }

}
