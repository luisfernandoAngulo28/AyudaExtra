package _DemoA;

import java.util.Date;

public class Venta implements Comparable<Object> {
	
	private Date fecha;
	private int cantidad;
	private double precio;
	
	private int codP, codC, codV;
	
	public Venta(int codV, int codCliente, int codProducto, int cantidad, double precio, Date fecha){
		this.codC = codCliente;
		this.codP = codProducto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
		this.codV = codV;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodP() {
		return codP;
	}

	public void setCodP(int codP) {
		this.codP = codP;
	}

	public int getCodC() {
		return codC;
	}

	public void setCodC(int codC) {
		this.codC = codC;
	}
	
	public int getCodV() {
		return codV;
	}

	public void setCodV(int codC) {
		this.codV = codC;
	}
	
	@Override
	public String toString(){
		return getFecha()+"\n"+String.valueOf(getCantidad())+"\t"+String.valueOf(getPrecio());
	}
	
	@Override
	public int compareTo(Object o) {
		Venta c = (Venta)o;
		if(o instanceof Cliente)
			return this.getCodV() < c.getCodV() ? -1: 0;
		else
			return -999;
	}

}
