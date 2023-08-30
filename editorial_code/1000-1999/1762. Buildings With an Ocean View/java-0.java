class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        
        for (int current = 0; current < n; ++current) {
            // If the current building is taller, 
            // it will block the shorter building's ocean view to its left.
            // So we pop all the shorter buildings that have been added before.
            while (!list.isEmpty() && heights[list.get(list.size() - 1)] <= heights[current]) {
                list.remove(list.size() - 1);
            }
            list.add(current);
        }
 
        // Push elements from list to answer array.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}