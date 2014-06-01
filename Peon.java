import java.util.*;
import java.io.*;

class Peon extends Pieza {

	private boolean primerMov;

	public Peon(String s, int f, int c, String s2) {

		super(s, f, c, s2);
		primerMov = true;
	}

	public ArrayList getMovimientosValidos(Tablero t) { // me da una lista con
														// todas las posiciones
														// posibles validas
														// (mover)
		ArrayList l = new ArrayList();
		int[] parDeMovimientos1 = new int[2];
		int[] parDeMovimientos2 = new int[2];
		int[] parDeMovimientos3 = new int[2];
		int[] parDeMovimientos4 = new int[2];

		// Este es el caso en que mueva el peon blanco, y hacia arriba (no
		// verifica que no pueda ir para abajo)
		if (!(t.hayPiezaDadaPosicion((this.getFila() + 1), this.getColumna()))) {

			parDeMovimientos1[0] = this.getFila() + 1;
			parDeMovimientos1[1] = this.getColumna();
			l.add(parDeMovimientos1);
			if ((this.primerMov)
					&& !(t.hayPiezaDadaPosicion(this.getFila() + 2,
							this.getColumna()))) {
				parDeMovimientos2[0] = this.getFila() + 2;
				parDeMovimientos2[1] = this.getColumna();
				l.add(parDeMovimientos2);
			}

		}
		// Este es el caso en que mueva el peon negro, y hacia abajo (no
		// verifica que no pueda ir para abajo)
		if (!(t.hayPiezaDadaPosicion((this.getFila() - 1), this.getColumna()))) {

			// /System.out.println("chequeo +1 peon fila");
			// Par p1 = new Par(this.getFila()+1,this.getColumna());
			parDeMovimientos1[0] = this.getFila() - 1;
			parDeMovimientos1[1] = this.getColumna();
			l.add(parDeMovimientos1);
			if ((this.primerMov)
					&& !(t.hayPiezaDadaPosicion(this.getFila() - 2,
							this.getColumna()))) {
				// Par p2 = new Par(this.getFila()+2,this.getColumna());
				parDeMovimientos2[0] = this.getFila() - 2;
				parDeMovimientos2[1] = this.getColumna();
				l.add(parDeMovimientos2);
			}

		}
		// Estos son los casos en que tenga que comer alguna pieza (tambien
		// falta verificar que siempre se mueva en la direccion que le
		// corresponde
		if (t.hayPiezaDadaPosicion(this.getFila() - 1, this.getColumna() + 1)) {
			parDeMovimientos3[0] = this.getFila() - 1;
			parDeMovimientos3[1] = this.getColumna() + 1;
			l.add(parDeMovimientos3);
		}
		if (t.hayPiezaDadaPosicion(this.getFila() - 1, this.getColumna() - 1)) {
			parDeMovimientos3[0] = this.getFila() - 1;
			parDeMovimientos3[1] = this.getColumna() - 1;
			l.add(parDeMovimientos3);
		}

		if (t.hayPiezaDadaPosicion(this.getFila() + 1, this.getColumna() - 1)) {
			parDeMovimientos4[0] = this.getFila() + 1;
			parDeMovimientos4[1] = this.getColumna() - 1;
			l.add(parDeMovimientos4);
		}

		return l;

	}

	public boolean getEsPrimerMov() {
		return this.primerMov;
	}

	public void setPrimerMov(boolean m) {
		this.primerMov = m;
	}

	public boolean mover(int f, int c, Tablero t) {
		// dada la pieza como la
		// pieza que esta en cf y
		// modifica el tablero
		// Par p1 = new Par(f,c);
		// System.out.println("chequeo +1 peon fila");
		int[] movimiento = new int[2]; // Duplas de que tienen el siguiente
										// formato [F,C]
		Object[] lista = getMovimientosValidos(t).toArray();

		for (int i = 0; i < lista.length; i++) {
			movimiento = (int[]) lista[i];
			if ((movimiento[0] == f) && (movimiento[1] == c)) {
				return true;
			}
		}

		return false;
	}
}
