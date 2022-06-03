import com.sg.Account;

import java.math.BigDecimal;

/** Represents the console use for demo.
 * @author Yvan Tchatat
 */
public class DemoConsole extends Console{
    private final BigDecimal DEFAULT_ACCOUNT_AMOUNT = BigDecimal.valueOf(5000);
    private final BigDecimal DEFAULT_WITHRAWAL = BigDecimal.valueOf(200);
    private final BigDecimal DEFAULT_DEPOSIT = BigDecimal.valueOf(1020);;
    @Override
   public void welcomeMessage(){
        System.out.println("Welcome to SG Bank, Please this is Demo");
    }

    @Override
    protected void withrawal() {
        withrawMessage();
        printChoice(DEFAULT_WITHRAWAL);
        account.withraw(DEFAULT_WITHRAWAL);
    }

    @Override
    protected void deposit() {
        depositMessage();
        printChoice(DEFAULT_DEPOSIT);
        account.deposit(DEFAULT_DEPOSIT);
    }

    public void printChoice(BigDecimal option){
        System.out.println("value inserted by user  ->  " + option);
    }

    void launchBankApp() {
        welcomeMessage();
        printMenu(startChoice);
        printChoice(BigDecimal.ONE);
        configAccount();
    }

    protected void configAccount() {
        System.out.println("\nPlease set Amount : ");
        printChoice(DEFAULT_ACCOUNT_AMOUNT);
        account = new Account(DEFAULT_ACCOUNT_AMOUNT);
        System.out.println("\nYou init " +account.toString());
        printMenuBankOperations();
        printChoice(BigDecimal.ONE);
        deposit();
        printMenuBankOperations();
        printChoice(BigDecimal.valueOf(2));
        withrawal();
        printMenuBankOperations();
        printChoice(BigDecimal.valueOf(3));
        showHistory();
        printMenuBankOperations();
        printChoice(BigDecimal.valueOf(4));
        goodBye();
        System.out.println("Demo is finished\n\n");
    }

    private void goodBye() {
        System.out.println("\nGoodbye !!! ");
    }
}
