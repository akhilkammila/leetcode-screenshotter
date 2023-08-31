class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int wordNum = 0; wordNum < words.size(); ++wordNum) {
            for (int charPos = 0; charPos < words.get(wordNum).length(); ++charPos) {
                // charPos (curr 'row' word) is bigger than column word, or
                // wordNum (curr 'column' word) is bigger than row word, or 
                // characters at index (wordNum,charPos) and (charPos,wordNum) are not equal.
                if (charPos >= words.size() || 
                    wordNum >= words.get(charPos).length() || 
                    words.get(wordNum).charAt(charPos) != words.get(charPos).charAt(wordNum)){
                    return false;
                }
            }
        }
        return true;
    }
}