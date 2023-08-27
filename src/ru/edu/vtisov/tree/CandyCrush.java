package ru.edu.vtisov.tree;

// https://leetcode.com/problems/candy-crush

public class CandyCrush {

    // in place
    public int[][] candyCrush(int[][] board) {
        while(find(board)) {
            crush(board);
            drop(board);
        }   
        return board; 
    }

    private boolean find(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean exist = false;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (Math.abs(board[i][j - 1]) == Math.abs(board[i][j]) && Math.abs(board[i][j]) == Math.abs(board[i][j + 1])) {
                    board[i][j - 1] = -Math.abs(board[i][j - 1]);
                    board[i][j] = -Math.abs(board[i][j]);
                    board[i][j + 1] = -Math.abs(board[i][j + 1]);
                    exist = true;
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                if (Math.abs(board[i - 1][j]) == Math.abs(board[i][j]) && Math.abs(board[i][j]) == Math.abs(board[i + 1][j])) {
                    board[i - 1][j] = -Math.abs(board[i - 1][j]);
                    board[i][j] = -Math.abs(board[i][j]);
                    board[i + 1][j] = -Math.abs(board[i + 1][j]);
                    exist = true;
                }
            }
        }
        return exist;
    }

    private void crush(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                } 
           }
        }
    }

    private void drop(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int j = 0; j < m; j++) {
            int lowestZero = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j] == 0) {
                    lowestZero = Math.max(lowestZero, i);
                } else if (lowestZero != -1) {
                    int temp = board[i][j];
                    board[i][j] = board[lowestZero][j];
                    board[lowestZero][j] = temp;
                    lowestZero--;
                }
            }
        }
    }

}


// class Solution {

//     public int[][] candyCrush(int[][] board) {
//         Set<Pair<Integer, Integer>> crushed = find(board);
//         while(!crushed.isEmpty()) {
//             crush(board, crushed);
//             drop(board);
//             crushed = find(board);
//         }   
//         return board; 
//     }

//     private Set<Pair<Integer, Integer>> find(int[][] board) {
//         int n = board.length;
//         int m = board[0].length;
//         Set<Pair<Integer, Integer>> crushed = new HashSet<>();

//         for (int i = 0; i < n; i++) {
//             for (int j = 1; j < m - 1; j++) {
//                 if (board[i][j] == 0) {
//                     continue;
//                 }
//                 if (board[i][j - 1] == board[i][j] && board[i][j] == board[i][j + 1]) {
//                     crushed.add(new Pair(i, j - 1));
//                     crushed.add(new Pair(i, j));
//                     crushed.add(new Pair(i, j + 1));
//                 }
//             }
//         }

//         for (int i = 1; i < n - 1; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (board[i][j] == 0) {
//                     continue;
//                 }
//                 if (board[i - 1][j] == board[i][j] && board[i][j] == board[i + 1][j]) {
//                     crushed.add(new Pair(i - 1, j));
//                     crushed.add(new Pair(i, j));
//                     crushed.add(new Pair(i + 1, j));
//                 }
//             }
//         }
//         return crushed;
//     }

//     private void crush(int[][] board, Set<Pair<Integer, Integer>> crushed) {
//         for (Pair<Integer, Integer> pair: crushed) {
//             board[pair.getKey()][pair.getValue()] = 0;
//         }
//     }

//     private void drop(int[][] board) {
//         int n = board.length;
//         int m = board[0].length;
//         for (int j = 0; j < m; j++) {
//             int lowestZero = -1;
//             for (int i = n - 1; i >= 0; i--) {
//                 if (board[i][j] == 0) {
//                     lowestZero = Math.max(lowestZero, i);
//                 } else if (lowestZero != -1) {
//                     int temp = board[i][j];
//                     board[i][j] = board[lowestZero][j];
//                     board[lowestZero][j] = temp;
//                     lowestZero--;
//                 }
//             }
//         }
//     }
// }