package multiclasedavid;
public class ClaseListaD{
    int dim = 0;
    ClaseNodoD P;
    ClaseNodoD U;

    private boolean vacio() {
        return (dim == 0);
    }

    private void insertarP(int ele) {
        ClaseNodoD q = new ClaseNodoD(ele);
        q.setenlaceD(P);
        P.setenlaceI(q);
        P = q;
        dim++;
    }

    private void insertarU(int ele) {
        ClaseNodoD q = new ClaseNodoD(ele);
        q.setenlaceI(U);
        U.setenlaceD(q);
        U = q;
        dim++;
    }

    public void insertarORD(int ele) {
        if (vacio()) {
            ClaseNodoD q = new ClaseNodoD(ele);
            P = q;
            U = q;
            dim++;
        } else {
            ClaseNodoD pos = P;
            while (pos != null && pos.getdata() < ele) {
                pos = pos.getenlaceD();
            }
            if (pos == null) {
                insertarU(ele);
            } else {
                if (pos.getdata() != ele) {
                    if (pos == P) {
                        insertarP(ele);
                    } else {
                        ClaseNodoD q = new ClaseNodoD(ele);
                        pos.getenlaceI().setenlaceD(q);
                        q.setenlaceI(pos.getenlaceI());
                        pos.setenlaceI(q);
                        q.setenlaceD(pos);
                        dim++;
                    }
                }
            }
        }
    }

    public void eliminar(int ele) {
        if (!vacio()) {
            ClaseNodoD pos = P;
            while ((pos != null) && (pos.getdata() != ele)) {
                pos = pos.getenlaceD();
            }
            if (pos != null) {//lo encontro
                if (P == U) {//hay un elemento
                    P = null;
                    U = null;
                } else {
                    if (pos == P) {//elimino el primer elemento
                        P = P.getenlaceD();//va recorriendo la lista
                        P.setenlaceI(null);
                    } else {
                        if (pos == U) {//esta al final
                            U = U.getenlaceI();
                            U.setenlaceD(null);
                        } else {//
                            pos.getenlaceI().setenlaceD(pos.getenlaceD());
                            pos.getenlaceD().setenlaceI(pos.getenlaceI());
                        }
                    }
                }
            }
            dim--;
        }
    }
    public void invertir() //ERROR
        {if(vacio()){
            //no haga nada
        }else{
            ClaseNodoD q=P;
            while(q!=null && q.getenlaceD()!=null){
                P=q.getenlaceD();
                q.getenlaceD().setenlaceD(q);
                q.getenlaceD().setenlaceI(null);
                q.setenlaceD(null);
                q=q.getenlaceD();
            }                             
            q.getenlaceD().setenlaceD(q);
            q.setenlaceI(q.getenlaceD());
            q.setenlaceD(null);
            U=q;             
        }    
    }
    
    
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻RECURSIVIDAD☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
    public int getDato(int pos)
    {
        if ((P != null)&&(U != null))
        {
            if (pos == 1)
            {
                return P.getdata();
            }else
            {
                pos--;
                ClaseNodoD aux = P;
                P = P.getenlaceD();
                int val = getDato(pos);
                P = aux;
                return val;
            }
        }
        System.out.println("Lista vacia");
        return 0;
    }
    
    
    
    
    public boolean capicua()
    {
        return capicuaR(P,U);
    }    
    private boolean capicuaR(ClaseNodoD a, ClaseNodoD b)
    {
        if ((a != b)&&(a.getenlaceI()!= b))
        {
            if (a.getdata() == b.getdata())
                return capicuaR(a.getenlaceD(),b.getenlaceI());
            else
                return false;
        }else
            return true;
    }
    
    
    
    
    public void Eliminar(int ele){
	eliminar(P, ele);
    }
    private void eliminar(ClaseNodoD p, int ele){
	if(p != null){
            if(p.getdata() == ele && p.getenlaceD() != null)
		p.setdata(p.getenlaceD().getdata());
			
	}		
    }	

    
    
    
    
    
    
    public void eliminarR(int ele) {
        eliminarRC(ele, P);
    }
    
    
    
    
    
    
    public void insertarR(int ele) {
        insertarRC(ele, P);
    }

    private void insertarRC(int ele, ClaseNodoD pos) {
        if (vacio()) {
           ClaseNodoD q = new ClaseNodoD(ele);
            P = q;
            U = q;
            dim++;       
        } else {
            if ((pos != null) && (pos.getdata() < ele)) {
                insertarRC(ele, pos = pos.getenlaceD());
            } else {
                //encontro el dato
                if (pos == null) {//si el mayor que el ultimo
                    ClaseNodoD r = new ClaseNodoD(ele);
                    r.setenlaceI(U);
                    U.setenlaceD(r);
                    r.setenlaceD(null);
                    U = r;
                }else{
                    if(pos.getdata()!=ele){                
                        if (pos == P)//si es menor primero
                        {
                            ClaseNodoD r = new ClaseNodoD(ele);
                            r.setenlaceD(P);
                            P.setenlaceI(r);
                            r.setenlaceI(null);
                            P = r;
                            dim++;
                        }else {
                            ClaseNodoD r = new ClaseNodoD(ele);
                            pos.getenlaceI().setenlaceD(r);
                            r.setenlaceI(pos.getenlaceI());
                            r.setenlaceD(pos);
                            pos.setenlaceI(r);
                            dim++;
                        }
                    }
                }
            }
        }
    }   
    
    
    
    public void invertirD(){
        InvertirR(P);
    }       
    private void InvertirR(ClaseNodoD p){
        if(vacio()){
            // no haga nada 
        }else{
            if(p!=null && p.getenlaceD()!=null){
                if(p.getenlaceD().getenlaceD()==null){
                    P=p.getenlaceD();
                    p.getenlaceD().setenlaceD(p);
                    p.getenlaceD().setenlaceI(null);
                    p.setenlaceD(null);
                }else{
                    InvertirR(p.getenlaceD());
                    p.getenlaceD().setenlaceD(p);
                    p.setenlaceI(p.getenlaceD());
                    p.setenlaceD(null);
                    U=p;
                }
            }
        }
    }
    
    
    public void eliminarimpar(){
    
        P=eliminarimparR(P);
    }
    private ClaseNodoD eliminarimparR (ClaseNodoD p){
        if (p!=null){
            if(p.getenlaceD()==null){
                p=null;
            }else {
            if (p.getenlaceD().getenlaceD()==null){
                p=p.getenlaceD();
                p.setenlaceI(null);
            }else{
                p=p.getenlaceD();
                p.setenlaceI(null);;
                p.setenlaceD(eliminarimparR(p.getenlaceD()));
                }          
            }
        }
        return p;
    }
    
    
    
    
    
    
    //NO SE QUE ES
    public boolean escalera()
    {
        return escaleraR(P);
    }    
    private boolean escaleraR(ClaseNodoD l)
    {
        if ((l.getenlaceD()!= null)&&(l != null))
        {
            if (l.getdata() == l.getenlaceD().getdata()-1)
                return escaleraR(l.getenlaceD());
            else
                return false;
        }else
            return true;
    }
    
    
    public void eliminarRep()
    {
        eliminarRep(P);
    }
    
    private void eliminarRep(ClaseNodoD l)
    {
        if ((l.getenlaceD() != null)&&(l != null))
        {
                if (l.getdata() == l.getenlaceD().getdata())
                {
                    if (l.getenlaceD().getenlaceD() != null)
                    {
                        l.getenlaceD().getenlaceD().setenlaceI(l);
                        l.setenlaceD(l.getenlaceD().getenlaceD());
                        eliminarRep(l);
                    }else
                    {
                        U = l;
                        l.setenlaceD(null);
                    }
                    dim--;
                }else
                    eliminarRep(l.getenlaceD());
        }
    }
    private void eliminarRC(int ele, ClaseNodoD r) {
        if (r == null) {
            //no hace nada
        }else {
            if (r.getdata() != ele) {
                eliminarRC(ele, r.getenlaceD());
            }else {//lo encontro
                if (r != null) {
                    if (P == U) {//hay un elemento
                        P = null;
                        U = null;
                    }else{
                        if (r == P) {//elimino el primer elemento
                            P = P.getenlaceD();//va recorriendo la lista
                            P.setenlaceI(null);
                        } else {
                            if (r == U) {//esta al final
                                U = U.getenlaceI();
                                U.setenlaceD(null);
                            } else {//
                                r.getenlaceI().setenlaceD(r.getenlaceD());
                                r.getenlaceD().setenlaceI(r.getenlaceI());
                                
                            }
                        }
                    }
                }
                dim--;
            }        
        }
    }
    public void eliminarPAR() {
        eliminarPARR(P);
    }
    private void eliminarPARR(ClaseNodoD r) {
        if (r == null) {
            //no hace nada
        }else {            
            if ((r.getdata() %2)==1) {
                eliminarPARR(r.getenlaceD());
            }else {                              
                if (P == U) {                                              
                    P = null;
                    U = null;
                }else{                        
                    r.getenlaceI().setenlaceD(r.getenlaceD());
                    r.getenlaceD().setenlaceI(r.getenlaceI());                         
                }                
                dim--;
            }        
        }
    }
    
    
    @Override
    public String toString() {
        String cad = "L => ";
        ClaseNodoD q = P;
        if (q == null) {
            return cad + "null";
        } else {
            while (q != null) {
                cad = cad + q.getdata() + "->";
                q = q.getenlaceD();

            }
        }
        return cad;
    }

    
    
    public String toString1(){
	return toString1(P);
    }        
    private String toString1(ClaseNodoD x){
	if(x == null)
            return "";
	else{
            return String.valueOf(x.getdata())+ " | " + toString1(x.getenlaceD()) ;
	}
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ClaseListaD a = new ClaseListaD();

//        a.insertarR(3);
//        a.insertarR(7);
//        a.insertarR(8);
       
       // a.insertarR(10);
        a.insertarR(1);
        a.insertarU(7);
        a.insertarU(6);
        a.insertarU(2);
        a.insertarU(9);
        a.insertarU(8);
        a.insertarU(8);
        a.insertarU(8);
        System.out.println(a.toString());
        a.eliminarPAR();
        System.out.println(a.toString());
//        a.eliminarR(8);
//        System.out.println(a.toString());
        //System.out.println("eliminamos 10");
        //a.invertir();ERROR
        
//        System.out.println(a.toString());
//        System.out.println("Lo invertiremos la ListaD");
//        a.invertirD();
//        System.out.println("ya esta invertido");
//        System.out.println(a.toString());
//        System.out.println("volvems a inveritir");
//        a.invertirD();
//        System.out.println(a.toString());
//        System.out.println("volvemos a insertar mas elementos a la ListaD");
//        a.insertar(9);
//        a.insertar(11);
//        a.insertarR(13);
//        a.insertar(10);
//        System.out.println(a);
//        a.eliminarimpar();
//        System.out.print(a);
//        if (a.capicua()==true){
//            System.out.print("La lista es capicua");
//        }else{
//            System.out.print("La lista no es capicua");
//        }
/*        if (a.escalera()==true){
            System.out.print("Ordenado");
        }else{
            System.out.print("No esta ordenado");
        }
//        System.out.println(" Lista "+a.toString1());*/
    }
}
