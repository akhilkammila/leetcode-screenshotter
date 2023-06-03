import threading
import time
from main_page_scraper import MainPageScraper
from debug_wrapper import DebugWrapper
from editorial_scraper import EditorialScraper

def runProblemDataScraper():
    scraper = MainPageScraper()
    scraper = DebugWrapper(scraper)
    for i in range(49):
        scraper.get_problems_on_page()
        scraper.next_page()

def runEditorialScraper():
    scraper = EditorialScraper()
    scraper = DebugWrapper(scraper)

    for i in range(49):
        scraper.get_problems_on_page()
        scraper.next_page()

if __name__ == "__main__":
    runEditorialScraper()