package multiclasedavid;
public class ClaseLista {
    int dim;
    ClaseNodo L;
    public ClaseLista(){
        dim=0;
        L=null;              
    }
    public boolean vacia(){
        return (L==null);
    }
    public int dimension(){
        return dim;
    }
    private void setdimension(int dimension){
        this.dim=dimension;
    }
    public void insertarprincipio(int x){
        ClaseNodo P = new ClaseNodo(x);
        P.setenlace(L);
        L = P;
        dim++;
    }
    public int ObtenerDato(ClaseNodo P){
        return P.getdata();        
    }
    public void insertaralfinal(int x){
        if (vacia()){
            ClaseNodo P=new ClaseNodo(x);
            L=P;
            dim++;
        }else{            
            ClaseNodo P=new ClaseNodo(x);
            ClaseNodo Q=L;
            while (Q.getenlace()!=null){
                Q=Q.getenlace();                
            }
            Q.setenlace(P);            
            dim++;
        }
    }
    public void insertarORDNOREP(int x){
        if (vacia()){
            ClaseNodo P=new ClaseNodo(x);
            L=P;
            dim++;
        }else{            
            ClaseNodo P=new ClaseNodo(x);
            ClaseNodo Ant=null;
            ClaseNodo aux=L;
            while ((aux!=null)&&(aux.getdata()<=x)){
                Ant=aux;
                aux=aux.getenlace();
            }
            //Inserta en la primera posición
            if (Ant==null){
                L=P;
                L.setenlace(aux);
                dim++;                
            }else{
                if (Ant.getdata()!=x){
                    Ant.setenlace(P);
                    P.setenlace(aux);
                    dim++;
                }                
            }
        }
    }
    
    public void OrdenarLista() {
        ClaseNodo aux = L;
        ClaseLista L1 = new ClaseLista();
        while (aux != null) {
            ClaseNodo a = aux;
            L1.insertarORDNOREP(a.getdata());
            aux = aux.getenlace();
        }
        L = L1.L;
    }
    
    public void insertarORDREP(int x){
        if (vacia()){
            ClaseNodo P=new ClaseNodo(x);
            L=P;
            dim++;
        }else{            
            ClaseNodo P=new ClaseNodo(x);
            ClaseNodo Ant=null;
            ClaseNodo aux=L;
            while ((aux!=null)&&(aux.getdata()<=x)){
                Ant=aux;
                aux=aux.getenlace();
            }
            if (Ant==null){
                L=P;
                L.setenlace(aux);
                dim++;                
            }else{                
                Ant.setenlace(P);
                P.setenlace(aux);
                dim++;                               
            }
        }
    }
    public void eliminarPOS (int pos){
        if (pos==1){
            L=L.getenlace();
            dim--;
        }else{
            int i=1;
            ClaseNodo aux=L;
            ClaseNodo Ant=null;
            while (i<pos){                
                Ant=aux;
                aux=aux.getenlace();
                i++;
            }
            Ant.setenlace(aux.getenlace());  
            dim--;
        }
    }
    public boolean SeEncuentra(int x){
        ClaseNodo Aux=L;        
        if (!vacia()){
            while ((Aux!=null)&&(Aux.getdata()!=x)){
                Aux=Aux.getenlace();
            }
            if (Aux==null){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }           
    }
    public void eliminarEleIncRepet(int ele){
        if (!vacia()){
            ClaseNodo aux=L;  
            ClaseNodo Ant=L;
            while ((aux!=null)&&(aux.getdata()==ele)){
                aux=aux.getenlace();
                L=L.getenlace();
                Ant=aux;                    
                dim--;
            }
            while (aux!=null){                    
                int c=0;
                while ((aux!=null)&&(aux.getdata()==ele)){                                                                                            
                    aux=aux.getenlace();
                    dim--;                    
                    c++;
                }
                if (c>0){
                    Ant.setenlace(aux);                                                                                                  
                }else{
                    Ant=aux;
                    aux=aux.getenlace();                    
                }                
            }
        }        
    }
    public void EliminarElementosRepetidos(){
        ClaseNodo Aux=L;
        ClaseLista L1=new ClaseLista();        
        if (!vacia()){
            while (Aux!=null){                
                if (L1.SeEncuentra(Aux.getdata())==false){
                    L1.insertaralfinal(Aux.getdata());
                }  
                Aux=Aux.getenlace();
            }
            L=L1.L;           
        }else{
            System.out.print("Lista Vacia");
        }
    }
    public boolean SeRepite(int x){
        if (!vacia()){
            ClaseNodo Aux=L;
            int c=0;
            while ((Aux!=null)&&(c<2)){
                if (Aux.getdata()==x){
                    c++;
                }
                Aux=Aux.getenlace();
            }
            if (c==1){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    public void EliminarElementosNoRepetidos(){
        if (!vacia()){            
            ClaseNodo Aux=L;
            ClaseLista L1=new ClaseLista();
            ClaseLista L2=new ClaseLista();
            L1.L=L;
            while (Aux!=null){
                if (L1.SeRepite(Aux.getdata())==true){
                    L2.insertaralfinal(Aux.getdata());                    
                }
                Aux=Aux.getenlace();
            }
            L=L2.L;
        }
    }
    public void invertir(){//l=<1-2-3-4-5>
        if (!vacia()){
            ClaseNodo Aux=L;
            ClaseNodo Ant=null;
            ClaseNodo Pos=L.getenlace();            
            while (Aux.getenlace()!=null){
                Aux.setenlace(Ant); //IMPORTANTE AQUI NO MODIFICA EL SETENLACE DEL AUX
                Ant=Aux;
                Aux=Pos;
                Pos=Pos.getenlace();
            }
            Aux.setenlace(Ant);
            L=Aux;
        }else{
            System.out.print("Lista Vacia");
        }
    }
    public void invertir1(){
        ClaseNodo Ant=null;
        ClaseNodo Aux=L;
        ClaseNodo Sig=L.getenlace();
        while (Sig!=null){
            Aux.setenlace(Ant);
            Ant=Aux;
            Aux=Sig;
            Sig=Sig.getenlace();
        }
        Aux.setenlace(Ant);
        L=Aux;
    }
    
    
    public void Permutar() {
        ClaseNodo P = L;
        if (vacia()) {
            //Nada
        } else {
            if (P.getenlace() == null) {
                //Nada
            } else {
                L = P.getenlace();
                ClaseNodo aux = P;
                ClaseNodo aux2 = P.getenlace();
                while (aux2.getenlace() != null) {
                    P.setenlace(aux2.getenlace());
                    aux2.setenlace(aux);
                    P = aux2;
                    aux = P.getenlace();
                    aux2 = aux.getenlace();
                }
            }

        }
    }
    public void inverti2en2(){//ERROR
        if (!vacia()||(L.getenlace()!=null)){ 
            ClaseNodo Aux=L;
            ClaseNodo Aux2=L.getenlace();
            ClaseNodo Pos=L.getenlace().getenlace();
            while (Aux.getenlace()!=null){
                Aux.setenlace(Pos);
                Aux2.setenlace(Aux);
                Aux=Pos;
                if (Aux!=null){
                    Aux2=Aux.getenlace();
                    if (Aux2!=null){
                        Pos=Aux2.getenlace();
                    }                    
                }                
            }
        }
    }

//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻RECURSIVIDAD☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻

    public void InvertirR(){
        invertirR(L);
    }
    private void invertirR(ClaseNodo P){
        if (P!=null){
            if (P.getenlace()==null){
                L=P;
            }else{
                invertirR(P.getenlace());
                P.getenlace().setenlace(P);
                P.setenlace(null);
            }
        }
    }
    public int SumarElementosR(){
        return SumarElementosR(L);
    }
    private int SumarElementosR(ClaseNodo P){        
        if (P==null){
            return 0;
        }else{
            return P.getdata()+SumarElementosR(P.getenlace());                
        }        
    }
    public int SumarElementosParesR(){
        return SumarElementosParesR(L);
    }
    private int SumarElementosParesR(ClaseNodo P){
        if (P==null){
            return 0;
        }else{
            if (P.getdata()%2==0)
                return P.getdata()+SumarElementosParesR(P.getenlace());
            else
                return SumarElementosParesR(P.getenlace());
        }
    }
    public int SumarElementosMultNR(int Mult){
        return SumarElementosMultNR(L,Mult);
    }
    private int SumarElementosMultNR(ClaseNodo P, int Mult){
        if (P==null){
            return 0;
        }else{
            if (P.getdata()%Mult==0)
                return P.getdata()+SumarElementosMultNR(P.getenlace(),Mult);
            else
                return SumarElementosMultNR(P.getenlace(),Mult);
        }
    }
    
    
    //INSERTAR POSICION X
    public void InsertarX(int x, int ele){
	insertarX(L, 1, x, ele);
    }
    private void insertarX(ClaseNodo p, int i, int t, int ele){
	if(dim >= t && t >= i){
            if(t == i && i == 1){
		ClaseNodo x = new ClaseNodo();
		x.setdata(ele);
		x.setenlace(p);
		L = x; 
		dim++;
            } else if(t == i){
		ClaseNodo x = new ClaseNodo();
		x.setdata(p.getdata());
		x.setenlace(p.getenlace());
		p.setdata(ele);
		p.setenlace(x);
		dim++;
            } else {
		i++;
		insertarX(p.getenlace(), i, t, ele);
            }
	} 
    }






    //ELIMINAR UN ELEMENTO
    public void EliminarUnElementoR(int x){
        EliminarUnElementoR(L, x);
    }
    private void EliminarUnElementoR(ClaseNodo p, int d){
	if(p != null){
            if(p.getenlace() == null && p.getdata() == d)
		L = null;			
	}
    }
		

    
    
    public int ContarPrimosR(){
	return contPrimosR(L);
    }
    private boolean primoR(int x, int i){
	if(x > 2 ){
            if((x-1) >= i){
		if(x%i==0)
                    return false;
		else
                    return primoR(x, i+1);
            }else
                return true;
        }
	return false;
    }
    private int contPrimosR(ClaseNodo p){
	if(p == null)
            return 0;
	else{
            if(primoR(p.getdata(), 2))
		return 1 + contPrimosR(p.getenlace());
            else
		return contPrimosR(p.getenlace());
        }
    }

        
    public double PromElePosPares(){
	return promediopares(L, 1) / (dimension()%2==0?(dimension()/2):((dimension()-1)/2));
    }
    private double promediopares(ClaseNodo p, int x){
	if(x <= dimension()){
            if(x % 2 == 0){
		return p.getdata() + promediopares(p.getenlace(), x+1);
            } else
		return promediopares(p.getenlace(), x+1);
        }else
            return 0;
    }
    
    
    
    
    public int EleMenor(int x){//ERROR
	return por_mx(L, x, 1);
    }
    private int por_mx(ClaseNodo p, int x, int r){
	if(r <= dimension()){
            if(r % x == 0){
		return p.getdata()<por_mx(p.getenlace(), x, r+1)?p.getdata():por_mx(p.getenlace(), x, r+1);
            }else
		return por_mx(p.getenlace(), x, r+1);
        }else
            return (Integer) null;
    }
    
    
    //VERIFICAR ORDENACION DESCENDENTE    
    public boolean OrdDes(){
	return ord_des(L);
    }
    private boolean ord_des(ClaseNodo p){
	if(p.getenlace() == null)
            return true;
	else{
            return p.getdata()>p.getenlace().getdata()?ord_des(p.getenlace()):false;
	}			
    }
    
    
    
    //VERIFICAR ELEMENTOS IGUALES
    public boolean Igual(){
	return igual(L);
    }
    private boolean igual(ClaseNodo p){
	if(p.getenlace() == null)
            return true;
	else
            return p.getdata() == p.getenlace().getdata()?igual(p.getenlace()):false;
    }

    
    
    //VERIFICAR ELEMENTOS INTERCALADOS ENTRE PARES E IMPARES
    public boolean Intercalados(){
	return intercalados(L, dim);
    }
    private boolean intercalados(ClaseNodo p, int a){
	if(p == null)
            return true;
	else{
            if(a%2!=0 && p.getdata()%2==0 || a%2==0 && p.getdata()%2!=0)
		return intercalados(p.getenlace(), a+1);
            else
		return false;
	}
    }
    
    
    
    
    //VERIFICAR SI TODOS LOS ELEMENTOS SON DIFERENTES
    public boolean Diferentes(){
	return diferentes(L);
    }
    private int frecuencia(ClaseNodo p, int x){
	if(p == null)
            return 0;
	else
            return p.getdata() == x?1+frecuencia(p.getenlace(), x):frecuencia(p.getenlace(), x);
	}
    private boolean diferentes(ClaseNodo p){
	if(p == null)
            return true;
	else
            return frecuencia(L, p.getdata())>1?false:diferentes(p.getenlace());
    }	
    
    
    
    //ELEMENTO DE MAYOR FRECUENCIA
    public int EleMayFrec() {
	return elemayFrecR(L);
    }    
    private int elemayFrecR(ClaseNodo p){
	if(p == null)
            return 0;
	else
            return frecuencia(L, p.getdata()) > elemayFrecR(p.getenlace())? p.getdata() : elemayFrecR(p.getenlace());
    }
    
    
    
    
    public void InsertarUR(int ele) {
        InsertarURR(L, ele);
    }

    private void InsertarURR(ClaseNodo P, int ele) {
        if (P == null) {
            ClaseNodo Q = new ClaseNodo(ele);
            L = Q;
            dim++;
        } else {
            if (P.getenlace() == null) {
                ClaseNodo Q = new ClaseNodo(ele);
                P.setenlace(Q);
                dim++;
            } else {
                InsertarURR(P.getenlace(), ele);
            }
        }
    }
    
    
    
    
    public void EliminarR(int ele) {
        EliminarRP(L, ele);
    }
    private void EliminarRP(ClaseNodo P, int ele) {
        if (P == null) {
            //Nada
        } else {
            if (ele == L.getdata()) {
                if (L.getenlace() == null) {
                    L = null;
                } else {
                    L = L.getenlace();
                }
            } else {
                if (P.getenlace() != null) {
                    if (ele == P.getenlace().getdata()) {
                        P.setenlace(P.getenlace().getenlace());
                    } else {
                        EliminarRP(P.getenlace(), ele);
                    }
                }
            }
        }
    }
    
    //FALTA RESOLVER
    public void EliminarElementosParesR(){
        EliminarElementosParesR(L);
    }
    private void EliminarElementosParesR(ClaseNodo P){
        if (P!=null){         
            if (P.getdata()%2==0){
                P=P.getenlace();
            }else{
                ClaseNodo Aux=P;
                Aux.setenlace(P.getenlace().getenlace());
                EliminarElementosParesR(P.getenlace());
            }
        }
    }
    
    public void EliminarParR() {
        EliminarParRP(L);
    }
    private void EliminarParRP(ClaseNodo P) {
        if (P == null) {
            //Nada
        } else {
            if (P.getenlace() == null) {
                //Nada
            } else {
                ClaseNodo aux = P;
                aux.setenlace(P.getenlace().getenlace());
                EliminarParRP(P.getenlace());
                dim--;
            }
        }
    }
    
    public void PermutarR() {
        PermutarRR(L);
    }
    private void PermutarRR(ClaseNodo P) {
        if (P == null) {
        } else {
            if (P.getenlace() == null) {
                //Nada
            } else {
                if (P.getenlace().getenlace() == null) {
                } else {
                    PermutarRR(P.getenlace().getenlace().getenlace());
                    if (P == L) {
                        ClaseNodo aux = P;
                        P = aux.getenlace().getenlace();
                        ClaseNodo aux2 = aux.getenlace().getenlace().getenlace();
                        P.setenlace(aux.getenlace());
                        P.getenlace().setenlace(aux);
                        aux.setenlace(aux2);
                        L = P;
                    } else {
                        ClaseNodo aux = P;
                        P = aux.getenlace().getenlace();
                        ClaseNodo aux2 = aux.getenlace().getenlace().getenlace();
                        P.setenlace(aux.getenlace());
                        P.getenlace().setenlace(aux);
                        aux.setenlace(aux2);
                        L.getenlace().getenlace().setenlace(P);
                    }
                }
            }
        }
    }
    
    public void inter3 (){
        L=inter3(L);
    }
    private ClaseNodo inter3(ClaseNodo p){
        if (p==null)
            return p;
        if(p.getenlace()==null)
            return p;
        if(p.getenlace().getenlace()==null)
            return p;
        
        ClaseNodo a = p;
        ClaseNodo b = p.getenlace();
        ClaseNodo c = b.getenlace();
        
        ClaseNodo r = inter3(c.getenlace());
        b.setenlace(r);
        c.setenlace(b);
        a.setenlace(c);
        
        
        return a;
    }
    public void IntercambiarR() {
        IntercambiarRR(L);
    }
    private void IntercambiarRR(ClaseNodo P) {
        if (P == null) {
        } else {
            if (P.getenlace() == null) {
                //Nada
            } else {
                if (P.getenlace().getenlace() == null) {
                    IntercambiarRR(P.getenlace().getenlace());
                    P.getenlace().setenlace(P);
                } else {
                    if (P == L) {
                        ClaseNodo aux = P;
                        P = aux.getenlace().getenlace();
                        ClaseNodo aux2 = aux.getenlace().getenlace().getenlace();
                        P.setenlace(aux.getenlace());
                        P.getenlace().setenlace(aux);
                        aux.setenlace(aux2);
                        L = P;
                    } else {
                        ClaseNodo aux = P;
                        P = aux.getenlace().getenlace();
                        ClaseNodo aux2 = aux.getenlace().getenlace().getenlace();
                        P.setenlace(aux.getenlace());
                        P.getenlace().setenlace(aux);
                        aux.setenlace(aux2);
                        L.getenlace().getenlace().setenlace(P);
                    }
                }
            }
        }
    }
    

    
    
    
    
    public void Invertir2en2R(){
        L=Invertir2en2RR(L);
    }    
    private ClaseNodo Invertir2en2RR(ClaseNodo p){
        if(p!=null && p.getenlace()!=null){
            p.getenlace().setenlace(Invertir2en2RR(p.getenlace().getenlace()));
            ClaseNodo q=p.getenlace().getenlace();
            p.getenlace().setenlace(p);
            p=p.getenlace();
            p.getenlace().setenlace(q);
        }
        return p;
    }
    public void invertir3en3R(){ //1RA FORMA
        L=invertir3en3R(L);
    }
    private ClaseNodo invertir3en3R(ClaseNodo p){
        if(p!=null && p.getenlace()!=null && p.getenlace().getenlace()!=null){
            p.getenlace().getenlace().setenlace(invertir3en3R(p.getenlace().getenlace().getenlace()));
            if (p.getenlace().getenlace().getenlace() == null) {
                ClaseNodo Aux=p.getenlace().getenlace();
                p.getenlace().getenlace().setenlace(p.getenlace());            
                p.getenlace().setenlace(p);            
                p=Aux;
                p.getenlace().getenlace().setenlace(null);                
            }else{
                ClaseNodo q=p.getenlace().getenlace().getenlace();
                ClaseNodo Aux=p.getenlace().getenlace();
                p.getenlace().getenlace().setenlace(p.getenlace());            
                p.getenlace().setenlace(p);            
                p=Aux;
                p.getenlace().getenlace().setenlace(q);                
            }
        }
        return p;
    }
    public void invertir3en3RR(){// 2DA FORMA
        L=invertir3en3RR(L);
    }
    private ClaseNodo invertir3en3RR(ClaseNodo P){
        if (P!=null && P.getenlace()!=null && P.getenlace().getenlace()!=null){
            if (P.getenlace().getenlace().getenlace()==null){                
                ClaseNodo Aux=P.getenlace().getenlace();
                P.getenlace().setenlace(P);
                Aux.setenlace(P.getenlace());
                P=Aux;
                Aux.getenlace().getenlace().setenlace(null);                                
            }else{
                ClaseNodo q=P.getenlace().getenlace().getenlace();
                ClaseNodo Aux=P.getenlace().getenlace();
                P.getenlace().setenlace(P);
                Aux.setenlace(P.getenlace());
                P=Aux;
                Aux.getenlace().getenlace().setenlace(invertir3en3RR(q));                                
            }
        }
        return P;
    }
   
    public void Desplazar3en3R(){
        L=Desplazar3en3RR(L);
    }
    private ClaseNodo Desplazar3en3RR(ClaseNodo p){        
        if (p != null && p.getenlace() != null && p.getenlace().getenlace() != null) {
            //p.getenlace().getenlace().setenlace(Desplazar3en3RR(p.getenlace().getenlace().getenlace()));
            if (p.getenlace().getenlace().getenlace() == null) {
                p.getenlace().getenlace().setenlace(p);
                p = p.getenlace();
                p.getenlace().getenlace().setenlace(null);
            } else {
                ClaseNodo q = p.getenlace().getenlace().getenlace();
                p.getenlace().getenlace().setenlace(p);
                p = p.getenlace();
                p.getenlace().getenlace().setenlace(Desplazar3en3RR(q));
            }
        }
        return p;
    }    
    
    
    
    public void ordenar2en2R(){
        L=ordenar2en2RR(L);
    }   
    private ClaseNodo ordenar2en2RR(ClaseNodo p){
        if (p!=null && p.getenlace()!=null){
            if(p.getenlace().getenlace()==null){
                if(p.getdata()>p.getenlace().getdata()){
                    p.getenlace().setenlace(p);               
                    p=p.getenlace();
                    p.getenlace().setenlace(null);
                }  
            }else{  
                ClaseNodo s=p.getenlace().getenlace();
                if (p.getdata()>p.getenlace().getdata()){
                    p.getenlace().setenlace(p);
                    p=p.getenlace();
                    p.getenlace().setenlace(ordenar2en2RR(s));
                }else{
                   p.getenlace().setenlace(ordenar2en2RR(s));
                }
            }
        }
        return p;
    }
    public void Ordenar3en3R(){
        L=Ordenar3en3R(L);
    }
    private ClaseNodo Ordenar3en3R(ClaseNodo P){
        if (P!=null && P.getenlace()!=null && P.getenlace().getenlace()!=null){
            if (P.getenlace().getenlace().getenlace()==null){
//                ClaseNodo Aux=P.getenlace().getenlace();
                if (P.getdata()<P.getenlace().getdata()&&P.getdata()<P.getenlace().getenlace().getdata()){
                    if (P.getenlace().getdata()<P.getenlace().getenlace().getdata()){
                        P.getenlace().getenlace().setenlace(null);
                    }else{                        
                        ClaseNodo Aux=P;
                        P.getenlace().getenlace().setenlace(P.getenlace());
                        Aux.setenlace(P.getenlace().getenlace());
                        P=Aux;
                        Aux.getenlace().getenlace().setenlace(null);
                    }
                }else{
                    if (P.getenlace().getdata()<P.getdata()&&P.getenlace().getdata()<P.getenlace().getenlace().getdata()){
                        if (P.getdata()<P.getenlace().getenlace().getdata()){
                            ClaseNodo Aux=P.getenlace();
                            P.setenlace(P.getenlace().getenlace());                            
                            Aux.setenlace(P);
                            P=Aux;
                            Aux.getenlace().getenlace().setenlace(null);
                        }else{
                            ClaseNodo Aux=P.getenlace();                            
                            P.getenlace().getenlace().setenlace(P);
                            Aux.setenlace(P.getenlace().getenlace());
                            P=Aux;
                            Aux.getenlace().getenlace().setenlace(null);
                        }
                    }else{
                        if (P.getenlace().getenlace().getdata()<P.getdata()&&P.getenlace().getenlace().getdata()<P.getenlace().getdata()){
                            if (P.getenlace().getdata()<P.getdata()){                              
                                ClaseNodo Aux=P.getenlace().getenlace();
                                P.getenlace().setenlace(P);
                                Aux.setenlace(P.getenlace());
                                P=Aux;
                                Aux.getenlace().getenlace().setenlace(null);        
                            }else{
                                ClaseNodo Aux=P.getenlace().getenlace();                                
                                Aux.setenlace(P);
                                P=Aux;
                                Aux.getenlace().getenlace().setenlace(null);        
                            }                                                        
                        }
                    }
                }
            }else{
                if (P.getdata()<P.getenlace().getdata()&&P.getdata()<P.getenlace().getenlace().getdata()){
                    if (P.getenlace().getdata()<P.getenlace().getenlace().getdata()){
                        ClaseNodo q=P.getenlace().getenlace().getenlace();
                        P.getenlace().getenlace().setenlace(Ordenar3en3R(q));
                    }else{                        
                        ClaseNodo q=P.getenlace().getenlace().getenlace();                        
                        ClaseNodo Aux=P;
                        P.getenlace().getenlace().setenlace(P.getenlace());
                        Aux.setenlace(P.getenlace().getenlace());
                        P=Aux;
                        Aux.getenlace().getenlace().setenlace(Ordenar3en3R(q));
                    }
                }else{
                    if (P.getenlace().getdata()<P.getdata()&&P.getenlace().getdata()<P.getenlace().getenlace().getdata()){
                        if (P.getdata()<P.getenlace().getenlace().getdata()){
                            ClaseNodo q=P.getenlace().getenlace().getenlace();
                            ClaseNodo Aux=P.getenlace();
                            P.setenlace(P.getenlace().getenlace());                            
                            Aux.setenlace(P);
                            P=Aux;
                            Aux.getenlace().getenlace().setenlace(Ordenar3en3R(q));
                        }else{
                            ClaseNodo q=P.getenlace().getenlace().getenlace();
                            ClaseNodo Aux=P.getenlace();                            
                            P.getenlace().getenlace().setenlace(P);
                            Aux.setenlace(P.getenlace().getenlace());
                            P=Aux;
                            Aux.getenlace().getenlace().setenlace(Ordenar3en3R(q));
                        }
                    }else{
                        if (P.getenlace().getenlace().getdata()<P.getdata()&&P.getenlace().getenlace().getdata()<P.getenlace().getdata()){
                            if (P.getenlace().getdata()<P.getdata()){                              
                                ClaseNodo q=P.getenlace().getenlace().getenlace();
                                ClaseNodo Aux=P.getenlace().getenlace();
                                P.getenlace().setenlace(P);
                                Aux.setenlace(P.getenlace());
                                P=Aux;
                                Aux.getenlace().getenlace().setenlace(Ordenar3en3R(q));        
                            }else{
                                ClaseNodo q=P.getenlace().getenlace().getenlace();
                                ClaseNodo Aux=P.getenlace().getenlace();                                
                                Aux.setenlace(P);
                                P=Aux;
                                Aux.getenlace().getenlace().setenlace(Ordenar3en3R(q));        
                            }                                                        
                        }
                    }
                }
            }
        }
        return P;
    }  
    
    public void InvertirExtremos(){
        L=InvertirExtremos(L);
    }
    private ClaseNodo InvertirExtremos(ClaseNodo P){        
        ClaseNodo Aux=P.getenlace();
        ClaseNodo Aux2=P;
        ClaseLista L1=new ClaseLista();        
        while (Aux.getenlace()!=null){                     
            Aux=Aux.getenlace();
        }
        L1.insertaralfinal(Aux.getdata());
        Aux=P.getenlace();
        while (Aux.getenlace()!=null){            
            L1.insertaralfinal(Aux.getdata());
            Aux=Aux.getenlace();
        }
        L1.insertaralfinal(Aux2.getdata());        
        return L=L1.L;
    }
    public void InvertirExtremosR(){
        InvertirExtremosR(L);
    }
    private void InvertirExtremosR(ClaseNodo p){
        if((p== null) || (dim==1)){
        }else{
            if(p.getenlace()==null){
                ClaseNodo ant = L;
                while (ant.getenlace()!= p ){
                    ant = ant.getenlace();
                }
                ClaseNodo aux = L;
                p.setenlace(aux.getenlace());
                aux.setenlace(null);
                ant.setenlace(aux);
                L = p;
                p = aux;
            }
            InvertirExtremosR(p.getenlace());
        }
    }
    
    public void InvertirMitad(){
        L=InvertirMitad(L);
    }
    private ClaseNodo InvertirMitad(ClaseNodo P){
        int c=0;        
        ClaseNodo Aux=P;        
        ClaseLista L1=new ClaseLista();
        while (Aux!=null){            
            c++;
            Aux=Aux.getenlace();
        }
        int k=0;        
        Aux=P;            
        while (Aux!=null && k<c/2){                        
            Aux=Aux.getenlace();
            k++;
        }
        ClaseNodo Aux2=Aux;
        if (Aux!=null&&c%2!=0){         
            Aux=Aux.getenlace();
        }        
        while (Aux!=null){
            L1.insertaralfinal(Aux.getdata());
            Aux=Aux.getenlace();
        }
        if (c%2!=0){
            L1.insertaralfinal(Aux2.getdata());            
        }
        k=0;
        while (k<c/2&&P!=null){
            L1.insertaralfinal(P.getdata());
            P=P.getenlace();
            k++;
        }
        return L=L1.L;
    }
    
    public boolean ListaSimetrica(){//NO ME SALE
        return ListaSimetrica(L);
    }
    private boolean ListaSimetrica(ClaseNodo P){
        if (P!=null){
            ClaseNodo Aux=P;
            ClaseLista L1=new ClaseLista();
            ClaseLista L2=new ClaseLista();
            while (Aux!=null){
                L1.insertaralfinal(Aux.getdata());
                L2.insertaralfinal(Aux.getdata());
                Aux=Aux.getenlace();
            }
            L1.InvertirR();
            if (L1==L2){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }                
    }
    
    public int MayorELE() {
        return MayorR(L);
    }
    private int MayorR(ClaseNodo P) {
        if (P.getenlace() == null) {
            return (P.getdata());
        } else {
            int x = MayorR(P.getenlace());
            if (x > P.getdata()) {
                return x;
            } else {
                return (P.getdata());
            }
        }
    }
    
    
    @Override
    public String toString(){
        String s=" L=<";
        ClaseNodo P=L;
        while (P!=null){
            s=s+P.getdata()+";";
            P=P.getenlace();
        }
        s=s+">";
        return (s);
    }
    
    public static void main(String[] args) {
        ClaseLista A=new ClaseLista();
//        A.insertarORDREP(5);
//        A.insertarORDREP(5);
//        A.insertarORDREP(7);
//        A.insertarORDREP(6);
//        A.insertarORDREP(10);
//        A.insertarORDREP(9);
//        A.insertarORDREP(8);
//        A.insertarORDREP(5);
//        A.insertarORDREP(6);
//        A.insertarORDREP(4);
//        A.insertarORDREP(5);
//        A.insertarORDREP(1);
//        A.insertarORDREP(11);        
        
        A.insertaralfinal(1);
        A.insertaralfinal(2);
        A.insertaralfinal(3);
        A.insertaralfinal(2);
        A.insertaralfinal(6);
        A.insertaralfinal(1);
        A.insertaralfinal(8);        
//        A.insertaralfinal(7); 
////        //System.out.print(A);
        A.insertaralfinal(9);
        A.insertaralfinal(11);
        A.insertaralfinal(12);
        A.insertaralfinal(10);        
        A.insertaralfinal(15);
        A.insertaralfinal(14);
        A.insertaralfinal(13);        
        A.insertaralfinal(18);
        A.insertaralfinal(16);
        A.insertaralfinal(3);
////        A.insertaralfinal(17);        
//        A.insertarORDNOREP(1);
        System.out.print(A); 
//          A.inter3();
//        System.out.print(A.SumarElementosParesR());
//        System.out.print(A.SumarElementosMultNR(11));
//        A.EliminarElementosParesR();
//        System.out.print(" Dimension "+A.dimension()+" ");
//        System.out.print(A);  
//        A.eliminarPOS(4);             
//        System.out.print(A); 
//        A.inverti2en2();
//        System.out.print(A);
//        A.OrdenarLista();
//        System.out.print(A);
//        System.out.print(A.MayorELE());
//        A.InsertarUR(5);
//        System.out.print(A);   
        A.Desplazar3en3R();
//        System.out.print(A);   
//        A.ordenar2en2R();
//        System.out.print(A); 
//        A.invertir1();
//        A.EliminarElementosNoRepetidos();
        //A.eliminarEleIncRepet(6);
//        A.EliminarElementosRepetidos();
//        System.out.print(A.SeRepite(4));
//        System.out.print(A.SeEncuentra(13));
//          System.out.print(A);
//        A.Desplazar3en3R();
        System.out.print(A);         
//        if (A.ListaSimetrica()==true){
//            System.out.print("La Lista es simetrica");
//        }else{
//            System.out.print("La Lista no es simetrica");
//        }
//        System.out.print(A.SumarElePares());
//        A.InsertarX(4, 7);
//        //System.out.print(A.EleMenor(4));NO FUNCIONA
//        System.out.print(A); 
    }
}
