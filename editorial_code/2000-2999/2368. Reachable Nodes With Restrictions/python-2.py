class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        # Store all edges according to nodes in 'neighbor'.
        neighbors = collections.defaultdict(set)
        for a, b in edges:
            neighbors[a].add(b)
            neighbors[b].add(a)
        
        # Mark the nodes in 'restricted' as visited.
        seen = [False] * n
        for node in restricted:
            seen[node] = True
        
        # Use stack 'stack' to store all nodes to be visited, start from node 0.
        stack = [0]
        ans = 0
        seen[0] = True
        
        while stack:
            curr_node = stack.pop()
            ans += 1

            # Add all unvisited neighbors of the current node to 'stack' 
            # and mark them as visited.
            for next_node in neighbors[curr_node]:
                if not seen[next_node]:
                    seen[next_node] = True
                    stack.append(next_node)
        
        return ans