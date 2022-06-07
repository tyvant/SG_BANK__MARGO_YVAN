import java.util.Scanner;

/** Represents the entrypoint of our app.
 * @author Yvan Tchatat
 */
public class BankApp {
    public static void main(String[] args) {

        Console console = new BankConsole(new Scanner(System.in));
        Console demoConsole = new DemoConsole();

        demoConsole.launchBankApp();

        console.launchBankApp();
    }

}
