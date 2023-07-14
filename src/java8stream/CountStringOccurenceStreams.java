package java8stream;
/*
//Given an array of strings words and an integer k, return the k most frequent strings.
//Example
//
//Input: words = ["i","love","i","love","coding"], k = 2 Output: ["i","love"]===>.
//
//Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4 Output: ["the","is","sunny","day"]

*/
import java.util.*;
import java.util.stream.Collectors;

public class CountStringOccurenceStreams {

    public static void main(String arg[]) {
        //  int k = 2;
        String[] words = {"i", "love", "i", "love", "coding", "love"};


        Map<String, Long> collect = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

        List<String> collect1 = collect.entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("======"+collect1);
       /* Map<String, Integer> map = countOcc.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        map.entrySet().forEach(a -> System.out.println(a.getKey() + " => " + a.getValue()));*/

    }

}
