class Solution:
    def smallestSufficientTeam(self, req_skills: List[str],
                               people: List[List[str]]) -> List[int]:
        n = len(people)
        m = len(req_skills)
        skill_id = dict()
        for i, skill in enumerate(req_skills):
            skill_id[skill] = i
        skills_mask_of_person = [0] * n
        for i in range(n):
            for skill in people[i]:
                skills_mask_of_person[i] |= 1 << skill_id[skill]
        dp = [(1 << n) - 1] * (1 << m)
        dp[0] = 0
        for skills_mask in range(1, 1 << m):
            for i in range(n):
                smaller_skills_mask = skills_mask & ~skills_mask_of_person[i]
                if smaller_skills_mask != skills_mask:
                    people_mask = dp[smaller_skills_mask] | (1 << i)
                    if people_mask.bit_count() < dp[skills_mask].bit_count():
                        dp[skills_mask] = people_mask

        answer_mask = dp[(1 << m) - 1]
        ans = []
        for i in range(n):
            if (answer_mask >> i) & 1:
                ans.append(i)
        return ans