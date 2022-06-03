import com.sg.Account;

public abstract class Console {
    protected Account account;

    protected String[] startChoice = {
            "   1 -> Set Amount of Your Account",
            "   2 -> End",
    };
    protected String[] bankOperations = {
            "    1 -> Deposit",
            "    2 -> Withdrawal",
            "    3 -> Show history",
            "    4 -> End"
    };

    void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
    }

    protected void withrawMessage() {
        System.out.println("\nPlease insert withrawal amount : ");
    }
    protected void depositMessage() {
        System.out.println("\nPlease insert deposit amount : ");
    }
    protected void showHistory() {
        System.out.println("\nList of Statements : ");
        account.showHistory();
    }
    protected void printMenuBankOperations() {
        System.out.println("\nBank Operations : ");
        printMenu(bankOperations);
    }
    public abstract void welcomeMessage();

    protected abstract void withrawal();
    protected abstract void configAccount();
    protected abstract void deposit();
}
