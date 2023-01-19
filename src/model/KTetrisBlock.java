package model;

import static tetrismain.Constants.BOARD_SAVE_PLUS;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

import controller.KTetrisController;

public class KTetrisBlock {
	public final int BLOCK_TYPE = 7;
	public final int BLOCK_ROW = 4;
	public final int BLOCK_COL = 4;

	public int[][] matrix;
	public int type;

	public int posX = 0, posY = 0;
	private KTetrisController controller;

	private final static Logger LOG = Logger.getGlobal();

	public KTetrisBlock(KTetrisController controller) {
		LOG.info("**** Start *****");

		this.controller = controller;
		Random rand = new Random();
		setBlock(rand.nextInt(BLOCK_TYPE));

		LOG.info("**** Finish *****");

	}

	private void setBlock(int type) {
		LOG.info("**** Start *****");
		this.type = type;

		if (type == 0) {
			matrix = new int[][] { { 1, 1, 1, 1 } };
		} else if (type == 1) {
			matrix = new int[][] { { 1, 1, 1 }, { 0, 1, 0 } };
		} else if (type == 2) {
			matrix = new int[][] { { 1, 1, 1 }, { 0, 0, 1 } };
		} else if (type == 3) {
			matrix = new int[][] { { 1, 1, 1 }, { 1, 0, 0 } };
		} else if (type == 4) {
			matrix = new int[][] { { 0, 1, 1 }, { 1, 1, 0 } };
		} else if (type == 5) {
			matrix = new int[][] { { 0, 1, 1 }, { 1, 1, 0 } };
		} else if (type == 6) {
			matrix = new int[][] { { 1, 1 }, { 1, 1 } };
		}
		;

		LOG.info("**** Finish *****");

	}

	public void nextBlock(KTetrisBoard board) {
		LOG.info("**** Start *****");
		Random rand = new Random();

		setBlock(rand.nextInt(BLOCK_TYPE));

		LOG.info("**** Finish *****");
		return;
	}

	private static int[][] rotateMatrix(int[][] orgMap) {
		LOG.info("**** Start *****");
		int iOrgRow = orgMap.length;
		int iOrgCol = orgMap[0].length;
		// 돌린 크기만큼으로 생성해준다.
		int[][] copyMap = new int[iOrgCol][iOrgRow];

		for (int i = 0; i < iOrgRow; i++) {
			for (int j = 0; j < iOrgCol; j++) {
				copyMap[j][iOrgRow - 1 - i] = orgMap[i][j];
			}
		}

		LOG.info("**** Finish *****");
		// 새로 돌린 배열로 반환해준다.
		return copyMap;
	}

	public void rotateBlock(KTetrisBoard board) {
		LOG.info("**** Start *****");

		int[][] nextBlock;
		nextBlock = rotateMatrix(matrix);

		if (isCrossBorder(board, nextBlock)) {
			return;
		}

		if (isBlockCollision(board, nextBlock, 0, 0)) {
			return;
		}

		matrix = nextBlock;

		LOG.info("**** Finish *****");
	}

	public boolean isCrossBorder(KTetrisBoard board, int[][] matrix) {
		if (posX + matrix[0].length > board.matrix[0].length)
			return true;
		if (posY + matrix.length > board.matrix.length)
			return true;

		return false;
	}

	void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			LOG.info(Arrays.toString(matrix[i]));
		}
	}

	public boolean isBlockCollision(KTetrisBoard board, int[][] matrix, int iDeltaX, int iDeltaY) {
		LOG.info("**** Start *****");
		printMatrix(board.matrix);
		printMatrix(matrix);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > 0 && board.matrix[posY + iDeltaY + i][posX + iDeltaX + j] > 0)
					return true;
				;
			}
		}

		return false;
	}

	public void leftBlock(KTetrisBoard board) {
		if (posX > 0) {
			if (isBlockCollision(board, matrix, -1, 0)) {
				return;
			}
			
			posX = posX - 1;
		}

	}

	public void rightBlock(KTetrisBoard board) {
		if (posX + matrix[0].length < board.matrix[0].length) {
			if (isBlockCollision(board, matrix, 1, 0)) {
				return;
			}
			posX = posX + 1;
		}
	}

	public void upBlock(KTetrisBoard board) {
		if (posY > 0) {
			if (isBlockCollision(board, matrix, 0, -1)) {
				return;
			}
			posY = posY - 1;
		}

	}

	public void downBlock(KTetrisBoard board) {
		if (posY + matrix.length < board.matrix.length) {
			if (isBlockCollision(board, matrix, 0, 1)) {
				return;
			}
			posY = posY + 1;
		}
		return;

	}

}
