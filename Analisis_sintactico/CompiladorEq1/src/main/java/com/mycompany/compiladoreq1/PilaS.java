/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compiladoreq1;

/**
 *
 * @author alfre
 */
public class PilaS {
    private String a[];
    private int tope;
    
    
    public PilaS()
    {
        a = new String[30];
        tope = -1;
    }
    
    public void agrega(String letra)
    {
        tope++;
        a[tope] = letra;
    }
    public String tope()
    {
        return a[tope];
    }
    
    public String elimina()
    {
        return a[tope--];
    }
    
    public boolean vacia()
    {
        return tope==-1;
    }
    
}
