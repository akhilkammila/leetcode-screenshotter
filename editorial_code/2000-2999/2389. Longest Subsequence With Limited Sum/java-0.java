class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        // Sort 'nums'
        Arrays.sort(nums);
        int n = nums.length, m = queries.length;
        int answer[] = new int[m];
        
        // For each query, collect numbers from lowest to highest.
        // If their sum exceeds the limit 'query', move on to the next query.
        for (int i = 0; i < m; ++i) {
            int count = 0;
            int query = queries[i];
            for (int num : nums) {
                if (query >= num) {
                    count++;
                    query -= num;
                }
                else
                    break;
            }
            answer[i] = count;
        }
        return answer;
    }
}