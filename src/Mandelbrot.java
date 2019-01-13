
public class Mandelbrot {

	public static void main(String[] args) {
		
		MandelbrotGUI mandelGUI = new MandelbrotGUI();
		Generator gen = new Generator();
		Boolean running = true;
		Boolean hasRendered = false;
		while (running) {
		int command = mandelGUI.getCommand();
//		Complex z1 = new Complex(2,-5);
//		Complex z2 = new Complex(2,5);
//		z1.mul(z2);
//		System.out.println(z1.getRe() + " " + z1.getIm());

		
		switch (command) {
		case MandelbrotGUI.RENDER:
			mandelGUI.resetPlane();
			gen.render(mandelGUI);
			hasRendered = true;
			break;
		case MandelbrotGUI.RESET:
			mandelGUI.resetPlane();
			mandelGUI.clearPlane();
			hasRendered = false;
			break;
		case MandelbrotGUI.QUIT:
			System.exit(command);
			break;
		case MandelbrotGUI.ZOOM:
			if (hasRendered)
			gen.render(mandelGUI);
			break;
		}
		//System.out.println(command);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Complex z1 = new Complex(1,1);
//		Complex z2 = new Complex(1,1);
//		z1.mul(z2);
//		System.out.println(z1.getRe() + " " + z1.getIm());

	}

}
