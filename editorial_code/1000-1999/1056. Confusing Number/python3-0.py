
class Solution:
    def confusingNumber(self, n: int) -> bool:
        # Use 'invertMap' to invert each valid digit.
        invert_map = {"0":"0", "1":"1", "8":"8", "6":"9", "9":"6"}
        rotated_number = []
        
        # Iterate over each digit of 'n'.
        for ch in str(n):
            if ch not in invert_map:
                return False

            # Append the inverted digit of 'ch' to the end of 'rotated_number'. 
            rotated_number.append(invert_map[ch])
        
        rotated_number = "".join(rotated_number)

        # Check if the reversed 'rotated_number' equals 'n'.
        return int(rotated_number[::-1]) != n
