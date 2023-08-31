
function characterReplacement(s, k) {
    // binary search over the length of substring
    // lo contains the valid value, and hi contains the
    // invalid value
    let lo = 1,
        hi = s.length + 1;
    while (lo + 1 < hi) {
        let mid = lo + Math.floor((hi - lo) / 2);

        // can we make a valid substring of length `mid`?
        if (canMakeValidSubstring(s, mid, k)) {
            // explore the right half
            lo = mid;
        } else {
            // explore the left half
            hi = mid;
        }
    }

    // length of the longest substring that satisfies
    // the given condition
    return lo;
}

function canMakeValidSubstring(s, substringLength, k) {
    // take a window of length `substringLength` on the given
    // string, and move it from left to right. If this window
    // satisfies the condition of a valid string, then we return
    // true
    let freqMap = {};
    let maxFrequency = 0;
    let start = 0;
    for (let end = 0; end < s.length; end += 1) {
        freqMap[s[end]] ||= 0;
        freqMap[s[end]] += 1;

        // if the window [start, end] exceeds substringLength
        // then move the start pointer one step toward right
        if (end + 1 - start > substringLength) {
            // before moving the pointer toward right, decrease
            // the frequency of the corresponding character
            freqMap[s[start]] -= 1;
            start += 1;
        }

        // record the maximum frequency seen so far
        maxFrequency = Math.max(maxFrequency, freqMap[s[end]]);
        if (substringLength - maxFrequency <= k) {
            return true;
        }
    }

    // we didn't a valid substring of the given size
    return false;
}
