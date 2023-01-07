package Genericas;

public class Nodo <TObjet>{
	private Nodo<TObjet> enlace ;
	private TObjet elemento;
	
	public Nodo(){
		setLink(null);
	}

	public Nodo<TObjet> getLink() {
		return enlace;
	}

	public void setLink(Nodo<TObjet> enlace) {
		this.enlace = enlace;
	}

	public TObjet getData() {
		return elemento;
	}

	public void setData(TObjet elemento) {
		this.elemento = elemento;
	}
	
	public int CompareTo(int e){
		return e;
	}
	
}
