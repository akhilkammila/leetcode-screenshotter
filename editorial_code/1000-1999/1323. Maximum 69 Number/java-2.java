class Solution {
    public int maximum69Number (int num) {
        // Since we start with the lowest digit, initialize currDigit = 0.
        int numCopy = num;
        int indexSix = -1;
        int currDigit = 0;
        
        // Check every digit of 'numCopy' from low to high.
        while (numCopy > 0) {
            // If the current digit is '6', record it as the highest digit of 6.
            if (numCopy % 10 == 6) 
                indexSix = currDigit;

            // Move on to the next digit.
            numCopy /= 10;
            currDigit++;
        }
        
        // If we don't find any digit of '6', return the original number,
        // otherwise, increment 'num' by the difference made by the first '6'.
        return indexSix == -1 ? num : num + 3 * (int)Math.pow(10, indexSix);
    }
}