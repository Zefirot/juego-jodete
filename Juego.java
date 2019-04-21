package juego;

import java.util.Scanner;

public class Juego {
	public static void main(String[] args) {
		Mazo mazo = new Mazo();
		Jodete jugador1 = new Jodete();
		JugadorJodete jugador2 = new JugadorJodete();
		Scanner input = new Scanner(System.in);
		//Variables auxiliares para guardar el transcurso del juego y ser mas facil de leer.
		Cartas cartaPrincipal;
		Cartas cartaUtilizada;
		boolean sigue = true;
		//Acomodar las cartas de cada jugador.
		for (int i=0;i<5;i++) {
			jugador1.recibirCarta(mazo.getCarta());
			jugador1.acomodarMano();
		}
		for (int k=0;k<5;k++) {
			jugador2.robarCarta(mazo.getCarta());
			jugador2.acomodarMano();
		}
		//Comienzo del juego.
		while (sigue) {
			for (int l=0;l<2;l++) {
				//Detecta la carta que sale del mazo, osea una carta random.
				cartaPrincipal=mazo.getCarta();
				if (l==0) { //Turno del usuario.
					System.out.println("-------------");
					System.out.println("--Jugador 1--");
					System.out.println("-------------");
					System.out.println("Estas son tus cartas: ");
					jugador1.mostrar();
					System.out.println("-------------");
					System.out.println("Esta es la carta que esta sobre la mesa: ");
					System.out.println("-------------");
					System.out.println(cartaPrincipal.paloNombre+" "+cartaPrincipal.numero);
					int n = input.nextInt();
					cartaUtilizada= jugador1.jugarCarta(n);
					jugador1.acomodarMano();
					if (cartaUtilizada.numero!=cartaPrincipal.numero && cartaUtilizada.palo!=cartaPrincipal.palo) {
						Cartas cartaAux= mazo.getCarta();
						System.out.println("La carta que agarraste del mazo es: ");
						System.out.println(cartaAux.paloNombre+" "+cartaAux.numero);
						char m = input.next().charAt(0);
						if (m=='s') {
							if (cartaAux.palo!=cartaPrincipal.palo && cartaAux.numero!=cartaPrincipal.numero) {
									System.out.println("Mentiste :c");
									System.out.println("Ahora seras castigado");
									jugador1.recibirCarta(mazo.getCarta());
									jugador1.acomodarMano();
									jugador1.recibirCarta(mazo.getCarta());
									jugador1.acomodarMano();
								}
							jugador1.recibirCarta(cartaUtilizada);
							jugador1.acomodarMano();
						}else {
							jugador1.recibirCarta(cartaUtilizada);
							jugador1.acomodarMano();
							jugador1.recibirCarta(mazo.getCarta());
							jugador1.acomodarMano();
						}
					}
				}else { //Turno de la ia.
					System.out.println("-------------");
					System.out.println("--Jugador 2--");
					System.out.println("-------------");
					Cartas aux2= jugador2.jugarCartaContra(cartaPrincipal);
					if (aux2 ==null) {
						jugador2.robarCarta(mazo.getCarta());
						jugador2.acomodarMano();
						System.out.println(" ");
						System.out.println("Jugador 2 acaba de ser penalizado");
						System.out.println(" ");
					}else {
						System.out.println(" ");
						System.out.println("Jugador 2 ha realizado una jugada exitosa");
						System.out.println(" ");
					}
				}
			}
			if (jugador1.cantidadCartas()==0) {
				sigue=false;
				System.out.println("Felicades Jugador 1, Ganaste");
			}
			if (jugador2.cantidadDeCartas()==0) {
				sigue=false;
				System.out.println("Felicades Jugador 2, Ganaste");
			}
		}
	}
	
}
