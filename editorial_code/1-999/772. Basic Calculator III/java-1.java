class Solution {
    private String evaluate(char operator, String first, String second) {
        int x = Integer.parseInt(first);
        int y = Integer.parseInt(second);
        int res = 0;
        
        if (operator == '+') {
            res = x;
        } else if (operator == '-') {
            res = -x;
        } else if (operator == '*') {
            res = x * y;
        } else {
            res = x / y;
        }
        
        return Integer.toString(res);
    }
    
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        String curr = "";
        char previousOperator = '+';
        s += "@";
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                curr += c;
            } else if (c == '(') {
                stack.push("" + previousOperator); // convert char to string before pushing
                previousOperator = '+';
            } else {
                if (previousOperator == '*' || previousOperator == '/') {
                    stack.push(evaluate(previousOperator, stack.pop(), curr));
                } else {
                    stack.push(evaluate(previousOperator, curr, "0"));
                }
                
                curr = "";
                previousOperator = c;
                if (c == ')') {
                    int currentTerm = 0;
                    while (!operators.contains(stack.peek())) {
                        currentTerm += Integer.parseInt(stack.pop());
                    }
                    
                    curr = Integer.toString(currentTerm);
                    previousOperator = stack.pop().charAt(0); // convert string from stack back to char
                }
            }
        }
        
        int ans = 0;
        for (String num: stack) {
            ans += Integer.parseInt(num);
        }

        return ans;
    }
}