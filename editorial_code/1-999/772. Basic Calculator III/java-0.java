class Solution {
    private int evaluate(char operator, int x, int y) {
        if (operator == '+') {
            return x;
        } else if (operator == '-') {
            return -x;
        } else if (operator == '*') {
            return x * y;
        }
        
        return x / y;
    }
    
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char previousOperator = '+';
        s += "@";
        
        for (char c: s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            
            if (Character.isDigit(c)) {
                curr = curr * 10 + Character.getNumericValue(c);
            } else {
                if (previousOperator == '*' || previousOperator == '/') {
                    stack.push(evaluate(previousOperator, stack.pop(), curr));
                } else {
                    stack.push(evaluate(previousOperator, curr, 0));
                }
                
                curr = 0;
                previousOperator = c;
            }
        }
        
        int ans = 0;
        for (int num: stack) {
            ans += num;
        }
        
        return ans;
    }
}