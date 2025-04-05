class Solution:

    def checkIfSorted(self, start, end, nums):
        for i in range(start + 1, end+1):

            if nums[i] - nums[i-1] != 1:
                return False

        return True

    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        
        res = []

        for i in range(len(nums) - k + 1):
            
            isSorted = self.checkIfSorted(i, i + k-1, nums)

            if isSorted == False:
                res.append(-1)
            else:
                res.append(nums[i+k-1])

        return res
        
