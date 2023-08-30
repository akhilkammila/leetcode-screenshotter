class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int n = answerKey.length();
        int left = k, right = n;
        
        while (left < right) {
            int mid = (left + right + 1) / 2;
            
            if (isValid(answerKey, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    bool isValid(string answerKey, int size, int k) {
        int n = answerKey.length();
        unordered_map<char, int> counter;
        
        for (int i = 0; i < size; i++) {
            char c = answerKey[i];
            counter[c]++;
        }
        
        if (min(counter['T'], counter['F']) <= k) {
            return true;
        }
        
        for (int i = size; i < n; i++) {
            char c1 = answerKey[i];
            counter[c1]++;
            char c2 = answerKey[i - size];
            counter[c2]--;
            
            if (min(counter['T'], counter['F']) <= k) {
                return true;
            }
        }
        
        return false;
    }
};