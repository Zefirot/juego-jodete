package juego;

import java.util.Random;

public class Mazo {
	public Cartas[] cartas;
	public Cartas [] cartasUsadas=new Cartas[0];
	Random r=new Random();
	public Mazo() {
		this.cartas=new Cartas[48];
		int j=0;
		for (int i=1;i<=4;i++) {
			for (int k=1;k<=12;k++) {
				cartas[j++]= new Cartas(i,k);
			}
		}
	}
	public void mezclar() {
		for (int i=0;i<=1000;i++) {
			int k= r.nextInt(cartas.length);
			int k1= r.nextInt(cartas.length);
			Cartas aux= cartas[k];
			cartas[k]=cartas[k1];
			cartas[k1]=aux;
		}
	}
	/*
	public void imprimirMazo(Cartas[] lista) {
		for (int i=0;i<lista.length;i++) {
			System.out.print(lista[i].numero+" ");
			System.out.print(lista[i].palo+" ");
		}
	}*/
	//Funcion que se encarga de agregar las cartas repetidas
	private static Cartas[] agregarAUsadas(Cartas[] lista , Cartas c) {
		Cartas[] aux= new Cartas[lista.length];
		for (int i=0;i<aux.length;i++) {
			if (i==aux.length-1) {
				aux[i]=c;
			}else {
				aux[i]=lista[i];
			}
		}
		return aux;
	}
	//Verifica si la carta no fue usada, y agrega esa carta en caso contrario.
	private static boolean estaUsada(Cartas[] lista, Cartas c) {
		for (int i=0;i<lista.length;i++) {
			if (lista[i].numero==c.numero) {
				return true;
			}
		}
		return false;
	}
	public Cartas getCarta() {
		int k=r.nextInt(cartas.length);
		for (int i=0;i<=5;i++) {
			if (estaUsada(cartasUsadas,cartas[k])==false) {
				return cartas[k];
			}else {
				cartasUsadas= agregarAUsadas(cartasUsadas,cartas[k]);
			}
		}
		return cartas[1];
	}
}
