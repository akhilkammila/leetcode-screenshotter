class Solution {
    public boolean checkIfPangram(String sentence) {
        // Array 'seen' of size 26.
        boolean[] seen = new boolean[26];
        
        // For every letter 'currChar', we find its ASCII code, 
        // and update value at the mapped index as true.
        for (char currChar : sentence.toCharArray())
            seen[currChar - 'a'] = true;
        
        // Once we finish iterating, check if 'seen' contains false.
        for (boolean status : seen)
            if (!status)
                return false;
        return true;
    }
}