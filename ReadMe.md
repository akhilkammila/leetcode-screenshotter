## This project contains screenshots of all leetcode problems – including premiums
They are all in the screenshots folder, organized by number

## Personal Docker commands:

Build data scraper:
docker build -t problem-scraper:1 -f Dockerfile.data .
Run:
docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots problem-scraper:1

Build screenshotter:
docker build -t premium-screenshotter:1 -f Dockerfile.screenshot .
Run:
docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots premium-screenshotter:1