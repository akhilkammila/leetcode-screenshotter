class Solution:
    def bestClosingTime(self, customers: str) -> int:
        # Start with closing at hour 0 and assume the current penalty is 0.
        cur_penalty = min_penalty = 0
        earliest_hour = 0
        
        for i, ch in enumerate(customers):
            # If status in hour i is 'Y', moving it to open hours decrement
            # penalty by 1. Otherwise, moving 'N' to open hours increment
            # penatly by 1.
            if ch == 'Y':
                cur_penalty -= 1
            else:
                cur_penalty += 1

            # Update earliest_hour if a smaller penatly is encountered
            if cur_penalty < min_penalty:
                earliest_hour = i + 1
                min_penalty = cur_penalty
                
        return earliest_hour