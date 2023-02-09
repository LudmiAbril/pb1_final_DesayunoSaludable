package ar.edu.unlam.pb1.dominio;


public class MixProductosSaludables {

	private String nombre;
	private IngredientesDesayuno ingredientes[] ;
	private final int TOTAL_MIX_DISPONIBLES =15;
	
	
	public MixProductosSaludables(String nombre) {
		this.nombre = nombre;
		this.ingredientes=new IngredientesDesayuno[TOTAL_MIX_DISPONIBLES];
		
		}
	
	/*
		*Con este metodo se incorporan  ingrediente al desayuno
		*Se necesita incorporar la semilla en base a sus caracter˙êticas 
	*/
	public boolean agregarIngrediente(IngredientesDesayuno nuevoIngrediente) {
		for(int i=0;i<ingredientes.length;i++) {
			if(ingredientes[i]==null) {
				ingredientes[i]=nuevoIngrediente;
				return true;
			}
		}
		return false;
	}

	//Metodo para quitar un ingrediente de la preparaciÛn
	
	public boolean eliminarIngrediente(String ingredienteASacar) {
		for(int i=0;i<ingredientes.length;i++) {
			if(ingredientes[i]!=null && ingredientes[i].getIngrediente().equals(ingredienteASacar)) {
				ingredientes[i]=null;
			return true;
			}
		} return false;
		
	}
	// Metodo para calcular si la cantidad de calorias estan en le limite permitido
	
	public boolean caloriasContenidasSonPermitidas(int limiteCalorias) {
		int caloriasTotales=0;
		for(int i=0;i<ingredientes.length;i++) {
			if(ingredientes[i]!=null) {
				caloriasTotales+=ingredientes[i].getCalorias();
			}
		}
		
		if(caloriasTotales<=limiteCalorias) {
			return true;
		}
		return false;
	}
	//Metodo para calcular el valor total del desayuno seleccionado en la bandeja
	
	public double costoTotalDesayuno () {
		Double costo=0.0;
		for(int i=0;i<ingredientes.length;i++) {
			if(ingredientes[i]!=null) {
				costo+=ingredientes[i].getPrecio();
			}
		}
		return costo;
	}

	//Metodo toString para ver el listado de ingredientes que componen el desayuno
	
	@Override
	public String toString() {
		String contiene = "El desayuno contiene:";
		for(int i = 0; i < ingredientes.length; i++) {		
				if(ingredientes[i]!=null) {
					contiene+="\n"+ingredientes[i].toString();
				  }
			}	
		
		if(ingredientes==null) {
			return "aun no hay ingredientes en la bandeja";
		}
		return contiene;
	}

}
