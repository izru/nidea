//1.definicion package
package com.ipartek.formacion.nidea.pojo;

//2. imports
//3.definicion de la clase
public class Mesa {
	public static final int PRECIO_PATA = 1;
	public static final int PRECIO_M2 = 5;
	public static final int PRECIO_MATERIAL_MADERA = 4;
	public static final int PRECIO_MATERIAL_ACERO = 6;
	public static final int PRECIO_MATERIAL_ALUMINIO = 5;
	public static final int PRECIO_MATERIAL_PLASTICO = 2;
	public static final int PRECIO_COLOR_CUSTOM = 23;
	public static final String PRECIO_COLOR_NAME_CUSTOM = "custom";
	public static final int MATERIAL_MADERA = 1;
	public static final int MATERIAL_ACERO = 2;
	public static final int MATERIAL_ALUMINIO = 3;
	public static final int MATERIAL_PLASTICO = 4;

	// 4.atributos son siempre private para mantener la encapsulacion
	private int numPatas; // al ser privado, no nos deja acceder desde fuera de la clase
	private int dimension;// metros cuadrados
	private String color;
	private int material;

	/*
	 * 5.metodos 5.1 constructores 5.2 getters/setters 5.3 otros metodos
	 */
	// 5.1 constructores
	public Mesa() {
		// llamar a super
		super();
		// inicializacion de atributos
		this.numPatas = 4;
		this.dimension = 1;
		this.color = "blanco";
		this.material = MATERIAL_MADERA;
	}

	/**
	 * Sirve para documentar con JavaDoc
	 * 
	 * @author IR
	 * @param numPatas
	 *            int en caso de ser negativo se inicializa con 0
	 */

	public Mesa(int material) {
		this();
		this.material = material;
	}

	public Mesa(int numPatas, int dimension, String color, int material) {
		this();// llamada al constructor padre, constructor por defecto o constructor vacio
		this.numPatas = numPatas;
		this.dimension = dimension;
		this.color = color;
		this.material = material;
	}

	// 5.2 getters/setters
	public int getNumPatas() {
		return this.numPatas;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMaterial() {
		return material;
	}

	public void setMaterial(int material) {
		this.material = material;
	}

	/**
	 * Cambio el numero de patas, si es menor que 0 asignamos valor 0
	 * 
	 * @param numPatas
	 *            int
	 */
	public void setNumPatas(int numPatas) {
		this.numPatas = (numPatas <= 0) ? 1 : numPatas;
	}

	// 5.3 otros metodos
	/**
	 * Calculamos el precio de una mesa
	 * 
	 * @see consultar tosas las constantes definidas para los precios
	 * @return int precio en €
	 */
	public int getPrecio() {
		int precio = 0;
		precio += this.getNumPatas() * PRECIO_PATA;
		precio += this.getDimension() * PRECIO_M2;
		if (PRECIO_COLOR_NAME_CUSTOM.equals(this.getColor())) {
			precio += PRECIO_COLOR_CUSTOM;
		}
		switch (this.getMaterial()) {
		case 1:
			precio += PRECIO_MATERIAL_MADERA;
			break;
		case 2:
			precio += PRECIO_MATERIAL_ACERO;
			break;
		case 3:
			precio += PRECIO_MATERIAL_ALUMINIO;
			break;
		case 4:
			precio += PRECIO_MATERIAL_PLASTICO;
			break;
		}

		return precio;
	}

	@Override
	public String toString() {
		return "Mesa [numPatas=" + numPatas + "]";
	}

	public String escribirPrecio() {
		String texto = "";
		texto = "Mesa elegida ";
		texto += "de " + this.getNumPatas() + " patas,";
		texto += " tiene un precio de " + this.getPrecio() + " €";

		return texto;
	}

	public String nombreMaterial(int numMaterial) {
		String result = "";
		switch (numMaterial) {
		case MATERIAL_MADERA:
			result = "Madera";
			break;
		case MATERIAL_ACERO:
			result = "Acero";
			break;
		case MATERIAL_ALUMINIO:
			result = "Aluminio";
			break;
		case MATERIAL_PLASTICO:
			result = "Plastico";
			break;
		}
		return result;
	}

	public int precioMaterial(int numMaterial) {
		int result = 0;
		switch (this.getMaterial()) {
		case 1:
			result = PRECIO_MATERIAL_MADERA;
			break;
		case 2:
			result = PRECIO_MATERIAL_ACERO;
			break;
		case 3:
			result = PRECIO_MATERIAL_ALUMINIO;
			break;
		case 4:
			result = PRECIO_MATERIAL_PLASTICO;
			break;
		}
		return result;
	}

}
