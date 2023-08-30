class Solution {
public:
    // All possible operations we can perform on two numbers.
    vector<double> generatePossibleResults(double& a, double& b) {
        vector<double> res = { a + b, a - b, b - a, a * b };
        if (a) {
            res.push_back(b / a);
        } 
        if (b) {
            res.push_back(a / b);
        }
        return res;
    }
    
    // Check if using current list we can react result 24.
    bool checkIfResultReached(vector<double> list) {
        if (list.size() == 1) {
            // Base Case: We have only one number left, check if it is approximately 24.
            return abs(list[0] - 24) <= 0.1;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // Create a new list with the remaining numbers and the new result.
                vector<double> newList;
                for (int k = 0; k < list.size(); k++) {
                    if (k != j && k != i) {
                        newList.push_back(list[k]);
                    }
                }
                
                // For any two numbers in our list,
                // we perform every operation one by one.
                for (double& res : generatePossibleResults(list[i], list[j])) {
                    // Push the new result in the list.
                    newList.push_back(res); 
                    
                    // Check if using this new list we can obtain the result 24.
                    if (checkIfResultReached(newList)) {
                        return true;
                    }
                    
                    // Backtrack: remove the result from the list.
                    newList.pop_back();
                }
            }
        }
        return false;
    }
    
    bool judgePoint24(vector<int>& cards) {
        vector<double> list(cards.begin(), cards.end());
        return checkIfResultReached(list);
    }
};