class Solution:
    def numberWays(self, hats: List[List[int]]) -> int:
        @cache
        def dp(hat, mask):
            if mask == done:
                return 1
            
            if hat > 40:
                return 0
            
            ans = dp(hat + 1, mask)

            for person in hats_to_people[hat]:
                if mask & (1 << person) == 0:
                    ans = (ans + dp(hat + 1, mask | (1 << person))) % MOD

            return ans
        
        hats_to_people = defaultdict(list)
        for i in range(len(hats)):
            for hat in hats[i]:
                hats_to_people[hat].append(i)

        n = len(hats)
        MOD = 10 ** 9 + 7
        done = 2 ** n - 1
        return dp(1, 0)