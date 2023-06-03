from selenium_base import SeleniumBase
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
import time
from csv import DictReader
from PIL import Image
from locators import SingleProblemPage
from locators import LoginPage
from locators import EditorialPage

class EditorialScreenshotter(SeleniumBase):
    def __init__(self, waitTime=20):
        super().__init__(waitTime)

    def login(self):
        self.driver.get(LoginPage.URL)
        self.wait.until(EC.title_is(LoginPage.TITLE))
        self.wait.until_not(EC.presence_of_element_located((By.ID, LoginPage.LOADING_SCREEN_ID)))
        
        filename = "premium-screenshotter/leetcode_cookies.csv"
        cookies = []
        with open(filename, 'r') as file:
            csv_reader = DictReader(file)
            for row in csv_reader:
                clean_row = {key.strip(): value.strip() for key, value in row.items() if key!=""}
                cookies.append(clean_row)
        for i in cookies:
            self.driver.add_cookie(i)
        
        self.driver.refresh()
        self.wait.until_not(EC.title_is(LoginPage.TITLE))
    
    def load_page(self, link):
        self.driver.get(link)
        self.wait.until(EC.presence_of_element_located((By.XPATH, EditorialPage.EDITORIAL_1_XPATH)))
        self.wait.until(EC.presence_of_element_located((By.XPATH, EditorialPage.EDITORIAL_2_XPATH)))
    
    def get_height(self):
        # resize window and wait
        self.driver.set_window_size(1920,100000) #higher than the page could possibly be
        self.wait.until(EC.presence_of_element_located((By.XPATH, EditorialPage.EDITORIAL_1_XPATH)))
        self.wait.until(EC.presence_of_element_located((By.XPATH, EditorialPage.EDITORIAL_2_XPATH)))

        height = 0
        height += self.driver.find_element(By.XPATH, EditorialPage.EDITORIAL_1_XPATH).size["height"]
        height += self.driver.find_element(By.XPATH, EditorialPage.EDITORIAL_2_XPATH).size["height"]

        self.driver.set_window_size(1920, height + 500)
        return height
    
    def screenshot_editorial(self, height, fileName):
        starting_div = self.driver.find_element(By.XPATH, EditorialPage.EDITORIAL_1_XPATH)
        width = starting_div.size["width"]

        left, top = starting_div.location["x"], starting_div.location["y"]
        right, bottom = left + width, top + height + 100

        self.screenshot_with_boundaries(fileName + '.png', left, top, right, bottom)