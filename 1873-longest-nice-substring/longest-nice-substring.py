class Solution:


    def func(self, string, start, end):

        if start > end:
            return ""
        
        if start == end:
            return ""

        freq = {}

        for i in range(0, 26):

            freq[chr(97 + i)] = 0
            freq[chr(65 + i)] = 0

        
        for i in range(start, end + 1):

            freq[string[i]] = 1

        
        for i in range(start, end + 1):
            ch = string[i]

            if (ch.islower() and freq[chr(ord(ch) - 32)] == 0) or (ch.isupper() and freq[chr(ord(ch) + 32)] == 0):
                str1 = self.func(string, start, i - 1)
                str2 = self.func(string, i + 1, end)

                if len(str1) >= len(str2):
                    return str1
                else:
                    return str2

        return string[start : end + 1]

        





    def longestNiceSubstring(self, s: str) -> str:
        res = self.func(s, 0, len(s) - 1)
        
        return res


