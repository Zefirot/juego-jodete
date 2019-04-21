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
		for (int i=0;i<mano.length;i++) {
			if (mano[i]==null) {
				for (int k=i;k<mano.length;k++) {
					if (mano[k]!=null) {
						mano[i]=mano[k];
						mano[k]=null;
						return;
					}
				}
			}
		}
	}
}
