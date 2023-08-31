function minimumDeleteSum(s1: string, s2: string): number {
    // Make sure s2 is smaller string
    if (s1.length < s2.length) {
        return minimumDeleteSum(s2, s1);
    }

    // Case for empty s1
    const m = s1.length;
    const n = s2.length;
    let currRow = new Array(n + 1).fill(0);
    for (let j = 1; j <= n; j++) {
        currRow[j] = currRow[j - 1] + s2.charCodeAt(j - 1);
    }

    // Compute answer row-by-row
    for (let i = 1; i <= m; i++) {

        let diag = currRow[0];
        currRow[0] += s1.charCodeAt(i - 1);

        for (let j = 1; j <= n; j++) {

            let answer = 0;

            // If characters are the same, the answer is top-left-diagonal value
            if (s1[i - 1] == s2[j - 1]) {
                answer = diag;
            }

            // Otherwise, the answer is minimum of top and left values with
            // deleted character's ASCII value
            else {
                answer = Math.min(
                    s1.charCodeAt(i - 1) + currRow[j],
                    s2.charCodeAt(j - 1) + currRow[j - 1]
                );
            }

            // Before overwriting currRow[j] with answer, save it in diag
            // for the next column
            diag = currRow[j];
            currRow[j] = answer;
        }
    }

    // Return the answer
    return currRow[n];
};