class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:

        max_time = -1
        for i1, D1 in enumerate(A):
            for i2, D2 in enumerate(A):
                for i3, D3 in enumerate(A):
                    if i1 == i2 or i2 == i3 or i1 == i3:
                        # skip duplicate elements
                        continue
                    # the total sum of indices is 0 + 1 + 2 + 3 = 6.
                    i4 = 6 - i1 - i2 - i3
                    D4 = A[i4]

                    # check if the permutation can form a time
                    hour = D1*10 + D2
                    minute = D3*10 + D4
                    if hour < 24 and minute < 60:
                        max_time = max(max_time, hour * 60 + minute)

        if max_time == -1:
            return ""
        else:
            return "{:02d}:{:02d}".format(max_time // 60, max_time % 60)