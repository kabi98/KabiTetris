package tetrismain;

import java.awt.EventQueue;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import controller.KTetrisController;
import view.BoardView;
import view.MainFrame;
import view.StatusBar;



public class KTetrisApplication {
//	private JFrame frame;
	private MainFrame frame;
	
	private final static Logger LOG = Logger.getGlobal();

	public static void main(String[] args) {
		initLogger();		
		
		LOG.info("*** Start ***");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KTetrisApplication window = new KTetrisApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		LOG.info("*** Finish ***");
	}
	
	public KTetrisApplication() {
		LOG.info("*** Start ***");
		initialize();
		LOG.info("*** Finish ***");
	}

	private void initialize() {
		LOG.info("*** Start ***");
		frame = new MainFrame();
		
		KTetrisController controller = new KTetrisController(frame);
		
		frame.setController(controller);
		
		JPanel statusBar = new StatusBar(controller);
		frame.getContentPane().add(statusBar);
		
		JPanel tetrisView = new BoardView(controller);
		frame.getContentPane().add(tetrisView);
//		
//		JPanel nextBlocksView = new NextBlockView(controller);
//		frame.getContentPane().add(nextBlocksView);
//		
//		JPanel holdingBlockView = new HoldBlockView(controller);
//		frame.getContentPane().add(holdingBlockView);
		LOG.info("*** Finish ***");
	}
	

	private static void initLogger() {
		Logger rootLogger = Logger.getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		if(handlers[0] instanceof ConsoleHandler) {
			rootLogger.removeHandler(handlers[0]);
		}
		
		LOG.setLevel(Level.INFO);
//		LOG.setLevel(Level.WARNING);
//		LOG.setLevel(Level.SEVERE);
		
		Handler handler = new ConsoleHandler();
		CustomLogFormatter fomatter = new CustomLogFormatter();
		handler.setFormatter(fomatter);
		LOG.addHandler(handler);
	}
	
}
