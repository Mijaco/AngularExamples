package com.beans;

import java.io.Serializable;

public class Paquete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id ;
	String id_proveedor;
	String 	alojamiento;
	String habitacion;
	String costo;
	String fecha_s;
	String fecha_r;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(String id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(String alojamiento) {
		this.alojamiento = alojamiento;
	}
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getFecha_s() {
		return fecha_s;
	}
	public void setFecha_s(String fecha_s) {
		this.fecha_s = fecha_s;
	}
	public String getFecha_r() {
		return fecha_r;
	}
	public void setFecha_r(String fecha_r) {
		this.fecha_r = fecha_r;
	}
	
	 
	
}
