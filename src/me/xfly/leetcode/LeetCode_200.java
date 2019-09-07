package me.xfly.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_200 {

	public static void main(String[] args) {
		char[][] ch = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		System.out.println(numIslands2(ch));
	}

	public static int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0) {
			return 0;
		}

		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}

		return count;
	}

	public static int numIslands2(char[][] grid) {
		    if (grid == null || grid.length == 0) {
		      return 0;
		    }

		    int nr = grid.length;
		    int nc = grid[0].length;
		    int num_islands = 0;

		    for (int r = 0; r < nr; ++r) {
		      for (int c = 0; c < nc; ++c) {
		        if (grid[r][c] == '1') {
		          ++num_islands;
		          grid[r][c] = '0'; // mark as visited
		          Queue<Integer> neiors = new LinkedList<>();
		          neiors.add(r * nc + c);
		          while (!neiors.isEmpty()) {
		            int id = neiors.remove();
		            int row = id / nc;
		            int col = id % nc;
		            if (row - 1 >= 0 && grid[row-1][col] == '1') {
		              neiors.add((row-1) * nc + col);
		              grid[row-1][col] = '0';
		            }
		            if (row + 1 < nr && grid[row+1][col] == '1') {
		              neiors.add((row+1) * nc + col);
		              grid[row+1][col] = '0';
		            }
		            if (col - 1 >= 0 && grid[row][col-1] == '1') {
		              neiors.add(row * nc + col-1);
		              grid[row][col-1] = '0';
		            }
		            if (col + 1 < nc && grid[row][col+1] == '1') {
		              neiors.add(row * nc + col+1);
		              grid[row][col+1] = '0';
		            }
		          }
		        }
		      }
		    }

		    return num_islands;
		  }

	public static void dfs(char[][] grid, int i, int j) {

		int m = grid.length;
		int n = grid[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i + 1, j);
		dfs(grid, i, j + 1);

	}
}
