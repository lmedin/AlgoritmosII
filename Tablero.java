import java.util.*;
import java.io.*;

class Tablero {

	private Pieza[][] mesa;

	// Constructor Tablero
	public Tablero(String s1, String s2) {

		mesa = new Pieza[8][8];
		generarPiezas(s1, s2);

	}

	// Generamos todas las piezas del Tablero (Inicializacion)
	public void generarPiezas(String s1, String s2) {

		// / Generando los peones Blancos
		for (int i = 0; i < 8; i++) {

			mesa[1][i] = new Peon(s1, 1, i, "P");

		}

		// / Generando los peones Negros

		for (int i = 0; i < 8; i++) {

			mesa[6][i] = new Peon(s2, 6, i, "P");

		}

		// / Generando posiciones vacias

		for (int i = 2; i != 6; i++) {
			for (int j = 0; j < 8; j++) {

				mesa[i][j] = null;
			}
		}
		// / Generando las torres
		mesa[0][0] = new Torre(s1, 0, 0, "T");
		mesa[0][7] = new Torre(s1, 0, 7, "T");

		mesa[7][0] = new Torre(s2, 7, 0, "T");
		mesa[7][7] = new Torre(s2, 7, 7, "T");
		// / Generando los alfiles

		mesa[0][2] = new Alfil(s1, 0, 2, "A");
		mesa[0][5] = new Alfil(s1, 0, 5, "A");

		mesa[7][2] = new Alfil(s2, 7, 2, "A");
		mesa[7][5] = new Alfil(s2, 7, 5, "A");
		// / Generando los reyes

		mesa[0][4] = new Rey(s1, 0, 4, "R");

		mesa[7][4] = new Rey(s2, 7, 4, "R");
		// / Generando las reynas

		mesa[0][3] = new Reyna(s1, 0, 3, "RY");

		mesa[7][3] = new Reyna(s2, 7, 3, "RY");
	}

	// Dada posicion tablero me devuelve la pieza (No valida si hay una ficha)
	public Pieza getPieza(int f, int c) {
		return mesa[f][c];
	}

	// Mueve la pieza pasada por parametro a la posicion "pos"
	public void setPieza(Pieza p, int f, int c) {

		mesa[f][c] = p;
		mesa[p.getFila()][p.getColumna()] = null;
		p.setFila(f);
		p.setColumna(c);

	}

	// Muestra el tablero por la termina
	public void mostrarTablero() throws UnsupportedEncodingException {

		PrintStream out = new PrintStream(System.out, true, "UTF-8");

		StringBuffer pantalla = new StringBuffer();

		for (int i = 7; i >= 0; i--) {
			pantalla.append(" " + i + " ");
			for (int j = 0; j < 8; j++) {

				if (hayPiezaDadaPosicion(i, j)) {

					pantalla.append((mesa[i][j]).getCode() + "  ");
				} else {

					pantalla.append("0  ");
				}
			}

			out.println(pantalla);
			pantalla.delete(0, pantalla.length());

		}

		out.println("   0  1  2  3  4  5  6  7");

	}

	// Dada una posicion del tablero indica si hay una pieza
	public boolean hayPiezaDadaPosicion(int f, int c) {
		if ((mesa[f][c]) == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean posicionValida(int f, int c) {
		if (f >= 0 && f < 8 && c >= 0 && c < 8) {
			return true;
		} else {
			return false;
		}
	}

	// Chequea si hay una ficha en "p" y si pertenece al jugador "s"
	public boolean chequeoInicio(int f, int c, String s) {

		if (posicionValida(f, c) && (hayPiezaDadaPosicion(f, c))
				&& ((mesa[f][c]).getJugador() == s)) {

			return true;
		} else {
			return false;
		}
	}

	// Esta funcion recibe los parametros pasados por la terminal y llama a
	// todas las funciones implementadas
	public boolean realizarJugada(int fi, int ci, int fd, int cd, String s) {

		// / tengo q chequear pos hay una ficha y si hay que sea del jugador

		if (chequeoInicio(fi, ci, s) && posicionValida(fd, cd)) {

			// System.out.println("paso chequeo inicio");

			Pieza ficha = mesa[fi][ci];

			// /System.out.println("paso chequeo inicio");
			boolean condicion = ficha.mover(fd, cd, this);

			if (condicion) { // devuelve un condicional si se pudo llevar a cabo
								// el movimiento , el tablero luego modifica las
								// posiciones

				
				// chequeo si la posicion a donde me muevo estaba el rey para terminar la partida
				if (this.hayPiezaDadaPosicion(fd,cd) && this.getPieza(fd,cd).getCode() == "R"){
					// aca seteamos un flag para q salga del ciclo la class terminal o agregamos un campo entablero	
										
				}

				// hacer funcion que si la ficha comida es el rey termine
				setPieza(ficha, fd, cd);

				// hacer aca funcion q verifique si se produce jaque al mover
				// una pieza				

				return true;

			}

			// MOVIMIENTO INVALIDO
		}

		return false;
	}
}
