package _DemoA;

public class Cliente implements Comparable<Object>{

	private int cod, nit, telefono;
	private String sexo, direccion, nombre;
	
	public Cliente(int cod, int nit, int telefono, String sexo, String direccion, String nombre){
		this.cod = cod;
		this.nit = nit;
		this.telefono = telefono;
		this.sexo = sexo;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString(){
		return String.valueOf(getNit())+"\t"+getNombre()+"\t"+getDireccion()+"\t"+getSexo()+"\t"+String.valueOf(getTelefono());
	}
	@Override
	public int compareTo(Object o) {
		Cliente c = (Cliente)o;
		
		if(o instanceof Cliente)
			return this.getCod() < c.getCod() ? -1: 0;
		else
			return -999;
	}
}
