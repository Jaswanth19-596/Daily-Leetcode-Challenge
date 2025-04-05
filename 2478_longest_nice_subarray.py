class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return 1

        longest = 1

        start, end = 0, 1

        curr = nums[start]

        while end < len(nums):

            while (curr & nums[end]) != 0:  # If there is a conflict
                curr ^= nums[start]  # Remove nums[start] from used_bits
                start += 1  # Shrink the window

            curr |= nums[end]  # Add nums[end] to OR
            longest = max(longest, end - start + 1) 

            end += 1

     


        return longest