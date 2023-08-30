class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        unordered_map<int, int> freq;
        // Store the frequencies in the map.
        for (int task : tasks) {
            freq[task]++;
        }
        
        int minimumRounds = 0;
        // Iterate over the task's frequencies.
        for (auto [task, count] : freq) {
            // If the frequency is 1, it's not possible to complete tasks.
            if (count == 1) {
                return - 1;
            }

            if (count % 3 == 0) {
                // Group all the task in triplets.
                minimumRounds += count / 3;
            } else {
                // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                minimumRounds += count / 3 + 1;
            }
        }
        
        return minimumRounds;
    }
};