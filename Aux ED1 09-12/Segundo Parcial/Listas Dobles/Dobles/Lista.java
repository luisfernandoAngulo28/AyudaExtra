 package Dobles;

public class Lista {

	private Nodo ini;
	private Nodo fin;
	private int cant;
	
	public Lista(){
		ini = null;
		fin = null;
		setCant(0);
	}
	
	public void InsertarP(int ele){
		Nodo p = new Nodo();
		p.setDato(ele);
		if(ini == null)
			fin = ini = p;
		else{
			p.setEnlaceD(ini);
			ini.setEnlaceI(p);
			ini = p;
		}
		setCant(getCant() + 1);
	}
	
	public void InsertarF(int ele){
		Nodo p = new Nodo();
		p.setDato(ele);
		if(ini == null)
			ini = fin = p;
		else{
			fin.setEnlaceD(p);
			p.setEnlaceI(fin);
			fin = p;
		}
		setCant(getCant() + 1);
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
	//═══════════════════════════════════════════════ Procedimientos recursivos ═══════════════════════════════════════════════════════════════════════════
	//═════════════════════════════════════════════ Mostrar los elementos de la lista ═════════════════════════════════════════════════════════════════════
	private String toString(Nodo x){
		if(x == null)
			return "";
		else{
			return String.valueOf(x.getDato())+ " | " + toString(x.getEnlaceD()) ;
		}
	}
	public String toString(){
		return toString(ini);
	}
	//════════════════════════════ Ej # 1 -- Eliminar un elemento de la lista ═══════════════════════════════════════════════════════════════════════════════
	private void eliminar(Nodo p, int ele){
		if(p != null){
			if(p.getDato() == ele && p.getEnlaceD() != null)
				p.setDato(p.getEnlaceD().getDato());
				
		}
			
	}
	public void Eliminar(int ele){
		eliminar(ini, ele);
	}
	
	//══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════
	
	public static void main(String[] args){
		Lista l = new Lista();
		l.InsertarP(2);
		l.InsertarP(1);
		l.InsertarF(3);
		l.InsertarF(4);
		
		System.out.print(l.toString());
	}


	
}
