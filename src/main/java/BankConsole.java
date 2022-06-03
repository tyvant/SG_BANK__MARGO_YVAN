import com.sg.Account;
import exceptions.SGBANKExceptions;

import java.math.BigDecimal;
import java.util.Scanner;

import static java.lang.System.exit;

/** Represents the console use for interactive action.
 * @author Yvan Tchatat
 */
public class BankConsole extends Console {
    private final Scanner scanner;
    BankConsole(Scanner scanner) {
        this.scanner = scanner;
    }

      void launchBankApp() {
        welcomeMessage();
        printMenu(startChoice);
        int option;
        try {
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    configAccount();
                    break;
                case 2:
                    exit(0);
                default:
                    System.out.println("\n Wrong choice !!");
            }
        } catch (SGBANKExceptions ex){
            System.out.println(ex.getMessage());
        }catch (Exception ex){
            System.out.println("Please enter an integer value between 1 and " + bankOperations.length);
            scanner.next();
        }
    }
    @Override
    public void welcomeMessage(){
        System.out.println("\t\t[START OF INTERACTIVE]\n");
        System.out.println("Welcome to SG Bank  , Please Choose your action : ");
    }

    protected void configAccount() {
        System.out.println("\nPlease set Amount (ex: 454,34 ou 100)  : ");
        final BigDecimal amount = scanner.nextBigDecimal();
        account = new Account(amount);
        System.out.println("\nYou init " +account.toString());
        System.out.println("\nBank Operations : ");
        printMenu(bankOperations);
        int option;
        while (true) {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withrawal();
                        break;
                    case 3:
                        showHistory();
                        break;
                    case 4:
                        System.out.println("\nGoodbye !!! ");
                        exit(0);
                        break;
                    default:
                        System.out.println("\n Wrong choice !!");
                }
            printMenuBankOperations();
        }
    }

        protected void withrawal() {
            withrawMessage();
            BigDecimal withdrawal = scanner.nextBigDecimal();
            account.withraw(withdrawal);
        }

    protected void deposit() {
        depositMessage();
        final BigDecimal amount = scanner.nextBigDecimal();
            account.deposit(amount);
        }
}

