package model;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Logger;

import controller.KTetrisController;

public class KTetrisBlock {
	public final int BLOCK_TYPE = 7;
	public final int BLOCK_ROW = 4;
	public final int BLOCK_COL = 4;
	
	public int[][] block;
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
		
		if(type == 0) {
			block = new int[][]	{
				{1, 1, 1, 1}
				};
		} else if(type == 1) {
			block = new int[][]	{
				{1, 1, 1},
				{0, 1, 0}
				};
		} else if(type == 2) {
			block = new int[][]	{
				{1, 1, 1},
				{0, 0, 1}
				};
		} else if(type == 3) {
			block = new int[][]	{
				{1, 1, 1},
				{1, 0, 0}
				};
		} else if(type == 4) {
			block = new int[][]	{
				{0, 1, 1},
				{1, 1, 0}
				};
		} else if(type == 5) {
			block = new int[][]	{
				{0, 1, 1},
				{1, 1, 0}
				};
		} else if(type == 6) {
			block = new int[][]	{
				{1, 1},
				{1, 1}
				};
		} ;

		
		LOG.info("**** Finish *****");
		
	}
	
	public void nextBlock(KTetrisBoard board) {
		LOG.info("**** Start *****");
		Random rand = new Random();
		setBlock(rand.nextInt(BLOCK_TYPE));
		
		LOG.info("**** Finish *****");
		return ;
	}	
	
	private static int[][] rotate(int[][] orgMap) {
		LOG.info("**** Start *****");
		int iRow = orgMap.length;
		int iCol = orgMap[0].length;
		// 돌린 크기만큼으로 생성해준다.
		int[][] copyMap = new int[iCol][iRow];

		for (int i = 0; i < iRow; i++) {
			for (int j = 0; j < iCol; j++) {
				copyMap[j][iRow - 1 - i] = orgMap[i][j];
			}
		}

		LOG.info("**** Finish *****");
		// 새로 돌린 배열로 반환해준다.
		return copyMap;
	}

	

	public void rotateBlock(KTetrisBoard board) {
		LOG.info("**** Start *****");
		
		int[][] currentBlock = block.clone();
		int[][] nextBlock;
		
		nextBlock = rotate(currentBlock);

		block = nextBlock;
//		trim(); // 일단 적용하고.
//		int currPOSX = posX;
//		boolean isAbleToRotate = false; // 돌릴 수 없다고 믿고.
//		for (int i = 0; i < 4; i++) { // 4번 시도 해본다.
//			posX = currPOSX - i; // 한칸씩 땡겨봄.
//			if (isAbleToMoveAfterCrachCheck(board, 0, 0)) {// 검사해서 회전 가능 하면,
//				isAbleToRotate = true; // flag를 세우고,
//				break; // 루프 탈출.
//			}
//		}
//		if (!isAbleToRotate) { // 위 루프에서 안됨이 판명되면,
//			posX = currPOSX;
//			block = currentBlock; // 회전상태 원상 복귀.
//		}
//		if (posX + getRightBorder() > TetrisBoard.x) {
//			// 돌렸는데, 우측으로 삐져나간 경우.
//			System.out.println("out" + ""
//					+ (posX + getRightBorder() - TetrisBoard.x)); // 출력하고.
//			posX = posX - (posX + getRightBorder() - TetrisBoard.x);
//			// 삐져나간만큼 왼쪽으로 땡김.
//		}
//		trim();
		LOG.info("**** Finish *****");
	}
	
	public void leftBlock(KTetrisBoard board) {
		if(posX > 0)
			posX = posX - 1;
//		if (posX + getLeftBorder() > 0) { // 좌측벽 충돌 검사.
//			if (isAbleToMoveAfterCrachCheck(board, -1, 0))
//		}
	}

	public void rightBlock(KTetrisBoard board) {
		if(posX + block.length < board.COL_SIZE)
			posX = posX+1;
//		if (posX + getRightBorder() < TetrisBoard.x) { // 우측벽 충돌검사.
//			if (isAbleToMoveAfterCrachCheck(board, 1, 0))
//		}
	}
	
	public void upBlock(KTetrisBoard board) {
		if(posY > 0)
			posY = posY - 1;
//		if (posX + getLeftBorder() > 0) { // 좌측벽 충돌 검사.
//			if (isAbleToMoveAfterCrachCheck(board, -1, 0))
//		}
	}

	public void downBlock(KTetrisBoard board) {
		if(posY + block[0].length < board.ROW_SIZE )
			posY = posY+1;
//		if (posX + getRightBorder() < TetrisBoard.x) { // 우측벽 충돌검사.
//			if (isAbleToMoveAfterCrachCheck(board, 1, 0))
//		}
	}
	

	private int getLeftBorder() {
		LOG.info("**** Start *****");
		// FIXME temp variables
		int i = 0, j = 0;
		int tmp1 = 3;
		int tmp2 = 3;

		for (j = 0; j < block.length; j++) {
			for (i = 0; i < block[j].length; i++) {
				if (block[j][i] >= 1) {
					tmp1 = i;
					break;
				}
			}
			if (tmp1 < tmp2)
				tmp2 = tmp1;
			tmp1 = 3;
		}

		LOG.info("**** Finish *****");
		return tmp2;
	}
	
}


