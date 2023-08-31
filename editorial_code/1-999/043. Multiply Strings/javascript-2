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
    let answer = new Array(N).fill(0);
        
    for (let place2 = 0; place2 < secondNumber.length; place2++) {
        let digit2 = Number(secondNumber[place2]);

        // For each digit in secondNumber multiply the digit by all digits in firstNumber.
        for (let place1 = 0; place1 < firstNumber.length; place1++) {
            let digit1 = Number(firstNumber[place1]);

            // The number of zeros from multiplying to digits depends on the 
            // place of digit2 in secondNumber and the place of the digit1 in firstNumber.
            let currentPos = place1 + place2;

            // The digit currently at position currentPos in the answer string
            // is carried over and summed with the current result.
            let carry = answer[currentPos];
            let multiplication = digit1 * digit2 + carry;

            // Set the ones place of the multiplication result.
            answer[currentPos] = multiplication % 10;

            // Carry the tens place of the multiplication result by 
            // adding it to the next position in the answer array.
            answer[currentPos + 1] += Math.floor(multiplication / 10);
        }
    }

    if (answer[answer.length - 1] == 0) {
        answer.pop();
    }

    // Ans is in the reversed order.
    // Reverse it to get the final ans.
    answer.reverse();
    return answer.join('');
};