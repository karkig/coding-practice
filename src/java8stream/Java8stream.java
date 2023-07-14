package java8stream;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8stream {
    public static void main(String[] args) {
       // findNuberStaringBy1();
        findFirstNoRepeatingChar();

    }

    public  static void findNuberStaringBy1()
    {
        // Find the number which are started by digit 1
        int[] a = {10, 20, 11, 40, 100};

        // Filter the numbers starting with digit 1
        int[] result = Arrays.stream(a)
                .filter(num -> String.valueOf(num).startsWith("1"))
                .toArray();

        // Print the result
        System.out.println(Arrays.toString(result));
    }

    public  static void findFirstNoRepeatingChar()
    {
        String str = "india";

        Optional<Character> firstNonRepeatingChar = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst();

        if (firstNonRepeatingChar.isPresent()) {
            System.out.println("First non-repeating character: " + firstNonRepeatingChar.get());
        } else {
            System.out.println("No non-repeating characters found.");
        }

    }



}
