function parseTernary(expression: string): string {
    // Initialize a stack
    const stack: string[] = [];
    let i = expression.length - 1;

    // Traverse the expression from right to left
    while (i >= 0) {

        // Current character
        const curr = expression[i];

        // Push every T, F, and digit on the stack
        if (curr >= '0' && curr <= '9' || curr === 'T' || curr === 'F') {
            stack.push(curr);
        }

        // As soon as we encounter ?,
        // replace top two elements of the stack with one
        else if (curr === '?') {
            const onTrue = stack.pop();
            const onFalse = stack.pop();
            stack.push(expression[i - 1] === 'T' ? onTrue : onFalse);

            // Decrement i by 1 as we have already used
            // Previous Boolean character
            i -= 1;
        }

        // Go to the previous character
        i -= 1;
    }

    // Return the final character
    return stack.pop();
};