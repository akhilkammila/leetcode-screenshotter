class Solution {
public:

    int nr, nc, rem, b_size;
    vector<unordered_set<int>> buckets;

    //c++11 random integer generation
    mt19937 rng{random_device{}()};
    //uniform random integer in [0, bound)
    int randint(int bound) {
        uniform_int_distribution<int> uni(0, bound - 1);
        return uni(rng);
    }

    Solution(int n_rows, int n_cols) {
        nr = n_rows, nc = n_cols, rem = nr * nc;
        b_size = sqrt(nr * nc);
        for (int i = 0; i < nr * nc; i += b_size)
            buckets.push_back({});
    }

    vector<int> flip() {
        int c = 0;
        int c0 = 0;
        int k = randint(rem);
        for (auto& b1 : buckets) {
            if (c0 + b_size - b1.size() > k) {
                while (true) {
                    if (!b1.count(c)) {
                        if (c0 == k) {
                            b1.insert(c);
                            rem--;
                            return {c / nc, c % nc};
                        }
                        c0++;
                    }
                    c++;
                }
            }
            c += b_size;
            c0 += b_size - b1.size();
        }
    }

    void reset() {
        for (auto& b1 : buckets)
            b1.clear();
        rem = nr * nc;
    }
};