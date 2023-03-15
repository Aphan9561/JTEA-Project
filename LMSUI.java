import java.util.Scanner;

/*
 * This is a UI that allows the user to give input
 * @authors: J TEA: Tessa Neal, Eve Blom, Anna Phan, and Jacqueline Askey
 */
import java.util.Scanner;
public class LMSUI {
    private Scanner keyboard;
    private LMSApplication application;

    public LMSUI() {
        run();
    }

    public void run(){
        keyboard = new Scanner(System.in);
        application.getInstance();
        keyboard.close();
    }

    public void displayMainMenu() {

    }
}