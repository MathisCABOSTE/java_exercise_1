public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenue !");           
        var scanner = new java.util.Scanner(System.in);
        var input = scanner.nextLine();
        if (!input.equals("quit")) {
            System.out.println("unkown command");
        }
        scanner.close();
    }
}