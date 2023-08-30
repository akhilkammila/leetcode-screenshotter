class Solution:
    def checkIfPangram(self, sentence: str) -> bool:
        # Add every letter of 'sentence' to hash set 'seen'.
        seen = set(sentence)
        
        # If the size of 'seen' is 26, then 'sentence' is a pangram.
        return len(seen) == 26