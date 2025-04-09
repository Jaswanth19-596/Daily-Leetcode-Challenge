
from collections import Counter

class Solution:


    def longestSubstring(self, s: str, k: int) -> int:
        
        if len(s) < k:
            return 0

        maxLength = 0
   
        def helper(start, end):
        
            if start > end:
                return 0

            nonlocal s
            invalidChars = set()
            dictionary = Counter(s[start:end + 1])

            for key, value in dictionary.items():
                if value < k:
                    invalidChars.add(key)

            for i in range(start, end + 1):

                if s[i] in invalidChars:
                    leftMax = helper(start, i - 1)
                    rightMax = helper(i + 1, end)
                    
                    return max(leftMax, rightMax)

            return end - start + 1

        maxLength = helper(0, len(s) - 1)

        return maxLength



