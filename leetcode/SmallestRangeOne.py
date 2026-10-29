class Solution:
    def smallestRangeI(self, nums: list[int], k: int) -> int:
        '''
        1. Sort the array
        2. get the mean of the min and max
        3. determine if the mean can be satisified by k
        4. we can use brute force and keep count of the min
        :param nums:
        :param k:
        :return: min value between max and min
        '''
        result =0
        if len(nums) < 2:
            return 0
        nums.sort()
        mean_value = (nums[len(nums)-1] + nums[0]) //2
        if mean_value <k:
            return 0
        else:
            result = nums[len(nums)-1] - nums[0]
            for i in range(0, k+1):
                for j in range (0, k+1):
                    new_result = abs((nums[len(nums)-1] -i) - (nums[0] + j))
                    result = min(result, new_result)
        return result

    def smallestRangeIb(self, nums: list[int], k: int) -> int:
        result = 0
        if len(nums) < 2:
            return 0
        max_val = max(nums)
        min_val = min(nums)
        mean_value = (max_val - min_val) // 2
        if mean_value < k:
            return 0
        else:
            result = max_val - min_val
            for i in range(0, k + 1):
                for j in range(0, k + 1):
                    new_result = abs(max_val- i) - (min_val + j)
                    result = min(result, new_result)
        return result


if __name__ == '__main__':
    sol = Solution()
    nums1 =[1]
    k1 =0
    nums2 =[0, 10]
    k2=2
    nums3=[1,3,6]
    k3=3
    nums4 = [1, 12, 9, 13]
    k4=10
    nums5 = [1, 12, 9, 13]
    k5=4
    nums6 =[2,7,2]
    k6=1
    print(sol.smallestRangeI(nums1,k1))
    print(sol.smallestRangeI(nums2,k2))
    print(sol.smallestRangeI(nums3,k3))
    print(sol.smallestRangeI(nums4,k4))
    print(sol.smallestRangeI(nums5,k5))
    print("---------------------------")
    print(sol.smallestRangeIb(nums1,k1))
    print(sol.smallestRangeIb(nums2,k2))
    print(sol.smallestRangeIb(nums3,k3))
    print(sol.smallestRangeIb(nums4,k4))
    print(sol.smallestRangeIb(nums5,k5))
    print(sol.smallestRangeIb(nums6,k6))

