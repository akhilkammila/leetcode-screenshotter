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

"""
Move editorial screenshots into subfolders
"""
def move_editorial_screenshots():
    i = 0
    for filename in os.listdir('editorial-screenshots'):
        base = ''
        if len(filename.split('. ')) < 2: continue
        number = filename.split('. ')[0]
        if int(number) < 1000: base = '1-999'
        elif int(number) < 2000: base = '1000-1999'
        else: base = '2000-2999'
        os.rename('editorial-screenshots/' + filename, 'editorial-screenshots/' + base + '/' + filename)

if __name__ == "__main__":
    move_editorial_screenshots()