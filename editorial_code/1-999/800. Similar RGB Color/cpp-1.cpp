class Solution {
public:
    // Given string 'colorSection' representing a two-digit 
    // base 16 number "AB", find out the number "XX" that 
    // has the highest similarity to "AB". 
    string findTarget(string colorSection) {
        int num = stoi(colorSection, nullptr, 16);
        
        // Get the rounded value of num to 17.
        int x = round(num * 1.0 / 17);
        
        // Return "XX", the pattern of the highest similarity.
        string ans;
        ans = x > 9 ? 'a' + x - 10 : '0' + x;
        return ans + ans;
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