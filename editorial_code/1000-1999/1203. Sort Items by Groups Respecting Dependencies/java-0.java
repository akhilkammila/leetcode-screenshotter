class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // If an item belongs to zero group, assign it a unique group id.
        int groupId = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = groupId;
                groupId++;
            }
        }
        
        // Sort all item regardless of group dependencies.
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        int[] itemIndegree = new int[n];
        for (int i = 0; i < n; ++i) {
            itemGraph.put(i, new ArrayList<>());
        }
        
        // Sort all groups regardless of item dependencies.
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < groupId; ++i) {
            groupGraph.put(i, new ArrayList<>());
        }
        
        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                // Each (prev -> curr) represents an edge in the item graph.
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;
                
                // If they belong to different groups, add an edge in the group graph.
                if (group[curr] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }

        // Topological sort nodes in the graph, return an empty array if a cycle exists.
        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return new int[0];
        }
        
        // Items are sorted regardless of groups, we need to differentiate them by the groups they belong to.
        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrder) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        
        // Concatenate sorted items in all sorted groups.
        // [group 1, group 2, ... ] -> [(item 1, item 2, ...), (item 1, item 2, ...), ...]
        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (Integer key : graph.keySet()) {
            if (indegree[key] == 0) {
                stack.add(key);
            }
        }
        
        while (!stack.isEmpty()) {
            Integer curr = stack.pop();
            visited.add(curr);
            
            for (Integer prev : graph.get(curr)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    stack.add(prev);
                }
            }
        }

        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}