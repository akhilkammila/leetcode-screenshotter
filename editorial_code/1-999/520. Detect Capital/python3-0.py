class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        n = len(word)
            
        match1, match2, match3 = True, True, True

        # case 1: All capital
        for i in range(n):
            if not word[i].isupper():
                match1 = False
                break
        if match1:
            return True

        # case 2: All not capital
        for i in range(n):
            if word[i].isupper():
                match2 = False
                break
        if match2:
            return True

        # case 3: All not capital except first
        if not word[0].isupper():
            match3 = False
        if match3:
            for i in range(1, n):
                if word[i].isupper():
                    match3 = False
                    break
        if match3:
            return True

        # if not matching
        return False