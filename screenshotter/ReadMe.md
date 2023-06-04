# What this does
Goes to problem links, and screenshots the problem page and editorials

problem_screenshotter screenshots the problems
editorial_screenshotter screenshots the editorials

# Running
Docker Commands
Build:
docker build -t premium-screenshotter:1 -f Dockerfile.screenshot .
Run:
docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots premium-screenshotter:1

For the -v commands, put the path to where you want the file on your local computer. It basically syncs the docker container's file with your local files.