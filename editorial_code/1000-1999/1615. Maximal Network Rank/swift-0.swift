class Solution {
    func maximalNetworkRank(_ n: Int, _ roads: [[Int]]) -> Int {
        var maxRank = 0
        var adj = [Int: Set<Int>]()
        // Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
        for road in roads {
            adj[road[0], default: Set<Int>()].insert(road[1])
            adj[road[1], default: Set<Int>()].insert(road[0])
        }

        // Iterate on each possible pair of nodes.
        for node1 in 0..<n {
            for node2 in (node1 + 1)..<n {
                var currentRank = (adj[node1]?.count ?? 0) + (adj[node2]?.count ?? 0)
                if let set = adj[node1], set.contains(node2) {
                    currentRank -= 1
                }
                // Find the current pair's respective network rank and store if it's maximum till now.
                maxRank = max(maxRank, currentRank)
            }
        }
        // Return the maximum network rank.
        return maxRank
    }
}