class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        
        vowels = 0
        maxVowels = 0
        vowelset = {'a', 'e', 'i', 'o', 'u'}

        end = 0

        while end < k:

            if s[end] in vowelset:
                vowels += 1
            end += 1
        maxVowels = max(vowels, maxVowels)
        while end < len(s):

            if s[end - k] in vowelset:
                vowels -= 1
            
            if s[end] in vowelset:
                vowels += 1

            maxVowels = max(vowels, maxVowels)

            end += 1

        return maxVowels