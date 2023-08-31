class Solution {
    func parseTernary(_ expression: String) -> String {
        
        // Initialize a stack
        var stack = [Character]()
        var i = expression.count - 1
        let expression = Array(expression)

        // Traverse the expression from right to left
        while i >= 0 {

            // Current character
            let curr = expression[expression.index(expression.startIndex, offsetBy: i)]
            
            // Push every T, F, and digit on the stack
            if curr >= "0" && curr <= "9" || curr == "T" || curr == "F" {
                stack.append(curr)
            }
            
            // As soon as we encounter ?, 
            // replace top two elements of the stack with one
            else if curr == "?" {
                let onTrue = stack.removeLast()
                let onFalse = stack.removeLast()
                stack.append(expression[expression.index(expression.startIndex, offsetBy: i - 1)] == "T" ? onTrue : onFalse)
                
                // Decrement i by 1 as we have already used
                // Previous Boolean character
                i -= 1
            }
            
            // Go to the previous character
            i -= 1
        }
        
        // Return the final character
        return String(stack.removeLast())
    }
}