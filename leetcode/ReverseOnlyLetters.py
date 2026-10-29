'''
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.



Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
'''


class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        '''
        1. Traverse the string
        2. Use a list and add the non alphabetical chars
        3. |In the list result also add ""
        4. Traverse inverse and change when you have "". Use a counter for list_chars to keep correct order
        5. use a join to transform it as string

        :param s:
        :return: the inverted string
        '''
        list_result = []
        list_chars = list()
        #count_dict_entrance = 0
        for i in range(0, len(s)):
            if (65 <= ord(s[i]) <= 90) or (97 <= ord(s[i]) <= 122):
                list_chars.append(s[i])
                list_result.append("")
            else:
                list_result.append(s[i])
        counter_results = 0
        for i in range (len(list_result)-1, -1, -1):
            if list_result[i] == "":
                list_result[i] = list_chars[counter_results]
                counter_results += 1

        # transform into string
        return "".join(list_result)


if __name__ == '__main__':
    s1 = "ab-cd"
    s2 = "a-bC-dEf-ghIj"
    s3 = "Test1ng-Leet=code-Q!"

    print(Solution().reverseOnlyLetters(s1))
    print(Solution().reverseOnlyLetters(s2))
    print(Solution().reverseOnlyLetters(s3))
