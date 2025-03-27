class Solution:


    

    def minOperations(self, nums: List[int]) -> int:
        # for index in range(0, len(nums) - 2):
        # if curr element == 0:
            # Grab the consecutive 3 elements and flip them
        # else:
        #   skip to the next iteration.


        count = 0
        for i in range(0, len(nums) - 2):

            currElement = nums[i]

            if currElement == 0:
                count += 1
                nums[i] = 1 - nums[i]
                nums[i+1] = 1 - nums[i+1]
                nums[i+2] = 1 - nums[i+2]

        for i in range(len(nums) - 2, len(nums)):
            if nums[i] == 0:
                return -1

        return count
                


