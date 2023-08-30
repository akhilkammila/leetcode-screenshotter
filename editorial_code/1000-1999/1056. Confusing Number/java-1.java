class Solution {
    public boolean confusingNumber(int n) {
        // Use 'invertMap' to invert each valid digit. Since we don't want to modify
        // 'n', we create a copy of it as 'nCopy'.
        Map<Integer, Integer> invertMap = new HashMap<>() {{
            put(0, 0);
            put(1, 1);
            put(6, 9);
            put(8, 8);
            put(9, 6);
        }};
        int nCopy = n, rotatedNumber = 0;
        
        // Get every digit of 'nCopy' by taking the remainder of it to 10.
        while (nCopy > 0) {
            int res = nCopy % 10;
            if (!invertMap.containsKey(res)) {
                return false;
            }

            // Append the inverted digit of 'res' to the end of 'rotatedNumber'. 
            rotatedNumber = rotatedNumber * 10 + invertMap.get(res);
            nCopy /= 10;
        }

        // Check if 'rotatedNumber' equals 'n'.
        return rotatedNumber != n;
    }
}