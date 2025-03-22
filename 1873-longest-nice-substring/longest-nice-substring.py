class Solution:


    def isNiceSubstring(self, string):

        dict1 = {}

        for i in range(26):
            capital = chr(65 + i)
            small = chr(97 + i)

            dict1[capital] = 0
            dict1[small] = 0
        
        for ch in string:

            dict1[ch] = 1

        for ch in string:

            if ch.islower() and dict1[chr(ord(ch) - 32)] == 0:
                return False
                
            if ch.isupper() and dict1[chr(ord(ch) + 32)] == 0:
                return False

        return True





    def longestNiceSubstring(self, s: str) -> str:
        # 1. Generate all possible substrings
        # 2. For every substring:
            # 3. Create a dictionary that has all the alphabets.
            # 4. Traverse the substring and then populate the dictionary.
            # 5. And then again traverse the substring and for every character, check for both small and capital versions.
            # 6. If charater is small : check for character and character - 32
            # 7. If character is capital : check for character and character + 32
        longestSubstring = ""
        for i in range(len(s)):
            substr = ""
            for j in range(i, len(s)):
                substr += s[j]

                res = self.isNiceSubstring(substr)

                if res == True and len(substr) > len(longestSubstring):
                    longestSubstring = substr

        return longestSubstring



