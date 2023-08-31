class Solution {
public:
    bool validWordSquare(vector<string>& words) {
        for (int wordNum = 0; wordNum < words.size(); ++wordNum) {
            for (int charPos = 0; charPos < words[wordNum].size(); ++charPos) {
                // charPos (curr 'row' word) is bigger than column word, or
                // wordNum (curr 'column' word) is bigger than row word, or 
                // characters at index (wordNum,charPos) and (charPos,wordNum) are not equal.
                if (charPos >= words.size() || 
                    wordNum >= words[charPos].size() || 
                    words[wordNum][charPos] != words[charPos][wordNum]){
                    return false;
                }
            }
        }
        return true;
    }
};