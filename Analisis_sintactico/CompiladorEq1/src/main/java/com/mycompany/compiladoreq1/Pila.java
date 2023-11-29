/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.compiladoreq1;

/**
 *
 * @author alfre
 */
public class Pila 
{
    private char a[];
    private int tope;
    
    
    public Pila()
    {
        a = new char[10];
        tope = -1;
    }
    
    public void agrega(char letra)
    {
        tope++;
        a[tope] = letra;
    }
    public char tope()
    {
        return a[tope];
    }
    
    public char elimina()
    {
        return a[tope--];
    }
    
    public boolean vacia()
    {
        return tope==-1;
    }
}
