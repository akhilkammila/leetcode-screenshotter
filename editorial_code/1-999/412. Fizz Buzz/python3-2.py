class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        # ans list
        ans = []

        # Dictionary to store all fizzbuzz mappings
        fizz_buzz_dict = {3 : "Fizz", 5 : "Buzz"}
        
        # List of divisors which we will iterate over.
        divisors = [3, 5]

        for num in range(1, n + 1):

            num_ans_str = []

            for key in divisors:
                # If the num is divisible by key,
                # then add the corresponding string mapping to current num_ans_str
                if num % key == 0:
                    num_ans_str.append(fizz_buzz_dict[key])

            if not num_ans_str:
                num_ans_str.append(str(num))

            # Append the current answer str to the ans list
            ans.append(''.join(num_ans_str))

        return ans