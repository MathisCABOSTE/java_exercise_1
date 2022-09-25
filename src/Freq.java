import java.nio.file.Paths;
import java.util.*;

public class Freq implements Command{
    public String freq(String filename) throws java.io.IOException {
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
    public String name() {
        return "freq";
    }
    public boolean run(Scanner scanner) {
        System.out.println("Ecrivez le chemin du fichier texte");
        var input = scanner.nextLine();
        try {
            System.out.println(this.freq(input));
        } catch (java.io.IOException e) {
            System.out.println("Unreadable file: " + e.toString());
        }
        return true;
    }
}
