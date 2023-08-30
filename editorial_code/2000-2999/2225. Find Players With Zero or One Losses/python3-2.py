class Solution: 
    def findWinners(self, matches: List[List[int]]) ->List[List[int]]: 
        losses_count = {}
        
        for winner, loser in matches:
            losses_count[winner] = losses_count.get(winner, 0)
            losses_count[loser] = losses_count.get(loser, 0) + 1
        
        zero_lose, one_lose = [], []
        for player, count in losses_count.items():
            if count == 0:
                zero_lose.append(player)
            if count == 1:
                one_lose.append(player)
        
        return [sorted(zero_lose), sorted(one_lose)]