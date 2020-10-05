/**
 * @ (#) PrioridadEDF.java
 *
 * Clase PrioridadEDF.
 * Clase principal donde se inicia el programa. Ademas se realizan los calculos de prioridad,
 * tiempo de espera y tiempo limite para cada proceso.
 *
 * @author Yassine Marroun
 * @version 1.00 2020/05/17
 */
package com.planificacionEDF.YassineMN;
import java.util.ArrayList;
import java.util.List;

public class PrioridadEDF {

	private static Proceso proceso1 = new Proceso ("Proceso 1", 25, 25, 5);
	private static Proceso proceso2 = new Proceso ("Proceso 2", 30, 30, 8);
	private static Proceso proceso3 = new Proceso ("Proceso 3", 40, 40, 10);
	private static List<Proceso> procesos = new ArrayList<Proceso>();
	
	private static void crearProcesos() {
		
		procesos.add(proceso1);
		procesos.add(proceso2);
		procesos.add(proceso3);
	}
	
	//Metodo para aplicar el tiempo que debe esperar cada proceso.
	private static void espera(Integer tiempoProceso, String tipo) {
	
		try {
			System.out.println("Tiempo: " + tiempoProceso + " Tipo: " + tipo);
			Thread.sleep(tiempoProceso * 100);
		} catch(Exception e){
			String error = "Error: " + e;
		    System.out.println(error);
		}
	}
	
	//Primero espera el tiempo limite si le queda,
	//y a continuacion va a esperar el tiempo que dura el proceso realmente en ejecucion.
	private static Integer process1() {
		
		if (proceso1.getTiempoLimite() >= 0) {
			espera(proceso1.getTiempoLimite(), "Espera");
		}
		espera(proceso1.getTiempoProceso(), proceso1.getNombre());
		return proceso1.getTiempoProceso();
	}
	
	//Primero espera el tiempo limite si le queda,
	//y a continuacion va a esperar el tiempo que dura el proceso realmente en ejecucion.
	private static Integer process2() {
		
		if (proceso2.getTiempoLimite() >= 0) {
			espera(proceso2.getTiempoLimite(), "Espera");
		}
		espera(proceso2.getTiempoProceso(), proceso2.getNombre());
		return proceso2.getTiempoProceso();
	}
	
	//Primero espera el tiempo limite si le queda,
	//y a continuacion va a esperar el tiempo que dura el proceso realmente en ejecucion.
	private static Integer process3() {
		
		if (proceso3.getTiempoLimite() >= 0) {
			espera(proceso3.getTiempoLimite(), "Espera");
		}
		espera(proceso3.getTiempoProceso(), proceso3.getNombre());
		return proceso3.getTiempoProceso();
	}
	
	//Va a devolver el proceso mas proximo a ser lanzado en su siguiente periodo, es decir,
	//el proceso que tiene el menor tiempo limite.
	private static Proceso calcularPrioritario() {
		
		Proceso procesoPrioritario = proceso1;
		if (proceso2.getTiempoLimite() < procesoPrioritario.getTiempoLimite()) {
			procesoPrioritario = proceso2;
		}
		if (proceso3.getTiempoLimite() < procesoPrioritario.getTiempoLimite()) {
			procesoPrioritario = proceso3;
		}
		return procesoPrioritario;
	}
	
	//Hace la llamada al metodo del proceso que se debe lanzar.
	private static void lanzarPrioritario(Proceso procesoPrioritario) {
		
		System.out.println(procesoPrioritario.toString());
		if (procesoPrioritario.equals(proceso1)) {
			process1();
		} else if (procesoPrioritario.equals(proceso2)) {
			process2();
		} else {
			process3();
		}
	}
	
	//Calcula el tiempo que ha pasado durante su espera mas su tiempo de ejecucion y
	//a cada proceso le damos su nuevo tiempo limite para poder calcular de nuevo la prioridad de procesos.
	private static void calcularTiempos(Proceso procesoPrioritario) {
		
		Integer tiempoTranscurrido = procesoPrioritario.getTiempoLimite() + procesoPrioritario.getTiempoProceso();
		for (Proceso p : procesos) {
			if(p.equals(procesoPrioritario)) {
				p.setTiempoLimite(p.getPeriodo() - tiempoTranscurrido);
			} else {
				p.setTiempoLimite(p.getTiempoLimite() - tiempoTranscurrido);
			}
        }	
	}
	
	public static void main(String[] args) throws Exception {
		
		crearProcesos();
		boolean run = true;
		while (run) {
			Proceso procesoPrioritario =  calcularPrioritario();
			lanzarPrioritario(procesoPrioritario);
			calcularTiempos(procesoPrioritario);
		}
	}
}