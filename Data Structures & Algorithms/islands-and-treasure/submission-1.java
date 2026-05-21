class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == 0) {
                    q.add(new int[]{r,c});
                }
            }
        }
        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            for(var dir : directions) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];

                if(nextRow >= rows || nextCol >= cols || nextCol < 0 || nextRow < 0 || grid[nextRow][nextCol] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[nextRow][nextCol] = grid[r][c] + 1;
                q.add(new int[]{nextRow, nextCol});
            }
        }
    }
}