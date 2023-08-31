# @param {String} expression
# @return {String}
def parse_ternary(expression)
    
    i = 0
    while i < expression.length do
        
        if expression[i] != 'T' && expression[i] != 'F' \
        || i == expression.length - 1 || expression[i + 1] == ':'
            break
        end
        if expression[i] == 'T'
            i += 2
        else
            count = 1
            i += 2
            while count != 0 do
                if expression[i] == ':'
                    count -= 1
                elsif expression[i] == '?'
                    count += 1
                end
                i += 1
            end
        end
    end

    return expression[i]
end