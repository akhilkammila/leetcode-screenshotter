class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        if num1 == "0" or num2 == "0":
            return "0"
        
        # Initialize answer as a string of zeros of length N.
        N = len(num1) + len(num2)
        answer = [0] * N
        
        # Reverse num1 and num2
        first_number = num1[::-1]
        second_number = num2[::-1]
        
        for place2, digit2 in enumerate(second_number):
            # For each digit in second_number multiply the digit by all digits in first_number.
            for place1, digit1 in enumerate(first_number):
                # The number of zeros from multiplying to digits depends on the place
                # of digit2 in second_number and the place of the digit1 in first_number.
                num_zeros = place1 + place2
                
                # The digit currently at position numZeros in the answer string
                # is carried over and summed with the current result.
                carry = answer[num_zeros]
                multiplication = int(digit1) * int(digit2) + carry
                
                # Set the ones place of the multiplication result.
                answer[num_zeros] = multiplication % 10
                
                # Carry the tens place of the multiplication result by 
                # adding it to the next position in the answer array.
                answer[num_zeros + 1] += multiplication // 10
        
        # Pop the excess 0 from the end of answer.
        if answer[-1] == 0:
            answer.pop()
            
        return ''.join(str(digit) for digit in reversed(answer))