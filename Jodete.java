package juego;

public class Jodete {
	private Cartas[] mano= new Cartas[5];  //Mano principal del jugador.
	public Jodete() {
		this.mano= crearMano(mano);
	}
	//Crea una mano con cartas "imaginarias", asi la mano es mas facil de manejar.
	private static Cartas[] crearMano(Cartas[] lista) {
		for (int i=0;i<lista.length;i++) {
			lista[i]=new Cartas(i,i);
		}
		return lista;
	}
	public void acomodar() {
		Cartas[] aux= new Cartas[5];
		int j=0;
		for (int i=9;i>=5;i--) {
			aux[j]=mano[i];
			j++;
		}
		mano=aux;
	}
	public void mostrar() {
		for (int i=0;i<mano.length;i++) {
			System.out.print(mano[i].palo+" ");
			System.out.println(mano[i].numero+" ");
			
		}
	}
	public void recibirCarta(Cartas c) {
		mano= agregarCarta(mano,c);
		
	}
	public Cartas jugarCarta(int n) {
		Cartas aux =new Cartas(1,1);
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
			if (i==aux.length-1 ) {
				aux[i]=c;
			}else {
				aux[i]=lista[i];
			}
		}
		return aux;
	}
	private static Cartas[] quitarCarta(Cartas[] lista, Cartas c) {
		Cartas[] aux=new Cartas[lista.length];
		for (int i=0;i<aux.length;i++) {
			if (lista[i]==c) {
			}else {
				aux[i]=lista[i];
			}
		}
		return aux;
	}
}
