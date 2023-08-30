class Solution {
    int n;
    int skillsMaskOfPerson[];
    long dp[];
    private Long f(int skillsMask) {
        if (skillsMask == 0) {
            return 0L;
        }
        if (dp[skillsMask] != -1) {
            return dp[skillsMask];
        }
        for (int i = 0; i < n; i++) {
            int smallerSkillsMask = skillsMask & ~skillsMaskOfPerson[i];
            if (smallerSkillsMask != skillsMask) {
                long peopleMask = f(smallerSkillsMask) | (1L << i);
                if (dp[skillsMask] == -1 || Long.bitCount(peopleMask) <
                                                Long.bitCount(dp[skillsMask])) {
                    dp[skillsMask] = peopleMask;
                }
            }
        }
        return dp[skillsMask];
    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        n = people.size();
        int m = req_skills.length;
        HashMap<String, Integer> skillId = new HashMap<String, Integer>();
        for (int i = 0; i < m; i++) {
            skillId.put(req_skills[i], i);
        }
        skillsMaskOfPerson = new int[n];
        for (int i = 0; i < n; i++) {
            for (String skill : people.get(i)) {
                skillsMaskOfPerson[i] |= 1 << skillId.get(skill);
            }
        }
        dp = new long [1 << m];
        Arrays.fill(dp, -1);
        long answerMask = f((1 << m) - 1);
        int ans[] = new int [Long.bitCount(answerMask)];
        int ptr = 0;
        for (int i = 0; i < n; i++) {
            if (((answerMask >> i) & 1) == 1) {
                ans[ptr++] = i;
            }
        }
        return ans;
    }
}