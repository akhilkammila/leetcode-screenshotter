class State {
    int row;
    int col;
    int dist;
    String path;
    
    public State(int row, int col, int dist, String path) {
        this.row = row;
        this.col = col;
        this.dist = dist;
        this.path = path;
    }
}

class Solution {
    int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    String[] textDirections = new String[]{"l", "u", "r", "d"};
    int m;
    int n;
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        m = maze.length;
        n = maze[0].length;
        
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> {
            int distA = a.dist;
            int distB = b.dist;
            
            if (distA == distB) {
                return a.path.compareTo(b.path);
            }
            
            return distA - distB;
        });
        
        boolean[][] seen = new boolean[m][n];
        heap.add(new State(ball[0], ball[1], 0, ""));
        
        while (!heap.isEmpty()) {
            State curr = heap.remove();
            int row = curr.row;
            int col = curr.col;
            
            if (seen[row][col]) {
                continue;
            }
            
            if (row == hole[0] && col == hole[1]) {
                return curr.path;
            }
            
            seen[row][col] = true;
            
            for (State nextState: getNeighbors(row, col, maze, hole)) {
                int nextRow = nextState.row;
                int nextCol = nextState.col;
                int nextDist = nextState.dist;
                String nextChar = nextState.path;
                heap.add(new State(nextRow, nextCol, curr.dist + nextDist, curr.path + nextChar));
            }
        }
        
        return "impossible";
    }
    
    private boolean valid(int row, int col, int[][] maze) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }

        return maze[row][col] == 0;
    }
    
    private List<State> getNeighbors(int row, int col, int[][] maze, int[] hole) {
        List<State> neighbors = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            int dy = directions[i][0];
            int dx = directions[i][1];
            String direction = textDirections[i];
            
            int currRow = row;
            int currCol = col;
            int dist = 0;
            
            while (valid(currRow + dy, currCol + dx, maze)) {
                currRow += dy;
                currCol += dx;
                dist++;
                if (currRow == hole[0] && currCol == hole[1]) {
                    break;
                }
            }
            
            neighbors.add(new State(currRow, currCol, dist, direction));
        }
        
        return neighbors;
    }
}