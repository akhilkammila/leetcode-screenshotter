class Solution {
    // Calculate the sum of all of the results from multiplyOneDigit.
    private StringBuilder sumResults(ArrayList<ArrayList<Integer>> results) {
        // Initialize answer as a number from results.
        ArrayList<Integer> answer = new ArrayList<>(results.get(results.size() - 1));
        ArrayList<Integer> newAnswer = new ArrayList<>();
        
        // Sum each digit from answer and result
        for (int j = 0; j < results.size() - 1; ++j) {
            ArrayList<Integer> result = new ArrayList<>(results.get(j));
            newAnswer = new ArrayList<>();
            
            int carry = 0;
            
            for (int i = 0; i < answer.size() || i < result.size(); ++i) {
                // If answer is shorter than result or vice versa, use 0 as the current digit.
                int digit1 = i < result.size() ? result.get(i) : 0;
                int digit2 = i < answer.size() ? answer.get(i) : 0;
                // Add current digits of both numbers.
                int sum = digit1 + digit2 + carry;
                // Set carry equal to the tens place digit of sum.
                carry = sum / 10;
                // Append the ones place digit of sum to answer.
                newAnswer.add(sum % 10);
            }

            if (carry != 0) {
                newAnswer.add(carry);
            }
            answer = newAnswer;
        }
        
        // Convert answer to a string.
        StringBuilder finalAnswer = new StringBuilder(); 
        for (int digit : answer) {
            finalAnswer.append(digit);
        }
        return finalAnswer;
    }
    
    // Multiply the current digit of secondNumber with firstNumber.
    ArrayList<Integer> multiplyOneDigit(StringBuilder firstNumber, char secondNumberDigit, int numZeros) {
        // Insert zeros at the beginning based on the current digit's place.
        ArrayList<Integer> currentResult = new ArrayList<>();
        for (int i = 0; i < numZeros; ++i) {
            currentResult.add(0);
        }
        
        int carry = 0;

        // Multiply firstNumber with the current digit of secondNumber.
        for (int i = 0; i < firstNumber.length(); ++i) {
            char firstNumberDigit = firstNumber.charAt(i);
            int multiplication = (secondNumberDigit - '0') * (firstNumberDigit - '0') + carry;
            // Set carry equal to the tens place digit of multiplication.
            carry = multiplication / 10;
            // Append last digit to the current result.
            currentResult.add(multiplication % 10);
        }

        if (carry != 0) {
            currentResult.add(carry);
        }
        return currentResult;
    }
    
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        StringBuilder firstNumber = new StringBuilder(num1);
        StringBuilder secondNumber = new StringBuilder(num2);
        
        // Reverse both the numbers.
        firstNumber.reverse();
        secondNumber.reverse();
        
        // For each digit in secondNumber, multipy the digit by firstNumber and
        // store the multiplication result (reversed) in results.
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        for (int i = 0; i < secondNumber.length(); ++i) {
            results.add(multiplyOneDigit(firstNumber, secondNumber.charAt(i), i));
        }
        
        // Add all the results in the results array, and store the sum in the answer string.
        StringBuilder answer = sumResults(results);
        
        // answer is reversed, so reverse it to get the final answer.
        answer.reverse();
        return answer.toString();
    }
}