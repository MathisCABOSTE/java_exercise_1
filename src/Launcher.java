import java.nio.file.Paths;
import java.util.*;

public class Launcher {
    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static String freq(String filename) throws java.io.IOException {
        var filepath = Paths.get(filename);
        var text = java.nio.file.Files.readString(filepath);
        text = text.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        var array = text.split(" ");
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 0);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        String result1Key = "";
        int result1Value = 0;
        String result2Key = "";
        int result2Value = 0;
        String result3Key = "";
        int result3Value = 0;
        String key = "";
        int value = 0;
        for (var entry : map.entrySet()) {
            value = entry.getValue();
            key = entry.getKey();
            if (!key.equals("")) {
                if (value > result1Value) {
                    result1Key = key;
                    result1Value = value;
                } else if (value > result2Value) {
                    result2Key = key;
                    result2Value = value;
                } else if (value > result3Value) {
                    result3Key = key;
                    result3Value = value;
                }
            }
        };
        return result1Key + " " + result2Key + " " + result3Key;

    }

    public static void main(String[] args) {
        System.out.println("Bienvenue !");
        var scanner = new java.util.Scanner(System.in);
        var input = scanner.nextLine();
        while (!(input.equals("quit"))) {
            if (input.equals("fibo")) {
                System.out.println("Ecrivez le nombre dont vous souhaitez voir la suite de Fibonacci");
                int n = scanner.nextInt();
                scanner.nextLine();
                System.out.println(fibo(n));
            } else if (input.equals("freq")) {
                System.out.println("Ecrivez le chemin du fichier texte");
                input = scanner.nextLine();
                try {
                    System.out.println(freq(input));
                } catch (java.io.IOException e) {
                    System.out.println("Unreadable file: " + e.toString());
                }
            } else {
                System.out.println("Unkown command");
            }
            input = scanner.nextLine();
        }
        scanner.close();
    }
}