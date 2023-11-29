package com.mycompany.compiladoreq1;

import java.util.*;

public class Ir_a{



    public List<String> crearConjuntoI(String[] arregloCadenas) {
        List<String> estadoI = new ArrayList<>();
        for (String cadena : arregloCadenas) {
            estadoI.add(cadena);
        }
        return estadoI;
    }

    public String[][] ir_a(List<String> conjuntoI, String simboloX) {
        Set<String> conjuntoJ = new HashSet<>();

        // Iterar sobre cada elemento en el conjunto 
        for (String elemento : conjuntoI) {
            String[] partes = elemento.split("->|\\·");

            // Verificar si el s mbolo X est  presente en la parte derecha del punto.
            if (partes.length > 2 && partes[2].length() > 0 && partes[2].startsWith(simboloX)) {
                // Agregar un elemento a J (Solo si esta presente X y el punto se recorre hacia adelante)
                String nuevoElemento = partes[0] + "->" + partes[1] + partes[2].substring(0, simboloX.length()) + "·" + partes[2].substring(simboloX.length());
                conjuntoJ.add(nuevoElemento);
            }
        }

        return convertirConjuntoJAMatriz(conjuntoJ);// antes de retornar lo convierto a una matriz
    }

    public String[] convertirMatrizAArray(String[][] matriz) {
        List<String> listaCadenas = new ArrayList<>();

        for (String[] fila : matriz) {
            listaCadenas.add(fila[0] + "->" + fila[1] );
        }

        return listaCadenas.toArray(new String[0]);
    }

    public String[][] convertirConjuntoJAMatriz(Set<String> conjuntoJ) {
        String[][] matrizConjuntoJ = new String[conjuntoJ.size()][2];
        int i = 0;

        for (String elemento : conjuntoJ) {
            // Se elimina el "->" para obtener una matriz de dos columnas
            String[] partes = elemento.split("->");
            matrizConjuntoJ[i][0] = partes[0].trim(); // Lado izquierdo
            matrizConjuntoJ[i][1] = partes[1].trim(); // Lado derecho
            i++;
        }

        return matrizConjuntoJ;
    }
}