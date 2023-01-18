package model;

import controller.KTetrisController;

public class KTetrisBoard {
	public int Board[][];
	private KTetrisController gameController;
	public static final int ROW_SIZE = 20;
	public static final int COL_SIZE = 10;

	public KTetrisBoard(KTetrisController gameController) {
		this.gameController = gameController;
		Board = new int[ROW_SIZE][COL_SIZE];
		for (int i = 0; i < COL_SIZE; i++)
			for (int j = 0; j < ROW_SIZE; j++)
				Board[j][i] = 0;
	}

//	public void addBlock(TetrisBlock block) {
//		for (int i = 0; i < block.block.length; i++) {
//			for (int j = 0; j < block.block[i].length; j++) {
//				if (block.posY + i >= y
//						|| block.posX + j >= x)
//					break;
//				if (block.block[i][j] >= 1
//						&& this.block[block.posY + i][block.posX + j] == 0)
//					this.block[block.posY + i][block.posX + j] = block.block[i][j];
//			}
//		}
//		fullLineCheck();
//	}
//
//	private void fullLineCheck() {
//		for (int j = y - 1; j > 0; j--) {
//			int lineChecker = 1;
//			for (int i = 0; i < x; i++) {
//				lineChecker = lineChecker * this.block[j][i];
//			}
//			if (lineChecker >= 1) {
//				deleteLine(j);
//				j++;
//			}
//			lineChecker = 1;
//		}
//	}
//
//	public void deleteLine(int line) {
//		for (int j = line; j > 0; j--)
//			for (int i = 0; i < x; i++) {
//				this.block[j][i] = this.block[j - 1][i];
//			}
//		gameController.getScore().scoreUp();
//		
//	}

}
