class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        vector<int> lossesCount(100001, -1);

        for (auto& match : matches) {
            int winner = match[0], loser = match[1];
            if (lossesCount[winner] == -1) {
                lossesCount[winner] = 0;
            }
            if (lossesCount[loser] == -1) {
                lossesCount[loser] = 1;
            } else {
                lossesCount[loser]++;
            }
        }

        vector<vector<int>> answer(2, vector<int>());
        for (int i = 1; i < 100001; ++i) {
            if (lossesCount[i] == 0) {
                answer[0].push_back(i);
            } else if (lossesCount[i] == 1) {
                answer[1].push_back(i);
            }
        }

        return answer;
    }
};