package aula00_hello_world;

public class HelloStringAndDouble {
	
	public static void main(String[] args) {
		
		double a = 5.0; 
		double b = 3.0; 
		double c = divisao(a, b); 
		
		System.out.println("A divisao de " + a + " por " + b + " eh igual a " + c);
	}
	
	
	public static double divisao(double numero1, double numero2) {
		return numero1/numero2;
	}

}
