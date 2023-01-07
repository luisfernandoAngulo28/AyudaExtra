package multiclasedavid;
public class ClasePolinomio {

    float vc[];//Vector Coeficiente
    int ve[];//Vector Exponente
    int n;//Cantidad de Polinomio

    public ClasePolinomio(int cantidad) {
        vc = new float[cantidad];
        ve = new int[cantidad];
        n = -1;
    }

    public ClasePolinomio() {
        vc = new float[50];
        ve = new int[50];
        n = -1;
    }

    public void InsMonomio(float coef, int exp) {
        if (coef == 0) {
            return;
        } else {
            if (n == -1)// Esta Vacio
            {
                vc[0]=coef;
                ve[0]=exp;
                n++;
            }else{int k=0;
                while ((k<=n)&&(ve[k]>exp)){
                    k++;
                }if ((k<=n)&&(ve[k]==exp)){
                    float suma=vc[k]+coef;
                    if (suma!=0){
                        vc[k]=suma;                        
                    }else{
                        for (int j=k;k<=n-1;k++){
                            vc[j]=vc[j+1];
                            ve[j]=ve[j+1];
                            n--;
                        }
                    }
                }else{
                    for (int i=n+1;i>k;i--){
                        vc[i]=vc[i-1];
                        ve[i]=ve[i-1];                        
                    }
                    vc[k]=coef;
                    ve[k]=exp;
                    n++;
                }                
            }
        }
    }
    public void sumar (ClasePolinomio q){
        for (int j=1;j<=q.n;j++){
            InsMonomio(q.vc[j],q.ve[j]);
        }
            
    }
    public static void main(String args[]) {
        ClasePolinomio p = new ClasePolinomio();
        ClasePolinomio q = new ClasePolinomio();        
        p.InsMonomio(0, 0);
        System.out.println("P(X)="+p);
        q.InsMonomio(3, 5);        
        System.out.println(q);
        
        
    }
}

