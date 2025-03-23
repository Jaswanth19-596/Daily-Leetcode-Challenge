class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        # The order of the k students doesn't matter

        if k == 1:
            return 0

        nums.sort()

        i = 0

        for i in range(k-1):
            i += 1

        res = nums[i] - nums[i-k + 1]

        for i in range(k, len(nums)):
            res = min(res, nums[i]- nums[i-k + 1])
            i+=1

        return res