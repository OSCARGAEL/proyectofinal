    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sopaletras;

/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SopaLetras extends JFrame {

    private char[][] sopaDeLetras;
    private ArrayList<String> misDatos;
    private ArrayList<String> posicionesPalabras;
    private SopaDeLetrasGrafico sopaDeLetrasGrafico;
    private GeneradorSopaLetras generadorSopaLetras;

    public SopaLetras(String archivoPalabras, boolean usarLetras) {
        // Configuración de la ventana
        setTitle("Sopa de Letras");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicialización de listas e instancias
        misDatos = new ArrayList<>();
        posicionesPalabras = new ArrayList<>();
        sopaDeLetrasGrafico = new SopaDeLetrasGrafico();
        generadorSopaLetras = new GeneradorSopaLetras();

        // Generación de la sopa de letras y colocación de palabras
        sopaDeLetras = generadorSopaLetras.generarSopaDeLetras();
        ColocadorElementos colocador = new ColocadorElementos();
        colocador.colocarElementosEnSopa(sopaDeLetras, misDatos, posicionesPalabras, usarLetras, archivoPalabras);

        // Agregar un JPanel personalizado para dibujar la sopa de letras
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                sopaDeLetrasGrafico.dibujarSopaDeLetras(g, sopaDeLetras);
            }
        };
        add(panel);

        // Mostrar la sopa de letras y posiciones en la consola
        SopaDeLetrasConsola consola = new SopaDeLetrasConsola();
        consola.mostrarSopaEnConsola(sopaDeLetras);
        consola.mostrarPosicionesEnConsola(posicionesPalabras);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear instancias de la clase para palabras y números
        SopaLetras sopaPalabras = new SopaLetras("palabras.txt", true);
        SopaLetras sopaNumeros = new SopaLetras("numeros.txt", false);
    }
}

