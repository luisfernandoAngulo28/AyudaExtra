package _DemoL;

public class NodoG <TObjeto>{
	
	TObjeto dato;
	NodoG<TObjeto> link;
	
	public NodoG(){
		link = null;
		dato = null;
	}
	
	public void setDato(TObjeto dato){
		this.dato = dato;
	}
	
	public void setLink(NodoG<TObjeto> link){
		this.link = link;
	}
	
	public TObjeto getDato(){
		return dato;
	}
	
	public NodoG<TObjeto> getLink(){
		return link;
	}
	
	public int CompareTo(int e){
		return e;
	}

}
