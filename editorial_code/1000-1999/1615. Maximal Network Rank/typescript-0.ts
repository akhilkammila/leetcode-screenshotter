function maximalNetworkRank(n: number, roads: number[][]): number {
    let maxRank = 0;
    const adj = new Map<number, Set<number>>();
    // Construct adjency list 'adj', where adj[node] stores all nodes connected to 'node'.
    for (const [a, b] of roads) {
        adj.set(a, (adj.get(a) || new Set<number>()).add(b));
        adj.set(b, (adj.get(b) || new Set<number>()).add(a));
    }

    // Iterate on each possible pair of nodes.
    for (let node1 = 0; node1 < n; ++node1) {
        for (let node2 = node1 + 1; node2 < n; ++node2) {
            let currentRank = (adj.get(node1)?.size ?? 0) + (adj.get(node2)?.size ?? 0);
            if (adj.get(node1)?.has(node2)) {
                --currentRank;
            }
            // Find the current pair's respective network rank and store if it's maximum till now.
            maxRank = Math.max(maxRank, currentRank);
        }
    }
    // Return the maximum network rank.
    return maxRank;
};