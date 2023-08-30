class Solution {
public:
    double average(vector<int>& salaries) {
        int minSalary = INT_MAX;
        int maxSalary = INT_MIN;
        int sum = 0;
        
        for (int salary : salaries) {
            // Sum of all the salaries.
            sum += salary;
            // Update the minimum salary.
            minSalary = min(minSalary, salary);
            // Update the maximum salary.
            maxSalary = max(maxSalary, salary);
        }
        
        // Divide the sum by total size - 2, as we exclude minimum and maximum values.
        return (double)(sum - minSalary - maxSalary) / (double)(salaries.size() - 2);
    }
};