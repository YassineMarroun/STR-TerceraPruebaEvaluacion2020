/**
 * @ (#) Proceso.java
 *
 * Clase Proceso.
 * Nos permite crear instancias de proceso, donde a cada una de ellas le podremos dar
 * un nombre, un periodo, un tiempo limite y un tiempo de proceso.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/05/17
 */
package com.planificacionEDF.YassineMN;

public class Proceso {

	private String nombre;
	private Integer periodo;
	private Integer tiempoLimite;
	private Integer tiempoProceso;
	
	public Proceso(String nombre, Integer periodo, Integer tiempoLimite, Integer tiempoProceso) {
		this.nombre = nombre;
		this.periodo = periodo;
		this.tiempoLimite = tiempoLimite;
		this.tiempoProceso = tiempoProceso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}

	public Integer getTiempoLimite() {
		return tiempoLimite;
	}

	public void setTiempoLimite(Integer tiempoLimite) {
		this.tiempoLimite = tiempoLimite;
	}

	public Integer getTiempoProceso() {
		return tiempoProceso;
	}

	public void setTiempoProceso(Integer tiempoProceso) {
		this.tiempoProceso = tiempoProceso;
	}

	@Override
	public String toString() {
		return "Proceso [nombre=" + nombre + ", periodo=" + periodo + ", tiempoLimite=" + tiempoLimite
				+ ", tiempoProceso=" + tiempoProceso + "]";
	}
	
	
}
