import java.util.*;
import java.io.*;

public class Terminal {

	public static void main(String args[]) throws UnsupportedEncodingException {
		
			
		String jugador1 = "ivan";
		String jugador2 = "lean";
		int posIF;
		int posIC;
		int posDF;
		int posDC;
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
					while (true){
					try{
						System.out.println("Ingrese ficha a mover");
					line = br.readLine();
					line2 = line;					
					posIF = (line2.charAt(0) - '0');
					posIC = (line.charAt(1) - '0');
					break;
					}catch (Exception name){
						System.out.println("Ingreso mal los parametros");						
					}
					
					}
					
					//System.out.println("imprimo I" + posIF + " " + posIC);
					
					
					while(true){
					try{
					System.out.println("Ingrese destino");
					line = br.readLine();
					line2 = line;
					posDF = (line2.charAt(0) - '0');
					posDC = (line.charAt(1) - '0');
					break;
					}catch (Exception name){
						System.out.println("Ingreso mal los parametros");
					}
					}
					
					
					if (turno == 0){
						
						tableroAjedrez.realizarJugada(posIF,posIC,posDF,posDC,jugador1);
						turno = 1;
					}else{
						tableroAjedrez.realizarJugada(posIF,posIC,posDF,posDC,jugador2);
						turno = 0;
					}	
					
					tableroAjedrez.mostrarTablero();
					
			}catch (IOException e){
				
				System.out.println("Error al ingresar datos");
				
					
			}
		}
	}
}
