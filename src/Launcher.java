public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !");           
        var scanner = new java.util.Scanner(System.in);
        var input = scanner.nextLine();
        while (!input.equals("quit")) {
            System.out.println("Unkown command");
            input = scanner.nextLine();
        }
        scanner.close();
    }
}