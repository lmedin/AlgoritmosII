import java.util.*;
import java.io.*;


class Peon extends Pieza {

	private boolean primerMov;

	public Peon (String s, int f, int c, String s2, String t){

		super(s,f,c,s2,t);
		primerMov = true;
	}

	
	public boolean getEsPrimerMov(){
		return this.primerMov;
	}	
	
	public void setPrimerMov(boolean m){
		this.primerMov = m;
	}
	
	public boolean mover (int f, int c, Tablero t){    // dada la pieza como la pieza que esta en cf y modifica el tablero
		
		ArrayList<Par> lista = posiblesMovimientos(t,f,c);
		Par p ;	
		//System.out.println( "(" + f + "," + c + ") ");		
		for (int i = 0; i < lista.size(); i++){
			p = lista.get(i);
			//System.out.println("imprimo lista movimientos");
			//System.out.println( "(" + p.getPrimero() + "," + p.getSegundo() + ") ");
			if ((p.getPrimero() == f) && (p.getSegundo() == c)){
				if (this.getEsPrimerMov()) this.setPrimerMov(false);
				return true;
				
			}
		}
		
		return false;
	}

	 public boolean validarMovimiento (Tablero tablero, int fF, int cF) {

                if (fF > 7 || fF < 0)
                        return false;
                if (cF > 7 || cF < 0)
                        return false;

               if (this.getColumna() == cF){
				   
				   switch ( this.getJugador() ) {
					   
						  case "blanco":
							   return ((this.getFila()+1 == fF  && (! tablero.hayPiezaDadaPosicion(fF,cF))));
							   
						  case "negro":
							   return ((this.getFila()-1 == fF  && (! tablero.hayPiezaDadaPosicion(fF,cF))));
							   
					}
							   
										
			   }else{
				 
					switch ( this.getJugador() ) {
					   
						  case "blanco":
								return ( this.getFila() < fF && tablero.hayPiezaDadaPosicion(fF,cF) && tablero.getPieza(fF,cF).getJugador() == "negro");
							   
						  case "negro":
							   return (this.getFila() > fF && tablero.hayPiezaDadaPosicion(fF,cF) && tablero.getPieza(fF,cF).getJugador() == "blanco");
							   
					}
				   
				}
				
			return false;
        }

    public ArrayList<Par> posiblesMovimientos(Tablero t, int i1, int i2) {

        ArrayList<Par> a = new ArrayList<Par>();
        int fil;
        int col;
        
       for (int df=-1; df<=1; df++){
                if (df != 0){
                        for (int dc=-1; dc<=1; dc++){
								//System.out.println( "(" + this.getFila() + "," + this.getColumna() + ") ");
								fil = this.getFila()+df;
								col = this.getColumna()+dc;
								//System.out.println( "(" + fil + "," + col + ") ");
                                if (validarMovimiento(t, fil, col)) {
										//System.out.println( "acepto");
										//System.out.println( "(" + fil + "," + col + ") ");
                                        a.add(new Par(fil, col));
                                }
                        }
                 }
        }
        
        if (this.getEsPrimerMov()){
			
			col = this.getColumna();
			
			switch ( this.getJugador() ) {
					   
						  case "blanco":
								fil = this.getFila()+2;
								//System.out.println( "(" + fil + "," + col + ") ");
								if (! t.hayPiezaDadaPosicion(fil, col)){
									//System.out.println( "(" + fil + "," + col + ") ");
									a.add(new Par(fil, col));
								}
								
															
							   break;
							   
						  case "negro":
								fil = this.getFila()-2;
								//System.out.println( "(" + fil + "," + col + ") ");
							   if (! t.hayPiezaDadaPosicion(fil,col)){
									a.add(new Par(fil,col));
								}
								
							   break;
							   
					}
			
				
		}
        
        return a;
    }   
}
