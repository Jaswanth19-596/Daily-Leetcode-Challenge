class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        
        # I need to find longest subarray of 1's where the number of zeroes is 1
        # Just start with two pointers and increase the subarray till the number of zeroes == 1
        # if number of zeroes > 1:
        # increase the start pointer till number of zeroes become == 1

        start = 0
        end = 0

        longest = 0

        zeroes = 0
        while end < len(nums):
            if nums[end] == 0:
                zeroes += 1

            while zeroes > 1:
                if nums[start] == 0:
                    zeroes -= 1
                start += 1
            
            longest = max(longest, end - start)
            end += 1


        return longest
            
