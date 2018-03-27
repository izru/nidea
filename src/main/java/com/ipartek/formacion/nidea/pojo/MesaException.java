package com.ipartek.formacion.nidea.pojo;

public class MesaException extends Exception {

	private static final long serialVersionUID = 1L;// para que el compilador vaya mas rapido
	public static final String MENSAJE_PATAS = "Minimo al menos 1 pata";

	public MesaException(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}
}
