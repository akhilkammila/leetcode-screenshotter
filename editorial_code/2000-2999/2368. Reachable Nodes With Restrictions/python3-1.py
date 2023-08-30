class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        # Store all edges according to nodes in 'neighbors'.
        neighbors = collections.defaultdict(list)
        for node_a, node_b in edges:
            neighbors[node_a].append(node_b)
            neighbors[node_b].append(node_a)
        
        # Mark the nodes in 'restricted' as visited.
        seen = [False] * n
        for node in restricted:
            seen[node] = True
        
        def dfs(curr_node):
            # Mark 'curr_node' as visited and increment 'ans' by 1.
            self.ans += 1
            seen[curr_node] = True
            
            # Go for unvisited neighbors of 'currNode'.
            for next_node in neighbors[curr_node]:
                if not seen[next_node]:
                    dfs(next_node)
                    
        self.ans = 0
        dfs(0)
        return self.ans