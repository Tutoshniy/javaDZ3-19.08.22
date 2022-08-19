/**
 * sem4
 */
public class sem4 {
    public static void main(String[] args) {
        int[][] board = new int [8][8];
        int n = board.length;
        board[0][0] = 1;
    if (solve(board, board.length) == true){
        for (int i = 0; i <= board.length-1; i++) {
            for (int j = 0; j <= board.length-1; j++) {
                if (checkPosition(board, i, j) == true){
                    board[i][j] = 1;
                };
            }
        }
    }
    System.out.println("------------------------------");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println("------------------------------");
    }

    public static boolean checkPosition(int[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 1) {
                return false;
            }
        }
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(int[][] board, int column) {
        if (column >= board.length) {
            return true;
        }

        for (int i = 0; i <= board.length; i++) {
            if (checkPosition(board, i, column)) {
                board[i][column] = 1;
                if (solve(board, column+1)) {
                    return true;
                }
                board[i][column] = 0;
            }
        }
        return false;
    }
}
