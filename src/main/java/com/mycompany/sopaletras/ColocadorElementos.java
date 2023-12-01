/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sopaletras;

/**
 *
 * @author HP
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class ColocadorElementos {

    private void leerArchivo(ArrayList<String> misDatos, String archivoPalabras) {
        try {
            File archivo = new File(archivoPalabras);
            Scanner lector = new Scanner(archivo);

            while (lector.hasNextLine()) {
                String cadena = lector.nextLine().trim();

                if (!cadena.isEmpty()) {
                    misDatos.add(cadena);
                }
            }

            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String obtenerNombreDireccion(int opcion) {
        switch (opcion) {
            case 0:
                return "Vertical";
            case 1:
                return "Horizontal";
            case 2:
                return "Diagonal";
            default:
                return "Error";
        }
    }
    public void colocarElementosEnSopa(char[][] sopaDeLetras, ArrayList<String> misDatos, ArrayList<String> posicionesPalabras, boolean usarLetras, String archivoPalabras) {
        leerArchivo(misDatos, archivoPalabras);
        Collections.shuffle(misDatos);
        Random random = new Random();

        ColocadorDireccion colocadorDireccion = new ColocadorDireccion(); // Crear instancia de ColocadorDireccion

        for (String palabra : misDatos) {
            boolean colocada = false;

            while (!colocada) {
                int fila = random.nextInt(15);
                int columna = random.nextInt(15);
                int direccion = random.nextInt(3);

                if (colocadorDireccion.colocarDireccion(sopaDeLetras, fila, columna, palabra, direccion)) {
                    posicionesPalabras.add("Palabra: " + palabra + ", Posición: "
                            + obtenerNombreDireccion(direccion) + ", x=" + (columna + 1) + ", y=" + (fila + 1));
                    colocada = true;
                }
            }
        }

        // Llenar los espacios restantes con letras o números aleatorios según el parámetro
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (sopaDeLetras[i][j] == ' ') {
                    if (usarLetras) {
                        sopaDeLetras[i][j] = (char) (random.nextInt(26) + 'A');
                    } else {
                        sopaDeLetras[i][j] = (char) (random.nextInt(10) + '0');
                    }
                }
            }
        }
    }
}
