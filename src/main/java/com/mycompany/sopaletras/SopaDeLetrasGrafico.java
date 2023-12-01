/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sopaletras;



/**
 *
 * @author HP
 */
import java.awt.Graphics;

public class SopaDeLetrasGrafico {

    public void dibujarSopaDeLetras(Graphics g, char[][] sopaDeLetras) {
        int celdaSize = 30;
        int x = 50;
        int y = 50;

        for (int i = 0; i < 15; i++) {
            g.drawString(String.valueOf(i + 1), x + i * celdaSize + celdaSize / 2, y - 10);
        }

        for (int i = 0; i < 15; i++) {
            g.drawString(String.valueOf(i + 1), x - 20, y + i * celdaSize + celdaSize / 2);
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                g.drawRect(x + j * celdaSize, y + i * celdaSize, celdaSize, celdaSize);
                g.drawString(String.valueOf(sopaDeLetras[i][j]),
                        x + j * celdaSize + celdaSize / 2, y + i * celdaSize + celdaSize / 2);
            }
        }
    }
}
