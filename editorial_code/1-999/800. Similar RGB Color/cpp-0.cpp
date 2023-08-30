class Solution {
public:
    // Given string 'colorSection' representing a two-digit base 16 number 
    // "AB", find out the number "XX" that has the highest similarity to "AB". 
    string findTarget(string colorSection) {
        int num = stoi(colorSection, nullptr, 16);

        // We need to find the smallest absolute value of similarity, thus
        // we start with a big value 'minDiff' for comparsion.
        int ans = -1, minDiff = 1000;
        
        // We try the value of every possible "XX" pair.
        for (int i = 0; i < 16; ++i) {
            int curDiff = (i * 17 - num) * (i * 17 - num);
            if (curDiff < minDiff) {
                minDiff = curDiff;
                ans = i;
            }
        }
        
        // Return "XX", the pair of the highest similarity.
        string ansHex{char(ans > 9 ? 'a' + ans - 10 : '0' + ans)};
        return ansHex + ansHex;
    }
    
    string similarRGB(string color) {
        string targetColor = "#";
        
        // Split input color into three sections, find out the best
        // fit for each section and attach it to 'targetColor'.
        for (int i = 1; i < 6; i += 2) {
            targetColor += findTarget(color.substr(i, 2));
        }
        
        return targetColor;
    }
};