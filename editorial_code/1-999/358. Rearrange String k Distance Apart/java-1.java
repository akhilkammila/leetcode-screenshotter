class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> freqs = new HashMap<>();
        int maxFreq = 0;
        // Store the frequency, and find the highest frequency.
        for (char c : s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqs.get(c));
        }

        Set<Character> mostChars = new HashSet<>();
        Set<Character> secondChars = new HashSet<>();
        // Store all the characters with the highest and second-highest frequency - 1.
        for (char c: freqs.keySet()) {
            if (freqs.get(c) == maxFreq) {
                mostChars.add(c);
            } else if (freqs.get(c) == maxFreq - 1) {
                secondChars.add(c);
            }
        }

        // Create maxFreq number of different strings.
        StringBuilder[] segments = new StringBuilder[maxFreq];
        // Insert one instance of characters with frequency maxFreq & maxFreq - 1 in each segment.
        for (int i = 0; i < maxFreq; i++) {
            segments[i] = new StringBuilder();

            for (char c: mostChars) {
                segments[i].append(c);
            }

            // Skip the last segment as the frequency is only maxFreq - 1.
            if (i < maxFreq - 1) {
                for (char c: secondChars) {
                    segments[i].append(c);
                }
            }
        }

        int segmentId = 0;
        // Iterate over the remaining characters, and for each, distribute the instances over the segments.
        for (char c: freqs.keySet()) {
            // Skip characters with maxFreq or maxFreq - 1 
            // frequency as they have already been inserted.
            if (mostChars.contains(c) || secondChars.contains(c)) {
                continue;
            }

            // Distribute the instances of these characters over the segments in a round-robin manner.
            for (int freq = freqs.get(c); freq > 0; freq--) {
                segments[segmentId].append(c);
                segmentId = (segmentId + 1) % (maxFreq - 1);
            }
        }

        // Each segment except the last should have exactly K elements; else, return "".
        for (int i = 0; i < maxFreq - 1; i++) {
            if (segments[i].length() < k) {
                return "";
            }
        }

        // Join all the segments and return them.
        return String.join("", segments);
    }
}