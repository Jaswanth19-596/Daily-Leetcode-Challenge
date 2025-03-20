class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        
        highestAvg = -100000

        currentSum = 0

        for i in range(k):
            currentSum += nums[i]

        highestAvg = currentSum / k

        for i in range(k, len(nums)):

            currentSum += nums[i]
            currentSum -= nums[i-k]

            highestAvg = max(highestAvg, currentSum / k)

        return highestAvg