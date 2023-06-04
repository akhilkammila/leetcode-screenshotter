import csv

# Get every row in csv file
with open('data/editorial_data.csv', 'r') as file:
    csv_reader = csv.reader(file)

    # Convert the CSV reader object to a list of rows
    rows = list(csv_reader)

# Loop through every row, turn into markdown
markdownLines = []
for row in rows[1:]:
    # Break down row
    number = row[0]
    problem_title = row[1]

    # Find subdirectory
    if int(number) < 1000: subdir = '1-999'
    elif int(number) < 2000: subdir = '1000-1999'
    else: subdir = '2000-2999'

    # Find full path
    base = "https://github.com/akhilkammila/leetcode-screenshotter/tree/main/editorial-screenshots/"
    imagePath = (number.zfill(3) + ". " + problem_title + ".png").replace(" ", "%20")
    fullPath = base + subdir + "/" + imagePath
    
    # Make markdown line
    markdownLine = "#### [" + number + ". " + problem_title + "](" + fullPath + ")"
    markdownLines.append(markdownLine)

# Write to readme
with open('ReadMe.md', 'a') as f:
    for line in markdownLines:
        f.write(line + '\n')