class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        unordered_set<int> zeroLoss, oneLoss, moreLoss;

        for (auto& match : matches) {
            int winner = match[0], loser = match[1];
            // Add winner.
            if ((oneLoss.find(winner) == oneLoss.end()) &&
                (moreLoss.find(winner) == moreLoss.end())) {
                zeroLoss.insert(winner);
            }
            // Add or move loser.
            if (zeroLoss.find(loser) != zeroLoss.end()) {
                zeroLoss.erase(loser);
                oneLoss.insert(loser);
            } else if (oneLoss.find(loser) != oneLoss.end()) {
                oneLoss.erase(loser);
                moreLoss.insert(loser);
            } else if (moreLoss.find(loser) != moreLoss.end()) {
                continue;
            } else {
                oneLoss.insert(loser);
            }
        }

        vector<vector<int>> answer(2, vector<int>());
        answer[0].assign(zeroLoss.begin(), zeroLoss.end());
        answer[1].assign(oneLoss.begin(), oneLoss.end());
        sort(answer[0].begin(), answer[0].end());
        sort(answer[1].begin(), answer[1].end());

        return answer;
    }
};