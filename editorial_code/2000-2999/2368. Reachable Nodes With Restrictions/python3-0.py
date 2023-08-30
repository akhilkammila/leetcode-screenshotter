class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        # Store all edges in 'neighbors'.
        neighbors = collections.defaultdict(list)
        for node_a, node_b in edges:
            neighbors[node_a].append(node_b)
            neighbors[node_b].append(node_a)
        
        # Mark the nodes in 'restricted' as visited.
        seen = [False] * n
        for node in restricted:
            seen[node] = True
        
        # Store all the nodes to be visited in 'queue'.
        ans = 0
        queue = collections.deque([0])
        seen[0] = True
        
        while queue:
            curr_node = queue.popleft()
            ans += 1
            
            # For all the neighbors of the current node, if we haven't visit it before,
            # add it to 'queue' and mark it as visited.
            for next_node in neighbors[curr_node]:
                if not seen[next_node]:
                    seen[next_node] = True
                    queue.append(next_node)
        
        return ans 