
public class Complex {
	private double re, im;
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}
	double getRe() {
		return re;
	}
	double getIm() {
		return im;
	}
	double getAbs2() {
		return Math.pow(re, 2) + Math.pow(im, 2);
	}
	void add(Complex x) {
		this.re+= x.getRe();
		this.im+= x.getIm();
		
	}
	void mul(Complex x) {
		double tempRe = (re*x.re - im*x.im);
		im = im*x.re + re*x.im;
		re = tempRe;
		
	}

}
