class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] answer = new int[n];
        
        for(int i = 0; i < n; ++i) {
            int num = nums[i];
            // Push transformed value in 'answer' array.
            answer[i] = (a * num * num) + (b * num) + c;
        }

        // Find the absolute maximum element to find max number of digits.
        int maxElement = nums[0];
        for (int num : answer) {
            maxElement = Math.max(Math.abs(num), maxElement);
        }
        int maxDigits = 0;
        while (maxElement > 0) {
            maxDigits += 1;
            maxElement /= 10;
        }

        // Radix sort, least significant digit place to most significant.
        int placeValue = 1;
        for (int digit = 0; digit < maxDigits; ++digit) {
            sort(answer, placeValue);
            placeValue *= 10;
        }

        // Seperate out negatives and reverse them. 
        ArrayList<Integer> negatives = new ArrayList<>();
        ArrayList<Integer> positives = new ArrayList<>();

        for (int num : answer) {
            if (num < 0) {
                negatives.add(num);
            } else {
                positives.add(num);
            }
        }
        Collections.reverse(negatives);

        // Final 'answer' will be 'negative' elements, then 'positive' elements.
        int index = 0;
        for (int num : negatives) {
            answer[index] = num;
            index++;
        }
        for (int num : positives) {
            answer[index] = num;
            index++;
        }
        return answer;
    }

    private void sort(int[] array, int placeValue) {
        ArrayList<List<Integer>> mapDigits = new ArrayList<>(10);
        for (int digit = 0; digit < 10; ++digit) {
            mapDigits.add(digit, new ArrayList<Integer>());
        }

        for (int num : array) {
            int digit = Math.abs(num) / placeValue;
            digit = digit % 10;
            mapDigits.get(digit).add(num);
        }

        // Overwrite 'array' in sorted order of current place digits.
        int index = 0;
        for (int digit = 0; digit < 10; ++digit) {
            for (int num : mapDigits.get(digit)) {
                array[index] = num;
                index++;
            }
        }
    }
}