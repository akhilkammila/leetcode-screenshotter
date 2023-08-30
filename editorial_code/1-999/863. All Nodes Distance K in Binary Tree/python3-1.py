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
        
        def dfs(cur, distance):
            if distance == k:
                answer.append(cur)
                return
            for neighbor in graph[cur]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    dfs(neighbor, distance + 1)
        dfs(target.val, 0)
        
        return answer