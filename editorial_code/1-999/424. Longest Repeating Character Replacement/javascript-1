
function characterReplacement(s, k) {
    let allLetters = new Set();
    // collect all unique letters
    for (let char of s) {
        allLetters.add(char);
    }
    let maxLength = 0;
    // iterate over each unique letter
    for (let letter of allLetters) {
        let start = 0,
            count = 0;
        // initialize a sliding window for each unique letter
        for (let end = 0; end < s.length; end += 1) {
            if (s[end] === letter) {
                // if the letter matches, increase the count
                count += 1;
            }
            // bring start forward until the window is valid again
            while (!isWindowValid(start, end, count, k)) {
                if (s[start] === letter) {
                    // if the letter matches, decrease the count
                    count -= 1;
                }
                start += 1;
            }
            // at this point the window is valid, update maxLength
            maxLength = Math.max(maxLength, end + 1 - start);
        }
    }
    return maxLength;
}

function isWindowValid(start, end, charFrequency, maxReplacements) {
    return end + 1 - start - charFrequency <= maxReplacements;
}
