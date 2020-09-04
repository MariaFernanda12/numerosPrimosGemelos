/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerosParesPrimos;

import java.util.Scanner;

/**
 *
 * @author María Fernanda Martínez Garzón
 * Ejercicio 2: Función que imprime los primero n números primos pares
 */
public class numerosParesPrimos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variable para leer parametros de entrada
        Scanner lectura = new Scanner(System.in);
         //variable de entrada que referencia la cantidad de parejas de primos a desarrollar
        int numeroDePrimos;
        //Entrada de variables
        System.out.println("ingrese el números de primos gemelos que desea obtener");
        numeroDePrimos=lectura.nextInt();
        //Llamado a la función que calcula números primos
        String cadenaPrimosGemelos=esPrimo(numeroDePrimos);
        System.out.println(cadenaPrimosGemelos);
    
        
    }
  
     public static String esPrimo(int numeroDePrimos){
        //variables de control de ciclos para realizar los calculos necesarios 
        // contador: variable de control referente al número de veces que se ejecutará el ciclo, se inicia en dos de acuerdo a la definición de números primos
        // n: variable de operación inicia en 4 ya que se tiene claro que los dos primeros números primos son 2 y 3
        // numeroA: primer numero primo, variable de control 
        // numeroG1: variable a analizar si es primo gemelo
        // numeroG2: variable a compara si es gemelo del anterior
        int numeroA;
        int numeroB=4;
        int contador=2;
        int numeroG1 = 0;
        int numeroG2 = 0;
        
        
        // variable de cadena para imrpimir los numeros primos requeridos
        String cadenaNumerosPrimosGemelos="";
        //Entrada de variables
         
            cadenaNumerosPrimosGemelos="3,5"; // Inicio cadena de numeros primos de salida (seestablece 3 y 5 como la primera pareja de gemelos primos)
            while(contador<=numeroDePrimos){//primer ciclo para realizar la operación el número de veces que se solicita en los parametros de entrada
                numeroA=2;// se establece variable de control en 2 por ser el primer número primo
                while(numeroA<=numeroB){ //segundo ciclo que valida el cálculo para saber si un número es primo
                  
                    if(numeroA==numeroB){ //validación que de ser cierta el némero es primo
           
                    
                    
                    if(numeroG1==0){//Guarda un número primo encontrado para ser comparado con su siguiente primo más cercano
                        numeroG1=numeroB;   
                    }else{
                        numeroG2=numeroB;// guarda el segundonúmeor primo que será analizado con su número primo anterior
                        String gemelo=esGemelo( numeroG1, numeroG2); //Lllmado a la función que valida si dos números primos son gemelos
                        if(gemelo != null){ //Si los dos números primos son gemelos se adjuntaran a la cadena que será retornada al final con los números primos genelos
                            //Limpiar variables y aumentar contadores
                            numeroG2=0;
                            numeroG1=0;
                            contador=contador+1;// Incrementa el contador en 1 y termina el segundo ciclo para iniciar de nuevo el primero
                             cadenaNumerosPrimosGemelos=cadenaNumerosPrimosGemelos+" - "+gemelo;
                        }else{
                           // Si los números primos encontrados no son gemelos se deben limpiar las variables de control
                           numeroG2=0;
                           numeroG1=0; 
                           
                        }
                        
                    }
                    }else{
                    if(numeroB % numeroA==0){//Valida el modulo entre dos números con el fin de  
                    numeroA=numeroB;
                    }
                    }
                    numeroA=numeroA+1;//Incremento variables de cálculo y control
                }
                numeroB=numeroB+1;//Incremento variables de cálculo y control
            }
            //Salida cadena de primos
           //System.out.println(cadenaNumerosPrimosGemelos);
           //Excpciones que se pueden presentar
               
        
        return cadenaNumerosPrimosGemelos;
    
        
    }
    public static String esGemelo(int numeroGemelo1,int numeroGemelo2){ //Funión que calcula si dos números primos son gemelos
        String cadena;
        if ((numeroGemelo2-numeroGemelo1)==2){//Operación 
            cadena = numeroGemelo1+","+numeroGemelo2;
        }else{
            cadena = null;
        }
      return cadena ; //Retorno de cadena de ser un par gemelos
    }
    
}
