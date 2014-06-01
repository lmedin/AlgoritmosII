import java.util.*;
import java.io.*;

class Par {

	private int fila;
	private int columna;

	public Par (int f, int c) {

		fila = f;
		columna = c;
	}

	public int getPrimero (){

		return fila;
	}

	public int getSegundo(){

		return columna;
	}

	public void setPrimero (int f){

		fila = f;
	}

	public void setSegundo (int c){

		columna = c;
	}

	public boolean iguales (Par p1){

		if ((p1.getPrimero() == this.getPrimero()) && (p1.getSegundo() == this.getSegundo())){

			return true;
		}else{

			return false;
		}
	}
}

