'''

Code
Testcase
Test Result
Test Result
941. Valid Mountain Array
Easy
Topics
premium lock icon
Companies
Hint
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]



Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true


Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
'''
class Solution:
    def validMountainArray(self, arr: list[int]) -> bool:
        if len(arr) < 3:
            return False
        if arr[0] >= arr[1]:
            return False
        #check is for last number directly - has to be lower than penultimate number
        if arr[len(arr)-1] >= arr[len(arr)-2]:
            return False
        counter_transitions = 0
        poz_transition = 0
        poz_start =0
        poz_end = 1
        while poz_end < len(arr):
            if arr[poz_start] == arr[poz_end]:
                return False
            elif arr[poz_start] < arr[poz_end]:
                poz_start += 1
                poz_end += 1
            #check transition
            elif arr[poz_start] > arr[poz_end]:
                # we need this to check if we have transition
                counter_transitions += 1
                pos_transition = poz_start
                #we brake and re-continue to count afterward
                break
        # first let's check if we have a transition - if not everything is monotonically increasing which is not ok
        if counter_transitions == 0:
            return False
        # we start counting from pos_transition till the end to check if we have decreasing stuff
        for i in range(pos_transition, len(arr)-1):
            if arr[i] <= arr[i+1]:
                return False
        #if not , we can return true
        return True

if __name__ == '__main__':
    arr = [2,1]
    arr2 = [3,5,5]
    arr3 = [0,3,2,1]
    arr4 = [0, 2, 3, 4, 5, 2, 1, 0]
    print(Solution().validMountainArray(arr))
    print(Solution().validMountainArray(arr2))
    print(Solution().validMountainArray(arr3))
    print(Solution().validMountainArray(arr4))


