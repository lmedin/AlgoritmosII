import java.util.*;
import java.io.*;

import javax.swing.text.StyledEditorKit.BoldAction;

class Pieza {

	private String jugador;
	private String code;
	private int fila;
	private int columna;

	public Pieza(String s, int f, int c, String s2) {
		jugador = s;
		fila = f;
		columna = c;
		code = s2;
	}

	public void setJugador(String s) {
		jugador = s;
	}

	public void setFila(int f) {

		fila = f;

	}

	public void setColumna(int c) {

		columna = c;

	}

	public int getFila() {

		return fila;
	}

	public int getColumna() {

		return columna;
	}

	public String getCode() {

		return code;
	}

	public String getJugador() {

		return jugador;
	}

	public boolean mover(int f, int c, Tablero t) {
		return false;
	}

	// Verifica que no halla ninguna pieza en la posicion destino, y si hay una
	// pieza verifica que sea del otro color para poder comerla
	private boolean filtrarMovimientos(int f, int c,
			ArrayList<Par> posiblesMovimientos, Tablero t) {
		Boolean noHaypiezaEnCamino = true;
		if (!(t.hayPiezaDadaPosicion(f, c))) {
			Par parDeMov = new Par(f, c);
			posiblesMovimientos.add(parDeMov);
		} else {
			noHaypiezaEnCamino = false;
			Pieza ficha = t.getPieza(f, c);
			if (ficha.getJugador() != this.getJugador()) {
				Par parDeMov = new Par(f, c);
				posiblesMovimientos.add(parDeMov);
			}

		}
		return noHaypiezaEnCamino;

	}

	// Obtengo todos los movimientos horizontales.
	// Devuelve un ArrayList con todos los lugares donde la Pieza puede ir.
	// Cuando encuentra una pieza en la horizontal, verifica si es de su color o
	// el contrario
	// si es del contrario, agrega la posicion como posible destino, y si es de
	// su color no la agrega.

	public void getMovimientosHorizontales(int fi, int ci, Tablero t,
			ArrayList<Par> posiblesMovimientos) {
		int i = 1;
		boolean noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi, ci + i)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi, ci + i,
					posiblesMovimientos, t);
			i++;
		}
		i = 1;
		noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi + i, ci)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi + i, ci,
					posiblesMovimientos, t);
			i++;
		}
		i = 1;
		noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi - i, ci)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi - i, ci,
					posiblesMovimientos, t);
			i++;
		}
		i = 1;
		noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi, ci - i)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi, ci - i,
					posiblesMovimientos, t);
			i++;
		}

	}

	public void getMovimientosDiagonales(int fi, int ci, Tablero t,
			ArrayList<Par> posiblesMovimientos) {

		Boolean noHayPiezaEnElCamino = true;
		int i = 1;

		while ((t.posicionValida(fi + i, ci + i)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi+i, ci + i,
					posiblesMovimientos, t);
			i++;
		}
		i = 1;
		noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi + i, ci - i)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi + i, ci-i,
					posiblesMovimientos, t);
			i++;
		}
		i = 1;
		noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi - i, ci -i)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi - i, ci-i,
					posiblesMovimientos, t);
			i++;
		}
		i = 1;
		noHayPiezaEnElCamino = true;
		while ((t.posicionValida(fi - i, ci + i)) && noHayPiezaEnElCamino) {
			noHayPiezaEnElCamino = this.filtrarMovimientos(fi-i, ci + i,
					posiblesMovimientos, t);
			i++;
		}

	}

}
