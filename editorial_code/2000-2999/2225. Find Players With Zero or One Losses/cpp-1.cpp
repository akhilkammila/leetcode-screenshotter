class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_set<int> seen;
        unordered_map<int, int> lossesCount;

        for (auto& match : matches) {
            int winner = match[0], loser = match[1];
            seen.insert(winner);
            seen.insert(loser);
            lossesCount[loser]++;
        }

        // Add players with 0 or 1 loss to the corresponding list.
        vector<vector<int>> answer(2, vector<int>());
        for (auto player : seen) {
            if (lossesCount.find(player) == lossesCount.end()) {
                answer[0].push_back(player);
            } else if (lossesCount[player] == 1) {
                answer[1].push_back(player);
            }
        }

        sort(answer[0].begin(), answer[0].end());
        sort(answer[1].begin(), answer[1].end());
        return answer;
    }
};