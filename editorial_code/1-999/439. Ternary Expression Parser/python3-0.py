class Solution:
    def parseTernary(self, expression: str) -> str:

        # Checks if the string s is a valid atomic expression
        def isValidAtomic(s):
            return s[0] in 'TF' and s[1] == '?' and s[2] in 'TF0123456789'\
                and s[3] == ':' and s[4] in 'TF0123456789'

        # Returns the value of the atomic expression
        def solveAtomic(s):
            return s[2] if s[0] == 'T' else s[4]

        # Reduce expression until we are left with a single character
        while len(expression) != 1:
            j = len(expression) - 1
            while not isValidAtomic(expression[j-4:j+1]):
                j -= 1
            expression = expression[:j-4] + \
                solveAtomic(expression[j-4:j+1]) + expression[j+1:]

        # Return the final character
        return expression