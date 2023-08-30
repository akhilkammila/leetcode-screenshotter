class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        # Initialize seen = 0 since we start with no letter.
        seen = 0
        
        # Iterate over 'sentence'.
        for curr_char in sentence:
            # Map each 'curr_char' to its index using its ASCII code.
            mapped_index = ord(curr_char) - ord('a')

            # 'curr_bit' represents the bit for 'curr_char'.
            curr_bit = 1 << mapped_index 

            # Use 'OR' operation since we only add its bit for once.
            seen |= curr_bit
        
        # Once we finish iterating, check if 'seen' contains 26 bits of 1.
        return seen == (1 << 26) - 1