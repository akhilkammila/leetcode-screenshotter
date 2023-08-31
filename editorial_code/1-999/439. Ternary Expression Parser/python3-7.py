class Solution:
    def parseTernary(self, expression: str) -> str:

        i = 0
        while True:

            if expression[i] not in 'TF' or i == len(expression) - 1\
            or expression[i + 1] == ':':
                return expression[i]
            if expression[i] == 'T':
                i = i + 2
            else:
                count = 1
                i = i + 2
                while count != 0:
                    if expression[i] == ':':
                        count -= 1
                    elif expression[i] == '?':
                        count += 1
                    i += 1