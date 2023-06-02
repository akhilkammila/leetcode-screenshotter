import os
import time
from selenium.webdriver.chrome.webdriver import WebDriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

class SeleniumBase:
    # Initialize
    def __init__(self, waitTime):
        options = Options()
        options.add_argument('--headless')
        options.add_argument('--no-sandbox')
    
        options.add_argument("--window-size=1920,1080")
        options.add_argument('start-maximized')

        options.add_argument('--disable-dev-shm-usage')
        options.add_argument('--disable-gpu')

        self.driver = WebDriver(options=options)
        self.wait = WebDriverWait(self.driver, waitTime)
        self.screenshotFile = "screenshots/" + time.strftime("%Y%m%d-%H%M%S") + "/"
        os.makedirs(self.screenshotFile)
    
    # Debug functions
    def screenshot(self, filename):
        self.driver.save_screenshot(self.screenshotFile + filename)
    
    def save_html(self, filename):
        with open(self.screenshotFile + filename, "w") as file:
            file.write(self.driver.page_source)

    # Getters (with waiting)
    def get_by_text(self, element_type, text):
        xpath = "//" + element_type + "[text()= '" + text + "']"
        self.wait.until(EC.element_to_be_clickable((By.XPATH, xpath)))
        return self.driver.find_element(By.XPATH, xpath)
    
    def get_by_id(self, id):
        self.wait.until(EC.element_to_be_clickable((By.ID, id)))
        return self.driver.find_element(By.ID, id)
    
    def get_by_href(self, href):
        xpath = "//a[@href='" + href + "']"
        self.wait.until(EC.element_to_be_clickable((By.XPATH, xpath)))
        return self.driver.find_element(By.XPATH, xpath)
    
    def get_by_link_text(self, text):
        self.wait.until(EC.element_to_be_clickable((By.LINK_TEXT, text)))
        return self.driver.find_element(By.LINK_TEXT, text)
    
    def get_by_xpath(self, xpath):
        self.wait.until(EC.element_to_be_clickable((By.XPATH, xpath)))
        return self.driver.find_element(By.XPATH, xpath)
    
    def get_by_class(self, class_name):
        self.wait.until(EC.element_to_be_clickable((By.CLASS_NAME, class_name)))
        return self.driver.find_element(By.CLASS_NAME, class_name)
    
    # Operators
    def click(self, element):
        element.click()
        # self.driver.execute_script("arguments[0].click();", element)
    
    def send_keys(self, element, keys):
        self.click(element)
        self.driver.switch_to.active_element.send_keys(keys)
    
    # Clipboard Operators
    def get_clipboard(self):
        # add input field
        self.driver.execute_script('''
        var tempInput = document.createElement("textarea");
        tempInput.id = "tempInput";
        document.body.appendChild(tempInput);''')

        # paste into it and get contents
        input_field = self.get_by_id("tempInput")
        input_field.send_keys(Keys.CONTROL, 'v')
        content = input_field.get_attribute('value')

        # remove field
        self.driver.execute_script("arguments[0].remove()", input_field)
        return content
    
    def set_clipboard(self, text):
        self.driver.execute_script('''
            var tempInput = document.createElement("textarea");
            tempInput.id = "tempInput";
            tempInput.value = String.raw`{content}`;
            document.body.appendChild(tempInput);
        '''.format(content=text))

        input_field = self.get_by_id("tempInput")
        input_field.send_keys(Keys.CONTROL, 'a', 'c')

        # remove field
        self.driver.execute_script("arguments[0].remove()", input_field)
    
    def pause(self, seconds):
        print("pausing for " + str(seconds) + " seconds", flush=True)
        time.sleep(seconds)