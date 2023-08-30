class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        m, n = len(grid), len(grid[0])
        queue = collections.deque()
        
        # seen['key'] is only for BFS with key state equals 'keys'
        seen = collections.defaultdict(set)
        
        key_set, lock_set = set(), set()
        all_keys = 0
        start_r, start_c = -1, -1
        for i in range(m):
            for j in range(n):
                cell = grid[i][j]
                if cell in 'abcdef':
                    all_keys += (1 << (ord(cell) - ord('a')))
                    key_set.add(cell)
                if cell in 'ABCDEF':
                    lock_set.add(cell)
                if cell == "@":
                    start_r, start_c = i, j
        
        # [row, column, key_state, distance]
        queue.append((start_r, start_c, 0, 0))
        seen[0].add((start_r, start_c))
        
        while queue:
            cur_r, cur_c, keys, dist = queue.popleft()
            for dr, dc in ((0, 1), (1, 0), (-1, 0), (0, -1)):
                new_r, new_c = cur_r + dr, cur_c + dc
                
                # If this cell (new_r, new_c) is reachable.
                if 0 <= new_r < m and 0 <= new_c < n and grid[new_r][new_c] != '#':
                    cell = grid[new_r][new_c]
                    
                    # If it is a key we haven't picked up yet
                    if cell in key_set and not ((1 << (ord(cell) - ord('a'))) & keys):
                        new_keys = (keys | (1 << (ord(cell) - ord('a'))))

                        # If we collect all keys, return dist + 1. 
                        # Otherwise, just add this state to seen and queue.
                        if new_keys == all_keys:
                            return dist + 1
                        seen[new_keys].add((new_r, new_c))
                        queue.append((new_r, new_c, new_keys, dist + 1))
                      
                    # If it is a lock and we don't have its key, continue.
                    elif cell in lock_set and not (keys & (1 << (ord(cell) - ord('A')))):
                        continue
                        
                    # We can walk to this cell if we haven't been here before with the same key state.
                    elif (new_r, new_c) not in seen[keys]:
                        seen[keys].add((new_r, new_c))
                        queue.append((new_r, new_c, keys, dist + 1))
            
        return -1