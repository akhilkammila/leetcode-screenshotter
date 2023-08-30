class Solution:
    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        words = set(words)
        ans = []
        for i in range(len(text)):
            for j in range(i, len(text)):
                if text[i:j + 1] in words:
                    ans.append([i, j])
        return ans