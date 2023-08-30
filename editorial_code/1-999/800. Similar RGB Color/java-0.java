class Solution {
    // Given string 'colorSection' representing a two-digit 
    // base 16 number "AB", find out the number "XX" that 
    // has the highest similarity to "AB".  
    public String findTarget(String colorSection) {
        int num = Integer.parseInt(colorSection, 16);

        // We need to find the smallest absolute value of similarity, thus
        // we start with a big value 'minDiff' for comparsion.
        int ans = -1, minDiff = 1000;

        // We try the value of every possible "XX" pair.
        for (int i = 0; i < 16; ++i) {
            int curDiff = (int)Math.pow(i * 17 - num, 2);
            if (curDiff < minDiff) {
                minDiff = curDiff;
                ans = i;
            }
        }
        
        // Return "XX", the pair of the highest similarity.
        return Integer.toHexString(ans).repeat(2);
    }
    
    public String similarRGB(String color) {
        StringBuilder targetColor = new StringBuilder();
        targetColor.append("#");
        
        // Split input color into three sections, find out the best
        // fit for each section and attach it to 'targetColor'.
        for (int i = 1; i < 6; i += 2) {
            targetColor.append(findTarget(color.substring(i, i + 2)));
        }
        
        return targetColor.toString();
    }
}