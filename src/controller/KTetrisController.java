package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JFrame;

import model.KTetrisBlock;
import model.KTetrisBoard;
import model.ViewListener;


public class KTetrisController implements Runnable, KeyListener {

	private final int BLOCK_DOWN_COUNT = 20; // COUNT 가 낮아지면 다운속도 올라감.
	private final int THREAD_PAINT_SLEEP = 30;
	private final int THREAD_INTERVAL = 2000; // 2000 * 30 / 1000 = 60(sec)

	private boolean isThreadAlive;
	private JFrame frame;
	private ArrayList<ViewListener> viewListener;
	
	private KTetrisBoard board;
	private List<KTetrisBlock> waitBlockList;
	private KTetrisBlock currBlock;
	

	private final static Logger LOG = Logger.getGlobal();

	public KTetrisController(JFrame frame) {

		LOG.info("**** Start *****");

		this.isThreadAlive = true;
		this.frame = frame;

		this.viewListener = new ArrayList<ViewListener>();
		this.board = new KTetrisBoard(this);
		this.currBlock = new KTetrisBlock(this);

		LOG.info("**** Finish *****");
	}

	@Override
	public void run() {
		LOG.info("**** Start *****");

		String threadName = Thread.currentThread().getName();
		LOG.info(String.format("- %s has been started", threadName));

		openGame();
		int speed = BLOCK_DOWN_COUNT;
		for (int moveTrigger = 0; isThreadAlive; moveTrigger++) {
			// move
			if (moveTrigger % speed == 0) {
//			currBlock.downBlock(board);
				if (moveTrigger % THREAD_INTERVAL == 0)
					speed--;
			}
			// paint
//			reaquestPaint();
			try {
				Thread.sleep(THREAD_PAINT_SLEEP);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		closeGame();

		LOG.info(String.format("- %s has been ended", threadName));
		LOG.info("**** Finish *****");
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		LOG.info("**** Start *****");
//		LOG.info("**** Finish *****");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		LOG.info("**** Start *****");
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			LOG.info(" VK_UP ");
			currBlock.rotateBlock(board);
			break;
		case KeyEvent.VK_LEFT:
			LOG.info(" VK_LEFT ");
//			currBlock.leftBlock(board);
			break;
		case KeyEvent.VK_RIGHT:
			LOG.info(" VK_RIGHT ");
//			currBlock.rightBlock(board);
			break;
		case KeyEvent.VK_DOWN:
			LOG.info(" VK_DOWN ");
//			currBlock.downBlock(board);
			break;
		case KeyEvent.VK_SPACE: 
			LOG.info(" VK_SPACE ");
//			TetrisBlock keepCurrent = currBlock;
//			while (keepCurrent == currBlock)
//				currBlock.downBlock(board);
			break;
		case KeyEvent.VK_N: 
			LOG.info(" VK_N ");
			currBlock.nextBlock(board);

//			TetrisBlock keepCurrent = currBlock;
//			while (keepCurrent == currBlock)
//				currBlock.downBlock(board);
			break;
			
		}
		reaquestPaint();
		LOG.info("**** Finish *****");
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		LOG.info("**** Start *****");
//		LOG.info("**** Finish *****");
	}
///////////////////////////////////////////////////////////////////////////////////////

	public void addViewListener(ViewListener listener) {
		this.viewListener.add(listener);
	}

	public void gameStart() {
		LOG.info("**** Start *****");
		Thread t = new Thread(this);
		t.start();
		LOG.info("**** Finish *****");
	}

	public void gameOver() {
		LOG.info("**** Start *****");
		isThreadAlive = false;
		System.exit(0);
		LOG.info("**** Finish *****");
	}

	private void openGame() {
		LOG.info("**** Start *****");
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.requestFocus();
//		waitBlockList.clear();
//		for (int i = 0; i < 3; i++) {
//			waitBlockList.add(new KTetrisBlock(this));
//		}
//		currBlock = waitBlockList.remove(0);
//		waitBlockList.add(new TetrisBlock(this));
		LOG.info("**** Finish *****");
	}

	private void closeGame() {
		LOG.info("**** Start *****");
		frame.removeKeyListener(this);
		LOG.info("**** Finish *****");
	}

	private void reaquestPaint() {
		LOG.info("**** Start *****");
		frame.repaint();
		for (ViewListener vl : viewListener) {
			vl.onRePaint();
		}
		LOG.info("**** Finish *****");
	}

	
	public KTetrisBlock getCurrentBlock() {
		return currBlock;
	}

	public List<KTetrisBlock> getNextBlocks() {
		return waitBlockList;
	}

	public KTetrisBoard getBoard() {
		return board;
	}
	
}
