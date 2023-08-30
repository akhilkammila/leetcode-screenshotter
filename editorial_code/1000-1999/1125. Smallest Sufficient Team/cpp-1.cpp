class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        int n = people.size(), m = req_skills.size();
        unordered_map<string, int> skillId;
        for (int i = 0; i < m; i++) {
            skillId[req_skills[i]] = i;
        }
        vector<int> skillsMaskOfPerson(n);
        vector<long long> dp(1 << m, -1);
        for (int i = 0; i < n; i++) {
            for (string skill : people[i]) {
                skillsMaskOfPerson[i] |= 1 << skillId[skill];
            }
        }
        function<long long(int)> f = [&](int skillsMask) -> long long {
            if (skillsMask == 0) {
                return 0;
            }
            if (dp[skillsMask] != -1) {
                return dp[skillsMask];
            }
            for (int i = 0; i < n; i++) {
                int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
                if (smallerSkillsMask != skillsMask) {
                    long long peopleMask = f(smallerSkillsMask) | (1LL << i);
                    if (dp[skillsMask] == -1 || __builtin_popcountll(peopleMask) <
                                                    __builtin_popcountll(dp[skillsMask])) {
                        dp[skillsMask] = peopleMask;
                    }
                }
            }
            return dp[skillsMask];
        };
        long long answerMask = f((1 << m) - 1);
        vector<int> ans;
        for (int i = 0; i < n; i++) {
            if ((answerMask >> i) & 1) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};