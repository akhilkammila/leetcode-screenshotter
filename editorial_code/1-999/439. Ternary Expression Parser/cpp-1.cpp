class Solution {
public:
    string parseTernary(string expression) {
        
        // Reduce expression until we are left with a single character
        while (expression.size() != 1) {
            int questionMarkIndex = expression.size() - 1;
            while (expression[questionMarkIndex] != '?') {
                questionMarkIndex--;
            }
            
            // Find the value of the expression.
            char value;
            if (expression[questionMarkIndex - 1] == 'T') {
                value = expression[questionMarkIndex + 1];
            } else {
                value = expression[questionMarkIndex + 3];
            }
            
            // Replace the expression with the value
            expression = expression.substr(0, questionMarkIndex - 1) + value + expression.substr(questionMarkIndex + 4);
        }
        
        // Return the final character
        return expression;
    }
};