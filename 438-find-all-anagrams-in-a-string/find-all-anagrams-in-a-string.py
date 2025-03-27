class Solution:

    def initializeDict(self):
        dict_p = {}

        for i in range(0, 26):

            dict_p[chr(97 + i)] = 0

        return dict_p

    def compareDict(self, dict1, dict2):

        for i in range(26):
            ch = chr(97 + i)

            if dict1[ch] != dict2[ch]:
                return False

        return True

    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        if len(p) > len(s):
            return []

        dict_p = self.initializeDict()

        for ch in p:
            dict_p[ch] += 1


        res = []

        dict_s = self.initializeDict()

        for i in range(0, len(p)):
            dict_s[s[i]] += 1

        if self.compareDict(dict_p, dict_s):
            res.append(0)

        for i in range(len(p), len(s)):

            prevChar = s[i - len(p)]
            currChar = s[i]

            dict_s[prevChar] -= 1
            dict_s[currChar] += 1

            if self.compareDict(dict_p, dict_s):
                res.append(i - len(p) + 1)

        return res
            


