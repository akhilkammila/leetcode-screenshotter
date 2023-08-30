class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:

        def backtrack(comb, remain, curr, results):

            if remain == 0:
                # make a deep copy of the resulted combination
                results.append(list(comb))
                return

            for next_curr in range(curr, len(candidates)):

                if next_curr > curr \
                  and candidates[next_curr] == candidates[next_curr-1]:
                    continue

                pick = candidates[next_curr]
                # optimization: skip the rest of elements starting from 'curr' index
                if remain - pick < 0:
                    break

                comb.append(pick)
                backtrack(comb, remain - pick, next_curr + 1, results)
                comb.pop()

        candidates.sort()

        comb, results = [], []
        backtrack(comb, target, 0, results)

        return results