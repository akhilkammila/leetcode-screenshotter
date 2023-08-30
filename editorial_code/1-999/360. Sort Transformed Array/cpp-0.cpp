class Solution {
public:
    vector<int> sortTransformedArray(vector<int>& nums, int a, int b, int c) {
        vector<int> answer;
        for(int& num : nums) {
            // Push transformed value in the 'answer' array.
            answer.push_back((a * num * num) + (b * num) + c);
        }
        // Sort the array of transformed values.
        sort(answer.begin(), answer.end());
        return answer;
    }
};