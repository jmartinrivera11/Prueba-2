/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Josue
 */

public class Main {
    private PalindromoAir avion = new PalindromoAir();
    
    public static void main(String[] args) {
        new Main().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("PalindromoAir");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Palindromo Air", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel, BorderLayout.CENTER);

        JButton vender = new JButton("Vender ticket");
        vender.addActionListener(e -> sellTicket());
        panel.add(vender);

        JButton cancelar = new JButton("Cancelar ticket");
        cancelar.addActionListener(e -> cancelTicket());
        panel.add(cancelar);

        JButton imprimir = new JButton("Imprimir los pasajeros");
        imprimir.addActionListener(e -> avion.printPassengers());
        panel.add(imprimir);

        JButton income = new JButton("Calcular los ingresos");
        income.addActionListener(e -> calculateIncome());
        panel.add(income);

        JButton dispatchButton = new JButton("Despachar");
        dispatchButton.addActionListener(e -> dispatch());
        panel.add(dispatchButton);

        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(e -> System.exit(0));
        panel.add(exitButton);

        frame.setVisible(true);
    }

    private void sellTicket() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            avion.sellTicket(nombre.trim());
        }
    }

    private void cancelTicket() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero que desea cancelar:");
        if (nombre != null && !nombre.trim().isEmpty()) {
            boolean cancelado = avion.cancelTicket(nombre.trim());
            String mensaje = cancelado ? "Ticket cancelado." : "Pasajero no encontrado.";
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    private void calculateIncome() {
        double income = avion.income();
        JOptionPane.showMessageDialog(null, "Ingreso total: $" + income);
    }

    private void dispatch() {
        avion.dispatch();
        JOptionPane.showMessageDialog(null, "Avion despachado y asientos reiniciados.");
    }
}
