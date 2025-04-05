class Solution:


    def fill(self,res, start , k):
        # if start >= len(res):
        #     return
        stop = start - (k - 1)
        while start >= 0 and start > stop:
            if start < len(res):
                res[start] = -1
            start -= 1

        


    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        
        # Go through the array and find the mismatches:
            # If there is a mismatch:
                # Start from the first element and go backwards till k-1 elements
                # Fill all of these with -1

            # else
                # Move to the next element

        res = [0] * (len(nums) - k + 1)

        if k == 1 and len(nums) == 1:
            return nums
        if k == 1:
            return nums

        for i in range(len(nums)-1):

            if nums[i] - nums[i+1] != -1:

                self.fill(res, i, k)
                
        for i in range(len(nums) - k + 1):

            if res[i] == 0:
                res[i] = nums[i + k - 1]

        return res

        