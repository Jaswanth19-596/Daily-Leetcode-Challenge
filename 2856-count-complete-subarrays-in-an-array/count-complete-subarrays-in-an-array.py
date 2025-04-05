class Solution:
    def countCompleteSubarrays(self, nums: List[int]) -> int:
        
        freq = dict()

        for i in nums:
            freq[i] = 1

        totalUnique = len(freq)

        freq.clear()

        start = 0
        end = 0

        count = 0

        print(totalUnique)

        while end < len(nums):

            ele = nums[end]

            if ele in freq:
                freq[ele] += 1
            else:
                freq[ele] = 1

            while len(freq) == totalUnique:
                count += len(nums) - end
                startele = nums[start]
                freq[startele] -= 1
                if freq[startele] == 0:
                    del freq[startele]
                start += 1

            end += 1

        return count


