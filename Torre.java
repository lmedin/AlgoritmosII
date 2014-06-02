import java.util.*;
import java.io.*;

class Torre extends Pieza {

	// private void filtrarMovimientosHorizontales(int f, int c,
	// ArrayList<Par> posiblesMovimientos, Tablero t) {
	//
	// if (!(t.hayPiezaDadaPosicion(f, c))) {
	// Par parDeMov = new Par(f, c);
	// posiblesMovimientos.add(parDeMov);
	// } else {
	// Pieza ficha = t.getPieza(f, c);
	// if (ficha.getJugador() != this.getJugador()) {
	// Par parDeMov = new Par(f, c);
	// posiblesMovimientos.add(parDeMov);
	// }
	// }
	//
	// }

	public Torre(String s, int f, int c, String s2) {

		super(s, f, c, s2);

	}

	//Obtengo todos los posibles movimientos para la torre. 
	public ArrayList<Par> getMovimientosValidos(Tablero t) {
		ArrayList<Par> posiblesMovimientos = new ArrayList<Par>();
		int fi = this.getFila();
		int ci = this.getColumna();
		this.getMovimientosHorizontales(fi, ci, t, posiblesMovimientos);
		return posiblesMovimientos;
	}

	

	public boolean mover(int f, int c, Tablero t) { // dada la pieza como la
													// pieza que esta en cf y
													// modifica el tablero

		ArrayList<Par> posiblesMovimientos = this.getMovimientosValidos(t);
		for (int i = 0; i < posiblesMovimientos.size(); i++) {
			if (posiblesMovimientos.get(i).getPrimero() == f
					&& posiblesMovimientos.get(i).getSegundo() == c) {
				return true;
			}

		}

		return false;
	}

}
