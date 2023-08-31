class Solution:
    def parseTernary(self, expression: str) -> str:

        # To analyze the expression between two indices
        def solve(i, j):

            # If expression is a single character, return it
            if i == j:
                return expression[i]

            # Find the index of ?
            questionMarkIndex = i
            while expression[questionMarkIndex] != '?':
                questionMarkIndex += 1

            # Find one index after corresponding :
            aheadColonIndex = questionMarkIndex + 1
            count = 1
            while count != 0:
                if expression[aheadColonIndex] == '?':
                    count += 1
                elif expression[aheadColonIndex] == ':':
                    count -= 1
                aheadColonIndex += 1

            # Check the value of B and recursively solve
            if expression[i] == 'T':
                return solve(questionMarkIndex + 1, aheadColonIndex - 2)
            else:
                return solve(aheadColonIndex, j)

        # Solve for the entire expression
        return solve(0, len(expression) - 1)