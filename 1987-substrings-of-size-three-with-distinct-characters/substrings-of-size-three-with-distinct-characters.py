class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        
        if len(s) < 3:
            return 0


        i = 0
        j = 1
        k = 2

        count = 0
        while k < len(s):

            if s[i] == s[j] or s[j] == s[k] or s[k] == s[i]:
                pass
            else:
                count += 1

            i += 1
            j += 1
            k += 1

        return count





        # Use three pointers on the first three characters.
        # Check if any of these three pointer are equal
        # if yes:
        #   Just move the pointers to the next step
        # else:
        #   Increase the count and increase the pointers.