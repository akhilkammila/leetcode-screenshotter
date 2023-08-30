class Solution {
    public boolean confusingNumber(int n) {
        // Use 'invertMap' to invert each valid digit.
        Map<Character, Character> invertMap = new HashMap<>() {{
            put('0', '0');
            put('1', '1');
            put('6', '9');
            put('8', '8');
            put('9', '6');
        }};
        StringBuilder sb = new StringBuilder();

        // Iterate over each digit of 'n'.
        for (char ch : String.valueOf(n).toCharArray()) {
            if (!invertMap.containsKey(ch)) {
                return false;
            }

            // Append the inverted digit of 'ch' to the end of 'rotatedNumber'. 
            sb.append(invertMap.get(ch));
        }

        // Check if the reversed 'rotatedNumber' equals 'n'.
        sb.reverse();
        return Integer.parseInt(sb.toString()) != n;
    }
}