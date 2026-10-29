'''
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).


Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 20
order.length == 26
'''
class Solution:
    def isAlienSorted(self, words: list[str], order: str) -> bool:
        '''
        compare word per word
        (function)
        check character length, find longest, add extra "_" to shortest -> if "_" at second -> return false (function)
        # check character per character
            # if words[i][0].index(order) < words[i+1][0].index(order)
                # continue and go to [1]
            # else:
                # return false
        '''
        order_under = "_"+order
        for i in range (0, len(words)-1):
            w1, w2 = self.equalize_characters(words[i], words[i+1])
            counter_index_letter = 0
            for j in range (0, len(w1)):
                if order_under.index(w1[counter_index_letter]) > order_under.index(w2[counter_index_letter]):
                    return False
                elif order_under.index(w1[counter_index_letter]) < order_under.index(w2[counter_index_letter]):
                    break
                else:
                    counter_index_letter += 1
        return True


    def equalize_characters(self, word1, word2):
        word1_length = len(word1)
        word2_length = len(word2)
        if len(word1) == len(word2):
            return word1, word2
        new_word = ""
        if word1_length > word2_length:
            dif = word1_length - word2_length
            new_word = word2 + "_" * dif
            return word1, new_word
        else:
            dif = word2_length - word1_length
            new_word = word1 + "_" * dif
            return new_word, word2

if __name__ == '__main__':
    solution = Solution()
    words1 = ["hello","leetcode"]
    order1 = "hlabcdefgijkmnopqrstuvwxyz"

    words2 = ["word","world","row"]
    order2 = "worldabcefghijkmnpqstuvxyz"

    words3 = ["apple","app"]
    order3 = "abcdefghijklmnopqrstuvwxyz"

    print(solution.isAlienSorted(words1, order1))
    print(solution.isAlienSorted(words2, order2))
    print(solution.isAlienSorted(words3, order3))


