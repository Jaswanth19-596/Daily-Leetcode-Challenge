class Solution:
    def findLHS(self, nums: List[int]) -> int:
        
        nums.sort()

        l = 0
        r = 1
        result = 0


        while r < len(nums):

            diff = nums[r] - nums[l]

            if diff == 1:
                result = max(result, r - l + 1)
                r += 1
            elif diff > 1:
                l += 1
            else:
                r +=1

        return result
