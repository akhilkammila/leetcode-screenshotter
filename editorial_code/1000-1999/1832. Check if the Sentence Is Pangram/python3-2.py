class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        # Array 'seen' of size 26.
        seen = [False] * 26

        # For every letter 'currChar', we find its ASCII code, 
        # and update value at the mapped index as true.
        for curr_char in sentence:
            seen[ord(curr_char) - ord('a')] = True
        
        # Once we finish iterating, check if 'seen' contains false.
        for status in seen:
            if not status:
                return False
        return True