class Solution:

    def func(self, arr, k):

        appended_arr = arr + arr
        n = len(arr)

        i = n - k

        currentSum = 0
        res = []
        for itr in range(i, i + abs(k)):

            currentSum += appended_arr[itr]

        # res.append(currentSum)

        for itr in range(i + abs(k), len(appended_arr)):
            res.append(currentSum)
            currentSum += appended_arr[itr]
            currentSum -= appended_arr[itr-abs(k)]

        return res


    def reverse_array(self, arr):

        i , j = 0, len(arr) - 1

        while( i < j):
            arr[i], arr[j] = arr[j], arr[i]
            i += 1
            j -= 1

        return arr


    def decrypt(self, code: List[int], k: int) -> List[int]:
        
        if k == 0:
            res = []
            for i in range(len(code)):
                res.append(0)
            return res

        if k > 0:
            arr = self.reverse_array(code)
            res = self.func(arr, k)
            res = self.reverse_array(res)
            return res
        if k < 0:
            res = self.func(code, abs(k))
            return res