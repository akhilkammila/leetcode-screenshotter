class Solution(object):
    def containVirus(self, grid):
        R, C = len(grid), len(grid[0])
        def neighbors(r, c):
            for nr, nc in ((r-1, c), (r+1, c), (r, c-1), (r, c+1)):
                if 0 <= nr < R and 0 <= nc < C:
                    yield nr, nc

        def dfs(r, c):
            if (r, c) not in seen:
                seen.add((r, c))
                regions[-1].add((r, c))
                for nr, nc in neighbors(r, c):
                    if grid[nr][nc] == 1:
                        dfs(nr, nc)
                    elif grid[nr][nc] == 0:
                        frontiers[-1].add((nr, nc))
                        perimeters[-1] += 1

        ans = 0
        while True:
            #Find all regions, with associated frontiers and perimeters.
            seen = set()
            regions = []
            frontiers = []
            perimeters = []
            for r, row in enumerate(grid):
                for c, val in enumerate(row):
                    if val == 1 and (r, c) not in seen:
                        regions.append(set())
                        frontiers.append(set())
                        perimeters.append(0)
                        dfs(r, c)

            #If there are no regions left, break.
            if not regions: break

            #Add the perimeter of the region which will infect the most squares.
            triage_index = frontiers.index(max(frontiers, key = len))
            ans += perimeters[triage_index]

            #Triage the most infectious region, and spread the rest of the regions.
            for i, reg in enumerate(regions):
                if i == triage_index:
                    for r, c in reg:
                        grid[r][c] = -1
                else:
                    for r, c in reg:
                        for nr, nc in neighbors(r, c):
                            if grid[nr][nc] == 0:
                                grid[nr][nc] = 1

        return ans
