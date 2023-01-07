package Genericas;

public class ListaG<TObject> {
	Nodo<TObject> l;
	TObject data;
	int n;
	
	public ListaG(){
		l = null;
		data = null;
	}
	
	public void InsertarP(TObject elemento){
		Nodo<TObject> p = new Nodo<TObject>();
		p.setData(elemento);
		if(l != null)
			p.setLink(l);
		l = p;
		n++;		
	}
	
	private String toString(Nodo<TObject> p){
		if(p == null)
			return "";
		else
			return p.getData() + " | " + toString(p.getLink());
	}
	
	public String ToString(){
		return toString(l);
	}
	
	
	public static void main(String[] args){
		ListaG<Object> l = new ListaG<Object>();
		l.InsertarP(8);
		l.InsertarP(7);
		l.InsertarP(6);
		System.out.print(l.ToString());
	}
}
