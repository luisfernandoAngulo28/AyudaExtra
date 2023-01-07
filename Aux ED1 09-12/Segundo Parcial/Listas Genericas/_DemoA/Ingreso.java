package _DemoA;

import java.util.Date;

public class Ingreso implements Comparable<Object> {
	
	private Date fecha;
	private int codProv, codProd, cantidad, codIn;
	
	/*codprod nombreprod*/
	
	public Ingreso(int codIn, int codProv, int codProd, int cant, Date fecha){
		this.codProv = codProv;
		this.codProd = codProd;
		this.cantidad = cant;
		this.fecha = fecha;
		this.codIn = codIn;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCodProv() {
		return codProv;
	}
	public void setCodProv(int codProv) {
		this.codProv = codProv;
	}
	public int getCodProd() {
		return codProd;
	}
	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCodIngreso() {
		return codIn;
	}

	public void setCodIngreso(int codIn) {
		this.codIn = codIn;
	}
	
	@Override
	public String toString(){
		return String.valueOf(getFecha());
	}
	
	@Override
	public int compareTo(Object o) {
		Ingreso c = (Ingreso)o;
		if(o instanceof Ingreso)
			return this.getCodProd() < c.getCodProd() ? -1: 0;
		else
			return -999;
	}	
}
