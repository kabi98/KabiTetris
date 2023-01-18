package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;

import javax.swing.JPanel;

import model.KTetrisBlock;


public class BlockView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5951384222156482301L;
	
	private final static Logger LOG = Logger.getGlobal();
	private KTetrisBlock lookingBlock = null;

	public BlockView() {
		super();
		LOG.info("*** Start ***");
		LOG.info("*** Finish ***");
	}

	public void setLookingBlock(KTetrisBlock lookingBlock) {
		LOG.info("*** Start ***");
		this.lookingBlock = lookingBlock;
		LOG.info("*** Finish ***");
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		LOG.info("*** Start ***");
		LOG.info("*** Finish ***");
		
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, getWidth(), getHeight());
//		if (lookingBlock == null) {
//			return;
//		}
//		int height = getHeight() / lookingBlock.block.length;
//		int width = getWidth() / lookingBlock.block[0].length;
//		Color[] whichColor = { Color.WHITE, Color.BLUE, Color.RED,
//				Color.YELLOW, Color.GREEN };
//		for (int i = 0; i < lookingBlock.block.length; i++) {
//			for (int j = 0; j < lookingBlock.block[0].length; j++) {
//				g.setColor(whichColor[lookingBlock.block[j][i]]);
//				g.fillRect(width * i, height * j, width, height);
//			}
//		}
	}

}
