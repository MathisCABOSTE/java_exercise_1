import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        List<Command> commands = Arrays.asList(new Freq(), new Fibo(), new Quit(), new Predict());
        System.out.println("Bienvenue !");
        var scanner = new Scanner(System.in);
        var input = scanner.nextLine();
        var found = false;
        while (true) {
            for (int i = 0; i < commands.size(); i++) {
                if (commands.get(i).name().equals(input)) {
                    found = true;
                    commands.get(i).run(scanner);
                }
            }
            if (!found) {
                System.out.println("Unknown command");
            }
            input = scanner.nextLine();
            found = false;
        }
    }
}