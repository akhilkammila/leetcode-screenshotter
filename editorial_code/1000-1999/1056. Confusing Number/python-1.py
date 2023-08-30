class Solution:
    def confusingNumber(self, n: int) -> bool:
        # Use 'invert_map' to invert each valid digit. Since we don't want to modify
        # 'n', we create a copy of it as 'nCopy'.
        invert_map = {0:0, 1:1, 8:8, 6:9, 9:6}
        invert_number = 0
        n_copy = n
        
        # Get every digit of 'n_copy' by taking the remainder of it to 10.
        while n_copy:
            res = n_copy % 10
            if res not in invert_map:
                return False
            
            # Append the inverted digit of 'res' to the end of 'rotated_number'. 
            invert_number = invert_number * 10 + invert_map[res]
            n_copy //= 10
        
        # Check if 'rotated_number' equals 'n'.
        return  invert_number != n