class UnionFind:
    def __init__(self, n):
        self.root = list(range(n))
        self.rank = [1] * n
    def find(self, x):
        if self.root[x] != x:
            self.root[x] = self.find(self.root[x])
        return self.root[x]
    def union(self, x, y):
        root_x, root_y = self.find(x), self.find(y)
        if root_x != root_y:
            if self.rank[root_x] > self.rank[root_y]:
                root_x, root_y = root_y, root_x
            self.rank[root_y] += self.rank[root_x]
            self.root[root_x] = root_y
    def getSize(self, x):
        return self.rank[self.find(x)]

class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        rest_set_ = set(restricted)
        uf = UnionFind(n)

        for a, b in edges:
            if a not in rest_set and b not in rest_set:
                uf.union(a, b)
        
        return uf.getSize(0)