class Solution:
    def threeEqualParts(self, arr: List[int]) -> List[int]:
        IMPOSSIBLE = [-1, -1]
        
        # If total number of ones is not evenly divisible by 3, then no solution exists.
        total_ones = sum(arr)
        if total_ones % 3: 
            return IMPOSSIBLE
        
        # Otherwise, each part should contain an equal amount of ones.
        target_ones = total_ones // 3
        if target_ones == 0:
            return [0, len(arr) - 1]

        # Find the index of the first and last 1 in each block of ones.
        breaks = []
        one_count = 0
        for i, bit in enumerate(arr):
            if bit == 1:
                one_count += bit
                if one_count in {1, target_ones + 1, 2 * target_ones + 1}:
                    breaks.append(i)
                if one_count in {target_ones, 2 * target_ones, 3 * target_ones}:
                    breaks.append(i)

        # i1, j1 marks the index of the first and last one in the first block of 1s, etc.
        i1, j1, i2, j2, i3, j3 = breaks

        # The array is in the form W [i1, j1] X [i2, j2] Y [i3, j3] Z
        # where each [i, j] is a block of 1s and W, X, Y, and Z represent blocks of 0s.
        if not(arr[i1 : j1 + 1] == arr[i2 : j2 + 1] == arr[i3 : j3 + 1]):
            return [-1, -1]

        # The number of zeros after the left, middle, and right parts
        trailing_zeros_left = i2 - j1 - 1
        trailing_zeros_mid = i3 - j2 - 1
        trailing_zeros = len(arr) - j3 - 1

        if trailing_zeros > min(trailing_zeros_left, trailing_zeros_mid): 
            return IMPOSSIBLE
        
        j1 += trailing_zeros
        j2 += trailing_zeros
        return [j1, j2 + 1]