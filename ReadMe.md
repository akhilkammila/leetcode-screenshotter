Run the problem data scraper:
docker build -t problem-scraper:1 -f Dockerfile.data .

docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots problem-scraper:1


Run the screenshotter:
docker build -t premium-screenshotter:1 -f Dockerfile.screenshot .

docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots premium-screenshotter:1