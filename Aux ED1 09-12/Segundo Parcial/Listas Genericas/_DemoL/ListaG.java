package _DemoL;

import _DemoA.Cliente;

@SuppressWarnings("rawtypes")
public class ListaG<TObjeto extends Comparable> {
	NodoG<TObjeto> l;
	int cant;
	
	public ListaG(){
		l = null;
		cant = 0;
	}
	
	public void InsertarP(TObjeto dato){
		NodoG<TObjeto> p = new NodoG<TObjeto>();
		p.setDato(dato);
		if(cant == 0){
			l = p;
			cant++;
		} else{
			p.setLink(l);
			l = p;
			cant++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void InsertarO(TObjeto dato){
		NodoG<TObjeto> p = new NodoG<TObjeto>();
		p.setDato(dato);
		if(cant == 0){
			l = p;
			cant++;
		} else {
			NodoG<TObjeto> ant = null;
			NodoG<TObjeto> aux = l;
			while (aux != null && aux.getDato().compareTo(dato) < 0) {
				ant = aux;
				aux = aux.getLink();
			}
			if(ant == null){
				p.setLink(l);
				l = p;
				cant++;
			} else {
				ant.setLink(p);
				p.setLink(aux);
				cant++;
			}
		}
	}

	 public void EliminarDato(TObjeto x){
	      NodoG<TObjeto> p = l;
	      NodoG<TObjeto> ant = null;
	        while ((p != null) && ( p.getDato() != x)) {
	            ant = p;
	            p = p.getLink();
	        }
	        if (p != null ) {
	            if (ant == null)
	                l = l.getLink();
	            else
	                ant.setLink(p.getLink());
	            cant --;

	        }else{
	            System.err.println("ERROR: No existe el Dato");
	        }
	    }

	public TObjeto GetDato(int pos){
		if ((pos <= cant) && (pos > 0) && (l != null)) {
		    NodoG<TObjeto> q = l;
		    for (int i = 0; i <= pos; i++){
		        q = q.getLink();
		    }
		    return (TObjeto)q.getDato();
		} else {
		    System.err.println("ERROR: Posicion Fuera de Rango");
		}
		return null;
	}

	public boolean Existe(TObjeto x){
        NodoG<TObjeto> p = l;
        while(p != null){
            if( p.getDato()== x)
                return true;
            p = p.getLink();
            break;
        }
        return false;
    }
    
    public void MostrarListaG(){
      NodoG<TObjeto> aux= l;
        while(aux != null){
            System.out.println("-------------------------------------------------------------------");
            System.out.println(aux.getDato().toString());
            aux = aux.getLink();
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public static void main(String[] args){
    	ListaG<Cliente> p = new ListaG<Cliente>();
    	Cliente c = new Cliente(210031247, 6513303, 78487227, "Arnold", "M", "Los lotes");
    	p.InsertarP(c);
    	p.MostrarListaG();
    }
}
