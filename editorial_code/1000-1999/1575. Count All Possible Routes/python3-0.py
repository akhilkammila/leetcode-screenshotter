class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        n = len(locations)

        memo = {}
        def solve(currCity, remainingFuel):
            if remainingFuel < 0:
                return 0
            if (currCity, remainingFuel) in memo:
                return memo[(currCity, remainingFuel)]

            ans = 0
            if currCity == finish:
                ans = 1
            for nextCity in range(n):
                if nextCity != currCity:
                    ans = (ans + solve(nextCity, remainingFuel - abs(
                        locations[currCity] - locations[nextCity]))) % 1000000007
            
            memo[(currCity, remainingFuel)] = ans
            return ans
        
        return solve(start, fuel)