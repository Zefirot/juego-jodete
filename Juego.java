package juego;

public class Juego {
	public static void main(String[] args) {
		Mazo m= new Mazo();
		m.mezclar();
		Jodete j= new Jodete();
		for (int i=1;i<=5;i++) {
			j.recibirCarta(m.cartas[i]);
			//System.out.print(m.cartas[i].palo+" ");
			//System.out.print(m.cartas[i].numero+" ");
		}
		//j.mostrar();
	}
	
	
	
	
	/*
	public static int[] agregar(int[] lista, int c) {
		int [] aux=new int[lista.length+1];
		for (int i=0;i<aux.length;i++) {
			if (i==aux.length-1) {
				aux[i]=c;
			}else {
				aux[i]=lista[i];
			}
		}
		return aux;
	}*/
	public static void imprimir(int[] lista) {
		for (int i=0;i<lista.length;i++) {
			System.out.println(lista[i]);
		}
	}
}
