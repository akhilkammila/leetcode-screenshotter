class ProblemPage:
    URL =  "https://leetcode.com/problemset/algorithms/"
    TITLE = "Problems - LeetCode"

    ROWGROUP = "//*[@id='__next']/div/div[2]/div[1]/div[1]/div[5]/div[2]/div/div/div[2]"
    NEXT_BUTTON_XPATH = "//*[@id='__next']/div/div[2]/div[1]/div[1]/div[5]/div[3]/nav/button[10]"

class ProblemRow:
    TITLE_ELEMENT = "./div[2]/div/div/div/div/a"
    PREMIUM = "./div[2]/div/div/div/*[local-name() = 'svg']"
    ACCEPTANCE_RATE = "./div[4]/span"
    DIFFICULTY = "./div[5]/span"

    EDITORIAL = "./div[3]/a"