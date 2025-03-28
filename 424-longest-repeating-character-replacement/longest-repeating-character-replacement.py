class Solution:

    def checkDict(self, dict_s, k):

        maxFreq = 0

        totalFreq = 0

        for char, freq in dict_s.items():
            totalFreq += freq
            maxFreq = max(freq, maxFreq)

        remFreq = totalFreq - maxFreq
        if remFreq <= k:
            return True

        return False


    def characterReplacement(self, s: str, k: int) -> int:

        highest = 0


        end = 0
        start = 0

        dict_s = dict()

        for itr in range(26):
            dict_s[chr(65 + itr)] = 0

        while end < len(s):

            ch = s[end]

            dict_s[ch] += 1

            while self.checkDict(dict_s, k) == False:
                
                startingChar = s[start]

                dict_s[startingChar] -= 1

                start += 1

            end += 1
            highest = max(highest, end - start)

        return highest