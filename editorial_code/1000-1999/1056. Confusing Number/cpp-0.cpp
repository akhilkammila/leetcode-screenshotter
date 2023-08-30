class Solution {
public:
    bool confusingNumber(int n) {
        // Use 'invertMap' to invert each valid digit.
        unordered_map<char, char> invertMap = {{'0','0'}, {'1','1'}, {'6','9'}, {'8','8'}, {'9','6'}};
        string rotatedNumber;

        // Iterate over each digit of 'n'.
        for (auto ch : to_string(n)) {
            if (invertMap.find(ch) == invertMap.end()) {
                return false;
            }

            // Append the inverted digit of 'ch' to the end of 'rotatedNumber'. 
            rotatedNumber += invertMap[ch];
        }
        
        // Check if the reversed 'rotatedNumber' equals 'n'.
        reverse(begin(rotatedNumber), end(rotatedNumber));
        return stoi(rotatedNumber) != n;
    }
};