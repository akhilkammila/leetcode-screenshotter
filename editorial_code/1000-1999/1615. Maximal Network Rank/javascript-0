var maximalNetworkRank = function(n, roads) {
    let maxRank = 0;
    let adj = new Map();
    // Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
    for (let road of roads) {
        if (!adj.has(road[0])) {
            adj.set(road[0], new Set());
        }
        if (!adj.has(road[1])) {
            adj.set(road[1], new Set());
        }
        adj.get(road[0]).add(road[1]);
        adj.get(road[1]).add(road[0]);
    }

    // Iterate on each possible pair of nodes.
    for (let node1 = 0; node1 < n; ++node1) {
        for (let node2 = node1 + 1; node2 < n; ++node2) {
            let currentRank = (adj.get(node1) || new Set()).size +
                              (adj.get(node2) || new Set()).size;
            if ((adj.get(node1) || new Set()).has(node2)) {
                --currentRank;
            }
            // Find the current pair's respective network rank and store if it's maximum till now.
            maxRank = Math.max(maxRank, currentRank);
        }
    }
    // Return the maximum network rank.
    return maxRank;
};