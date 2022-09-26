import java.nio.file.Paths;
import java.util.*;

public class Predict implements Command{
    public String next_word(HashMap<String, HashMap<String, Integer>> map, String word, int step) {
        var bestms = "";
        var bestmsvalue = 0;
        var word_dict = map.get(word);
        while (step < 20) {
            if (map.containsKey(word)) {
                for (var entry : word_dict.entrySet()) {
                    if (entry.getValue() > bestmsvalue) {
                        bestmsvalue = entry.getValue();
                        bestms = entry.getKey();
                    }
                }
                return bestms + " " + next_word(map, bestms, step + 1);
            } else {
                return "";
            }
        }
        return bestms;
    }

    public String predict(String filename, String input) throws java.io.IOException {
        var filepath = Paths.get(filename);
        var text = java.nio.file.Files.readString(filepath);
        text = text.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        var array = text.split(" ");
        var map = new HashMap<String, HashMap<String, Integer>>();
        String mp;
        String ms;
        HashMap<String, Integer> inmp;
        for (int i = 0; i < array.length-1; i++) {
            mp = array[i];
            ms = array[i+1];
            if (!(mp.equals("") || ms.equals(""))){
                if (map.containsKey(mp)) {
                    if (map.get(mp).containsKey(ms)) {
                        map.get(mp).put(ms, map.get(mp).get(ms) + 1);
                    } else {
                        map.get(mp).put(ms, 1);
                    }
                } else {
                    inmp = new HashMap<String, Integer>();
                    inmp.put(ms, 1);
                    map.put(mp,inmp);
                }
            }
        }
        if (map.containsKey(input)) {
            return input + " " + next_word(map, input, 1);
        } else {
            return "Error: word " + input + " is not in provided text";
        }

    }
    public String name() {
        return "predict";
    }
    public boolean run(Scanner scanner) {
        System.out.println("Ecrivez le chemin du fichier texte");
        var input = scanner.nextLine();
        System.out.println("Entrez un mot existant dans le texte");
        var word = scanner.nextLine();
        try {
            System.out.println(this.predict(input,word));
        } catch (java.io.IOException e) {
            System.out.println("Unreadable file: " + e.toString());
        }
        return true;
    }
}
