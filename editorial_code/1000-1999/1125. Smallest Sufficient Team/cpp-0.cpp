class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        int n = people.size(), m = req_skills.size();
        unordered_map<string, int> skillId;
        for (int i = 0; i < m; i++) {
            skillId[req_skills[i]] = i;
        }
        vector<int> skillsMaskOfPerson(n);
        for (int i = 0; i < n; i++) {
            for (string skill : people[i]) {
                skillsMaskOfPerson[i] |= 1 << skillId[skill];
            }
        }
        vector<long long> dp(1 << m, (1LL << n) - 1);
        dp[0] = 0;
        for (int skillsMask = 1; skillsMask < (1 << m); skillsMask++) {
            for (int i = 0; i < n; i++) {
                int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
                if (smallerSkillsMask != skillsMask) {
                    long long peopleMask = dp[smallerSkillsMask] | (1LL << i);
                    if (__builtin_popcountll(peopleMask) < __builtin_popcountll(dp[skillsMask])) {
                        dp[skillsMask] = peopleMask;
                    }
                }
            }
        }
        long long answerMask = dp[(1 << m) - 1];
        vector<int> ans;
        for (int i = 0; i < n; i++) {
            if ((answerMask >> i) & 1) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};