class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:

        max_time = -1

        def build_time(permutation):
            nonlocal max_time

            h, i, j, k = permutation
            hour = h*10 + i
            minute = j*10 + k
            if hour < 24 and minute < 60:
                max_time = max(max_time, hour * 60 + minute)

        def swap(array, i, j):
            if i != j:
                array[i], array[j] = array[j], array[i]

        def permutate(array, start):
            if start == len(array):
                build_time(array)
                return

            for index in range(start, len(array)):
                swap(array, index, start)
                # repeat the permutation with the original array mutated
                permutate(array, start+1)
                swap(array, index, start)

        permutate(A, 0)
        if max_time == -1:
            return ""
        else:
            return "{:02d}:{:02d}".format(max_time // 60, max_time % 60)