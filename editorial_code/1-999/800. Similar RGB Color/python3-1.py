class Solution:
    def similarRGB(self, color: str) -> str:
        # Given string 'color_section' representing a two-digit 
        # base 16 number "AB", find out the number "XX" that 
        # has the highest similarity to "AB".
        def findTarget(color_section):
            num = int(color_section, 16)
            
            # Get the rounded value of num to 17.
            x = round(num / 17)

            # Return "XX", the pattern of the highest similarity.
            return hex(x)[-1] * 2
        
        # Split input color into three sections, find out the best
        # fit for each section and attach it to 'target_color'.
        target_color = "#"
        for i in range(1, 6, 2):
            target_color += findTarget(color[i:i + 2])
            
        return target_color