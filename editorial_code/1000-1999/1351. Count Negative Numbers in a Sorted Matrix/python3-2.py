class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        count = 0
        n = len(grid[0])
        currRowNegativeIndex = n - 1

        # Iterate on all rows of the matrix one by one.
        for row in grid:
            # Decrease 'currRowNegativeIndex' so that it points to current row's last positive element.
            while currRowNegativeIndex >= 0 and row[currRowNegativeIndex] < 0:
                currRowNegativeIndex -= 1
            # 'currRowNegativeIndex' points to the last positive element,
            # which means 'n - (currRowNegativeIndex + 1)' is the number of all negative elements.
            count += (n - (currRowNegativeIndex + 1))
        return count