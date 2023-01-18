package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.logging.Logger;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

import controller.KTetrisController;
import model.KTetrisBlock;
import model.KTetrisBoard;
import model.ViewListener;



public class BoardView extends JPanel implements ViewListener{

	private static final long serialVersionUID = -8236763247406460328L;
	private final static Logger LOG = Logger.getGlobal();
	private final static int BOARD_X = 6;
	private final static int BOARD_Y = 58;
//	private final static int BOARD_X = 0;
//	private final static int BOARD_Y = 0;
	
	private final static int BOARD_WIDTH = 400;
	private final static int BOARD_HEIGHT = 550;
	
	private BufferedImage imageBlocks;	
	private BufferedImage imageBackground;	
	private Clip clipMmusic;
	
	private KTetrisController controller;
	
	public BoardView(KTetrisController controller) {
		super();
		LOG.info("*** Start ***");
		this.controller = controller;
		controller.addViewListener(this);
		this.setBackground(Color.WHITE);
		this.setBounds(BOARD_X, BOARD_Y, BOARD_WIDTH, BOARD_HEIGHT);
		
		imageBlocks = ImageLoader.loadImage("./textures/tiles.png");
		imageBackground = ImageLoader.loadImage("./textures/background.png");
		clipMmusic = ImageLoader.LoadSound("./textures/music.wav");
//		clipMmusic.loop(Clip.LOOP_CONTINUOUSLY);
		
		LOG.info("*** Finish ***");
	}
	
	@Override
	public void paint(Graphics g) {
		LOG.info("*** Start ***");
		super.paint(g);
		
		KTetrisBoard board = controller.getBoard();
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		int height = getHeight() / board.ROW_SIZE;
		int width = getWidth() / board.COL_SIZE;
		Color[] whichColor = { Color.WHITE, Color.BLUE, Color.RED,
				Color.YELLOW, Color.GREEN };

		g.drawImage(imageBackground, 0, 0, null);
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(new Color(0, 0, 0, 100));
		
		
		for(int i = 0; i <= board.ROW_SIZE; i++)
		{
			g2d.drawLine(0, i*30, board.COL_SIZE*30, i*30);
		}
		for(int j = 0; j <= board.COL_SIZE; j++)
		{
			g2d.drawLine(j*30, 0, j*30, board.ROW_SIZE*30);
		}
		
		
//		// draw back.
//		for (int i = 0; i < board.COL_SIZE; i++) {
//			for (int j = 0; j < board.ROW_SIZE; j++) {
//				g.setColor(whichColor[board.Board[j][i]]);
//				g.fill3DRect(width * i, height * j, width, height, true);
//			}
//		}
		
		// draw front
		KTetrisBlock lookingBlock = controller.getCurrentBlock();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (lookingBlock.block[j][i] > 0) {
					g.setColor(lookingBlock.color);
//					g.fillRect(width * (i + lookingBlock.posX), height * (j + lookingBlock.posY), width, height);
					
					g.drawImage(imageBlocks.getSubimage(30, 0, 30, 30), 
							width * (i + lookingBlock.posX), height * (j + lookingBlock.posY), null);

					LOG.info(String.format("x:%d, y:%d, w:%d, h:%d %n", 
							width * (i + lookingBlock.posX), height * (j + lookingBlock.posY), width, height));
				}
			}
		}
		LOG.info("*** Finish ***");
	}
	
	@Override
	public void onRePaint() {
		repaint();
	}

}
