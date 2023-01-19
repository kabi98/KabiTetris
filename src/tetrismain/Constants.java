package tetrismain;

import java.awt.Color;

public final class Constants {
	private Constants() {
		
	}
	
	// rainbow 7 colors : red, orange, yellow, green, blue, indigo, purple
	public static final Color[] BLOCK_COLORS = { Color.RED, Color.ORANGE,
			Color.YELLOW, Color.GREEN, Color.BLUE, Color.decode("#4B0082"),
			Color.decode("#800080") };
	
	public static final int BOARD_SAVE_PLUS = 10;
}



//public final class Constants {
//	 private Constants() {
//	  // restrict instantiation
//	 }
//
//	 public static final double PI = 3.14159;
//	 public static final double PLANCK_CONSTANT = 6.62606896e-34;
//	}
//
//
//
//	import static Constants.BLOCK_COLORS;
//	import static Constants.PI;
//
//	public class Calculations {
//
//	 public double getReducedPlanckConstant() {
//	  return PLANCK_CONSTANT / (2 * PI);
//	 }
//	}