/**
 * You are given a string sentence that consist of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.) The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel ('a', 'e', 'i', 'o', or 'u'), append "ma" to the end of the word.
 * For example, the word "apple" becomes "applema".
 * If a word begins with a consonant (i.e., not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end, and so on.
 * Return the final sentence representing the conversion from sentence to Goat Latin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: sentence = "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * <p>
 * Input: sentence = "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= sentence.length <= 150
 * sentence consists of English letters and spaces.
 * sentence has no leading or trailing spaces.
 * All the words in sentence are separated by a single space.
 */

package hackerRank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GoatLatin {

    String[] vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};
    List<String> vowelList = new ArrayList<>(Arrays.asList(vowels));

    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuilder temp = new StringBuilder();
            if (checkIfWordStartsWithVowel(vowelList, words[i])) {
                temp.append(words[i]);
                temp.append("ma");
            } else {
                for (int wordLength = 1; wordLength < words[i].length(); wordLength++) {
                    temp.append(words[i].charAt(wordLength));
                }
                // add first letter
                temp.append(words[i].charAt(0));
                temp.append("ma");
            }
            for (int j = 0; j < i+1; j++) {
                temp.append("a");
            }
            if (i != words.length - 1) {
                sb.append(temp);
                sb.append(" ");
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    public boolean checkIfWordStartsWithVowel(List<String> vowels, String word) {
        for (String s : vowels) {
            if (word.startsWith(s)) {
                return true;
            }
        }
        return false;
    }

    static void main() {
        GoatLatin goatLatin = new GoatLatin();
        String sentence = "I speak Goat Latin";
        String sentence2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(goatLatin.toGoatLatin(sentence));
        System.out.println(goatLatin.toGoatLatin(sentence2));
    }


}
