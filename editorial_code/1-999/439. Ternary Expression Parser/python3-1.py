class Solution:
    def parseTernary(self, expression: str) -> str:

        # Reduce expression until we are left with a single character
        while len(expression) != 1:
            questionMarkIndex = len(expression) - 1
            while expression[questionMarkIndex] != '?':
                questionMarkIndex -= 1

            # Find the value of the expression.
            if expression[questionMarkIndex - 1] == 'T':
                value = expression[questionMarkIndex + 1]
            else:
                value = expression[questionMarkIndex + 3]

            # Replace the expression with the value
            expression = expression[:questionMarkIndex - 1] + value\
                + expression[questionMarkIndex + 4:]

        # Return the final character
        return expression