
import java.util.*;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                long sum = 0;
                Stack<int[]> stack = new Stack<>();

                stack.push(new int[]{i, j});
                visited[i][j] = true;

                while (!stack.isEmpty()) {
                    int[] cell = stack.pop();
                    int r = cell[0];
                    int c = cell[1];

                    sum += grid[r][c];

                    for (int[] d : dirs) {
                        int nr = r + d[0];
                        int nc = c + d[1];

                        if (nr >= 0 && nr < m &&
                            nc >= 0 && nc < n &&
                            grid[nr][nc] != 0 &&
                            !visited[nr][nc]) {

                            visited[nr][nc] = true;
                            stack.push(new int[]{nr, nc});
                        }
                    }
                }

                if (sum % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
