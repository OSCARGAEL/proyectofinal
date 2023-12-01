/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sopaletras;

/**
 *
 * @author HP
 */

public class GeneradorSopaLetras {

    // Genera una sopa de letras vacía
    public char[][] generarSopaDeLetras() {
        char[][] sopaDeLetras = new char[15][15];
        

        // Llenar la sopa de letras con espacios en blanco
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                sopaDeLetras[i][j] = ' ';
            }
        }

        return sopaDeLetras;
    }
}
