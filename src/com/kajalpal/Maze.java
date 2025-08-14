package com.kajalpal;

import java.util.Arrays;
import java.util.ArrayList;
public class Maze {
    public static void main(String[] args) {
//int ans = count(3,3);
        // System.out.println(ans);
        // path("",3,3);
        // pathDiagonal("",3,3);
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}

        };
        // pathwithObscticles("", board, 0, 0);
        int[][] path = new int[board.length][board[0].length];
        BacktrackingWithMaze("", board, 0, 0, path, 1);
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        int left = count(r - 1, c);
        int right = count(r, c - 1);
        return left + right;
    }

    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            path(p + 'D', r - 1, c);
        }
        if (c > 1) {
            path(p + 'R', r, c - 1);
        }
    }

    static void pathDiagonal(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            pathDiagonal(p + 'v', r - 1, c);
        }
        if (r > 1 && c > 1) {
            pathDiagonal(p + 'D', r - 1, c - 1);
        }
        if (c > 1) {
            pathDiagonal(p + 'h', r, c - 1);
        }
    }

    static void pathwithObscticles(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        if (r < maze.length - 1) {
            pathwithObscticles(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            pathwithObscticles(p + 'R', maze, r, c + 1);
        }
    }

    static void Backtracking(String p, boolean[][] maze, int r, int c) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        //cpnsidering this maze in path
        maze[r][c] = false;

        if (r < maze.length - 1) {
            Backtracking(p + 'D', maze, r + 1, c);
        }
        if (c < maze[0].length - 1) {
            Backtracking(p + 'R', maze, r, c + 1);
        }
        if (c > 0) {
            Backtracking(p + 'U', maze, r, c - 1);
        }
        if (r > 0) {
            Backtracking(p + 'L', maze, r - 1, c);
        }
        //remove the changes that were made before
        maze[r][c] = true;
    }

    static void BacktrackingWithMaze(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
             path[r][c] = step;
            for (int[] arr : path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if (!maze[r][c]) {
            return;
        }
        //cpnsidering this maze in path
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1) {
            BacktrackingWithMaze(p + 'D', maze, r + 1, c, path, step + 1);
        }
        if (c < maze[0].length - 1) {
            BacktrackingWithMaze(p + 'R', maze, r, c + 1, path, step + 1);
        }
        if (c > 0) {
            BacktrackingWithMaze(p + 'U', maze, r, c - 1, path, step + 1);
        }
        if (r > 0) {
            BacktrackingWithMaze(p + 'L', maze, r - 1, c, path, step + 1);
        }
        //remove the changes that were made before
        maze[r][c] = true;
        path[r][c] = 0;
    }
}



