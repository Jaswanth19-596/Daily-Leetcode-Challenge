class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        if len(nums) < 3:
            return 0
        # First I'll be having two pointers
        # start, end
        # I will keep the start at the starting position and end at first element and get their diff in a diff varaible.
        # Now i will move the end pointer till the diff between end and end - 1 ! = diff.
        # if end - (end - 1) != diff:
            # num = end - start
            # count += (num * (num + 1)/2)
            # start = end - 1
            # diff = end - (end - 1)
        # else:
            # end += 1

        start = 0
        end = 1

        diff = nums[end] - nums[start]

        count = 0
        while(end < len(nums)):

            newDiff = nums[end] - nums[end - 1]

            if newDiff != diff:
                
                numberOfElements = (end - start) - 2
                if numberOfElements >= 0:
                    count += ((numberOfElements * (numberOfElements + 1)) // 2)

                start = end - 1

                diff = newDiff
            else:
                end += 1 

        numberOfElements = (end - start) - 2
        if numberOfElements >= 0:
            count += ((numberOfElements * (numberOfElements + 1)) // 2)
        return count
            # end += 1