class Solution {
    int better(int x, int y) { return x < 0 || (y >= 0 && y < x) ? y : x; }

    int dfs(const vector<vector<int>>& mat, vector<int>& operations) {
        if (operations.size() == mat[0].size()) {
            vector<int> changed = vector<int>(mat[0].size());
            vector<int> last_state = operations;
            int maybe = 0;
            for (const vector<int>& row : mat) {
                vector<int> state = changed;
                for (int j = 0; j < row.size(); ++j) {
                    state[j] ^= row[j];
                    if (last_state[j]) {
                        state[j] ^= 1;
                        if (j) {
                            state[j - 1] ^= 1;
                        }
                        if (j + 1 < row.size()) {
                            state[j + 1] ^= 1;
                        }
                        ++maybe;
                    }
                }
                changed = last_state;
                last_state = state;
            }
            for (int x : last_state) {
                if (x) {
                    return -1;
                }
            }
            return maybe;
        }
        operations.push_back(0);
        const int maybe1 = dfs(mat, operations);
        operations.back() = 1;
        const int maybe2 = dfs(mat, operations);
        operations.pop_back();
        return better(maybe1, maybe2);
    }

public:
    int minFlips(vector<vector<int>>& mat) {
        vector<int> operations;
        return dfs(mat, operations);
    }
};