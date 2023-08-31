class Solution {
    public String parseTernary(String expression) {
        
        int i = 0;
        for ( ; i < expression.length(); ) {
            
            if (expression.charAt(i) != 'T' && expression.charAt(i) != 'F'
            || i == expression.length() - 1 || expression.charAt(i + 1) == ':') {
                break;
            }
            if (expression.charAt(i) == 'T') {
                i += 2;
            } else {
                int count;
                for (count = 1, i += 2; count != 0; i++) {
                    if (expression.charAt(i) == ':') {
                        count--;
                    } else if (expression.charAt(i) == '?') {
                        count++;
                    }
                }
            }
        }

        return expression.substring(i, i + 1);
    }
}