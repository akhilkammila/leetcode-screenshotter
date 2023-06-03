from problem_screenshotter import ProblemScreenshotter
from editorial_screenshotter import EditorialScreenshotter
from debug_wrapper import DebugWrapper
import csv
import os

class ProblemScreenshotRunner:
    def __init__(self):
        self.screenshotter = ProblemScreenshotter()
        self.screenshotter = DebugWrapper(self.screenshotter)

    def login(self):
        self.screenshotter.login()
    
    def solve_problem(self, link, fileName):
        self.screenshotter.load_page(link)
        height = self.screenshotter.get_height()
        self.screenshotter.screenshot_problem(height, fileName)

def runProblemScreenshotter():
    runner = ProblemScreenshotRunner()
    runner.login()

    # loop through each problem, and solve
    with open('data/problem_data.csv', 'r') as file:
        csv_reader = csv.reader(file)

        # Convert the CSV reader object to a list of rows
        rows = list(csv_reader)

        # Access specific rows by index
        for row in rows[1:]:
            number = row[0]
            problem_title = row[1]
            link = row[2]

            full_name = number + ". " + problem_title
            if int(number) < 1100 or full_name + '.png' in os.listdir('screenshots'):
                continue

            runner.solve_problem(link, full_name)

class EditorialScreenshotRunner:
    def __init__(self):
        self.screenshotter = EditorialScreenshotter()
        self.screenshotter = DebugWrapper(self.screenshotter)

    def login(self):
        self.screenshotter.login()
    
    def solve_problem(self, link, fileName):
        self.screenshotter.load_page(link)
        height = self.screenshotter.get_height()
        self.screenshotter.screenshot_editorial(height, fileName)

def runEditorialScreenshotter():
    runner = EditorialScreenshotRunner()
    runner.login()

    # loop through each problem, and solve
    with open('data/editorial_data.csv', 'r') as file:
        csv_reader = csv.reader(file)

        # Convert the CSV reader object to a list of rows
        rows = list(csv_reader)

        # Access specific rows by index
        for row in reversed(rows[1:]):
            number = row[0]
            problem_title = row[1]
            link = row[2]

            full_name = number.zfill(3) + ". " + problem_title
            if full_name + '.png' in os.listdir('screenshots'):
                continue

            print("solving " + full_name, flush=True)
            runner.solve_problem(link, full_name)

if __name__ == "__main__":
    runEditorialScreenshotter()