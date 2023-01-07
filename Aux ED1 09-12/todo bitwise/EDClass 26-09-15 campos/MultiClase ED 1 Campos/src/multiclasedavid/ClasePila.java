package multiclasedavid;
public class ClasePila {
    int tope;
    int v[];
    public ClasePila(int cant){
        tope=-1;//TOPE APUNTA -1;
        v=new int[cant]; //PILA VACIA
    }
    public boolean vacia(){
        return (tope==-1);
    }    
    public boolean llena(){
        return (tope==v.length-1);
    }
    public void push(int ele){
        if (llena()){
            System.out.print("Error; Pila llena");
        }else{
            tope++;
            v[tope]=ele;
        }
    }
    public int pop(){        
        int x=v[tope];
        tope--;
        return x;                
    }
    public int getdata(){
        return v[tope];
    }
    public int obtener1erELE(){
        return v[tope-tope];
    }
    public int dimension(){
        return tope+1;
    }
    public void invertirpila(){
        ClasePila v1=new ClasePila(10);
        while (!vacia()){
            v1.push(pop());                        
        }
        tope=v1.tope;
        v=v1.v;                
    }
    public ClasePila invertirfuncion(ClasePila p){
        ClasePila q=new ClasePila(tope+1);
        for(int i=tope+1-1;i>0;i--){
            int aux=p.pop();
            for(int j=i;j>0;j--){
                    q.push(p.pop());
            }
            p.push(aux);
            for(int k=q.tope+1;k>0;k--){
                 p.push(q.pop());
            }
        }
        return p;
    }
    


    public void EliminarPares() {

        int x;
        ClasePila aux = new ClasePila(10);
        while( !vacia() ){            
            x = pop();
            if(x % 2 == 1 ){
                aux.push(x);
            }
        }
        while (!aux.vacia()) {
            push(aux.pop());
        }
    }
    
    public int multiplicarPila(){
        ClasePila aux= new ClasePila(5);
        int mul = 1;
            while ( !vacia()) {
                int x = pop();
                mul = mul * x;
                aux.push(x);
            }
            while (!aux.vacia()) {
                push(aux.pop());
            }
        return mul;
    }
    
    
    public int sumarPila(){
        ClasePila aux= new ClasePila(5);
        int sum = 0;
            while ( !vacia()) {
                int x = pop();
                sum = sum + x;
                aux.push(x);
            }
            while (!aux.vacia()) {
                push(aux.pop());
            }
        return sum;
    }
    
    public float  promedioPila(){
        return ((sumarPila())/(tope+1));
    }
    
    public void Ordenar(){
        if (!vacia()){
            System.out.println("LA PILA ORDENA ES :   ");
            ClasePila q =new ClasePila(10);
            int cant= dimension();
            int i=1;
            int c=cant-1;
            int a=cant-1;
            while(i<=a){
                int x=pop();
                int j=1;
                while(j<=c){
                    int y=pop();
                    if(x<=y){
                        q.push(y);
                    }else{
                        q.push(x);
                        x=y;
                    }

                    j++;
                }
                push(x);
                    int k=1;
                    while(k<=c){
                        int z= q.pop();
                        push(z);
                     k++;   
                    }
              i++;
              c--;
            }
        }
    }
    public ClasePila ordenarASC(ClasePila P)// throws Exception
    {
        ClasePila Q = new ClasePila(tope+1);
        for (int i = (P.tope+1)- 2; i >= 0; i--) {
            int aux = P.pop();
            for (int j = i; j >= 0; j--) {
                int x = P.pop();
                if (aux < x) {
                    Q.push(x);
                } else {
                    Q.push(aux);
                    aux = x;
                }
            }
            P.push(aux);
            int y = (Q.tope+1)-1;
            while (y >= 0) {
                P.push(Q.pop());
                y--;
            }
        }
        return P;
    }
    public boolean Secuencia(ClasePila P) throws Exception{ //NO ENTIENDO       
        if(vacia()){
            // String s="false"
        }else{
            int x=pop();
            Secuencia(P);
            if(!vacia()){
                int y=pop();
                if(x>y){
                    while(!vacia()){
                        x=y;
                        y=pop();
                    }
                    return true;
                }
                if(x<y){
                    while(!vacia()){
                        x=y;
                        y=pop();
                    }
                    return true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
/*    @Override
    //MOSTRAR COMO VECTOR
    public String toString(){
        String aux="|";
        for (int i = 0; i <= tope; i++) {
            int j = v[i];
            aux = aux + j +"|";
        }
        return aux;
    }*/
    public void DesplazarMitad(){ //PREGUNTA DE EXAMEN
        ClasePila aux=new ClasePila(10);
        int dim=(tope+1)/2;
        int dim1=tope+1;
        int i=1;
        while (i<=dim){
            aux.push(pop());
            i++;
        }
        aux.invertirpila();
        if ((dim1%2)==1){
            dim++;
        }
        i=0;
        while (i<dim){
            aux.push(v[i]);
            i++;
        }
        tope=aux.tope;
        v=aux.v;
    }            
    public void EliminarEleNoRep() { //PREGUNTA DE EXAMEN
        ClasePila aux = new ClasePila(10);        
        int tope1=tope;
        int tope2=tope;
        int i=0;
        while( i<=tope1){
            int j=0;            
            int cont=0;
            while (j<=tope2){
                if ((v[i]==v[j])&&(i!=j)){
                    cont++;
                }
                j++;
            }
            if (cont>0){
                int m=0;                    
                int cont2=0;
                while (m<=aux.tope){
                    if (aux.v[m]==v[i]){
                        cont2++;
                    }
                    m++;
                }                
                if (cont2==0){
                    int k=0;
                    while (k<=tope2){                    
                        if (v[i]==v[k]){
                            aux.push(v[i]);
                        }                            
                        k++;
                    }
                }                
            }
            i++;
        }
        while (!vacia()){
            pop();
        }
        while (!aux.vacia()) {
            push(aux.pop());
        }
        invertirpila();
    }    
    public void OrdeMitadDesAsc() throws Exception{

        if(!vacia()){
            Ordenar();
            ClasePila q= new ClasePila(20);
            int cant=dimension();
            int i=1;
            int mitad= cant/2;
            while(i<=mitad){
               int x= pop();
               q.push(x);
               i++;
            }
            q.invertirpila();
            int j=1;
            while(j<=mitad){
                int z= q.pop();
                push(z);
                j++;
            }
        }
    }
    public void Fusionar2PilasASC(ClasePila p1, ClasePila p2){	
        ClasePila aux=new ClasePila(30);        
	while(!p1.vacia())
            aux.push(p1.pop());
	while(!p2.vacia())
            aux.push(p2.pop());	
        tope=aux.tope;
	ordenarASC(aux);     
        v=aux.v;
    }
    public boolean TodosIguales(ClasePila q){
        ClasePila r= new ClasePila(20);
        int j=1;
        boolean sw=true;
        int cant=q.dimension();
        while(j<=cant){
            int x=q.pop();
            r.push(x);
            q.push(x);
            j++;
        }
        int i=1;
        int x=r.pop();
        while(i<=cant-1  && sw==true){
            r.push(x);
            if(x!=r.pop())
                sw=false;
        }
        return sw;
    }
    public int  Frecuencia(int x , ClasePila q){

        int i=1;
        int cant=0;
        int c=q.dimension();
        while(i<=c){
            int y=q.pop();
            q.push(y);
            if(x==y)
            cant++;
            i++;
        }
        return cant;
    }
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻RECURSIVIDAD☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
    public void EliminarNoRepe(ClasePila q){
        if(!vacia()){
            ClasePila pi=new ClasePila(q.dimension());

            int i=1;
            int c=q.dimension();
            while(i<=c){
                int x=q.pop();
              if(Existe(x, q)!=false || Existe(x, pi)!=false){
                  pi.push(x);
              }
                i++;
            }
        //    q=Vaciar(pi);
           int j=1;
           int cant=pi.dimension();
           while(j<=cant){
               int x=pi.pop();
               q.push(x);
           j++;
           }
        }
    }
    public Boolean Existe(int x, ClasePila q){
        ClasePila r= new ClasePila(q.dimension());
        boolean sw=false;
        int i=1;
        int c=q.dimension();
        int z=0;
        while(i<=c  && sw==false){
            int y=q.pop();
            if(x==y)
                sw=true;
            i++;
            z++;
            r.push(y);
        }
        int j=1;
        while(j<=z){
            int y=r.pop();
            q.push(y);
        j++;
        }
        return sw;
    }
    
    
    
    
    
    
    
    
    private int simetricaFuncion(ClasePila B, int cant)   //PREGUNTA DE EXAMEN
    {
        int a = 0;
        if (cant == -1)
        {
        }
        else
        {
            int z=B.pop();
            a = simetricaFuncion(B, cant-1);
            if(cant == 0)
                a=z;
            B.push(z);        
        }
        return a;
    }
    public boolean simetrico(ClasePila B)
    {
        boolean s =true;
        if(!vacia())
        { 
        }
        else
        {
            int x = pop();
            s = simetrico(B);
            int y = simetricaFuncion(B, tope+1);
            if (x != y)
                s= false;
            push(x);
            ;
        }
        return s;
    } 
    
    
    
    
    
    
    
    public void EliminarRepe(ClasePila q){
        if (!vacia()){
           int i=1;
           int cant=q.dimension();
            while(i<=cant){
                int x=pop();
                ElimRepe(x, q);
                i++;
            }
        }
    }
    public void ElimRepe(int x, ClasePila q){
        if(!q.vacia()){
        //      System.out.println("pila sin el elemento repertid : ");
            ClasePila r= new ClasePila(20);
            int cant= q.dimension();
            int i=1;
            while(i<=cant){
                int z=q.pop();

                if(x==z){

                }else{
                    r.push(z);
                }
                i++;
            }
            q.push(x);
            int j=1;
            int b=r.dimension();
            while(j<=b){
                int a=r.pop();
                q.push(a);
                j++;
            }
        }
    }
    
    
    
    
    
    
    public void Invertir() throws Exception
    { 
        if (tope>0){
            System.out.println("la pila invertida es :   ");
            int veces=tope;
            ClasePila Aux=new ClasePila(20);
            while (veces>=0){            
                int x=pop();
                LlevarA(Aux,veces);
                push(x);
                TraerDe(Aux,veces);
                veces=veces-1;
            }
        }
    }
    public void TraerDe(ClasePila Aux,int veces) throws Exception
    { while (veces>0)
      {     int x=Aux.pop();
            push(x);
            veces=veces-1;
      }
    }
    public void LlevarA(ClasePila Aux,int veces) throws Exception
    { while (veces>0)
      {     int x=pop();
            Aux.push(x);
            veces=veces-1;
      }
    }
    /*public void ordenarASCR(){  //ESTA MAL ALGO FALTA
        ordenarASCRR(v);
    }
    private ClasePila ordenarASCRR(ClasePila aux){        
        if ((aux.tope)<2){
            if (aux.v[tope]<aux.v[tope-1]){
                int x=pop();
                int y=pop();
                aux.push(x);
                aux.push(y);
            }else
                aux.ordenarASCRR(aux);            
        }
        return aux;
    }*/
    public void mostrar(){
        if (!vacia()){
            int x;
            System.out.print(" Pila = ");
            for (int i = 0; i <= tope; i++) {
                x=v[i];
                System.out.print("|"+x+"");
            }     
            System.out.print("|");
        }
    }
    public static void main(String[] args) throws Exception {
        ClasePila v=new ClasePila(30);
        ClasePila v2=new ClasePila(30);
        v.push(9);
        v.push(9);    
        v.push(6);     
        v.push(5);   
        v2.push(7);
        v2.push(8);
        v2.push(9);
        v2.push(10);
//        v2.push(9);
//        v2.push(9);
//        v2.push(6);
//        v2.push(5);
        v.mostrar();
        v2.mostrar();
        v.Fusionar2PilasASC(v, v2);
        v.mostrar();
//        if (v.simetrico(v2)==true) 
//            System.out.print(" Son simetricas");
//        else
//            System.out.print(" No son simetricas");
//        v=v.ordenarASC(v);
//        v.mostrar();
        //v=v.invertirfuncion(v);
        //v.mostrar();
        
     /*   v.invertirpila();
        v.mostrar();
        System.out.print(" 1er elememto "+v.obtener1erELE());
        v.EliminarPares();        
        v.mostrar();
        System.out.println(" La multiplicacion de la pila es: "+v.multiplicarPila());
        System.out.println(" La suma de la pila es: "+v.sumarPila());
        System.out.println(" La promedio de la pila es: "+v.promedioPila());*/
     //   v.EliminarEleNoRep();
     //   v.mostrar();        
//        v.DesplazarMitad();
  //      v.mostrar();
        
        
        
        
       /* if (v.simetrico(v2)==true){
            System.out.println("Las pilas son simétricas entre si");
        }                   
        while (v.tope > -1)
            System.out.println(v.pop());
        while (v2.tope > -1)
            System.out.println(v2.pop());
        try{
            System.out.println(v.pop());
        }catch(Exception e){
            System.out.println("Pila vacía");
        }*/             
    }
}
