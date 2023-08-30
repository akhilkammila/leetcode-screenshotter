class Solution:
    def maximum69Number (self, num: int) -> int:
        # Convert the input 'num' to a list of character 'num_char_list'.
        num_char_list = list(str(num))
        
        # Iterate over the list (from high to low).
        for i, cur_char in enumerate(num_char_list):
            # If we find the first '6', replace it with '9' and break the loop.
            if cur_char == '6':
                num_char_list[i] = '9'
                break
        
        # Convert the modified char list to integer and return it.
        return int("".join(num_char_list))