class Solution(object):
    def reachableNodes(self, edges, M, N):
        graph = collections.defaultdict(dict)
        for u, v, w in edges:
            graph[u][v] = graph[v][u] = w

        pq = [(0, 0)]
        dist = {0: 0}
        used = {}
        ans = 0

        while pq:
            d, node = heapq.heappop(pq)
            if d > dist[node]: continue
            # Each node is only visited once.  We've reached
            # a node in our original graph.
            ans += 1

            for nei, weight in graph[node].iteritems():
                # M - d is how much further we can walk from this node;
                # weight is how many new nodes there are on this edge.
                # v is the maximum utilization of this edge.
                v = min(weight, M - d)
                used[node, nei] = v

                # d2 is the total distance to reach 'nei' (neighbor) node
                # in the original graph.
                d2 = d + weight + 1
                if d2 < dist.get(nei, M+1):
                    heapq.heappush(pq, (d2, nei))
                    dist[nei] = d2

        # At the end, each edge (u, v, w) can be used with a maximum
        # of w new nodes: a max of used[u, v] nodes from one side,
        # and used[v, u] nodes from the other.
        for u, v, w in edges:
            ans += min(w, used.get((u, v), 0) + used.get((v, u), 0))

        return ans