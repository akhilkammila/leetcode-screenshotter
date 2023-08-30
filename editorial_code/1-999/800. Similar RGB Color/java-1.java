class Solution {
    // Given string 'colorSection' representing a two-digit 
    // base 16 number "AB", find out the number "XX" that 
    // has the highest similarity to "AB".  
    public String findTarget(String colorSection) {
        int num = Integer.parseInt(colorSection, 16);
        
        // Get the rounded value of num to 17.
        int x = Math.round((float)num / 17);
        
        // Return "XX", the pattern of the highest similarity.
        return Integer.toHexString(x).repeat(2);
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