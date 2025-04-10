class Solution:


    def createPrefixArr(self, nums, k):

        if k == 1:
            return nums


        prefixArr = []

        currSum = 0
        for i in range(k):
            currSum += nums[i]

        prefixArr.append(currSum)

        for i in range(k, len(nums)):
            currSum = currSum - nums[i-k]
            currSum = currSum +  nums[i]
            prefixArr.append(currSum)

        return prefixArr




    def maxSumTwoNoOverlap(self, nums: List[int], firstLen: int, secondLen: int) -> int:

        # if firstLen < secondLen:
        #     firstLen, secondLen = secondLen, firstLen


        firstPrefixArr = self.createPrefixArr(nums, firstLen)
        secondPrefixArr = self.createPrefixArr(nums, secondLen)



        # print(firstPrefixArr)
        # print(secondPrefixArr)


        finalMax = 0
        for i in range(len(firstPrefixArr)):

            start = i
            end = i + firstLen - 1

            noOfElementsLeft = len(nums) - end - 1

            noOfSubarraysFormedOnRight = noOfElementsLeft - secondLen + 1
            noOfSubarraysFormedOnLeft = i - secondLen + 1

            currMax = 0
            for j in range(noOfSubarraysFormedOnLeft):
                currMax = max(currMax, secondPrefixArr[j])

            for j in range(len(secondPrefixArr) - noOfSubarraysFormedOnRight, len(secondPrefixArr)):
                currMax = max(currMax, secondPrefixArr[j])


            finalMax = max(finalMax, currMax + firstPrefixArr[i])

        return finalMax