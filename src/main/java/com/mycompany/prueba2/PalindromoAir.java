
package com.mycompany.prueba2;
import javax.swing.JOptionPane;

public class PalindromoAir {
    
    private Ticket[] ticket;
    
    public PalindromoAir() {
        ticket = new Ticket[30];
    }
    
    private int firstAvailable(int asiento) {
        if (asiento >= ticket.length) {
            return -1;
        }
        if (ticket[asiento] == null) {
            return asiento;
        }
        return firstAvailable(asiento + 1);
    }
    
    public int firstAvailable() {
        return firstAvailable(0);
    }
    
    private int searchPassenger(String name, int index) {
        if (index >= ticket.length) {
            return -1;
        }
        if (ticket[index] != null && ticket[index].getNombre().equals(name)) {
            return index;
        }
        return searchPassenger(name, index + 1);
    }
    
    public int searchPassenger(String name) {
        return searchPassenger(name, 0);
    }
    
    private boolean isPalindromo(String name, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (name.charAt(left) != name.charAt(right)) {
            return false;
        }
        return isPalindromo(name, left + 1, right - 1);
    }
    
    public boolean isPalindromo(String name) {
        return isPalindromo(name, 0, name.length() - 1);
    }
    
    private void printPassengers(int asiento, StringBuilder string) {
        if (asiento >= ticket.length) {
            return;
        }
        if (ticket[asiento] != null) {
            string.append(ticket[asiento].toString()).append("\n\n");
        }
        printPassengers(asiento + 1, string);
    }
    
    public void printPassengers() {
        StringBuilder string = new StringBuilder();
        printPassengers(0, string);
        JOptionPane.showMessageDialog(null, string.toString(), "Pasajeros", 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    private double income(int asiento) {
        if (asiento >= ticket.length) {
            return 0;
        }
        if (ticket[asiento] != null) {
            return ticket[asiento].gettotalPagado() + income(asiento + 1);
        }
        return income(asiento + 1);
    }
    
    public double income() {
        return income(0);
    }
    
    private void reset(int asiento) {
        if (asiento >= ticket.length) {
            return;
        }
        ticket[asiento] = null;
        reset(asiento + 1);
    }
    
    public void reset() {
        reset(0);
    }
    
    public void sellTicket(String name) {
        int availableSeat = firstAvailable();
        
        if (availableSeat != -1) {
            double precio = 800;
            
            if (isPalindromo(name)) {
                precio *= 0.8;
            }
            
            ticket[availableSeat] = new Ticket(name, precio);
            JOptionPane.showMessageDialog(null, "Adquirido por " + name + " a $" + precio);
            
        } else {
            JOptionPane.showMessageDialog(null, "No quedan más asientos");
        }
    }
    
    public boolean cancelTicket(String name) {
        int passengerIndex = searchPassenger(name);
        
        if (passengerIndex != -1) {
            ticket[passengerIndex] = null;
            return true;
        }
        return false;
    }
    
    public void dispatch() {
        JOptionPane.showMessageDialog(null, "Ingreso generado: $" + income());
        reset();
    }
}
