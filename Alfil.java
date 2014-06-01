import java.util.*;
import java.io.*;


class Alfil extends Pieza {

	public Alfil (String s, int f, int c, String s2){

		super(s,f,c,s2);
		
	}

	public ArrayList getMovimientosValidos(Tablero t){
		ArrayList l = new ArrayList();
		return l;
	}
	
	public boolean mover (int f, int c, Tablero t){    // dada la pieza como la pieza que esta en cf y modifica el tablero
		
		//System.out.println("chequeo +1 peon fila");
		Par p1 = new Par(f,c);
		if (getMovimientosValidos(t).contains(p1)){
		
			return true;
		}
		
		return false;
	}
	
}
