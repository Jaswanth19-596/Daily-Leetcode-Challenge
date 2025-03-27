class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        
        if len(arr) < 3:
            return 0



        count = 0
        sum_k = 0
        for i in range(k):
            sum_k += arr[i]


        i = k 
        while i < len(arr):
            avg = sum_k / k

            if avg >= threshold:
                count += 1

            sum_k -= arr[i - k]
            sum_k += arr[i]
            i+=1

        avg = sum_k / k
        if avg >= threshold:
            count += 1

        return count