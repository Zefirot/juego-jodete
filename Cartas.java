package juego;

public class Cartas {
	public int numero;
	public String palo;
	public Cartas(int a,int b) {
		this.palo=clasificar(a);
		this.numero=b;
	}
	public String clasificar(int n) {
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
