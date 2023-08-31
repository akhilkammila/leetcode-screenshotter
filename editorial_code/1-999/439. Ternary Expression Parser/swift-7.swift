class Solution {
    func parseTernary(_ expression: String) -> String {
        
        var i = 0
        for _ in 0..<expression.count {
            
            if expression[expression.index(expression.startIndex, offsetBy: i)] != "T" && expression[expression.index(expression.startIndex, offsetBy: i)] != "F"
            || i == expression.count - 1 || expression[expression.index(expression.startIndex, offsetBy: i + 1)] == ":" {
                break
            }
            if expression[expression.index(expression.startIndex, offsetBy: i)] == "T" {
                i += 2
            } else {
                var count = 1
                i += 2
                while count != 0 {
                    if expression[expression.index(expression.startIndex, offsetBy: i)] == ":" {
                        count -= 1
                    } else if expression[expression.index(expression.startIndex, offsetBy: i)] == "?" {
                        count += 1
                    }
                    i += 1
                }
            }
        }

        return String(expression[expression.index(expression.startIndex, offsetBy: i)])
    }
}