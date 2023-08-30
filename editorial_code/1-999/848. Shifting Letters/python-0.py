class Solution(object):
    def shiftingLetters(self, S, shifts):
        ans = []
        X = sum(shifts) % 26
        for i, c in enumerate(S):
            index = ord(c) - ord('a')
            ans.append(chr(ord('a') + (index + X) % 26))
            X = (X - shifts[i]) % 26

        return "".join(ans)