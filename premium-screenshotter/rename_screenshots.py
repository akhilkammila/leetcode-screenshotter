"""
Renames screenshots to be zero-padded by 3 digits
"""

import os

"""
Makes screenshots 1-999 have 3 digits
so they are ordered properly on GitHub
"""
def rename_screenshots():
    i = 0
    for filename in os.listdir('screenshots/1-999'):
        number = filename.split('. ')[0]
        title = filename.split('. ')[1]
        number = number.zfill(3)
        os.rename('screenshots/1-999/' + filename, 'screenshots/1-999/' + number + '. ' + title)

if __name__ == "__main__":
    rename_screenshots()