package com.utc.logica;
import com.utc.logica.CalculadoraPromedio;
//logica de negocio 
/*
 * Desarrolla por: Josselyn
 * Creado:18-11-2025
 * Ultima Modificacion:18-11-2025 Por Josselyn
 */

public class CalculadoraPromedio {
	
	//Atributos
	double nota1;
	double nota2;
	double nota3;
	double promedio;
	String estudiante;
	String observacion;
	
	//Metodo
	//constructor 
	public CalculadoraPromedio () {
		this.nota1=0;
		this.nota2=0;
		this.nota3=0;
		
	}
	//Metodo
	//Constructo de inicializacion con valores
	public CalculadoraPromedio (double n1, double n2, double n3) {
		this.nota1=n1;
		this.nota2=n2;
		this.nota3=n3;
	}
	//Calcular el promedio
	public void calcularPromedio() {
		double sumatoria=this.nota1+this.nota2+this.nota3;
		this.promedio=sumatoria/3;
		
		
	}
	//getter promedio 
	public double getPromedio() {
		return promedio;
	}
}//cierre de la clase 