package juego;

public class JugadorJodete {
	public Cartas[] mano;
	public JugadorJodete() {
		this.mano=new Cartas[48];
	}
	//Si la carta de la mesa es igual 
	public Cartas jugarCartaContra(Cartas mesa) {
		for (int i=0;i<mano.length;i++) {
			if (mano[i].numero!=mesa.numero && mano[i].palo!=mesa.palo) {
				return mano[i];
			}
		}
		return null;
	}
	
	public void robarCarta(Cartas c) {
		for (int i=0;i<mano.length;i++) {
			if (mano[i]==null) {
				mano[i]=c;
			}
		}
	}
	public int cantidadDeCartas() {
		int cont=0;
		for (int i=0;i<mano.length;i++) {
			if (mano[i]!=null) {
				cont++;
			}
		}
		return cont;
	}
	public void acomodarMano() {
		for (int i=0;i<mano.length-1;i++) {
			if (mano[i]==null && mano[i+1]!=null) {
				Cartas aux= mano[i+1];
				mano[i+1]=null;
				mano[i]=aux;
			}
		}
	}
}
