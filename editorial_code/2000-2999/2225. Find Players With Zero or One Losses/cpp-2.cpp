class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_map<int, int> lossesCount;
        for (auto& match : matches) {
            int winner = match[0], loser = match[1];
            if (lossesCount.find(winner) == lossesCount.end()) {
                lossesCount[winner] = 0;
            }
            lossesCount[loser]++;
        }

        vector<vector<int>> answer(2, vector<int>());
        for (auto [player, count] : lossesCount) {
            if (count == 0) {
                answer[0].push_back(player);
            } else if (count == 1) {
                answer[1].push_back(player);
            }
        }

        sort(answer[0].begin(), answer[0].end());
        sort(answer[1].begin(), answer[1].end());
        return answer;
    }
};