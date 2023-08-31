class Solution {
    private int transform(int x, int a, int b, int c) {
        // Return the transformed result for element 'x'
        return (a * x * x) + (b * x) + c;
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] answer = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = 0;
        
        if (a < 0) {
            // When 'downward parabola' we will put the edge element (smaller elements) first.
            while (left <= right) {
                int leftTransformedVal = transform(nums[left], a, b, c);
                int rightTransformedVal = transform(nums[right], a, b, c);
                if (leftTransformedVal < rightTransformedVal) {
                    answer[index++] = leftTransformedVal;
                    left++;
                } else {
                    answer[index++] = rightTransformedVal;
                    right--;
                }
            }
        } else {
            while (left <= right) {
                // When 'upward parabola' or a 'straight line' 
                // we will put the edge element (bigger elements) first.
                int leftTransformedVal = transform(nums[left], a, b, c);
                int rightTransformedVal = transform(nums[right], a, b, c);
                if (leftTransformedVal > rightTransformedVal) {
                    answer[index++] = leftTransformedVal;
                    left++;
                } else {
                    answer[index++] = rightTransformedVal;
                    right--;
                }
            }
            // Reverse the decreasing 'answer' array.
            for (int i = 0; i < answer.length / 2; i++) {
                int temp = answer[i];
                answer[i] = answer[answer.length - i - 1];
                answer[answer.length - i - 1] = temp;
            }
        }
        return answer;
    }
}