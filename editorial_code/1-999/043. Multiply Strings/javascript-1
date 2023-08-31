// Function to add two strings.
let addStrings = function(num1, num2) {
    let ans = [];
    let carry = 0;

    for (let i = 0; i < num1.length || i < num2.length; ++i) {
        // If num2 is shorter than num1 or vice versa, use 0 as the current digit.
        let digit1 = i < num1.length ? num1[i] : 0;
        let digit2 = i < num2.length ? num2[i] : 0;
        
        // Add current digits of both numbers.
        let sum = digit1 + digit2 + carry;
        // Set carry equal to the tens place digit of sum.
        carry = Math.floor(sum / 10);
        // Append the ones place digit of sum to answer.
        ans.push(sum % 10);
    }
    
    if (carry) {
        ans.push(carry);
    }
    return ans;
}

// Multiply the current digit of secondNumber with firstNumber.
let multiplyOneDigit = function(firstNumber, secondNumberDigit, numZeros) {
    // Insert zeros at the beginning based on the current digit's place.
    let currentResult = [];
    for (let i = 0; i < numZeros; ++i) {
        currentResult.push(0);
    }

    let carry = 0;

    // Multiply firstNumber with the current digit of secondNumber.
    for (let i = 0; i < firstNumber.length; ++i) {
        let firstNumberDigit = firstNumber[i];
        let multiplication = (Number(secondNumberDigit) * Number(firstNumber[i])) + carry;
        // Set carry equal to the tens place digit of multiplication.
        carry = Math.floor(multiplication / 10);
        // Append last digit to the current result.
        currentResult.push(multiplication % 10);
    }

    if (carry) {
        currentResult.push(carry);
    }
    return currentResult;
};


let multiply = function(num1, num2) {
    if (num1 === "0" || num2 === "0") {
        return "0";
    }
        
    let firstNumber = [...num1];
    let secondNumber = [...num2];
    
    // Reverse both the numbers.
    firstNumber.reverse();
    secondNumber.reverse();

    // To store the multiplication result of each digit of secondNumber with firstNumber.
    let N = firstNumber.length + secondNumber.length;
    let ans = new Array(N).fill(0);
    
    // For each digit in secondNumber, multipy the digit by firstNumber and
    // add the multiplication result to ans.
    for (let i = 0; i < secondNumber.length; ++i) {
        // Add the current result to final ans.
        ans = addStrings(multiplyOneDigit(firstNumber, secondNumber[i], i), ans);
    }

    // Pop excess 0 from the rear of ans.
    if (ans[ans.length - 1] === 0) {
        ans.pop();
    }

    // Ans is in the reversed order.
    // Reverse it to get the final ans.
    ans.reverse();
    return ans.join('');
};