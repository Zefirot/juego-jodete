package juego;


public class Jodete {
	public Cartas[] mano;  //Mano principal del jugador.
	public Jodete() {
		this.mano= new Cartas[48];
	}
	public void mostrar() {
		for (int i=0;i<mano.length;i++) {
			if (mano[i]!=null) {
				System.out.print(mano[i].paloNombre+" ");
				System.out.println(mano[i].numero+" ");
			}
			
		}
	}
	public void recibirCarta(Cartas c) {
		for (int i=0;i<mano.length;i++) {
			if (mano[i]==null) {
				mano[i]=c;
				return;
			}
		}
		
	}
	public Cartas jugarCarta(int n) {
		int aux1=n-1;
		Cartas aux =null;
		for (int i=0;i<mano.length;i++) {
			if (i==aux1 && mano[i]!=null) {
				aux= new Cartas(mano[i].palo,mano[i].numero);
				mano[i]=null;
			}else if(i==n-1 && mano[i]==null) {
				throw new NullPointerException("La carta que elegiste no tiene posicion");
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
	//Cuando se encuentra con un null recorre otra vez la lista hasta encontrar una carta que no sea null.
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
