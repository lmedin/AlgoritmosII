import java.util.*;
import java.io.*;


class Pieza {

	private String jugador;
	private String code;
	private int fila;
	private int columna;

	public Pieza (String s, int f, int c, String s2){
		this.jugador = s;
		this.fila = f;
		this.columna = c;
		this.code = s2;
	}

	public void setJugador (String s){
		this.jugador = s;
	}

	public void setFila (int f){
		
		this.fila = f;
		
	}

	public void setColumna (int c){
		
		this.columna = c;
		
	}

	public int getFila(){
		
		return this.fila;
	}

	public int getColumna(){
		
		return this.columna;
	}

	public String getCode(){
		
		return this.code;
	}
	
	public String getJugador(){
		
		return this.jugador;
	}

	public boolean mover (int f, int c, Tablero t){ 
		return false;
	}
	
	
}
