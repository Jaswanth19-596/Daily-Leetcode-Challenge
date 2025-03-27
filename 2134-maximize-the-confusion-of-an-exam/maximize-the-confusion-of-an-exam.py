class Solution:
    def maxConsecutiveAnswers(self, answerKey: str, k: int) -> int:
        
        falseCount = 0

        start = 0
        end = 0

        longest1 = 0

        while(end < len(answerKey)):

            ch = answerKey[end]

            if ch == 'F':
                falseCount += 1

            while falseCount > k:

                startch = answerKey[start]

                if startch == 'F':
                    falseCount -= 1

                start += 1

            longest1 = max(longest1, end - start + 1)
            end += 1

        longest1 = max(longest1, end - start)

        start = 0
        end = 0
        trueCount = 0
        longest2 = 0

        while(end < len(answerKey)):

            ch = answerKey[end]

            if ch == 'T':
                trueCount += 1

            while trueCount > k:

                startch = answerKey[start]

                if startch == 'T':
                    trueCount -= 1

                start += 1

            longest2 = max(longest2, end - start + 1)
            end += 1

        longest2 = max(longest2, end - start)


        return max(longest1, longest2)
