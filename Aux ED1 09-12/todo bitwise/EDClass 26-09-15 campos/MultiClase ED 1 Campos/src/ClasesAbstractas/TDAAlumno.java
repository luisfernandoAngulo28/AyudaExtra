package ClasesAbstractas;

import java.util.ArrayList;

public abstract class TDAAlumno {
    //ALUMNO CLASE PADRE... COLOCAMOS SUS ATRIBUTOS
    ArrayList Nombre;
    ArrayList Registro;
    ArrayList Sexo;
    ArrayList Edad;
    ArrayList Carrera;
    //INSERTAR CONSTRUCTOR

    public TDAAlumno(ArrayList Nombre, ArrayList Registro, ArrayList Sexo, ArrayList Edad, ArrayList Carrera) {
        this.Nombre = Nombre;
        this.Registro = Registro;
        this.Sexo = Sexo;
        this.Edad = Edad;
        this.Carrera = Carrera;
    }
    

    public ArrayList getNombre() {
        return Nombre;
    }

    public void setNombre(ArrayList Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList getEdad() {
        return Edad;
    }

    public void setEdad(ArrayList Edad) {
        this.Edad = Edad;
    }

    public ArrayList getRegistro() {
        return Registro;
    }

    public void setRegistro(ArrayList Registro) {
        this.Registro = Registro;
    }

    public ArrayList getSexo() {
        return Sexo;
    }

    public void setSexo(ArrayList Sexo) {
        this.Sexo = Sexo;
    }

    public ArrayList getCarrera() {
        return Carrera;
    }

    public void setCarrera(ArrayList Carrera) {
        this.Carrera = Carrera;
    }
    
    public abstract void ingresarNombre(String nombres);
    public abstract void ingresarRegistro(int registro);
    public abstract void ingresarSexo(String sexo);
    public abstract void ingresarEdad(byte edad);
    public abstract void ingresarCarrera(String carrera);
    
    public abstract void eliminarNombre(String nombres);
    public abstract void eliminarRegistro(int registro);
    public abstract void eliminarSexo(String sexo);
    public abstract void eliminarEdad(byte edad);
    public abstract void eliminarCarrera(String carrera);
    
    public abstract String buscarNombre(String nombres);
    public abstract int buscarRegistro(int registro);
    public abstract String buscarSexo(String sexo);
    public abstract byte buscarEdad(byte edad);
    public abstract String buscarCarrera(String carrera);
}
