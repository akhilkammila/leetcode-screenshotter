class Solution {
public:
    bool confusingNumber(int n) {
        // Use 'invertMap' to invert each valid digit. Since we don't want to modify
        // 'n', we create a copy of it as 'nCopy'. 
        map<int, int> invertMap = {{0, 0}, {1, 1}, {6, 9}, {8, 8}, {9, 6}};
        int rotatedNumber = 0, nCopy = n;

        // Get every digit of 'nCopy' by taking the remainder of it to 10.
        while (nCopy > 0) {
            int res = nCopy % 10;
            if (invertMap.find(res) == invertMap.end()) {
                return false;
            }

            // Append the inverted digit of 'res' to the end of 'rotatedNumber'. 
            rotatedNumber = rotatedNumber * 10 + invertMap[res];
            nCopy /= 10;
        }
        
        // Check if 'rotatedNumber' equals 'n'.
        return rotatedNumber != n; 
    }
};