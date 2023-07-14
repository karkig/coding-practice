package java8stream;
/*
Given two strings S1 and S2 in lowercase, the task is to make them anagram. The only allowed operation is to remove a character from any string.
 Find the minimum number of characters to be deleted to make both the strings anagram.
Two strings are called anagram of each other if one of them can be converted into another by rearranging its letters.
 */


/*
Solution is to take a count array and increment that array for str1 and dcrement that array for str2 if the count array
still zero mean all the character are same if not then those are the extra item to remove.

 */
public class StringMakeAnagram {

    static int NO_OF_CHARS = 26;
   static String removedChars="";
    static void areAnagram(char[] str1, char[] str2)  {

        int[] count = new int[NO_OF_CHARS];
        int i;
        for(i = 0; i < str1.length; i++)
        {
            count[str1[i] - 'a']++;
        }
        for(i = 0; i < str2.length; i++)
        {
            count[str2[i] - 'a']--;
        }

        for(i = 0; i < count.length; i++)
        {
            if(count[i]!=0)
            {
                removedChars =removedChars+(char)('a'+i);
            }
        }
        System.out.println(removedChars);
    }

    // Driver code
    public static void main(String[] args)
    {
        char str1[] = "aaa".toCharArray();
        char str2[] = "aaab".toCharArray();

        // Function call
        areAnagram(str1, str2);

    }
}
