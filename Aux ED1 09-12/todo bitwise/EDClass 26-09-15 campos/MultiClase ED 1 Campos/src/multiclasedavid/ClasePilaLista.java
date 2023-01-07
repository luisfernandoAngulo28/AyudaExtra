/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package multiclasedavid;

/**
 *
 * @author Shadow
 */
public class ClasePilaLista 
{
    ClaseNodo tope;
    int cantidad;
    
    public ClasePilaLista()
    {
        tope = null;
        cantidad = 0;
    }
    
    public boolean vacia()
    {
        return (tope == null);
    }
   
    public void push(int dato)
    {
          ClaseNodo P = new ClaseNodo();
          P.setdata(dato);
          P.setenlace(tope);
          tope=P;
          cantidad++;
    }   
    
    public int pop()
    {
        int x=tope.getdata();
        tope=tope.getenlace();
        cantidad--;
        return x;        
    }    
    public int Cantidad(){
        if (vacia()){
            return 0;            
        }else{
            int x=pop();
            int y=Cantidad()+1;            
            push(x);
            return y;
        }
    }
    public int MenorElemento(){
        if (!vacia()){
            if (tope.getenlace()==null){
                return tope.getdata();
            }else{
                int x=pop();
                int Men=MenorElemento();
                if (x<Men){
                    Men=x;
                }
                push(x);
                return Men;
            }                        
        }else{
            return 0;
        }
    }
    public void InvertirR(){
        ClasePilaLista aux=new ClasePilaLista();
        int c=cantidad;
        InvertirR(aux,c);
    }
    private void InvertirR(ClasePilaLista a,int c){
        if (vacia()){
            return;            
        }else{
            int x=pop();
            InvertirR(a,c);
            a.push(x);
            if (a.cantidad==c){
                while (!a.vacia()){
                    push(a.pop());
                }
            }
        }
    }
    public int SumarElementosR(){
        ClasePilaLista aux=new ClasePilaLista();        
        return SumarElementosR(aux);
    }
    private int SumarElementosR(ClasePilaLista P){
        if (vacia()){
            return 0;
        }else{
            int x=pop();
            int s=SumarElementosR(P);
            s=s+x;
            push(x);
            return s;
        }
    }
    public int SumarElementosParesR(){
        ClasePilaLista aux=new ClasePilaLista();
        return SumarElementosParesR(aux);
    }
    private int SumarElementosParesR(ClasePilaLista P){
        if (vacia()){
            return 0;
        }else{
            int x=pop();            
            int s=SumarElementosParesR(P);
            if (x%2==0){
                s=s+x;
            }
            push(x);
            return s;
        }        
    }
    public float PromedioPilaR(){//ERROR
        ClasePilaLista aux=new ClasePilaLista();
        return PromedioPilaR(aux);
    }
    private float PromedioPilaR(ClasePilaLista P){
        if (vacia()){
            return 0;
        }else{
            int x=pop();
            float s=PromedioPilaR(P)/cantidad;
            push(x);
            return s+x/cantidad;
        }
    }
    public int ElementoMayorR(){
        ClasePilaLista aux=new ClasePilaLista();
        return ElementoMayorR(aux);
    }
    private int ElementoMayorR(ClasePilaLista P){
        if (!vacia()){
            if (cantidad==1){
                return tope.getdata();
            }else{
                int x=pop();
                int May=ElementoMayorR(P);
                if (May<x){
                    May=x;
                }
                push(x);
                return May;
            }
        }else{
            return 0;
        }
    }
    public void Invertir2en2R(){
        ClasePilaLista aux=new ClasePilaLista();
        Invertir2en2R(aux,cantidad);      
    }
    private void Invertir2en2R(ClasePilaLista a,int c){
        if(vacia()||cantidad < 2){
            return ;
        }
        int x =pop();
        int y =pop();
        Invertir2en2R();
        push(x);
        push(y);                                        
    }
    
//    public boolean capicua(ClasePilaLista P, int C){
//        
//            if(cantidad>C/2){
//                P.push(pop());
//                capicua(P, C);
//            }else{                          
//                if(P.pop()!=pop()){
//                    return  false;
//                }else{
//                    return true;
//                }
//            }
//    }
    
//    public void prueba()
//    {
//        if (vacia()) {
//            return;
//        }
//        int x = pop();
//         prueba();
//         if (x %2==0) {
//             push(x);
//        }
//    }
    public void InvertirM(){
        
    }
    private void InvertirM(ClasePilaLista a){
        if(!vacia()){
            if (cantidad==1){
                
            }
        }
    }
    public void Invertir3en3RFinal()
    {
        if(vacia()||cantidad < 3){
            return ;
        }
        int x =pop();
        int y =pop();
        int z =pop();
        Invertir3en3RFinal();
        push(x);
        push(y);
        push(z);
    }
    public void Invertir3en3delPrincipio()
    {
        ClasePilaLista a = new ClasePilaLista();
        Invertir3en3delPrincipio(a,Cant());
    }
    public void Invertir3en3delPrincipio(ClasePilaLista a,int c)
    {
        while (!vacia()) {        
            a.push(pop());
        }
        if(a.vacia()||a.cantidad < 3){
            return ;
        }
        int x =a.pop();
        int y =a.pop();
        int z =a.pop();
        Invertir3en3delPrincipio(a, c);
        a.push(x);
        a.push(y);
        a.push(z);
        if (a.Cant()==c) {
            while (!a.vacia()) {  
                push(a.pop());
            }
        }
    }
    
    
    
    
    
    
    public void invertir()
    {
        invertirR();
    }
    private void invertirR()
    {
        if(!vacia()){
            if(cantidad==1)
            {   
                int y =pop();
//                System.out.println("|"+y+"|");  
            }else{
                int x=pop();
                invertirR();
                push(x);
//                System.out.println("|"+x+"|");                
            }            
        }
    }
    
   
    @Override
    public String toString() 
    {
        String S= "Pila:";
        ClaseNodo P = tope;
        while(P!=null)
        {
            S=S+"|"+P.getdata()+"|";
            P=P.getenlace();
        }
        return S;
    }
 
    public void insertarO(int dato)
    {
        insertarOR(dato);
    }
    

    private void insertarOR(int dato)
    {
        if(vacia())
        {
            push(dato);
        }
        else
        {
            int x= pop();
            int y=pop();
            if(x<y)
            {                
                int z=y;
                y=x;
                x=z;
            }
            else
            {
//                if()
//                {
//                
//                }
            }
            insertarOR(dato);
        }
    }
    
    
  
    public void pares_impares1(){
        ClasePilaLista a = new ClasePilaLista();
        a.tope= tope;
        a.cantidad=cantidad;
        pares_impares(a);
    }
    public void pares_impares(ClasePilaLista a){
        int c=0;   
        int ii=cantidad;
        int r,o;
        int cantP=0;
        for (int i = 0; i <ii ; i++) {
            r=i;
            o=0;
            while(r<ii){
                int f = a.pop();
                if(f>o){
                    o=f;
                }
                r++;
            }
            a.push(o);
            r=i;
            while(r<ii){
                int f=pop();
                 if(f!=o){
                     a.push(f);
                 }
                 r++;
            }
            tope=a.tope;
            cantidad=a.cantidad;
        }
        tope=a.tope;
        cantidad=a.cantidad;
        
        while(a.vacia()==false){
            int x=a.pop();
            if(x%2==0){
                push(x);
                cantP++;
                
                c++;
            }
        }
        while(c>0){
            a.push(pop());
            c--;
        }
        while(vacia()==false){
            int x=pop();
            if(x%2!=0){
                a.push(x);
            }
        }
        while(a.vacia()==false){
            push(a.pop());
        }
        for (int i = 1; i < cantP; i++) {
            c=i;
            int x = pop();
            while(c<cantP){
                a.push(pop());
                c++;
            }
            push(x);
            while(a.vacia()==false){
                push(a.pop());
            }
        }
    }
    public void ordenarRon(ClasePilaLista a){
        int c=0;   
        int ii=cantidad;
        int r,o;
        for (int i = 0; i <ii ; i++) {
            r=i;
            o=0;
            while(r<ii){
                int f = a.pop();
                if(f>o){
                    o=f;
                }
                r++;
            }
            a.push(o);
            r=i;
            while(r<ii){
                int f=pop();
                 if(f!=o){
                     a.push(f);
                 }
                 r++;
            }
            tope=a.tope;
            cantidad=a.cantidad;
        }
        tope=a.tope;
        cantidad=a.cantidad;

    }
    
    //Si una pilca contiene a otra 
    public boolean contiene(ClasePilaLista a){
        int c=0; int caux=0;
        ClasePilaLista aux = new ClasePilaLista();     
        int r,o;     
        aux.tope=a.tope;
        aux.cantidad=a.cantidad;
        int ii=a.cantidad;
            for (int i = 0; i <ii ; i++) {
            r=i;
            o=0;
            while(r<ii){
                int f = aux.pop();
                if(f>o){
                    o=f;
                }
                r++;
            }
            aux.push(o);
            r=i;
            while(r<ii){
                int f=a.pop();
                 if(f!=o){
                     aux.push(f);
                 }
                 r++;
            }
            a.tope=aux.tope;
            a.cantidad=aux.cantidad;
        }
        aux.tope=tope;
        aux.cantidad=cantidad;
        while(a.vacia()==false){
            aux.tope=tope;
            aux.cantidad = cantidad;
            int x=a.pop();
            caux=1;
             while(aux.vacia()==false){
                 if(aux.pop()==x){
                     c++;
                     caux=0;
                 }
                 
             }
             c=c-caux;
        }
        if (c==cantidad){
            return true;
        }else{
            return false;
        }
    }
    public void OrdenarYEliminarRep(){
        int ii=cantidad;
        ClasePilaLista a = new ClasePilaLista();
        a.tope=tope;
        a.cantidad=cantidad;
        int r,o;
        for (int i = 0; i <ii ; i++) {
            r=i;
            o=0;
            while(r<ii){
                int f = a.pop();
                if(f>o){
                    o=f;
                }
                r++;
            }
            a.push(o);
            r=i;
            while(r<ii){
                int f=pop();
                 if(f!=o){
                     a.push(f);
                 }
                 r++;
            }
            tope=a.tope;
            cantidad=a.cantidad;
        }
    }
    public void invertirExamen(){
        ClasePilaLista a = new ClasePilaLista();
        int can =cantidad/2;
        while(can > 0){
            int x = pop();
            int c2=can-1;
            while(c2>0){
                a.push(pop());
                c2--;
            }
            push(x);
            while(a.vacia()==false){
                push(a.pop());
            }
            can --;
        }
        while(vacia()==false){
            a.push(pop());
        }       
        can=a.cantidad/2;
        while(can > 0){
            int x = a.pop();
            int c2 = can-1;
             while(c2>0){
                 push(a.pop());
                 c2--;
             }
             a.push(x);
             while(vacia()==false){
                 a.push(pop());
             }
             can--;
        }
        tope=a.tope;
        cantidad=a.cantidad;        
    }    
    public int Cant(){
        if (vacia())
            return 0;
        int x=pop();
        int c=Cant();
        push(x);
        return c+1;
    }
    public void ElimElePares(){
        if (vacia())
            return;
        int x=pop();
        ElimElePares();
        if(x%2==0)
            push(x);
    }
    
    public int SumarElePares(){
        if (vacia())
            return 0;
        int x=pop();
        int s=SumarElePares();
        push(x);
        if(x%2==0)
            return s+x;  
        return s;      
    }
    
    public void IntercambiarMitadR(){
        ClasePilaLista a= new ClasePilaLista();
        IntercambiarMitadR(cantidad,a);      
    }
    private void IntercambiarMitadR(int cant,ClasePilaLista a){
        if(vacia())
            return;
        while(cantidad > cant/2 )
            a.push(pop());
        int x =pop();
        IntercambiarMitadR(cant, a);
        while (!a.vacia())
            push(a.pop());
        push(x);
    }    
    public void Fucionar2Pilas(ClasePilaLista a){
        int x=0;
        if(a.vacia()&&vacia())
            return;
        if(cantidad>= a.cantidad){
            x=pop();
        }else
            x=a.pop();
        Fucionar2Pilas(a);
        push(x);
    }
    public void InvertirMitadR(){
        ClasePilaLista aux=new ClasePilaLista();
        InvertirMitadR(aux,cantidad);
    }
    private void InvertirMitadR(ClasePilaLista a,int c){
        if (vacia()){
            return;
        }
        int x=pop();
        InvertirMitadR(a,c);
        a.push(x);
        if(a.cantidad==c/2){
            while(!a.vacia())
                push(a.pop());
        }
    }
    public void InvertirMitadR2(){
        ClasePilaLista a= new ClasePilaLista();
        InvertirMitadR2(a,cantidad/2);  
    }
    private void InvertirMitadR2(ClasePilaLista x,int c){
        if (vacia())
            return;
        int z=pop();
        InvertirMitadR2(x,c);
        x.push(z);
        if (x.cantidad==c){
            while (!x.vacia())
                push(x.pop());
        } 
    }    
    public static void main(String[] args) {
       ClasePilaLista P = new ClasePilaLista();
       ClasePilaLista P2 = new ClasePilaLista();
     
       P.push(1);
       P.push(2);
       P.push(3);
       P.push(4);
       P.push(5);
//       P2.push(1);
//       P2.push(2);
//       P2.push(3);
//       P2.push(5);
       P2.push(1);
       P2.push(2);
       P2.push(3);
       P2.push(4);
       P2.push(5);
       P2.push(6);
       P2.push(7);
       P2.push(8);
       P2.push(9);
       P2.push(10);
//       P2.push(11);
//       P2.push(12);
//       
       
       
      
        System.out.println(P2);                        
        P2.IntercambiarMitadR();
        System.out.print(P2);
//        if (P2.contiene(P)==true){
//            System.out.println("verdad");
//        }else{
//            System.out.println("false");
//        }        
        
             
       
//       P2.push(1);
//       P2.push(2);
//       P2.push(2);
//       P2.push(3);
//       P2.push(3);
//       if(P.contiene(P2)){
//           System.out.print("Contiene");
//       }else{
//           System.out.println("No contiene");
//       }

       

     //   P.pares_impares1();
       //P.invertirDe3();
       //P.inv2();
       
    //    System.out.println(P); 
      //  P.ordenar();
     //   System.out.println(P);
      // P.invertir();
    }
    
}
