class Solution {
private:
    // Function to add two strings.
    vector<int> addStrings(vector<int> num1, vector<int>& num2) {
        vector<int> ans;
        int carry = 0;
        
        for (int i = 0; i < num1.size() || i < num2.size() || carry; ++i) {
            // If num1 is shorter than num2 or vice versa, use 0 as the current digit.
            int digit1 = i < num1.size() ? num1[i] : 0;
            int digit2 = i < num2.size() ? num2[i] : 0;
            
            // Add current digits of both numbers.
            int sum = digit1 + digit2 + carry;
            // Set carry equal to the tens place digit of sum.
            carry = sum / 10;
            // Append the ones place digit of sum to answer.
            ans.push_back(sum % 10);
        }
        
        return ans;
    }
    
     // Multiply the current digit of secondNumber with firstNumber.
    vector<int> multiplyOneDigit(string& firstNumber, char& secondNumberDigit, int numZeros) {
        // Insert zeros at the beginning based on the current digit's place.
        vector<int> currentResult(numZeros, 0);
        int carry = 0;

        // Multiply firstNumber with the current digit of secondNumber.
        for (char firstNumberDigit : firstNumber) {
            int multiplication = (secondNumberDigit - '0') * (firstNumberDigit - '0') + carry;
            // Set carry equal to the tens place digit of multiplication.
            carry = multiplication / 10;
            // Append last digit to the current result.
            currentResult.push_back(multiplication % 10);
        }

        if (carry) {
            currentResult.push_back(carry);
        }
        return currentResult;
    }
    
public:
    string multiply(string firstNumber, string secondNumber) {
        if (firstNumber == "0" || secondNumber == "0") {
            return "0";
        }
        
        // Reverse both the numbers.
        reverse(firstNumber.begin(), firstNumber.end());
        reverse(secondNumber.begin(), secondNumber.end());
        
        // To store the multiplication result of each digit of secondNumber with firstNumber.
        vector<int> ans(firstNumber.size() + secondNumber.size(), 0);
        
        // For each digit in secondNumber, multipy the digit by firstNumber and
        // add the multiplication result to ans.
        for (int i = 0; i < secondNumber.size(); ++i) {
            // Add the current result to final ans.
            ans = addStrings(multiplyOneDigit(firstNumber, secondNumber[i], i), ans);
        }
        
        // Pop excess 0 from the rear of ans.
        if (ans[ans.size() - 1] == 0) {
            ans.pop_back();
        }
        
        // Ans is in the reversed order.
        // Copy it in reverse order to get the final ans.
        string answer;
        for (int i = ans.size() - 1; i >= 0; --i) {
            answer.push_back(ans[i] + '0');
        }
        
        return answer;
    }
};