function parseTernary(expression: string): string {
    
    let i = 0;
    for ( ; i < expression.length; ) {
        
        if (expression[i] != 'T' && expression[i] != 'F'
        || i == expression.length - 1 || expression[i + 1] == ':') {
            break;
        }
        if (expression[i] == 'T') {
            i += 2;
        } else {
            let count = 1;
            i += 2;
            for ( ; count != 0; i++) {
                if (expression[i] == ':') {
                    count--;
                } else if (expression[i] == '?') {
                    count++;
                }
            }
        }
    }

    return expression[i];
};