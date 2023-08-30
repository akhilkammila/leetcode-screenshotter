class Solution {
private:
    // Calculate the sum of all of the results from multiplyOneDigit.
    string sumResults(vector<vector<int>>& results) {
        // Initialize answer as a number from results.
        vector<int> answer = results.back();
        vector<int> newAnswer;
        results.pop_back();
        
        // Sum each digit from answer and result
        for (vector<int> result : results) {
            newAnswer.clear();
            int carry = 0;
            
            for (int i = 0; i < answer.size() || i < result.size(); ++i) {
                // If answer is shorter than result or vice versa, use 0 as the current digit.
                int digit1 = i < result.size() ? result[i] : 0;
                int digit2 = i < answer.size() ? answer[i] : 0;
                // Add current digits of both numbers.
                int sum = digit1 + digit2 + carry;
                // Set carry equal to the tens place digit of sum.
                carry = sum / 10;
                // Append the ones place digit of sum to answer.
                newAnswer.push_back(sum % 10);
            }

            if (carry) {
                newAnswer.push_back(carry);
            }
            answer = newAnswer;
        }
        
        // Convert answer to a string.
        string finalAnswer;
        for (int digit : answer) {
            finalAnswer.push_back(digit + '0');
        }
        return finalAnswer;
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
        
        // Reverse both numbers.
        reverse(firstNumber.begin(), firstNumber.end());
        reverse(secondNumber.begin(), secondNumber.end());
        
        // For each digit in secondNumber, multipy the digit by firstNumber and
        // store the multiplication result (reversed) in results.
        vector<vector<int>> results;
        for (int i = 0; i < secondNumber.size(); ++i) {
            results.push_back(multiplyOneDigit(firstNumber, secondNumber[i], i));
        }
        
        // Add all the results in the results array, and store the sum in the answer string.
        string answer = sumResults(results);
        
        // answer is reversed, so reverse it to get the final answer.
        reverse(answer.begin(), answer.end());
        return answer;
    }
};