var minExtraChar = function(s, dictionary) {
    const n = s.length;
    const dictionarySet = new Set(dictionary);
    const memo = new Map();

    const dp = function(start) {
        if (start === n) {
            return 0;
        }
        if (memo.has(start)) {
            return memo.get(start);
        }
        // To count this character as a left over character 
        // move to index 'start + 1'
        let ans = dp(start + 1) + 1;
        for (let end = start; end < n; end++) {
            const curr = s.slice(start, end + 1);
            if (dictionarySet.has(curr)) {
                ans = Math.min(ans, dp(end + 1));
            }
        }
        memo.set(start, ans);
        return ans
    };

    return dp(0);
};