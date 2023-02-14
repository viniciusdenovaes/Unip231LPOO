package ex04;

public class Boletim {
	
	double notaNP1;
	double notaNP2;
	
	public Boletim(double aNotaNP1, double aNotaNP2) {
		this.notaNP1 = aNotaNP1;
		this.notaNP2 = aNotaNP2;
	}
	
	public double media() {
		return (this.notaNP1 + this.notaNP2)/2.0;
	}
	
	public boolean passou() {
		if(this.media()<7) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		String res = "Boletim: \n";
		res += "NotaNP1: " + this.notaNP1 + "\n";
		res += "NotaNP2: " + this.notaNP2;
		
		return res;
	}
	
	

}
