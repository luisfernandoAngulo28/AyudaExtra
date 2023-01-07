package Dobles;

public class Nodo {

	private Nodo enlaceI;
	private Nodo enlaceD;
	private int dato;
	
	public Nodo(){
		setEnlaceI(null);
		setEnlaceD(null);
	}
	
	public Nodo(int dato){
		this.setDato(dato);
		setEnlaceI(null);
		setEnlaceD(null);
	}

	public Nodo getEnlaceI() {
		return enlaceI;
	}

	public void setEnlaceI(Nodo enlaceI) {
		this.enlaceI = enlaceI;
	}

	public Nodo getEnlaceD() {
		return enlaceD;
	}

	public void setEnlaceD(Nodo enlaceD) {
		this.enlaceD = enlaceD;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}
}
