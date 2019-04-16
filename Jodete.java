package juego;

public class Jodete {
	private Cartas[] mano;
	public Jodete() {
		this.mano= new Cartas[5];
	}
	public void mostrar() {
		for (int i=0;i<mano.length;i++) {
			System.out.print(mano[i].numero);
			System.out.print(mano[i].palo);
		}
	}
	public void recibirCarta(Cartas c) {
		mano= agregarCarta(mano,c);
		System.out.println(agregarCarta(mano,c)[1].numero);
	}
	public Cartas jugarCarta(int n) {
		Cartas aux = null;
		for (int i=0;i<mano.length;i++) {
			if (i==n-1) {
				aux= new Cartas(mano[i].palo,mano[i].numero);
				mano=quitarCarta(mano,mano[i]);
			}
		}
		return aux;
	}
	public int cantidadCartas() {
		int cont=0;
		for (int i=0;i<mano.length;i++) {
			if (mano[i]!=null) {
				cont++;
			}
		}
		return cont;
	}
	//Agrega la carta a la mano.
	private static Cartas[] agregarCarta(Cartas[] lista,Cartas c) {
		Cartas[] aux= new Cartas[lista.length+1];
		for (int i=0; i<aux.length;i++) {
			if (i==aux.length-1) {
				aux[i]=c;
			}else {
				aux[i]=lista[i];
			}
		}
		return aux;
	}
	//Quita la carta de la mano principal
	private static Cartas[] quitarCarta(Cartas[] lista, Cartas c) {
		Cartas[] aux=new Cartas[lista.length];
		for (int i=0;i<aux.length;i++) {
			if (lista[i]==c) {
				aux[i]=null;
			}else {
				aux[i]=lista[i];
			}
		}
		return aux;
	}
}
