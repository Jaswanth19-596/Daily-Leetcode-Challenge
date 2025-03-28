class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        # Find the longest subarray which can have atmost k zeroes

        highest = 0

        start = 0
        end = 0

        nzeroes = 0

        while end < len(nums):

            if nums[end] == 0:
                nzeroes += 1

            while nzeroes > k:

                if nums[start] == 0:
                    nzeroes -= 1

                start += 1

            highest = max(highest, end - start + 1)
            end += 1

        return highest