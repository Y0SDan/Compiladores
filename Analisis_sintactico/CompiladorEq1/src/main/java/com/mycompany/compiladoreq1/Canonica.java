package com.mycompany.compiladoreq1;

import com.mycompany.compiladoreq1.Cerradura;
import java.util.*;
public class Canonica {
    public List<String> coleccion(String[][] produccion,String[] nt,String[] t){
        List<String> tabla1 = new ArrayList<String>();
        List<String> tabla2 = new ArrayList<String>();
        String [][]aumentada = new String[produccion.length+1][2];
        aumentada[0][0]=nt[0]+"'";
        aumentada[0][1]="·"+nt[0]+"$";
        tabla2.add("Cerradura({["+nt[0]+"->"+"·"+nt[0]+"$]})");
        for (int i = 0; i < produccion.length; i++){
            aumentada[i+1]=produccion[i];
        }
        Cerradura c = new Cerradura();
        Ir_a a = new Ir_a();
        String aux0= "";
        String[][] m1 ={aumentada[0]};
        String[][] aux1 =(String[][]) c.cerradura(nt,produccion,m1);
        for(int i = 0; i <aux1.length; i++){
            aux0 =aux0+ "[" + aux1[i][0] + "->"+aux1[i][1]+"]"; 
        }
        List<String[][]> aux_1 = new ArrayList<String[][]>();
        aux_1.add(aux1);
        tabla1.add(aux0);
        tabla2.add("I"+(aux_1.size()-1)+"={"+aux0+"}");
        String[] tnt = new String [t.length+nt.length+1];
        System.arraycopy(nt, 0, tnt, 0, nt.length);
        System.arraycopy(t, 0, tnt, nt.length, t.length);
        tnt[t.length+nt.length]= "$";
        for(int p = 0; p < aux_1.size();p++){
            String[] aux2 = (String[]) a.convertirMatrizAArray(aux_1.get(p));
            List<String> aux3 = a.crearConjuntoI(aux2);
            for (int i = 0; i < tnt.length; i++){
                String[][] aux4 =(String[][]) a.ir_a(aux3, tnt[i]);
                if(aux4.length > 0){
                    String [] auxA = (String[]) a.convertirMatrizAArray(aux4);
                    String aux00 = "";
                    for(int j = 0; j < auxA.length; j++){
                        aux00 = aux00 + "[" + auxA[j] + "]";
                    }
                    aux1 = (String[][])c.cerradura(nt, produccion, aux4);
                    aux0 = "";
                    for(int j = 0;j<aux1.length; j++){
                       aux0 =aux0+ "[" + aux1[j][0] + "->"+aux1[j][1]+"]"; 
                   }
                    if(aux0.equals("["+nt[0]+"'->"+nt[0]+"$·]")){
                        tabla2.add("Ir_a(I"+p+","+tnt[i]+")= Aceptacion");
                    }
                    else if (!tabla1.contains(aux0)){
                       tabla2.add("Ir_a(I"+p+","+tnt[i]+")=cerradura({"+aux00+"})");
                       tabla1.add(aux0);
                       aux_1.add(aux1);
                       tabla2.add("I"+(aux_1.size()-1)+"={"+aux0+"}");
                   }
                   else{
                       tabla2.add("Ir_a(I"+p+","+tnt[i]+")=cerradura({"+aux00+"})");
                       String aaux = tabla2.get(tabla2.size()-1);
                       tabla2.remove(aaux);
                       String aaux2 = tabla1.get(0);
                       int r = 0;
                       while (!aaux2.equals(aux0) && r < tabla1.size()){
                           r++;
                           aaux2 = tabla1.get(r);
                       }
                       aaux = aaux + "= I"+r;
                       tabla2.add( aaux);
                   }
                }
            }
        }
        return tabla2;
    }
}
