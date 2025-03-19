class Solution:
    def findLHS(self, nums: List[int]) -> int:
        
        freq = {}

        for ele in nums:
            if ele in freq:
                freq[ele] += 1
            else:
                freq[ele] = 1

        maxSequence = 0

        for ele in nums:

            if ele + 1 in freq:
                maxSequence = max(maxSequence, freq[ele] + freq[ele + 1])
            
            if ele - 1 in freq:
                maxSequence = max(maxSequence, freq[ele] + freq[ele - 1])

        return maxSequence