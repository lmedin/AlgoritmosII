import java.util.*;
import java.io.*;


public class Terminal {

	public static void main(String args[]) throws UnsupportedEncodingException {
		
			
		String jugador1 = "blanco";
		String jugador2 = "negro";
		
		// Inicializamos el tablero de Ajedrez
		
		Tablero tableroAjedrez = new Tablero (jugador1 , jugador2);
		
		/*StringBuffer pantalla = new StringBuffer(); 
		
		for (int i = 0; i < 8;i++){
			for (int j = 0; j < 8;j++){
				
				if (tableroAjedrez.hayPiezaDadaPosicion(i,j)){ 
					Pieza pie = tableroAjedrez.getPieza(i,j);
					pantalla.append( "(" + pie.getFila() + "," + pie.getColumna() + ") ");
				}else{
					
					pantalla.append("\u2610  ");
				}
			}	
			
			System.out.println(pantalla);	
			pantalla.delete(0, pantalla.length());		
			
		}*/
		
		
		// Mostramos tablero en consola
		tableroAjedrez.mostrarTablero();
		
		int turno = 0;
		String line;
		String line2;
		
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		// Leemos las entradas del teclado		
		
		while(true){
			
			try{
					System.out.println("Ingrese ficha a mover");
					line = br.readLine();
					line2 = line;
					int posIF = (line2.charAt(0) - '0');
					int posIC = (line.charAt(1) - '0');
					
					//System.out.println("imprimo I" + posIF + " " + posIC);
					
					
					
					System.out.println("Ingrese destino");
					line = br.readLine();
					line2 = line;
					int posDF = (line2.charAt(0) - '0');
					int posDC = (line.charAt(1) - '0');
					//System.out.println("imprimo F " + posDF + " " + posDC);
					
					
					if (turno == 0){
						
						if (tableroAjedrez.realizarJugada(posIF,posIC,posDF,posDC,jugador1)){
							tableroAjedrez.mostrarTablero();
							turno = 1;							
 
						}else{
							System.out.println("Movimiento invalido");
							System.out.println("Si desea mover una ficha , ej: posicion 11, ingrese: 11");		
						}
					}else{
						
						if(tableroAjedrez.realizarJugada(posIF,posIC,posDF,posDC,jugador2)){
							tableroAjedrez.mostrarTablero();
							turno = 0;
						}else{
							System.out.println("Movimiento invalido");
							System.out.println("Si desea mover una ficha , ej: posicion 11, ingrese: 11");		
						}
					}	
					
					
					
			}catch (IOException e){
				
				System.out.println("Error al ingresar datos");
				
					
			}
		}
	}
}
