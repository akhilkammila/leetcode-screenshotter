class Solution {
    public int minCost(String colors, int[] neededTime) {
        // Initalize two pointers i, j.
        int totalTime = 0;
        int i = 0, j = 0;
        
        while (i < neededTime.length && j < neededTime.length) {
            int currTotal = 0, currMax = 0;
            
            // Find all the balloons having the same color as the 
            // balloon indexed at i, record the total removal time 
            // and the maximum removal time.
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }
            
            // Once we reach the end of the current group, add the cost of 
            // this group to total_time, and reset two pointers.
            totalTime += currTotal - currMax;
            i = j;
        }
        return totalTime;    
    }
}