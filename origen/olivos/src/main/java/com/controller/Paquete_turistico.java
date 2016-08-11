package com.controller;

import static com.conexion.Conexion.obtenerConexion;
import static dao.prueba.daoPrueba.*;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.beans.Paquete;


@ManagedBean(name="paquete_turistico")
@ApplicationScoped
public class Paquete_turistico implements Serializable{
	
	
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Paquete> paquetes;
	private Paquete paquete;
	String id ;
	String id_proveedor;
	String 	alojamiento;
	String habitacion;
	String costo;
	String fecha_s;
	String fecha_r;
	
	String dni;
	
	Date date_s;
	Date date_f; 
	 String conexion;
	
	    private List<String> listaProvs;
	     
	    @PostConstruct
	    public void init() {
	    	listaProvs = new ArrayList<String>();
//	    	listaProvs.add("Movil Tour");
//	    	listaProvs.add("Civa");
//	    	listaProvs.add("Flores");
//	    	listaProvs.add("Palomino");
//	    	listaProvs.add("LAN");
//	    	listaProvs.add("Taca Peru");
	    	
	     	listaProvs.add("545566445");
	    	listaProvs.add("533453440");
	    	listaProvs.add("923423222");
	    	listaProvs.add("456456456");
	    	listaProvs.add("888833434");
	    	listaProvs.add("625834757");
	    	conexion = "Init";
	    	probarConexion();
	    }
	 
	public void inicio(){
		
		if(!isPostback()){
			 id = null;
			 id_proveedor= null;
			 	alojamiento= null;
			 habitacion= null;
			 costo= null;
			 fecha_s= null;
			 fecha_r= null;
			 date_s= null;
			 date_f= null;
			 id = null;
			 
				conexion = "inicio";
				probarConexion();
		}
		
	
	}
	 
	public static boolean isPostback() {
	    return FacesContext.getCurrentInstance().isPostback();
	}
	
	
	 
	    
	   public List<Paquete>  armarPaquete(){
		   List<Paquete> lista = new ArrayList<Paquete>();
		   Paquete paquete;
		   for (int i = 0; i < 4; i++) {
			   
			   paquete = new Paquete();
			   paquete.setAlojamiento("Alojamiento 0-"+ i);
			   paquete.setCosto("30");
			   paquete.setId("P-" +i);
			   paquete.setId_proveedor("Proveedor "+ i);
			   paquete.setFecha_s(new Date().toString());
			   paquete.setFecha_r(new Date().toString());
			   paquete.setHabitacion(""+10 + i);
			   
			   lista.add(paquete);
		}
		  return lista; 
	   }




	public List<Paquete> getPaquetes() {
		if(paquetes==null || paquetes.isEmpty()){
			paquetes = armarPaquete();	
		}
		
		
		return paquetes;
	}




	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}




	public Paquete getPaquete() {
		return paquete;
	}




	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	
	public String agregarRegistro(){
		paquetes = getPaquetes();
		Paquete p = new Paquete();
		try {
			
			if(alojamiento!=null && costo!=null && date_s!=null && habitacion!=null && id!=null && id_proveedor!=null){
			String parsear = paquetes.get(paquetes.size()-1).getId().substring(2, 3);
			System.out.println("-> " + parsear);
			int i = Integer.parseInt(parsear)+1;
			System.out.println("-> i " + i);
			id = paquetes.get(paquetes.size()-1).getId().substring(0, 2).concat(String.valueOf(i));
			
			
//			fecha_s= parsearFecha(date_s);
//			fecha_r= parsearFecha(date_f);
			
			System.out.println("GGWP");
			System.out.println("-->>> id " + id_proveedor);
			System.out.println("-->>>id_proveedor " + id_proveedor);
			System.out.println("-->>>alojamiento " + alojamiento);
			System.out.println("-->>>habitacion " + habitacion);
			System.out.println("-->>>costo " + costo);
			System.out.println("-->>>fecha_s " + fecha_s);
			System.out.println("-->>>fecha_r " + fecha_r);
			
			
				p.setAlojamiento(alojamiento);
				p.setCosto(costo);
				p.setFecha_r("Hoy");
				p.setFecha_s("Hoy");
				p.setHabitacion(habitacion);
				p.setId(id);
				p.setId_proveedor(id_proveedor);
				
				paquetes.add(p);
			}
		
			
			System.out.println("-- size -> " + paquetes.size());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  "/faces/paquete_turistico.xhtml?faces-redirect=true";
	}




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
	
	
	   
	public String parsearFecha(Date fecha){
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String fe = sp.format(fecha);
		return fe;
	}




	public Date getDate_s() {
		return date_s;
	}




	public void setDate_s(Date date_s) {
		this.date_s = date_s;
	}




	public Date getDate_f() {
		return date_f;
	}




	public void setDate_f(Date date_f) {
		this.date_f = date_f;
	}

	public List<String> getListaProvs() {
		return listaProvs;
	}

	public void setListaProvs(List<String> listaProvs) {
		this.listaProvs = listaProvs;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	public String agregarId(){
		System.out.println("dni-> " + dni);
		listaProvs.add(dni);
		
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Se Registr� correctamente"));
		        return  "/faces/generar_paquete.xhtml?faces-redirect=true";
	}
	
	public String getConexion() {
		if(conexion==null){
			return	"Ni por init ni por Inicio";
		}
		return conexion;
	}

	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
	
	public void probarConexion(){
		
		String nombre;
		try {
				conexion = "CONEXION NULL";
				conexion = cargarNombrePrueba();
				
			
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "RESULTADO -> " + conexion));
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}
	}
	

}
