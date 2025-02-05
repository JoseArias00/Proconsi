package com.company;

import com.company.formas.Circulo;
import com.company.formas.rectangulares.Cuadrado;
import com.company.formas.rectangulares.Rectangulo;
import com.company.formas.triangulares.TrianguloEquilatero;
import com.company.formas.triangulares.TrianguloEscaleno;
import com.company.formas.triangulares.TrianguloIsosceles;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Esta clase genera tantas figuras con valores aleatorios como se indique
 *
 * @author Jose Maria
 */
public class Aleatorios {
    public static final String ERROR = "Lo sentimos,debes introducir un valor entero sin decimales (0-32.767)";

    /**
     * @throws InputMismatchException Excepción lanzada cuando se introduce un valor distinto a un valor entero
     *                                <p>
     *                                Método main donde recogemos en consola los valores deseados solicitados al cliente
     */
    public static void main() {
        entrada();

    }

    private static void entrada(){
        byte numRectángulos;
        byte numCirculos = 0;
        byte numTriángulos;
        Scanner sc = new Scanner(System.in);

        //Comprobamos que la entrada sea un int con un try catch y luego que cada valor sea positivo
        System.out.println("Introduce el número de círculos a crear:");
        try {
            numCirculos =sc.nextByte();
        } catch (InputMismatchException e) {
        }

        /*System.out.println("Introduce el número de formas rectangulares (se generarán cuadrados y rectángulos de forma aleatoria):");
        numRectángulos = Verificador.verificaEnterosPositivos(sc.nextByte());


        System.out.println("Introduce el número de triángulos (se generarán triángulos equiláteros, isósceles y escalenos de forma aleatoria):");
        numTriángulos = Verificador.verificaEnterosPositivos(sc.nextByte());*/


        //Indicamos por órden el número de figuras a crear de cada tipo
        if (numCirculos > 0) {
            generaCirculos(numCirculos);
        }

       /* if (numRectángulos > 0) {
            generaRectángulos(numRectángulos);
        }

        if (numTriángulos > 0) {
            generaTriángulos(numTriángulos);
        }*/

    }

    /**
     * @param cantidad Número de círculos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de círculos con valores aleatorios.
     */
    private static void generaCirculos(int cantidad) {
        for (int círculosCreados = 0; círculosCreados < cantidad; círculosCreados++) {
            BigDecimal radio = BigDecimal.valueOf(random() * 100 + 1);
            Circulo círculo = new Circulo(radio);
            System.out.println("---------------Figura---------------\n" + círculo.toString());
        }

    }

    /**
     * @param cantidad Número de triángulos a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de triángulos con valores aleatorios.
     */
    private static void generaTriángulos(int cantidad) {
        int numEquiláteros;
        int numIsósceles;
        int numEscalenos;
        //Usamos el azar para saber cuantos triángulos crear de cada tipo
        numEquiláteros = (int) (random() * cantidad + 1);
        cantidad -= numEquiláteros;
        for (int numEquiCreados = 0; numEquiCreados < numEquiláteros; numEquiCreados++) {
            BigDecimal lados = BigDecimal.valueOf(random() * 100 + 1);
            TrianguloEquilatero tEquilatero = new TrianguloEquilatero(lados);
            System.out.println("---------------Figura---------------\n" + tEquilatero.toString());
        }

        if (cantidad > 0) {
            numIsósceles = (int) (random() * cantidad + 1);
            cantidad -= numIsósceles;

            for (int numIsoCreados = 0; numIsoCreados < numIsósceles; numIsoCreados++) {
                BigDecimal ladosIguales = BigDecimal.valueOf(random() * 100 + 1);
                BigDecimal ladoDesigual = BigDecimal.valueOf(random() * 100 + 1);
                TrianguloIsosceles tIsósceles = new TrianguloIsosceles(ladosIguales, ladoDesigual);
                System.out.println("---------------Figura---------------\n" + tIsósceles.toString());
            }
            if (cantidad > 0) {
                numEscalenos = (int) (random() * cantidad + 1);

                for (int numEscaCreados = 0; numEscaCreados < numEscalenos; numEscaCreados++) {
                    BigDecimal lado1 = BigDecimal.valueOf(random() * 100 + 1);
                    BigDecimal lado2 = BigDecimal.valueOf(random() * 100 + 1);
                    BigDecimal lado3 = BigDecimal.valueOf(random() * 100 + 1);
                    TrianguloEscaleno tEscaleno = new TrianguloEscaleno(lado1, lado2, lado3);
                    System.out.println("---------------Figura---------------\n" + tEscaleno.toString());
                }
            }
        }

    }

    /**
     * @param cantidad Número de cuadrados a crear
     *                 <p>
     *                 Método encargado de generar el número indicado de cuadrados con valores aleatorios.
     */
    private static void generaRectángulos(int cantidad) {
        int numCuadrados = (int) (random() * cantidad + 1);
        int numRectángulos = cantidad - numCuadrados;

        //Primero generamos todos los cuadrados que se vayan a crear
        for (int cuadradosCreados = 0; cuadradosCreados < numCuadrados; cuadradosCreados++) {
            BigDecimal medidaLado = BigDecimal.valueOf(random() * 100 + 1);
            Cuadrado cuadrado = new Cuadrado(medidaLado);
            System.out.println("---------------Figura---------------\n" + cuadrado.toString());
        }

        for (int rectángulosCreados = 0; rectángulosCreados < numRectángulos; rectángulosCreados++) {
            BigDecimal medidaLado1 = BigDecimal.valueOf(random() * 100 + 1);
            BigDecimal medidaLado2 = BigDecimal.valueOf(random() * 100 + 1);
            Rectangulo rectángulo = new Rectangulo(medidaLado1, medidaLado2);
            System.out.println("---------------Figura---------------\n" + rectángulo.toString());
        }

    }
}
