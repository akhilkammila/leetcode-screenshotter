class LoginPage:
    URL = "https://leetcode.com/accounts/login/"
    TITLE = "Account Login - LeetCode"
    LOADING_SCREEN_ID = "initial-loading"
    USERNAME_BTN_ID = "id_login"
    PASSWORD_BTN_ID = "id_password"
    SIGN_IN_BUTTON_ID = "signin_btn"

class SingleProblemPage:
    EDITOR_XPATH = "//*[@id='editor']/div[4]/div[1]/div/div/div[1]/div[1]/div[3]"
    PROBLEM_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]"

    PROBLEM_1_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/div[1]"
    PROBLEM_2_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/div[2]"
    PROBLEM_3_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/div[3]"
    PROBLEM_4_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/div[4]"

class EditorialPage:
    EDITORIAL_1_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/div/div/div[1]"
    EDITORIAL_2_XPATH = "//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/div/div/div[2]/div[1]"