## This project contains screenshots of all leetcode problems – including premiums
They are all in the screenshots folder, organized by number
Not There:
145,Binary Tree Postorder Traversal,https://leetcode.com/problems/binary-tree-postorder-traversal/solution
264,Ugly Number II,https://leetcode.com/problems/ugly-number-ii/solution/
351,Android Unlock Patterns,https://leetcode.com/problems/android-unlock-patterns/solution
459,Repeated Substring Pattern,https://leetcode.com/problems/repeated-substring-pattern/solution
519,Random Flip Matrix,https://leetcode.com/problems/random-flip-matrix/solution
564,Find the Closest Palindrome,https://leetcode.com/problems/find-the-closest-palindrome/solution
661,Image Smoother,https://leetcode.com/problems/image-smoother/solution
675,Cut Off Trees for Golf Event,https://leetcode.com/problems/cut-off-trees-for-golf-event/solution
676,Implement Magic Dictionary,https://leetcode.com/problems/implement-magic-dictionary/solution
711,Number of Distinct Islands II,https://leetcode.com/problems/number-of-distinct-islands-ii/solution
730,Count Different Palindromic Subsequences,https://leetcode.com/problems/count-different-palindromic-subsequences/solution
749,Contain Virus,https://leetcode.com/problems/contain-virus/solution
762,Prime Number of Set Bits in Binary Representation,https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/solution
773,Sliding Puzzle,https://leetcode.com/problems/sliding-puzzle/solution
779,K-th Symbol in Grammar,https://leetcode.com/problems/k-th-symbol-in-grammar/solution
818,Race Car,https://leetcode.com/problems/race-car/solution
840,Magic Squares In Grid,https://leetcode.com/problems/magic-squares-in-grid/solution
861,Score After Flipping Matrix,https://leetcode.com/problems/score-after-flipping-matrix/solution
874,Walking Robot Simulation,https://leetcode.com/problems/walking-robot-simulation/solution
898,Bitwise ORs of Subarrays,https://leetcode.com/problems/bitwise-ors-of-subarrays/solution
939,Minimum Area Rectangle,https://leetcode.com/problems/minimum-area-rectangle/solution
992,Subarrays with K Different Integers,https://leetcode.com/problems/subarrays-with-k-different-integers/solution

## Personal Docker commands:

Build data scraper:
docker build -t problem-scraper:1 -f Dockerfile.data .
Run:
docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots problem-scraper:1

Build screenshotter:
docker build -t premium-screenshotter:1 -f Dockerfile.screenshot .
Run:
docker run -v /Users/akhilkammila/Projects/leetcode-problem-scraper/data:/app/data -v /Users/akhilkammila/Projects/leetcode-problem-scraper/screenshots:/app/screenshots premium-screenshotter:1