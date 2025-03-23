class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        
        # create a string variable out of num
        # Keep two pointers i and j  which represent the start and end of window
        # slice from string and then convert to integer and check if it's a divisor


        string = str(num)

        start = 0
        end = 0

        for i in range(k - 1):
            end += 1

        
        count = 0

        for i in range(k-1 , len(string)):

            substr = string[start: end + 1]

            if int(substr) != 0 and num % int(substr) == 0:
                count += 1

            start += 1
            end += 1

        return count 