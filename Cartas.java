package juego;

public class Cartas {
	public int numero;
	public int palo;
	public String paloNombre;
	public Cartas(int a,int b) {
		this.palo=a;
		this.numero=b;
		this.paloNombre= clasificar(a);
	}
	//Clasifica las cartas por su numero de palo.
	public static String clasificar(int n) {
		if (n==1) {
			return "Basto";
		}
		if (n==2) {
			return "Espada";
		}
		if (n==3) {
			return "Copa";
		}else {
			return "Oro";
		}
	}
}
