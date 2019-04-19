package juego;

import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Mazo mazo= new Mazo();
		Cartas cartaMazo=null; //Creo una carta que va agarrar la del mazo.
		Cartas cartaMano=null; //Creo una carta que va a agarrar la de la mano para guardarla.
		boolean aux=true;
		Scanner input = new Scanner(System.in);
		mazo.mezclar();
		Jodete j= new Jodete();
		//Crea una mano principal para que el jugador pueda tener cartas antes de empezar el juego.
		for (int i=0;i<=5;i++) {
			j.recibirCarta(mazo.getCarta());
		}
		j.acomodarInicio();
		while (aux) {
			System.out.println("Estas son tus cartas:");
			System.out.println("--------------------");
			j.mostrar();
			System.out.println("La carta del mazo es...");
			cartaMazo=mazo.getCarta();
			System.out.print(cartaMazo.paloNombre+" ");
			System.out.print(cartaMazo.numero+" ");
			int cont= input.nextInt();
			cartaMano=j.jugarCarta(cont);
			j.acomodarMano();
			if (cartaMano.numero!=cartaMazo.numero && cartaMano.palo!=cartaMazo.palo) {
				Cartas aux1=mazo.getCarta();
				System.out.println(cartaMano.palo);
				System.out.println("La carta que agarraste del mazo es: ");
				System.out.println("Palo: "+aux1.palo+" Numero: "+aux1.numero);
				char decision= input.next().charAt(0);
				if (decision=='s') {  //Se calcula si el jugador necesita la carta que acaba de agarrar del mazo.
					j.recibirCarta(cartaMano);
					j.acomodarMano();
				}else {  //En caso de no necesitarla se le sumara la carta que habia tirado anteriormente...
				j.recibirCarta(cartaMano);  //Y tambien se le suma una nueva carta del mazo.
				j.acomodarMano();
				j.recibirCarta(aux1);
				j.acomodarMano();
				}
			}
			if (j.cantidadCartas()==0) {
				System.out.println("¡¡Felicidades Ganaste!!");
				aux=false;
			}
		}
	}
	
}
