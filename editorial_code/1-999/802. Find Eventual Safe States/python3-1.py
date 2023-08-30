class Solution:
    def dfs(self, node, adj, visit, inStack):
        # If the node is already in the stack, we have a cycle.
        if inStack[node]:
            return True
        if visit[node]:
            return False
        # Mark the current node as visited and part of current recursion stack.
        visit[node] = True
        inStack[node] = True
        for neighbor in adj[node]:
            if self.dfs(neighbor, adj, visit, inStack):
                return True
        # Remove the node from the stack.
        inStack[node] = False
        return False

    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        n = len(graph)

        visit = [False] * n
        inStack = [False] * n

        for i in range(n):
            self.dfs(i, graph, visit, inStack)

        safeNodes = []
        for i in range(n):
            if not inStack[i]:
                safeNodes.append(i)

        return safeNodes