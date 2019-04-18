package nigga;


public class Jodete {
	public Cartas[] mano= new Cartas[5];  //Mano principal del jugador.
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
	public void acomodarInicio() {
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
			if (mano[i]!=null) {
				System.out.print("Palo: "+mano[i].palo+" ");
				System.out.println("Numero: "+mano[i].numero+" ");
				
			}
			
		}
	}
	public void recibirCarta(Cartas c) {
		mano= agregarCarta(mano,c);
		
	}
	public Cartas jugarCarta(int n) {
		Cartas aux =null;
		for (int i=0;i<mano.length;i++) {
			if (i==n-1 && mano[i]!=null) {
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
			if (i==aux.length-1 && c!=null) {
				aux[i]=c;
			}else  {
				aux[i]=lista[i];
			}
		}
		return aux;
	}
	//Cuando se agrega una carta al final de la mano y despues de haber jugado 2 cartas.
	//Quedan 3 cartas para usar y 2 nulls, por ende acomodarMano no funca
	public void acomodarMano() {
		for (int i=0;i<mano.length-1;i++) {
			if (mano[i]==null && mano[i+1]!=null) {
				Cartas aux= mano[i+1];
				mano[i+1]=null;
				mano[i]=aux;
			}
		}
	}
	private static Cartas[] quitarCarta(Cartas[] lista, Cartas c) {
		Cartas[] aux=new Cartas[lista.length];
		for (int i=0;i<aux.length;i++) {
			if (lista[i]!=c) {
				aux[i]=lista[i];
			} else{
				aux[i]=null;
			}
		}
		return aux;
	}
}
