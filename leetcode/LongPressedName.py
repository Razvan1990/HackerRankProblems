'''
Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.



Example 1:

Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.
Example 2:

Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it was not in the typed output.


Constraints:

1 <= name.length, typed.length <= 1000
name and typed consist of only lowercase English letters.
'''
class Solution:
    def isLongPressedName(self, name: str, typed: str) -> bool:
        if (len(typed) < len(name)):
            return False
        count_index_name = 0
        count_index_typed = 0
        last_typed_char = None
        result = True
        while count_index_typed < len(typed) and count_index_name < len(name):
            if name[count_index_name] == typed[count_index_typed]:
                last_typed_char = typed[count_index_typed]
                count_index_name += 1
                count_index_typed += 1
            elif typed[count_index_typed] == last_typed_char:
                count_index_typed += 1
            else:
                return False
        # if count_index_name is not done then it means it is false
        if count_index_name < len(name):
            return False
        # we are not done if typed is not clear and check if we have a character which is different than the last character of the name
        if count_index_typed <= len(typed) - 1:
            while count_index_typed < len(typed):
                if typed[count_index_typed] == name[len(name) - 1]:
                    count_index_typed += 1
                else:
                    return False
        return result


if __name__ == '__main__':
    sol = Solution()
    print(sol.isLongPressedName("vtkgn", "vttkgnn"))
    print(sol.isLongPressedName("alex", "aaleexa"))
    print(sol.isLongPressedName("pyplrz", "ppyypllr"))