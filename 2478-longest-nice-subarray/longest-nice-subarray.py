class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:
        
        if len(nums) == 1:
            return 1

        
        res = 1

        start, end = 0, 0
        currWindow = 0

        while end < len(nums):

            while end < len(nums) and currWindow & nums[end] == 0:
                currWindow = currWindow | nums[end]
                end += 1
                res = max(res, end - start)

            while start < end and end < len(nums) and currWindow & nums[end] != 0:
                currWindow = currWindow ^ nums[start]
                start += 1

        return res