class Solution:
    def divisorSubstrings(self, num: int, k: int) -> int:
        
        # Create a new variable as a string version of num
        # create n substrings of length k and then convert them to integer and check if it is a divisor.
        # increment the count

        string = str(num)   

        count = 0

        for i in range(len(string) - k + 1):
            
            currNum = ""
            for j in range(i, i + k):

                currNum += string[j]

                if int(currNum) == 0:
                    continue
                
                if len(currNum) == k and num % int(currNum) == 0:
                    count += 1

        return count