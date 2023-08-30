class Solution {
public:
    vector<vector<string>> suggestedProducts(vector<string> &products,
                                             string searchWord) {
        sort(products.begin(), products.end());
        vector<vector<string>> result;
        int start, bsStart = 0, n=products.size();
        string prefix;
        for (char &c : searchWord) {
            prefix += c;

            // Get the starting index of word starting with `prefix`.
            start = lower_bound(products.begin() + bsStart, products.end(), prefix) - products.begin();

            // Add empty vector to result.
            result.push_back({});

            // Add the words with the same prefix to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int i = start; i < min(start + 3, n) && !products[i].compare(0, prefix.length(), prefix); i++)
                result.back().push_back(products[i]);

            // Reduce the size of elements to binary search on since we know
            bsStart = start;
        }
        return result;
    }
};