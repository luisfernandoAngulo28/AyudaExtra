package ClasesAbstractas;

import java.util.ArrayList;

public class TDAAlumnoArreglo extends TDAAlumno{

    public TDAAlumnoArreglo(ArrayList Nombre, ArrayList Registro, ArrayList Sexo, ArrayList Edad, ArrayList Carrera) {
        super(Nombre, Registro, Sexo, Edad, Carrera);
    }

    @Override
    public void ingresarNombre(String nombres) {
        super.Nombre.add(nombres);
    }

    @Override
    public void ingresarRegistro(int registro) {
        super.Registro.add(registro);
    }

    @Override
    public void ingresarSexo(String sexo) {
        super.Sexo.add(sexo);
    }

    @Override
    public void ingresarEdad(byte edad) {
        super.Edad.add(edad);
    }

    @Override
    public void ingresarCarrera(String carrera) {
        super.Carrera.add(carrera);
    }

    @Override
    public void eliminarNombre(String nombres) {
        super.Nombre.remove(super.Nombre.indexOf(nombres));
    }

    @Override
    public void eliminarRegistro(int registro) {
        super.Registro.remove(super.Registro.indexOf(registro));
    }

    @Override
    public void eliminarSexo(String sexo) {
        super.Sexo.remove(super.Sexo.indexOf(sexo));
    }

    @Override
    public void eliminarEdad(byte edad) {    
        super.Edad.remove(super.Edad.indexOf(edad));
    }

    @Override
    public void eliminarCarrera(String carrera) {
        super.Carrera.remove(super.Carrera.indexOf(carrera));
    }

    @Override
    public String buscarNombre(String nombres) {
        String buscarNombre="";
        if (super.Nombre.contains(nombres)==true){
            buscarNombre=super.Nombre.get(super.Nombre.indexOf(nombres)).toString();
        }else{
            buscarNombre="No Existe el nombre: "+nombres;
        }
        return buscarNombre;
    }

    @Override
    public int buscarRegistro(int registro) {
        int buscarRegistro=0;
        if (super.Registro.contains(registro)==true){
            buscarRegistro=Integer.parseInt(super.Registro.get(super.Registro.indexOf(registro)).toString());
        }else{
            buscarRegistro=0; 
        }
        return buscarRegistro;
    }

    @Override
    public String buscarSexo(String sexo) {
        String buscarSexo="";
        if (super.Sexo.contains(sexo)==true){
            buscarSexo=super.Sexo.get(super.Sexo.indexOf(sexo)).toString();
        }else{
            buscarSexo="No existe la edad: "+sexo;
        }
        return buscarSexo;
    }

    @Override
    public byte buscarEdad(byte edad) {
        byte buscarEdad=0;
        if (super.Edad.contains(edad)==true){
            buscarEdad=Byte.parseByte(super.Edad.get(super.Edad.indexOf(edad)).toString());            
        }else{
            buscarEdad=0;
        }
        return buscarEdad;
    }

    @Override
    public String buscarCarrera(String carrera) {
        String buscarCarrera="";
        if (super.Carrera.contains(carrera)==true){
            buscarCarrera=super.Carrera.get(super.Carrera.indexOf(carrera)).toString();
        }else{
            buscarCarrera="No existe la carreara: "+carrera;
        }
        return buscarCarrera;
    }
    
}
