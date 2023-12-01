/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sopaletras;

/**
 *
 * @author HP
 */
public class ColocadorDireccion {

    public boolean colocarDireccion(char[][] sopaDeLetras, int fila, int columna, String palabra, int direccion) {
        int longitud = palabra.length();

        switch (direccion) {
            case 0: // Vertical
                if (fila + longitud <= 15) {
                    for (int i = 0; i < longitud; i++) {
                        char letra = sopaDeLetras[fila + i][columna];
                        if (letra != ' ' && letra != palabra.charAt(i)) {
                            return false; // Colisión
                        }
                    }
                    for (int i = 0; i < longitud; i++) {
                        sopaDeLetras[fila + i][columna] = palabra.charAt(i);
                    }
                    return true;
                }
                break;

            case 1: // Horizontal
                if (columna - longitud >= -1) {
                    for (int i = 0; i < longitud; i++) {
                        char letra = sopaDeLetras[fila][columna - i];
                        if (letra != ' ' && letra != palabra.charAt(i)) {
                            return false; // Colisión
                        }
                    }
                    for (int i = 0; i < longitud; i++) {
                        sopaDeLetras[fila][columna - i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;

            case 2: // Diagonal
                if (fila - longitud >= -1 && columna - longitud >= -1) {
                    for (int i = 0; i < longitud; i++) {
                        char letra = sopaDeLetras[fila - i][columna - i];
                        if (letra != ' ' && letra != palabra.charAt(i)) {
                            return false; // Colisión
                        }
                    }
                    for (int i = 0; i < longitud; i++) {
                        sopaDeLetras[fila - i][columna - i] = palabra.charAt(i);
                    }
                    return true;
                }
                break;
        }

        return false; // Palabra no colocada
    }
}
