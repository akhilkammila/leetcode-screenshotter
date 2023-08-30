class Solution {
public:
    int maxConsecutiveAnswers(string answerKey, int k) {
        int maxSize = 0;
        unordered_map<char, int> count;
        
        for (int right = 0; right < answerKey.length(); right++) {
            count[answerKey[right]]++;
            int minor = min(count['T'], count['F']);
            
            if (minor <= k) {
                maxSize++;
            } else {
                count[answerKey[right - maxSize]]--;
            }
        }

        return maxSize;
    }
};