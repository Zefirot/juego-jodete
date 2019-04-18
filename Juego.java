package nigga;

import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Mazo mazo= new Mazo();
		Cartas cartaMazo=null;
		Cartas cartaMano=null;
		boolean aux=true;
		Scanner input = new Scanner(System.in);
		mazo.mezclar();
		Jodete j= new Jodete();
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
			System.out.print("Palo: "+cartaMazo.palo+" ");
			System.out.print("Numero: "+cartaMazo.numero);
			int cont= input.nextInt();
			cartaMano=j.jugarCarta(cont);
			j.acomodarMano();
			if (cartaMano.numero!=cartaMazo.numero && cartaMano.palo!=cartaMazo.palo) {
				Cartas aux1=mazo.getCarta();
				System.out.println(cartaMano.palo);
				System.out.println("La carta que agarraste del mazo es: ");
				System.out.println("Palo: "+aux1.palo+" Numero: "+aux1.numero);
				char decision= input.next().charAt(0);
				if (decision=='s') {
					j.recibirCarta(cartaMano);
					j.acomodarMano();
				}else {
				j.recibirCarta(cartaMano);
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
	
	
	/*Para crear el juego:
	 * se debe crear el mazo y antes de empezar acomodar las cartas.
	 * luego entra en un while y el mazo de la mesa tira una carta al azar.
	 * luego de tirar una carta la mano debe acomodarse con la funcion "acomodarMano".
	 * si el jugador tiena una cara del mismo palo o el mismo numero puede tirarla y descartar esa misma.
	 * si no tiene ninguna carta puede agarrar una del maso y fijarse si le sirve. Si no sirve se le agrega a la mano.
	 * el juego termina cuando el jugador llega a tener 0 cartas.
	 * 
	 */
	
}
