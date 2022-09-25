public class Fibo implements Command {
    public int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
    public String name(){
        return "fibo";
    }
    public boolean run(java.util.Scanner scanner){
        System.out.println("Ecrivez le nombre dont vous souhaitez voir la suite de Fibonacci");
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println(this.fibo(n));
        return true;
    }
}
