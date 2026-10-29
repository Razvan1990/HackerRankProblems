'''
Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.



Example 1:

Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
Example 2:

Input: nums = [2,3]
Output: [2,3]

'''

class Solution:
    def sortArrayByParityII(self, nums: list[int]) -> list[int]:
        results = []
        even_numbers = [x for x in nums if x % 2 ==0]
        odd_numbers = [x for x in nums if x % 2!=0]
        #now we can iterate and add at even place even number and at odd place odd number
        idx_even, idx_odd =0,0
        for i in range(len(nums)):
            if i % 2 ==0:
                results.append(even_numbers[idx_even])
                idx_even+=1
            else:
                results.append(odd_numbers[idx_odd])
                idx_odd+=1
        return results
