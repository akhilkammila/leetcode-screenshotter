
function characterReplacement(s, k) {
    let start = 0;
    let frequencyMap = {};
    let maxFrequency = 0;
    let longestSubstringLength = 0;
    for (let end = 0; end < s.length; end += 1) {
        frequencyMap[s[end]] ||= 0;
        frequencyMap[s[end]] += 1;

        // the maximum frequency we have seen in any window yet
        maxFrequency = Math.max(maxFrequency, frequencyMap[s[end]]);

        // move the start pointer towards right if the current
        // window is invalid
        const isValid = (end + 1 - start - maxFrequency <= k);
        if (!isValid) {
            frequencyMap[s[start]] -= 1;
            start += 1;
        }
        
        // the window is valid at this point, store length
        // size of the window never decreases
        longestSubstringLength = end + 1 - start;
    }
    return longestSubstringLength;
}
