class Solution {
    public double average(int[] salaries) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sum = 0;

        for (int salary : salaries) {
            // Sum of all the salaries.
            sum += salary;
            // Update the minimum salary.
            minSalary = Math.min(minSalary, salary);
            // Update the maximum salary.
            maxSalary = Math.max(maxSalary, salary);
        }

        // Divide the sum by total size - 2, as we exclude minimum and maximum values.
        return (double)(sum - minSalary - maxSalary) / (double)(salaries.length - 2);
    }
}