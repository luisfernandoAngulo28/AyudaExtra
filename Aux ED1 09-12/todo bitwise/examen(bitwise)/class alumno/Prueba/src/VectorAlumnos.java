public class VectorAlumnos {
    VectorBitGenerico vector;
    int Dim;
    public VectorAlumnos()
    {
        vector = new VectorBitGenerico(Alumno.getCantidadBits(), 50);
        this.Dim=0;
    }
    
    public void insertar(Alumno a, int pos)
    {
        if (pos >= 1 && pos <= 50)
          vector.Insertar(a.getEntero(), pos);
        Dim++;
    }
    
    public Alumno sacarAlumno(int pos)
    {
        if (pos >= 1 && pos <= 50)
        {
            int dato = vector.Sacar(pos);
            Alumno a = new Alumno();
            a.setEntero(dato);
            return a;
        }
        return null;
    }
    
    public void OrdenarPorEdad(){     
        for (int i =1; i <=50 ;i++) {
              Alumno may=sacarAlumno(i);
            for (int j = i+1; j <50; j++) {
               Alumno me=sacarAlumno(j);
                if(me.getEdad()>may.getEdad()){
                    may=me;
                }
            }
            insertar(may, i);
        }
    }

    @Override
    public String toString() {
   String  m=""; 
        for (int i = 1; i <= 50; i++) {
          
               m=m+ sacarAlumno(i)+ "  ";
    
        }
        return m;
    }
    
    
    public static void main(String[] args)
    {
        Alumno a = new Alumno();
        VectorAlumnos v = new VectorAlumnos();

        v.insertar(new Alumno('F',"Redes",2,22,8), 15);
        v.insertar( new Alumno('F',"Sistemas",25,78,9), 48);
        v.insertar(new Alumno('M',"Informatica", 15,40, 6), 27);
//        a.setRegistro(515);
//
        System.out.println(v.sacarAlumno(15) + "");
         System.out.println(v.sacarAlumno(48) + "");
       // v.OrdenarPorEdad();
       // System.out.println(v.toString());
//    }}
    }
    
}
