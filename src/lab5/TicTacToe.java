package lab5;

import java.util.Arrays;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;
	
	public TicTacToe(char[][] board) {
		super();
		this.board = board;
	}
	public boolean checkRows() {
		char tmp = ' ';
		for (int i = 0; i < board.length; i++) {
			tmp = board[i][0];
			if (tmp != EMPTY) {
				for (int j = 1; j < board.length; j++) {
					if (board[i][j] != tmp) {
						break;
					}
					if (j == board.length-1) {
						System.out.println(tmp == 'X' ? "X win row" : "O win row");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkColumns() {
		char tmp = ' ';
		for (int i = 0; i < board.length; i++) {
			tmp = board[0][i];
			if (tmp != EMPTY) {
				for (int j = 1; j < board.length; j++) {
					if (board[j][i] != tmp) {
						break;
					}
					if (j == board.length-1) {
						System.out.println(tmp == 'X' ? "X win col" : "O win col");
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkDiagonals() {
		// Check top-left to bottom-right
		char tmp = board[0][0];
		if (tmp != EMPTY) {
			for (int i = 1; i < board.length; i++) {
				if (board[i][i] != tmp) {
					break;
				}
				if (i == board.length-1) {
					System.out.println(tmp == 'X' ? "X win diagonal" : "O win diagonal");
					return true;
				}
			}
		}
		
		// Check bottom-left to top-right
		tmp = board[0][board.length-1];
		if (tmp != EMPTY) {
			for (int i = board.length-2; i >= 0; i--) {
				if (board[i][board.length-1-i] != tmp) {
					break;
				}
				if (i == 0) {
					System.out.println(tmp == 'X' ? "X win diag /" : "O win diag /");
					return true;
				}
			}
		}
		return false;
	}
	
	public void checkResult() {
		checkRows();
		checkColumns();
		checkDiagonals();
	}
	
	public static void main(String[] args) {
		char[][] testMatrix1 = {{'X','O','O'},
								{'O','X','O'},
								{'X','O','X'}};
		
		char[][] testMatrix2 = {{'X','O','X'},
								{'O','X','O'},
								{'X','O','O'}};
		
		char[][] testMatrix3 = {{'O','O','O'},
								{'O','X','X'},
								{'X','O','X'}};
		
		char[][] testMatrix4 = {{'O','X','O'},
								{'O','X','X'},
								{'X','X','O'}};
		
		char[][] testMatrix5 = {{'O','X','O','X'},
								{'O','X','X','X'},
								{'O','X','O','O'},
								{'X','X','O','O'}};
		
		TicTacToe test1 = new TicTacToe(testMatrix1);
		TicTacToe test2 = new TicTacToe(testMatrix2);
		TicTacToe test3 = new TicTacToe(testMatrix3);
		TicTacToe test4 = new TicTacToe(testMatrix4);
		TicTacToe test5 = new TicTacToe(testMatrix5);
		
		test1.checkResult();
		test2.checkResult();
		test3.checkResult();
		test4.checkResult();
		test5.checkResult();
		
	}
}
