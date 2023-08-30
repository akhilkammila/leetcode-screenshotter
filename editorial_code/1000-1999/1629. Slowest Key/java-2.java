class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        int longestPress = releaseTimes[0];
        char slowestKey = keysPressed.charAt(0);
        for (int i = 1; i < n; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            // check if we found the key that is slower than slowestKey
            if (currentDuration > longestPress ||
                (currentDuration == longestPress && keysPressed.charAt(i) > slowestKey)) {
                // update the slowest key and longest press duration
                longestPress = currentDuration;
                slowestKey = keysPressed.charAt(i);
            }
        }
        return slowestKey;
    }
}