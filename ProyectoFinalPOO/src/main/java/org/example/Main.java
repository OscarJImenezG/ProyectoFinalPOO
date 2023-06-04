package org.example;

import org.example.Controlador.ControladorZelda;
import org.example.Vista.VentanaCompu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        VentanaCompu view = new VentanaCompu("The legend of Zelda");
        ControladorZelda controller = new ControladorZelda(view);
    }
}