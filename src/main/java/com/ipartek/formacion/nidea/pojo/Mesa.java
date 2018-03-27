//1.definicion package
package com.ipartek.formacion.nidea.pojo;

//2. imports
//3.definicion de la clase
public class Mesa {
	public static final int PRECIO_PATA = 1;
	public static final int PRECIO_M2 = 5;
	public static final int PRECIO_COLOR_CUSTOM = 23;
	public static final String COLOR_POR_DEFECTO = "#FFF";
	public static final String PRECIO_COLOR_NAME_CUSTOM = "custom";

	public static final String[] MATERIALES_LISTA = { "madera", "acero", "aluminio", "plastico" };
	public static final int[] MATERIALES_LISTA_CODIGO = { 1, 2, 3, 4 };

	// 4.atributos son siempre private para mantener la encapsulacion
	private int numPatas; // al ser privado, no nos deja acceder desde fuera de la clase
	private int dimension;// metros cuadrados
	private String color;
	private Material material;
	private boolean custom;

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
		this.color = COLOR_POR_DEFECTO; // blanco
		this.custom = false;
		this.material = new Material();
	}

	/**
	 * Sirve para documentar con JavaDoc
	 * 
	 * @author IR
	 * @param numPatas
	 *            int en caso de ser negativo se inicializa con 0
	 */

	public Mesa(Material material) {
		this();
		this.material = material;
	}

	public Mesa(int numPatas, int dimension, String color, Material material) {
		this();// llamada al constructor padre, constructor por defecto o constructor vacio
		this.numPatas = numPatas;
		this.dimension = dimension;
		this.color = color;
		this.material = material;
	}

	// 5.2 getters/setters

	public static int getPrecioPata() {
		return PRECIO_PATA;
	}

	public static int getPrecioM2() {
		return PRECIO_M2;
	}

	public static int getPrecioColorCustom() {
		return PRECIO_COLOR_CUSTOM;
	}

	public static String getPrecioColorNameCustom() {
		return PRECIO_COLOR_NAME_CUSTOM;
	}

	/*
	 * si hubiesemos usado array en vez de clase public static String[]
	 * getMaterialesLista() { return MATERIALES_LISTA; }
	 * 
	 * public static int[] getMaterialesListaCodigo() { return
	 * MATERIALES_LISTA_CODIGO; }
	 */
	public boolean isCustom() {
		return custom;
	}

	public void setCustom(boolean custom) {
		this.custom = custom;
	}

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

	public Material getMaterial() {
		return material;
	}

	/**
	 * 
	 * @param material
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * Cambio el numero de patas, si es menor que 0 asignamos valor 0 Seteamos el
	 * numero de patas de la Mesa
	 * 
	 * @param numPatas
	 *            int
	 * @throws MesaException
	 *             lanza exception si numeroPatas <=0
	 */
	public void setNumPatas(int numPatas) throws MesaException {
		if (numPatas <= 0) {
			throw new MesaException(MesaException.MENSAJE_PATAS);
		}
		this.numPatas = numPatas;
		// this.numPatas = (numPatas <= 0) ? 1 : numPatas;
	}

	// 5.3 otros metodos

	/**
	 * Calculamos el precio de una mesa
	 * 
	 * @see consultar tosas las constantes definidas para los precios
	 * @return int precio en �
	 */
	public int getPrecio() {
		int precio = 0;
		precio += this.getNumPatas() * PRECIO_PATA;
		precio += this.getDimension() * PRECIO_M2;

		if (!COLOR_POR_DEFECTO.equalsIgnoreCase(this.color)) {
			precio += PRECIO_COLOR_CUSTOM;
		}

		precio += material.getPrecio();

		return precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + dimension;
		result = prime * result + numPatas;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesa other = (Mesa) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dimension != other.dimension)
			return false;
		if (material != other.material)
			return false;
		if (numPatas != other.numPatas)
			return false;
		return true;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String escribirPrecio() {
		String texto = "";
		texto = "Mesa elegida ";
		texto += "de " + this.getNumPatas() + " patas,";
		texto += " tiene un precio de " + this.getPrecio() + " �";

		return texto;
	}

}
