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
    
    private int solve(String s, int[] i) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        char previousOperator = '+';
        
        while (i[0] < s.length()) {
            char c = s.charAt(i[0]);
            if (c == '(') {
                i[0]++;
                curr = solve(s, i);
            } else if (Character.isDigit(c)) {
                curr = curr * 10 + Character.getNumericValue(c);
            } else {
                if (previousOperator == '*' || previousOperator == '/') {
                    stack.push(evaluate(previousOperator, stack.pop(), curr));
                } else {
                    stack.push(evaluate(previousOperator, curr, 0));
                }
                
                if (c == ')') {
                    break;
                }
                
                curr = 0;
                previousOperator = c;
            }
            
            i[0]++;
        }
        
        int ans = 0;
        for (int num: stack) {
            ans += num;
        }
        
        return ans;
    }
    
    public int calculate(String s) {
        s += "@";
        int[] i = new int[1];
        return solve(s, i);
    }
}