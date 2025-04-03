class Solution:
    def minSwaps(self, nums: List[int]) -> int:

        totalones = 0

        for i in range(len(nums)):
            if nums[i] == 1:
                totalones += 1

        if totalones == 0 or totalones == len(nums):
            return 0

        windowsize = totalones

        maxones = 0
        currones = 0
        for i in range(windowsize):            

            if nums[i] == 1:
                currones += 1

        maxones = currones


        for i in range(len(nums)):

            currones += nums[(i + totalones) % len(nums)]
            currones -= nums[i]

            maxones= max(maxones, currones)

        return totalones - maxones


