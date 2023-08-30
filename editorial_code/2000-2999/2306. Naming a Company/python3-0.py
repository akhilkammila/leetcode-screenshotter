class Solution:
    def distinctNames(self, ideas: List[str]) -> int:
        # Group idea by their initials.
        initial_groups = [set() for _ in range(26)]
        for idea in ideas:
            initial_groups[ord(idea[0]) - ord('a')].add(idea[1:])
        
        answer = 0
        # Calculate number of valid names from every pair of groups.
        for i in range(25):
            for j in range(i + 1, 26):
                # Get the number of mutual suffixes.
                num_of_mutual = len(initial_groups[i] & initial_groups[j]) 
                
                # Valid names are only from distinct suffixes in both groups.
                # Since we can swap a with b and swap b with a to create two valid names, multiple answer by 2.
                answer += 2 * (len(initial_groups[i]) - num_of_mutual) * (len(initial_groups[j]) - num_of_mutual)
                
        return answer