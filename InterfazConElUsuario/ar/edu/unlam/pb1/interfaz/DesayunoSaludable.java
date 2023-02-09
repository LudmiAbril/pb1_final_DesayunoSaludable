package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;


import ar.edu.unlam.pb1.dominio.*;


public class DesayunoSaludable {

	private static String productos []= { "leche", "cafe", "te","teConLeche","Chocolatada",
										"CafeConLeche","cereales", "frutosSecos", "lacteos",
										"manzana","JugoNaranja", "banana","colacionSinTacc"};
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcionIngresada =0;
		mostrarMensaje("BIENVENIDOS A COMER SALUDABLE ES LO IMPORTANTE");
		
		MixProductosSaludables actual = new MixProductosSaludables("desayuno");
				do {
					mostrarMenu();
					opcionIngresada = teclado.nextInt();
					actual =determinarAccionARealizar( actual, opcionIngresada, teclado);
					 

}while (opcionIngresada !=9);
	}
private static MixProductosSaludables determinarAccionARealizar(MixProductosSaludables actual, int opcionIngresada, Scanner teclado) {
	switch(opcionIngresada) {
	case 1:	
		agregarIngredienteAlaPreparacion(teclado , actual);
		break;
	case 2:
		verListaDeIngredientes(teclado , actual);
		break;
	case 3:
		listaIngrediestesConTopeDeCalorias(teclado , actual);
		break;
	case 4:
		calcularCostoDelDesayuno(teclado , actual);
		break;
	case 9:
		break;
	default: 
		System.out.println("Opcion no contemplada");
		break;
	}
	return actual;
}
private static void mostrarMenu() {
	
	mostrarMensaje("*******************************************************");
	mostrarMensaje("OPERACIONES QUE SE PUEDEN EFECTUAR");
	mostrarMensaje("1- Incorporar ingredientes a la preparación");
	mostrarMensaje("2 -Ver los ingredientes que contiene la preparacion");
	mostrarMensaje("3- Verificar que el dasayuno no supere X cantidad de calorias");
	mostrarMensaje("4- Determinar el costo de una lista de ingredientes seleccionados ");
	mostrarMensaje("9- Salir ");
	mostrarMensaje("*******************************************************");
	mostrarMensaje("Ingrese la opcion deseada ");
	}

private static String mostrarMensaje(String mensaje) {
	System.out.println(mensaje);
	return mensaje;
}

/*
 * Agrega un nuevo ingrediente a la bandeja del desayuno
 * Para trasformar el numero a String se puede usar Integer.toString(numero)
 */
private static void agregarIngredienteAlaPreparacion(Scanner teclado, MixProductosSaludables actual  ) {
	int opcion=0;
	String nombre;
	do {
	mostrarOpciones();
	opcion=teclado.nextInt();
	nombre=obtenerNombreDelIngrediente(opcion-1);
	}while(opcion<1 || opcion>13);
	System.out.println("ingrese el precio:");
	Double precio=teclado.nextDouble();
	System.out.println("ingrese las calorias:");
	Integer calorias=teclado.nextInt();
	String codigo=nombre+precio.toString()+calorias.toString();
	
	IngredientesDesayuno ingrediente=new IngredientesDesayuno(nombre,codigo,precio,calorias);
	
	boolean agregado=actual.agregarIngrediente(ingrediente);
	if(agregado) {
		System.out.println("se agrego el ingrediente");
	}else {
		System.out.println("no se pudo agregar el ingrediente");
	}

}

private static void mostrarOpciones() {
	int num=1;
	System.out.println("Seleccione el ingrediente:");
	for(int i=0;i<productos.length;i++) {
		System.out.println("\n"+num+" - "+productos[i]);
		num++;
	}
}
	
/*
 * Mostrar la cantidad de productos que estan contenidos en la bandeja del desayuno
 */
private static void verListaDeIngredientes(Scanner teclado, MixProductosSaludables actual ) {
	System.out.println(actual.toString());
	
}

/*
 * Realizar un ordenar por el campo precio que contiene la preparación
 */
private static void listaIngrediestesConTopeDeCalorias(Scanner teclado, MixProductosSaludables actual ) {
 System.out.println("ingrese el limite de calorias:");
 int lim=teclado.nextInt();
	if(actual.caloriasContenidasSonPermitidas(lim)) {
		System.out.println("el desayuno no supera las calorias");
	}else {
		System.out.println("el desayuno esta excedido de calorias");
	}
}
/*
 * Calcular el costo de la preparación que hemos agregado segun los ingredientes en uso.
 */
private static void calcularCostoDelDesayuno(Scanner teclado, MixProductosSaludables actual ) {
	Double costo=actual.costoTotalDesayuno();
	System.out.println("el costo total de su desayuno es de: " + costo +"$" );
}
/*
 * Este método retorna el nombre del producto que se encuentra en la lista de productos
 */
private static String obtenerNombreDelIngrediente(int numeroPosicion) {
	String nombre=productos[numeroPosicion];
	
return nombre;
}
	
}
