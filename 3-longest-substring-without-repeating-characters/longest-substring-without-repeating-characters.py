class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        # Using sliding window
        # i will have two pointers
        # one points to the end of window and the other points to start of window
        # i will use a set
        # This set will help me to identify duplicates

        if len(s) <= 1:
            return len(s)

        start = 0
        end = 0
        seen = set()
        maxLength = 0

        while end < len(s):

            while s[end] in seen:
                seen.remove(s[start])
                start += 1

            seen.add(s[end])
            maxLength = max(maxLength, end - start + 1)
            end += 1

        return maxLength