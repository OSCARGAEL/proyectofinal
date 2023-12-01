/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sopaletras;



/**
 *
 * @author HP
 */
import java.util.ArrayList;

public class SopaDeLetrasConsola {

    // Muestra la sopa de letras en la consola
    public static void mostrarSopaEnConsola(char[][] sopaDeLetras) {
        System.out.println("Sopa de Letras:");
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(sopaDeLetras[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Muestra las posiciones de las palabras en la consola
    public static void mostrarPosicionesEnConsola(ArrayList<String> posicionesPalabras) {
        System.out.println("Posiciones de las palabras:");
        for (String posicion : posicionesPalabras) {
            System.out.println(posicion);
        }
    }
}
