/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2;


/**
 *
 * @author Josue
 */
public class Ticket {
    
    private String nombre;
    private double totalPagado;
    
    public Ticket(String nombre, double totalPagado) {
        this.nombre = nombre;
        this.totalPagado = totalPagado;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public double gettotalPagado() {
        return totalPagado;
    }
    
    @Override
    public String toString() {
        return "Nombre pasajero: " + nombre + "\nTotal pagado: $" + totalPagado;
    }
}