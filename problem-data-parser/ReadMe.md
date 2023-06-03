# What this does
Goes to the problem page, and finds data on each problem
including Number, Title, Link, Acceptance Rate, Difficulty

Saves this data into data/problem_data.csv

# Docker Commands
Build docker container:
docker build -t problem-scraper:1 -f Dockerfile.data .

Run:
docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots problem-scraper:1

For the -v commands, put the path to where you want the file on your local computer. It basically syncs the docker container's file with your local files.

# Running
This does not require you to log into leetcode to run.

Just build the docker file and run. It will append to problem_data.csv, so if you want to restart it, delete problem_data.csv first.