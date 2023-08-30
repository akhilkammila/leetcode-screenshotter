class Solution:
    def similarRGB(self, color: str) -> str:
        # Given string 'color_section' representing a two-digit 
        # base 16 number "AB", find out the number "XX" that 
        # has the highest similarity to "AB".
        def findTarget(color_section):
            # We need to find the smallest absolute value of similarity, thus
            # we start with a big value 'min_diff' for comparsion.
            min_diff = 1000
            ans = -1
            
            # We try the value of every possible "XX" pair.
            for i in range(16):
                cur_diff = (int(color_section, 16) - i * 17) ** 2
                if cur_diff < min_diff:
                    min_diff = cur_diff
                    ans = i
            
            # Return "XX", the pair of the highest similarity.
            return hex(ans)[-1] * 2
        
        # Split input color into three sections, find out the best
        # fit for each section and attach it to 'target_color'.
        target_color = "#"
        for i in range(1, 6, 2):
            target_color += findTarget(color[i:i + 2])
            
        return target_color