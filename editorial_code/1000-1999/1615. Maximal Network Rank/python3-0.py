class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        maxRank = 0
        adj = defaultdict(set)
        # Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
        for road in roads:
            adj[road[0]].add(road[1])
            adj[road[1]].add(road[0])

        # Iterate on each possible pair of nodes.
        for node1 in range(n):
            for node2 in range(node1 + 1, n):
                currentRank = len(adj[node1]) + len(adj[node2])
                if node2 in adj[node1]:
                    currentRank -= 1
                # Find the current pair's respective network rank and store if it's maximum till now.
                maxRank = max(maxRank, currentRank)
        # Return the maximum network rank.
        return maxRank