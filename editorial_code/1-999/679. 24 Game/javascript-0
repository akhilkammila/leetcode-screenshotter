// All possible operations we can perform on two numbers.
let generatePossibleResults = (a, b) => {
    let res = [ a + b, a - b, b - a, a * b ];
    if (a) {
        res.push(b / a);
    }
    if (b) {
        res.push(a / b);
    }
    return res;
}

// Check if using current list we can react result 24.
let checkIfResultReached = list => {
    if (list.length == 1) {
        // Base Case: We have only one number left, check if it is approximately 24.
        return Math.abs(list[0] - 24.0) <= 0.1;
    }

    for (let i = 0; i < list.length; i++) {
        for (let j = i + 1; j < list.length; j++) {
            // Create a new list with the remaining numbers and the new result.
            let newList = [];
            for (let k = 0; k < list.length; k++) {
                if (k != i && k != j) {
                    newList.push(list[k]);
                }
            }
            
            // For any two numbers in our list,
            // we perform every operation one by one.
            let results = generatePossibleResults(list[i], list[j]);
            for (let resIdx = 0; resIdx < results.length; ++resIdx) {
                // Push the new result in the list
                newList.push(results[resIdx]);
                
                // Check if using this new list we can obtain the result 24.
                if (checkIfResultReached(newList)) {
                    return true;
                }
                
                // Backtrack: remove the result from the list.
                newList.pop();
            }
        }
    }
    return false;
};

let judgePoint24 = cards => checkIfResultReached(cards);