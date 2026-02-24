package com.utc.logica;

/**
 * Hello world!
 */
public class App {
	//metodo que se ejecuta al dar play 
    public static void main(String[] args) {
        System.out.println("Calcular promedio");
        //Instanciando un objeto de tipo CalculadoraPromedio
        CalculadoraPromedio estudiante1=new CalculadoraPromedio();
        CalculadoraPromedio estudiante2=new CalculadoraPromedio(10,9,8);
        //Calcular promedios 
        estudiante1.calcularPromedio();
        estudiante2.calcularPromedio();
        //salida de promedios
        System.out.print("Promedio estudiante 1:"+estudiante1.getPromedio);
        System.out.print("Promedio estudaunte 2:"+estudiante2.getPromedio);
    }
}
