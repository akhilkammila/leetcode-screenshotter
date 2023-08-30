class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        graph = collections.defaultdict(list)
        # Recursively build the undirected graph from the given binary tree.
        def build_graph(cur, parent):
            if cur and parent:
                graph[cur.val].append(parent.val)
                graph[parent.val].append(cur.val)
            if cur.left:
                build_graph(cur.left, cur)
            if cur.right:
                build_graph(cur.right, cur) 
        build_graph(root, None)
        
        answer = []
        visited = set([target.val])

        # Add the target node to the queue with a distance of 0
        queue = collections.deque([(target.val, 0)])
        while queue:
            cur, distance = queue.popleft()

            # If the current node is at distance k from target,
            # add it to the answer list and continue to the next node.
            if distance == k:
                answer.append(cur)
                continue

            # Add all unvisited neighbors of the current node to the queue.
            for neighbor in graph[cur]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append((neighbor, distance + 1))
                    
        return answer