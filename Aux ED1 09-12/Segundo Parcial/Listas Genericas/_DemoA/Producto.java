package _DemoA;

import java.util.Date;

public class Producto implements Comparable<Object>{
	
	private int cod ;
	private String nombre, descripcion, marco, precedencia;
	private Date fechaVenc;
	
	public Producto(String nombre, String desc, String marco, String precedencia, Date fecha){
		this.nombre = nombre;
		this.descripcion = desc;
		this.marco = marco;
		this.precedencia = precedencia;
		this.fechaVenc = fecha;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarco() {
		return marco;
	}
	public void setMarco(String marco) {
		this.marco = marco;
	}
	public String getPrecedencia() {
		return precedencia;
	}
	public void setPrecedencia(String precedencia) {
		this.precedencia = precedencia;
	}
	public Date getFechaVenc() {
		return fechaVenc;
	}
	public void setFechaVenc(Date fechaVenc) {
		this.fechaVenc = fechaVenc;
	}

	/*
	 * 		this.nombre = nombre;
		this.descripcion = desc;
		this.marco = marco;
		this.precedencia = precedencia;
		this.fechaVenc = fecha;
	 * */
	
	@Override
	public String toString(){
		return getNombre()+"\t"+getDescripcion()+"\t"+getMarco()+"\t"+getPrecedencia()+"\t"+String.valueOf(getFechaVenc());
	}
	@Override
	public int compareTo(Object o) {
		Producto c = (Producto)o;
		
		if(o instanceof Cliente)
			return this.getCod() < c.getCod() ? -1: 0;
		else
			return -999;
	}
	
}
