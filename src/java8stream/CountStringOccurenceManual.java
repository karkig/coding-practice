package java8stream;
/*
//Given an array of strings words and an integer k, return the k most frequent strings.
//Example
//
//Input: words = ["i","love","i","love","coding"], k = 2 Output: ["i","love"]===>.
//
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4 Output: ["the","is","sunny","day"]

*/
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountStringOccurenceManual {

    public static void main(String arg[]) {
        //  int k = 2;
        String[] words = {"i", "love", "i", "love", "coding", "love"};

        HashMap<String, Integer> countOcc = new HashMap<>();

        for (String word : words) {
            Integer c = countOcc.get(word);
            if (c != null) {
                countOcc.put(word, c + 1);
            } else {
                countOcc.put(word, 1);
            }

        }


        Map<String, Integer> map = countOcc.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        map.entrySet().forEach(a -> System.out.println(a.getKey() + " => " + a.getValue()));

    }

}
