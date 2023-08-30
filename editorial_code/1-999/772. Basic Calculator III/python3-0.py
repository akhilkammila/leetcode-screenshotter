class Solution:
    def calculate(self, s: str) -> int:
        def evaluate(operator, x, y = 0):
            if operator == "+":
                return x
            if operator == "-":
                return -x
            if operator == "*":
                return x * y
            return int(x / y)
        
        stack = []
        curr = 0
        previous_operator = "+"
        s += "@"
        
        for c in s:
            if c == " ":
                continue
            if c.isdigit():
                curr = curr * 10 + int(c)
            else:
                if previous_operator in "*/":
                    stack.append(evaluate(previous_operator, stack.pop(), curr))
                else:
                    stack.append(evaluate(previous_operator, curr))
                
                curr = 0
                previous_operator = c

        return sum(stack)