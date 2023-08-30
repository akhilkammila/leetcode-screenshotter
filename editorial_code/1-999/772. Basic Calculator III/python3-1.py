class Solution:
    def calculate(self, s: str) -> int:
        def evaluate(x, y, operator):
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
            if c.isdigit():
                curr = curr * 10 + int(c)
            elif c == "(":
                stack.append(previous_operator)
                previous_operator = "+"
            else:
                if previous_operator in "*/":
                    stack.append(evaluate(stack.pop(), curr, previous_operator))
                else:
                    stack.append(evaluate(curr, 0, previous_operator))
                
                curr = 0
                previous_operator = c
                if c == ")":
                    while type(stack[-1]) == int:
                        curr += stack.pop()
                    previous_operator = stack.pop()

        return sum(stack)