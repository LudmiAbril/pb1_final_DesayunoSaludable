package ar.edu.unlam.pb1.dominio;

public class IngredientesDesayuno {
	private String codigo;
	private String ingrediente;
	private double precio;
	private int calorias;
	
	
	public IngredientesDesayuno(String nombre, String codigoDeSemilla, double precio,  int calorias) {
		this.ingrediente = nombre;
		this.codigo =codigoDeSemilla;
		this.precio = precio;
		this.calorias= calorias;
	}


	// Metodos
	
	
	public String getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public String toString() {
		return "IngredientesDesayuno [ingrediente=" + ingrediente + ", codigo=" + codigo + ", precio=" + precio
				+ ", calorias=" + calorias + "]";
	}




	
}
