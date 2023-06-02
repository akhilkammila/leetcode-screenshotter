import threading
import time
from main_page_scraper import MainPageScraper
from debug_wrapper import DebugWrapper


if __name__ == "__main__":
    scraper = MainPageScraper()
    scraper = DebugWrapper(scraper)
    for i in range(49):
        scraper.get_problems_on_page()
        scraper.next_page()