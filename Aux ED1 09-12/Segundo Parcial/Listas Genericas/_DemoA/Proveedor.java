package _DemoA;

public class Proveedor implements Comparable<Object>{

	private int codigo, nit, telefono;
	private String nombre, direccion;
	
	public Proveedor(int codigo, int nit, int telefono, String nombre, String direccion){
		this.codigo = codigo;
		this.nit = nit;
		this.telefono = telefono;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString(){
		return String.valueOf(getNit())+"\t"+getNombre()+"\t"+getDireccion()+"\t"+String.valueOf(getTelefono());
	}
	@Override
	public int compareTo(Object o) {
		Proveedor c = (Proveedor)o;
		
		if(o instanceof Cliente)
			return this.getCodigo() < c.getCodigo() ? -1: 0;
		else
			return -999;
	}
	
}
