var validWordSquare = function(words) {
    for (let wordNum = 0; wordNum < words.length; ++wordNum) {
        for (let charPos = 0; charPos < words[wordNum].length; ++charPos) {
            // charPos (curr 'row' word) is bigger than column word, or
            // wordNum (curr 'column' word) is bigger than row word, or 
            // characters at index (wordNum,charPos) and (charPos,wordNum) are not equal.
            if (charPos >= words.length || 
                wordNum >= words[charPos].length || 
                words[wordNum][charPos] != words[charPos][wordNum]){
                return false;
            }
        }
    }
    return true;
};