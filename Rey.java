import java.util.*;
import java.io.*;

class Rey extends Pieza {

	public Rey (String s, int f, int c, String s2){

		super(s,f,c,s2);
		
	}

	public boolean validarMovimiento(Tablero t, int fd, int cd) {		
				
		Boolean noHaypiezaEnCamino = false;
		
		if (t.posicionValida(fd,cd) && !(t.hayPiezaDadaPosicion(fd, cd))) {			
			noHaypiezaEnCamino = true;
		} else {
			Pieza ficha = t.getPieza(fd,cd);
			if (ficha.getJugador() != this.getJugador()) {
				noHaypiezaEnCamino = true;
			}

		}
		
		return (noHaypiezaEnCamino && ! estaEnJaque(t,fd,cd));	
		
	}
	
	// Verifica si alrededor de la posicion pasada por parametro hay un rey enemigo 
	public boolean validacionRey (Tablero t, int f, int c){
		
		int fil;
        int col;
        
       for (int df=-1; df<=1; df++){                
          for (int dc=-1; dc<=1; dc++){
				fil = f+df;
				col = c+dc;	
							
				if (t.posicionValida(fil,col) && t.hayPiezaDadaPosicion(fil, col) && (t.getPieza(fil,col).getCode() == "R" && t.getPieza(fil,col).getJugador() != this.getJugador())) {
					return true;
                }
                
                /// Aca chequeo los peones (Fila -1 me interesan peones blancos, fila 1 me interesan peones negros (por la forma de comer))
                if (df == -1 && dc !=0){
					if (t.posicionValida(fil,col) && t.hayPiezaDadaPosicion(fil, col) && (t.getPieza(fil,col).getCode() == "P" && t.getPieza(fil,col).getJugador() != this.getJugador())) {
						return true;
					}
                }
                
                if (df == 1 && dc !=0){
					if (t.posicionValida(fil,col) && t.hayPiezaDadaPosicion(fil, col) && (t.getPieza(fil,col).getCode() == "P" && t.getPieza(fil,col).getJugador() != this.getJugador())) {
						return true;
					}
                }
          }
        }
        
        return false;	
		
	}
	
	// devuelve true si hay alguna ficha enemiga que ataca esa posicion 
	public boolean estaEnJaque(Tablero t, int fila, int columna){
		
		int f;
		int c;
		Pieza p;
		
		/// Valido primero las 8 posiciones alrededor, si hay un rey enemigo o peon
		if ( validacionRey(t,fila,columna)) return true;
				
		///  lista con todas posiciones horizontales (posiciones vacias o con fichas enemigas) , ahora chequeo si hay ficha y si es una torre o reyna devuelvo true , ya que en esa posicion el rey esta en jaque
		ArrayList<Par> posiblesMovimientosH = new ArrayList<Par>();
		
		this.getMovimientosHorizontales(fila, columna, t, posiblesMovimientosH);
		
		for (int i = 0; i < posiblesMovimientosH.size(); i++) {
			f = posiblesMovimientosH.get(i).getPrimero();
			c = posiblesMovimientosH.get(i).getSegundo();
			if (t.hayPiezaDadaPosicion(f,c)){
				p = t.getPieza(f,c);
				if (p.getCode() == "T" || p.getCode() == "RY" ) {  /// habria que agregar una propiedad a las ficha que diga su tipo (ej: rey, reyna , etc)
					return true;
				}
			}
		}		
		
		ArrayList<Par> posiblesMovimientosD = new ArrayList<Par>();
		
		this.getMovimientosDiagonales(fila, columna, t, posiblesMovimientosD);
		
		for (int i = 0; i < posiblesMovimientosD.size(); i++) {
			f = posiblesMovimientosD.get(i).getPrimero();
			c = posiblesMovimientosD.get(i).getSegundo();
			if (t.hayPiezaDadaPosicion(f,c)){
				p = t.getPieza(f,c);
				if (p.getCode() == "A" || p.getCode() == "RY" ) {  /// habria que agregar una propiedad a las ficha que diga su tipo (ej: rey, reyna , etc)
					return true;
				}
			}
		}		
			
		return false;		
	}

	public boolean mover(int f, int c, Tablero t) { // dada la pieza como la
													// pieza que esta en cf y
													// modifica el tablero

		ArrayList<Par> listaMovimientos = this.posiblesMovimientos(t);
		for (int i = 0; i < listaMovimientos.size(); i++) {
			if (listaMovimientos.get(i).getPrimero() == f && listaMovimientos.get(i).getSegundo() == c) {
				return true;
			}

		}

		return false;
	}
	
	public ArrayList<Par> posiblesMovimientos(Tablero t) {

        ArrayList<Par> a = new ArrayList<Par>();
        int fil;
        int col;
        
       for (int df=-1; df<=1; df++){                
          for (int dc=-1; dc<=1; dc++){
				fil = this.getFila()+df;
				col = this.getColumna()+dc;
				if (t.posicionValida(fil,col) && validarMovimiento(t, fil, col)) {					
					a.add(new Par(fil, col));
                }
          }
        } 
         
         return a;       
      }	
}

