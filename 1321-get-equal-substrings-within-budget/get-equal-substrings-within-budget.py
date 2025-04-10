class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        
        # Keep adding elements till maxCost > Difference
        # While maxCost < difference:
            # Remove elements from the front and add the difference to the maxCost


        start = 0
        end = 0

        maxLength = 0

        while end < len(s):

            diff = abs(ord(s[end]) - ord(t[end]))

            while diff > maxCost:

                prevDiff = abs(ord(s[start]) - ord(t[start]))
                maxCost += prevDiff
                start += 1

            maxCost -= diff
            maxLength = max(maxLength, end - start + 1)
            end += 1

        return maxLength

            
