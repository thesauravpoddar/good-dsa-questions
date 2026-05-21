class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                // We have to launch a completely separate DFS from every single treasure
                if (grid[r][c] == 0) {
                    dfs(grid, r, c, 0); 
                }
            }
        }
    }

    public void dfs(int[][] grid, int r, int c, int distance) {
        // Stop if out of bounds, hitting a wall, OR if the current path 
        // is longer than a path we already found earlier.
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length 
            || grid[r][c] == -1 || grid[r][c] < distance) {
            return;
        }

        // Overwrite the cell with the new, shorter distance
        grid[r][c] = distance;

        // Keep exploring (this will re-explore the same cells thousands of times)
        dfs(grid, r + 1, c, distance + 1);
        dfs(grid, r - 1, c, distance + 1);
        dfs(grid, r, c + 1, distance + 1);
        dfs(grid, r, c - 1, distance + 1);
    }
}