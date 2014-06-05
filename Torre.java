import java.util.*;
import java.io.*;

class Torre extends Pieza {

	public Torre(String s, int f, int c, String s2, String t) {

		super(s, f, c, s2,t);

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
