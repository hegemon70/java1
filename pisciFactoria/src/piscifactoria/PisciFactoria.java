/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;

import java.util.Scanner;

/**
 *
 * @author Fernando
 */
public class PisciFactoria {
    //
//Se considera los siguientes puntos:
//
//      Un tablero con dimensión de 30 * 30.
//
//      La cantidad de Vegetales (V) la ingresa el Usuario.
//
//      La cantidad de Tiburones (T) la ingresa el Usuario.
//
//      La cantidad de Peces (P) la ingresa el Usuario.
//
//      Cada ciclo implica: decremento de energía si no come.
//
//      Los V aumentan en uno por cada ciclo.
//
//     Si T come P y llega a su energía máxima, entonces se multiplica.
//
//     Si P como V y llega a su energía máxima entonces se multiplica.
//
//     Si T o P llegan a su nivel de energía mínima, entonces muere.
//
//     Tanto T como P miran a su casilla próxima para comer o desplazarse.
//
//     El programa procesa al azar el ciclo de la casilla que se procesara.
    
    
    public static boolean  isNumeric(String mensaje){
        try{
            Integer.parseInt(mensaje);
            return true;
        }
        catch(NumberFormatException nfe){
            return false;
        }
        
    }
    
    
    
    public static int pideDatoNumerico(String peticion,String peticionSiFallo){
        String mensaje; 
        java.util.Scanner sc =new Scanner(System.in);
        System.out.println(peticion);
         mensaje=sc.next();
                while ( ! isNumeric(mensaje) ) {            
            System.out.println(peticionSiFallo);
            mensaje=sc.next();
        }
        return Integer.parseInt(mensaje);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String mensaje;
        int nNiveles,tamX,tamY;
        System.out.println("vamos a crea una piscifactoria");
        nNiveles=pideDatoNumerico("dime el numero de Niveles","dame un numero valido de niveles");
        tamX=pideDatoNumerico("dime el X del nivel","dame un X valido");
        tamY=pideDatoNumerico("dime el Y del nivel","dame un Y valido");
        System.out.println("pintando....");
        mar Oceano = new mar(nNiveles,tamX,tamY);
        String [] lienzo = new String [tamY+1];
     
        for (String cursor:  Oceano.pintaMar() ){
            System.out.println(cursor);
        }
            //int numNiv, int tamX, int tamY
        
//        java.util.Scanner sc =new Scanner(System.in);
//        System.out.println("dime el numero de niveles");
//        mensaje=sc.next();
//        while ( ! isNumeric(mensaje) ) {            
//            System.out.println("dame un numero valido de niveles");
//            mensaje=sc.next();
//        }
        //        while ( ! isNumeric(mensaje) ) {            
//            System.out.println("dame un numero valido de ancho");
//            mensaje=sc.next();
//        }
//        ntamX=Integer.parseInt(mensaje);
        
        
    }

  
    
}
