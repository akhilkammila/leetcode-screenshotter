class Solution {
    // All possible operations we can perform on two numbers.
    private List<Double> generatePossibleResults(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b); 
        res.add(a - b);
        res.add(b - a); 
        res.add(a * b);
        if (b != 0) {
            res.add(a / b);
        }
        if (a != 0) {
            res.add(b / a);
        }
        return res;
    }
    
    // Check if using current list we can react result 24.
    private boolean checkIfResultReached(List<Double> list) {
        if (list.size() == 1) {
            // Base Case: We have only one number left, check if it is approximately 24.
            return Math.abs(list.get(0) - 24) <= 0.1;
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                // Create a new list with the remaining numbers and the new result.
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != j && k != i) {
                        newList.add(list.get(k));
                    }
                }
                
                // For any two numbers in our list,
                // we perform every operation one by one.
                for (double res : generatePossibleResults(list.get(i), list.get(j))) {
                    // Push the new result in the list
                    newList.add(res);
                    
                    // Check if using this new list we can obtain the result 24.
                    if (checkIfResultReached(newList)) {
                        return true;
                    }
                    
                    // Backtrack: remove the result from the list.
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }
    
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        
        return checkIfResultReached(list);
    }
}