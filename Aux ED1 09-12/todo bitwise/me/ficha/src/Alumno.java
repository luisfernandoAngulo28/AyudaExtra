
public class Alumno {

    VectorBitGenerico v;
    int cantidad;

    public Alumno() {
        v = new VectorBitGenerico(20, 50);
        cantidad = 0;
    }

    public void InsAlumno(char Sexo, String carrera, int Registro, int Edad, int Semestre) {
        int valor = 0;
        int s = -1;
        if (Sexo == 'M') {
            s = 0;
        } else {
            if (Sexo == 'F') {
                s = 1;
            }
        }
        valor = valor | s;
        valor = valor << 2;
        int c = -1;
        if (carrera.toUpperCase().equals("INFORMATICA")) {
            c = 0;
        } else {
            if (carrera.toUpperCase().equals("SISTEMAS")) {
                c = 1;
            } else {
                if (carrera.toUpperCase().equals("REDES")) {
                    c = 2;
                }
            }
        }
        valor = valor | c;
        valor = valor << 6;
        valor = valor | Registro;
        valor = valor << 7;
        valor = valor | Edad;
        valor = valor << 4;
        valor = valor | Semestre;

        cantidad++;
        v.Insertar(valor, cantidad);       
    }

    public char getSexo(int pos) {
        int aux = v.Sacar(pos);
        int mask = (int) Math.pow(2, 1) - 1;
        aux = aux >>> 19;
        mask = aux & mask;
        if (mask == 0) {
            return 'M';
        } else {
            return 'F';
        }
    }

    public String getcarrera(int pos) {
        int aux = v.Sacar(pos);
        int mask = (int) Math.pow(2, 2) - 1;
        aux = aux >>> 17;
        mask = aux & mask;
        if (mask == 0) {
            return "Informatica";
        } else {
            if (mask == 1) {
                return "Sistemas";
            } else {
                if (mask == 2) {
                    return "Redes";
                }
            }
        }
        return "Error";
    }

    public int getregistro(int pos) {
        int aux = v.Sacar(pos);
        int mask = (int) Math.pow(2, 6) - 1;
        aux = aux >>> 11;
        mask = mask&aux;
        return mask;
    }

    public int getedad(int pos) {
        int aux = v.Sacar(pos);
        int mask = (int) Math.pow(2, 7) - 1;
        aux = aux >>> 4;
        mask = aux & mask;
        return mask;
    }

    public int getsemestre(int pos) {
        int aux = v.Sacar(pos);
        int mask = (int) Math.pow(2, 4) - 1;
        mask = aux & mask;
        return mask;
    }

    @Override
    public String toString() {
        String s = "Alumno";
        for (int i = 1; i <= cantidad; i++) {
            s = s +"\n"+"Sexo: "+ getSexo(i) 
                    +"\n"+"Carrera: "+getcarrera(i)
                    +"\n"+"Registro: "+ getregistro(i)
                    +"\n"+"Edad: "+ getedad(i)
                    +"\n"+"Semestre:" +getsemestre(i);
        }
        return s;
    }

    public static void main(String[] args) {
        Alumno a = new Alumno();
        a.InsAlumno('M', "Sistemas", 21, 20, 8);
        a.InsAlumno('F', "informatica", 22, 19, 5);
        System.out.println(a);
    }
}
