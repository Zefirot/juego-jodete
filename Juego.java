package juego;

public class Juego {
	public static void main(String[] args) {
		Mazo mazo= new Mazo();
		mazo.mezclar();
		Jodete j= new Jodete();
		for (int i=0;i<5;i++) {
			j.recibirCarta(mazo.getCarta());
		}
		j.acomodar();
		j.mostrar();
	
		
		//Crear un metodo en jodete para sacar las cartas de más. 
		//System.out.println(j.jugarCarta(2).numero);
		//System.out.println(mazo.getCarta());
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
	}
	public static void imprimir(int[] lista) {
		for (int i=0;i<lista.length;i++) {
			System.out.println(lista[i]);
		}
	}*/
}
