class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int rows = int(maze.size()), cols = int(maze[0].size());
        vector<pair<int, int>> dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Mark the entrance as visited since its not a exit.
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';
        
        // Start BFS from the entrance, and use a queue `queue` to store all 
        // the cells to be visited.
        queue<array<int, 3>> queue;
        queue.push({startRow, startCol, 0});
        
        while (!queue.empty()) {
            auto [currRow, currCol, currDistance] = queue.front();
            queue.pop();
            
            // For the current cell, check its four neighbor cells.
            for (auto dir : dirs) {
                int nextRow = currRow + dir.first, nextCol = currCol + dir.second;

                // If there exists an unvisited empty neighbor:
                if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols \
                   && maze[nextRow][nextCol] == '.') {
                    
                    // If this empty cell is an exit, return distance + 1.
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1)
                        return currDistance + 1;
                    
                    // Otherwise, add this cell to 'queue' and mark it as visited.
                    maze[nextRow][nextCol] = '+';
                    queue.push({nextRow, nextCol, currDistance + 1});
                    
                }
            }
        }
        
        // If we finish iterating without finding an exit, return -1.
        return -1;
    }
};