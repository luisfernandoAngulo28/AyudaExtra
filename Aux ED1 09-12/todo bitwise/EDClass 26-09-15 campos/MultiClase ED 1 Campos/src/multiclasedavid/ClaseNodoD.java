package multiclasedavid;
public class ClaseNodoD {
    int data;
    ClaseNodoD enlaceD;
    ClaseNodoD enlaceI;
    public ClaseNodoD(int ele)
    {
        data=ele;
        enlaceD=null;
        enlaceI=null;
    }
    public ClaseNodoD(){
        enlaceD=null;
        enlaceI=null;
    }
    
    public void setenlaceD(ClaseNodoD p){
        enlaceD=p;
    }
    
    public void setenlaceI(ClaseNodoD q){
        enlaceI=q;
    }
    
    public void setdata(int ele){
        data=ele;
    }
    
    public int getdata(){    
        return(data);
    }
    
    public ClaseNodoD getenlaceD(){
        return(enlaceD);
    }
    
    public ClaseNodoD getenlaceI(){
        return(enlaceI);
    }
    
    
    
}
