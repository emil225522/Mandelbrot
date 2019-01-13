import java.awt.Color;

public class Generator {
	private Color[][] picture;
	
	public Generator () {
		
	}
	public void render(MandelbrotGUI gui) {
		gui.disableInput();
		int pixelSize = 1;
		switch (gui.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_LOW:
			pixelSize = 9;
			break;
		case MandelbrotGUI.RESOLUTION_LOW:
			pixelSize = 7;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM:
			pixelSize = 5;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH:
			pixelSize = 3;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			pixelSize = 1;
			break;
		}

		Complex[][] complex = mesh	(gui.getMinimumReal(),gui.getMaximumReal(),
				gui.getMinimumImag(),gui.getMaximumImag(),gui.getWidth(),gui.getHeight());
		picture = new Color[gui.getHeight()/pixelSize][gui.getWidth()/pixelSize];
		
		
		
		int maxIter = 200;
		
		
		for (int i = 0; i < picture.length; i++) {
				for (int j = 0; j < picture[0].length; j++) {
					
					Complex c = complex[i*pixelSize][j*pixelSize];
					Complex temp = new Complex(0,0);
					int k = 0;
					while (k < maxIter && temp.getAbs2() <= 4) {

						temp.mul(temp);
						temp.add(c);
						k++;
					}
					if (k < maxIter) {
						if (gui.getMode() == MandelbrotGUI.MODE_COLOR)
						picture[i][j] = Color.getHSBColor(1.0f*k, 1.0f*k/maxIter, 1.0f*k/maxIter);
						else
							picture[i][j] = Color.WHITE;
					}
					else
					{
						picture[i][j] = Color.BLACK;
					}
				}
			}
////		for (int i = 0; i < picture.length; i++) {
////			for (int j = 0; j < picture[0].length; j++) {
////			if (complex[i*pixelSize][j*pixelSize].getAbs2() > 1) {
////				picture[i][j] = Color.WHITE;
////			}
////			else 
////				picture[i][j] = Color.RED;
////				
////			}
//			
//		}
		gui.putData(picture, pixelSize, pixelSize);
		gui.enableInput();
		
	}
	private Complex[][] mesh (double minRe, double maxRe,
								double minIm, double maxIm,
								int width, int height){
		Complex[][] matrix = new Complex[height][width];
		double imaginaryScale = (maxIm - minIm) / (height);
		double realScale = (maxRe - minRe) / (width);
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				matrix[i][j] = new Complex(minRe + j*realScale,maxIm - i*imaginaryScale);
			}
		}
//		System.out.println(minRe);
		//matrix[0][0] = new Complex(minRe,maxIm);
		matrix[height-1][width-1] = new Complex(maxRe,minIm);
		return matrix;
	}

}
