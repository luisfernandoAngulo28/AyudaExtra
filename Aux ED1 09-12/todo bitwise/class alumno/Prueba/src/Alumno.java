public class Alumno {
    int n;
    
    public Alumno()
    {
        n = 0;
    }
    
    public Alumno(char Sexo, String carrera, int Registro,int Edad, int Semestre)
    {
        Edad = Edad - 10;
        n = Edad;
        n = n << 6;
        Registro = Registro -1;
        n = n | Registro;
        n = n << 4;
        Semestre = Semestre -1;
        n = n | Semestre;
        int dato =0;
        if (carrera.toUpperCase().equals("INFORMATICA"))
            dato = 0;
        else
        {
            if (carrera.toUpperCase().equals("SISTEMAS"))
                dato = 1;
            else
                if (carrera.toUpperCase().equals("REDES"))
                    dato = 2;
        }
        n = n << 2;
        n = n | dato;
        int s = 0;
        if (Sexo == 'M')
            s = 0;
        else
            if (Sexo == 'F')
                s = 1;
        n = n << 1;
        n = n | s;
    }
    
    public Alumno(Alumno copia)
    {
        this.n = copia.n;
    }
    //char Sexo, String carrera, int Registro,
    //        int Edad, int Semestre
    public char getSexo()
    {
        int aux = n;
        aux = aux & 1;
        if (aux == 0)
            return 'M';
        else
            if (aux == 1)
                return 'F';
        return 'M';
    }
    
    public String getCarrera()
    {
        int aux = n;
        aux = aux >>> 1;
        aux = aux & 3;
        if (aux == 0)
            return "Informatica";
        if (aux == 1)
            return "Sistemas";
        if (aux == 2)
            return "Redes";
        return "Informatica";
    }
    
    public int getRegistro()
    {
        int aux = n;
        aux = aux >>> 7;
        aux = aux & 63;
        return (aux + 1);
    }
    
    public int getEdad()
    {
        int aux = n;
        aux = aux >>> 13;
        aux = aux & 127;
        return (aux + 10);
    }
    
    public int getSemestre()
    {
        int aux = n;
        aux = aux >>> 3;
        aux = aux & 15;
        return (aux + 1);
    }
    //char Sexo, String carrera, int Registro,
    //        int Edad, int Semestre
    public void setSexo(char sexo)
    {
        int dato = 0;
        if (sexo == 'M')
            dato = 0;
        else
            if (sexo == 'F')
                dato = 1;
        n = n & -2;
        n = n | dato;
    }
    
    public void setCarrera(String carrera)
    {
        int dato =0;
        if (carrera.toUpperCase().equals("INFORMATICA"))
            dato = 0;
        else
        {
            if (carrera.toUpperCase().equals("SISTEMAS"))
                dato = 1;
            else
                if (carrera.toUpperCase().equals("REDES"))
                    dato = 2;
        }
        n = n & -7;
        dato = dato << 1;
        n = n | dato;
    }
    
    public void setRegistro(int registro)
    {
        registro = registro - 1;
        n = n & -8065;
        registro = registro << 7;
        n = n | registro;
    }
    
    public void setEdad(int edad)
    {
        edad = edad - 10;
        n = n & -1040385;
        edad = edad << 13;
        n = n | edad;
    }
    
    public void setSemestre(int semestre)
    {
        semestre = semestre -1;
        n = n & -121;
        semestre = semestre << 3;
        n = n | semestre;
    }
    
    public int getEntero()
    {
        return n;
    }
    
    public void setEntero(int dato)
    {
        n = dato;
    }
    
    public static int getCantidadBits()
    {
        return 20;
    }
    
    public String toString()
    {
        return this.getSemestre() + "  -  " + this.getSexo() + " - "
                + this.getCarrera() + "  - " + this.getRegistro() + " - "
                + this.getEdad();
    }
}

