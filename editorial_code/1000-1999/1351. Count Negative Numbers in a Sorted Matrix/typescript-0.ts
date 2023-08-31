function countNegatives(grid: number[][]): number {
    let count = 0;
    // Iterate on all elements of the matrix one by one.
    for (const row of grid) {
        for (const element of row) {
            // If the current element is negative, we count it.
            if (element < 0) {
                count++;
            }
        }
    }
    return count;
};