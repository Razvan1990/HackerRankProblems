'''
You are given an array of n strings strs, all of the same length.

The strings can be arranged such that there is one on each line, making a grid.

For example, strs = ["abc", "bce", "cae"] can be arranged as follows:
abc
bce
cae
You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.

Return the number of columns that you will delete.



Example 1:

Input: strs = ["cba","daf","ghi"]
Output: 1
Explanation: The grid looks as follows:
  cba
  daf
  ghi
Columns 0 and 2 are sorted, but column 1 is not, so you only need to delete 1 column.
Example 2:

Input: strs = ["a","b"]
Output: 0
Explanation: The grid looks as follows:
  a
  b
Column 0 is the only column and is sorted, so you will not delete any columns.
Example 3:

Input: strs = ["zyx","wvu","tsr"]
Output: 3
Explanation: The grid looks as follows:
  zyx
  wvu
  tsr
All 3 columns are not sorted, so you will delete all 3.
'''
from textwrap import indent


class Solution:
    def minDeletionSize(self, strs: list[str]) -> int:
        '''
        1. Traverse each letter per list a create a word
        2. Now that you have the word check if it is sorted lexicographically
            2a. sorted_string = ".join(sorted(s))
        3. If it is not sorted increment a counter result
        :param strs:
        :return: the number of columns that you will delete
        '''

        counter_result = 0
        indx_word = 0
        while indx_word < len(strs[0]):
            new_word = ""
            for i in range(0, len(strs)):
                new_word += strs[i][indx_word]
            if not self.check_if_same_word(new_word):
                counter_result += 1
            indx_word += 1
        return counter_result

    def check_if_same_word(self, s) -> bool:
        return s == "".join(sorted(s))

    def minDeletionSize2(self, strs: list[str]) -> int:
        length_list = len(strs)
        counter_result = 0
        index_word = 0
        while index_word < length_list:
            for i in range(0, len(strs[0]) - 1):
                if ord(strs[i][index_word]) > ord(strs[i + 1][index_word]):
                    counter_result += 1
                    break
            index_word += 1
        return counter_result


if __name__ == '__main__':
    strs = ["cba", "daf", "ghi"]
    strs1 = ["a", "b"]
    strs2 = ["zyx", "wvu", "tsr"]
    print(Solution().minDeletionSize(strs))
    print(Solution().minDeletionSize(strs1))
    print(Solution().minDeletionSize(strs2))

    print(Solution().minDeletionSize2(strs))
    print(Solution().minDeletionSize2(strs1))
    print(Solution().minDeletionSize2(strs2))
