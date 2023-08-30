class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] durationArray = new int[26];
        durationArray[keysPressed.charAt(0) - 'a'] = releaseTimes[0];

        // find and store the key pressed duration for each key
        for (int i = 1; i < releaseTimes.length; i++) {
            int currentDuration = releaseTimes[i] - releaseTimes[i - 1];
            char currentKey = keysPressed.charAt(i);
            durationArray[currentKey - 'a'] = Math.max(durationArray[currentKey - 'a'], currentDuration);
        }
        // initialize slowest key as 'z'
        int slowestKeyIndex = 25;
        // iterate from 'y' to 'a' to find slowest key
        for (int currentKey = 24; currentKey >= 0; currentKey--) {
            if (durationArray[currentKey] > durationArray[slowestKeyIndex]) {
                slowestKeyIndex = currentKey;
            }
        }
        return (char) (slowestKeyIndex + 'a');
    }
}
