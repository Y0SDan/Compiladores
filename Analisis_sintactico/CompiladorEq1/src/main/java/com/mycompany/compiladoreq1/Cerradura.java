package com.mycompany.compiladoreq1;

import java.util.Arrays;
public class Cerradura {
	public String[][] cerradura(String[] noTerminales, String[][] producciones, String[][]produccionesActuales){
		for(int i=0; i < produccionesActuales.length; i++) {
			for(int j=0; j < 2; j++) {
				int posicion = produccionesActuales[i][1].indexOf("·") + 1;	//Obtiene la posición del punto y se le suma 1 porque vamos a trabajar con el siguiente caracter despues del punto
				if(posicion < produccionesActuales[i][1].length())
				{
                                    char caracterSiguiente = produccionesActuales[i][1].charAt(posicion);//"3"
                                    for(String noTerminal : noTerminales) {
                                            if(Character.toString(caracterSiguiente).equals(noTerminal)) {	//Comprueba si el caracter siguiente es un noTerminal
                                                    // Buscar la fila correspondiente en producciones y agregarla a produccionesActuales
                                                for (int k = 0; k < producciones.length; k++) {
                                                    
                                                    
                                                    if (producciones[k][0].equals(noTerminal)) {
                                                            StringBuilder aux = new StringBuilder(producciones[k][1]);	//Auxiliar para agregar el punto al inicio de la produccion
                                                            aux.insert(0, '·');
                                                            String cadenaConPunto = aux.toString();
                                                            // Crear una nueva fila para agregarla a produccionesActuales
                                                             // Ajusta esto según la estructura real de tus datos
                                                            int epsilon = cadenaConPunto.indexOf('3');
                                                            
                                                            if(epsilon!=-1)
                                                            {
                                                                StringBuilder aaa = new StringBuilder(cadenaConPunto);
                                                                
                                                                aaa.deleteCharAt(epsilon);
                                                                cadenaConPunto =  aaa.toString();
                                                            }
                                                            
                                                            String[] nuevaFila = {producciones[k][0], cadenaConPunto};
                                                            // Verificar si la fila ya existe en produccionesActuales antes de agregarla
                                                            
                                                            
                                                            boolean yaExiste = false;
                                                            for (String[] filaActual : produccionesActuales) {
                                                                    if (Arrays.equals(filaActual, nuevaFila)) {
                                                                            yaExiste = true;
                                                                            break;
                                                                    }
                                                            }

                                                            // Agregar la fila solo si no existe en produccionesActuales
                                                            if (!yaExiste) {
                                                            // Ajusta el tamaño de produccionesActuales según sea necesario
                                                                    produccionesActuales = Arrays.copyOf(produccionesActuales, produccionesActuales.length + 1);
                                                                    produccionesActuales[produccionesActuales.length - 1] = nuevaFila;
                                                            }
                                                        }
                                                    }
                                            }

					}
				}
			}
		}
                
                
		return produccionesActuales;
	}
}