public class Launcher {
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Bienvenue !");
        var scanner = new java.util.Scanner(System.in);
        var input = scanner.nextLine();
        while (!(input.equals("quit"))) {
            if (input.equals("fibo")) {
                System.out.println("Ecrivez le nombre dont vous souhaitez voir la suite de FIbonacci: ");
                int n = scanner.nextInt();
                scanner.nextLine();
                System.out.println(fibo(n));
            } else {
                System.out.println("Unkown command");
            }
            input = scanner.nextLine();
        }
        scanner.close();
    }
}