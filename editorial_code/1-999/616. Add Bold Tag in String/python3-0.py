bold = [False] * len(s)

for word in words:
    for i in range(len(s) - len(word) + 1):
        if s[i:i + len(word)] == word:
            for j in range(i, i + len(word)):
                bold[j] = True