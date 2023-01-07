package multiclasedavid;
public class ClaseCola {

    int Q[];
    int Frente;
    int Atras;
    int Max;

    public ClaseCola(int n){
    Q = new int[n];
    Frente = -1;
    Atras = -1;
    Max = n;
}

    public void EliminarRep() throws Exception{
        int m = 0;
        int ele;
        while(Atras-m>Frente) {
             ele = Sacar();
             int dis= Atras-Frente;
             for(int i=0; i<=dis; i++)
             {
                int aux = Sacar();
                if (aux!= ele){
                    Meter(aux);
                }
             }
             Meter(ele);
             m++;
       }
        Meter(Sacar());
    }


public boolean Vacio(){
    return (Frente==-1 && Atras==-1);
}
public boolean Llena(){
    if (Atras == Max) {
        return (Frente == 0);
    }
    else{
        return(Frente == Atras + 1);
    }
}
public void Meter(int x) throws Exception{
    if (Llena()) {
        throw new Exception("Error la cola esta llena");
    }
    else{
        if (Vacio()){
            Q[0] = x;
            Atras = Frente = 0;
        }
        else{
            Atras = (Atras + 1) % (Max + 1);
            Q[Atras] = x;

        }
    }
}
public int Sacar() throws Exception{
    if (Vacio())
        throw new Exception("Error la cola esta vacio");
    else{
        if (Frente == Atras) {
            int x = Frente;
            Frente = Atras = -1;
            return (Q[x]);
        }
        else{
            int x = Frente;
            Frente = (Frente + 1) % (Max + 1);
            return (Q[x]);
        }
    }


}
public int sacar()
    {
        if (!Vacio())
        {
            int valor = Q[Frente];
            if ((Frente == Atras)&&(Frente != -1))
                Frente = Atras = -1;
            else
                 Frente = (Frente + 1) % Q.length;
            return valor;
        }else
            System.out.println("Error: La cola esta vacia");
        return 0;
    }
public int dimension()
    {
        if (!Vacio())
        {
            int m = Atras + 1 - Frente;
            if ((Frente >= Atras)&&(Frente != 0))
                m = Q.length + m;
            return m;
        }else
            return 0;
    }

public int ContElement() throws Exception{
    int cont=0;
    ClaseCola aux=new ClaseCola(5);
    while (!Vacio()) {
        int x = Sacar();
        if (x != 0) {
            cont++;
        }
        aux.Meter(x);
    }
    this.Q=aux.Q;
    this.Max=aux.Max;
    this.Frente=aux.Frente;
    this.Atras=aux.Atras;
    return cont;
}
public int SumaElemento() throws Exception{
    int sum=0;
    ClaseCola aux = new ClaseCola (5);
     while (!Vacio()) {
        int x = Sacar();

            sum=sum + x;
                aux.Meter(x);
    }
    this.Q=aux.Q;
    this.Max=aux.Max;
    this.Frente=aux.Frente;
    this.Atras=aux.Atras;
    return sum;
}
//public void Ordenar(){
//    for (int i = 0; i < Q.length; i++) {
//        int j = Q[i];
//
//    }
//
//}


public int sumarpares()throws Exception
    {
    int sum=0;
    ClaseCola aux = new ClaseCola (5);
     while (!Vacio()) {
        int x = Sacar();
        if((x % 2) == 0)
        {
            sum=sum + x;
            aux.Meter(x);
         }
    }
    this.Q=aux.Q;
    this.Max=aux.Max;
    this.Frente=aux.Frente;
    this.Atras=aux.Atras;
    return sum;
}
public int sumarimpares()throws Exception
    {
    int sum=0;
    ClaseCola aux = new ClaseCola (5);
     while (!Vacio()) {
        int x = Sacar();
        if((x % 2) != 0)
        {
            sum=sum + x;
            aux.Meter(x);
         }
    }
    this.Q=aux.Q;
    this.Max=aux.Max;
    this.Frente=aux.Frente;
    this.Atras=aux.Atras;
    return sum;
}
public void eliminarpares()throws Exception
    {
    ClaseCola aux = new ClaseCola (5);
     while (!Vacio()) {
        int x = Sacar();
        if((x % 2) != 0)
        {
            System.out.println(x);
            aux.Meter(x);
         }
    }
    this.Q=aux.Q;
    this.Max=aux.Max;
    this.Frente=aux.Frente;
    this.Atras=aux.Atras;
    }
    public void eliminarImpares()throws Exception
    {
    ClaseCola aux = new ClaseCola (5);
     while (!Vacio()) {
        int x = Sacar();
        if((x % 2) == 0)
        {
            System.out.println(x);
            aux.Meter(x);
         }
    }
    this.Q=aux.Q;
    this.Max=aux.Max;
    this.Frente=aux.Frente;
    this.Atras=aux.Atras;
    }
    public void Invertir() throws Exception{
        ClasePila aux=new ClasePila(5);
        while (!Vacio()) {
            aux.push(Sacar());
        }
        while (!aux.vacia()) {
            Meter(aux.pop());
        }
    }
    public int suma()throws Exception
    {
        int sum = 0;
        ClaseCola aux = new ClaseCola(10);
        while (!Vacio()) {
            int x = Sacar();
               sum=sum + x;
            aux.Meter(x);
         }
        while (!aux.Vacio()) {
            Meter(aux.Sacar());
        }
        return sum;
    }
    public double pro1()throws Exception
    {
        return (suma()/ (Atras + 1));
    }
    @Override
    public String toString()//ERROR
    {
        String s = "";
        int constante = dimension();
        for (int i = 0; i < constante; i++) {
            s = s + "|" + sacar();
        }
        return s;
    }
    
    
    
    public boolean igual(ClaseCola P, ClaseCola Q)
    {
        boolean sw = false;
        if(P.dimension() == Q.dimension())
        {
            sw = true;
            int i = 0;
            while((i < Q.dimension()) && (sw == true))
            {
                if(Q.sacar() != P.sacar())
                {
                  sw = false;
                }
            }
        }
        return sw;
    }
    public int menor()throws Exception
    {
        ClaseCola X = new ClaseCola(this.dimension());
        X.copiar(this);
        int men = X.sacar();
        while(X.dimension()>0)
        {
            int g = X.sacar();
            if(g < men)
            {
                men = g;
            }
        }
        return men; 
    }

//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻RECURSIVIDAD☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
//☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻
    public void elimrepetidos(ClaseCola P)throws Exception{
        for (int i=0;i<dimension();i++){
            int s=P.sacar();
            if (frecunc(P, s)>1){
                eliminar(P, s);
            }
            P.Meter(s);
        }
    }
    public void eliminar(ClaseCola P, int ele)throws Exception{
        for (int i=0;i<dimension()+1;i++){
            int y=P.sacar();
            if (y!=ele){
                P.Meter(y);
            }else{

            }
        }
    }
    public int frecunc(ClaseCola P, int ele)throws Exception{
        int x=0;
           for(int i =0;i<dimension();i++){
            int y =P.sacar();
            if (y==ele){
                x++;
                   }
            P.Meter(y);
        }
        return x;
    }
    
    
    
    
    
    public void ordenar(ClaseCola P)throws Exception{
        if (!Vacio()){
            int x=sacaMen(P);
            P.sacarEle(P, x);
            ordenar(P);
            P.Meter(x);
        }
    }
    public int  sacaMen(ClaseCola P)throws Exception{
        int x=100;
        for (int i=0;i<dimension();i++){
            int f=P.sacar();
            if (f<x){
                x=f;
            }
            P.Meter(f);
        } 
        return x;
    }
    public void sacarEle(ClaseCola P,int ele)throws Exception{
        int i=0;
        int b=1;
        while(i<dimension()&&(b==1) ){
            int x=P.sacar();
            if(x==ele){
                b=0;
            }else{
                P.Meter(x);
            }
            i++;
        }

    }


    
    
    

    public void invertirR(ClaseCola P)throws Exception
    {
        if(!(Vacio()))
        {
            int x = P.sacar();
            invertirR(P);
            P.Meter(x);
        }
    }
    
    
    
    public boolean simetrica()throws Exception
    {
        ClaseCola Y = new ClaseCola(this.dimension());
        Y.copiar(this);
        invertirR(this);
        return igual(Y, this);
    }
    public void copiar(ClaseCola P)throws Exception
    {
        int i = 1;
        while(i <= P.Max)
        {
            int x = P.sacar();
            P.Meter(x);
            this.Meter(x);
            i++;
        }
    }
    
    
    
    public void intercarlarPilaCola(ClaseCola aux1,ClaseCola aux2){
        ClasePila aux=new ClasePila(20);
        //int tope1=tope;        
    }
    
    public static void main(String[] args) throws Exception {

        ClaseCola p = new ClaseCola(100);
        p.Meter(2);
        p.Meter(1);
        p.Meter(2);
        p.Meter(3);
        p.Meter(1);
        p.EliminarRep();
        System.out.print("Cola= "+p.toString()+" ");
        
        
        
        
/*        System.out.print("Cola= ");
        while(!p.Vacio())
        {
            System.out.print(p.Sacar()+"|");
        }*/
    }
}
