import java.util.Scanner;

public class Quit implements Command{
    public void quit(Scanner scanner) {
        scanner.close();
        System.exit(0);
        return;
    }
    public String name(){
        return "quit";
    }
    public boolean run(Scanner scanner) {
        quit(scanner);
        return true;
    }
}